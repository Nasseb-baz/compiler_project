package Compiler.builder;

import Compiler.antlr.TemplateLexer;
import Compiler.ast.Node;
import Compiler.ast.html.Attribute;
import Compiler.ast.html.HtmlDocument;
import Compiler.ast.html.HtmlElement;
import Compiler.ast.html.TextNode;
import Compiler.ast.jinja.*;
import Compiler.antlr.TemplateParser;
import Compiler.antlr.TemplateParserBaseVisitor;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class AstBuilder extends TemplateParserBaseVisitor<Node> {

    // ===== Main Document =====
    @Override
    public Node visitDocument(TemplateParser.DocumentContext ctx) {
        HtmlDocument document = new HtmlDocument(ctx.start.getLine());

        // جمع جميع العناصر
        for (var contentCtx : ctx.htmlContent()) {
            Node content = visit(contentCtx);
            if (content instanceof HtmlElement) {
                document.addChild((HtmlElement) content);
            } else if (content != null) {
                // إذا كان نصاً أو jinja مباشرة، ضعه في div افتراضي
                HtmlElement wrapper = new HtmlElement("div", contentCtx.start.getLine());
                if (content instanceof TextNode) {
                    wrapper.addChild(content);
                } else if (content instanceof JinjaNode) {
                    wrapper.addChild(content);
                }
                document.addChild(wrapper);
            }
        }

        return document;
    }

    // ===== HTML Content =====
    @Override
    public Node visitHtmlContent(TemplateParser.HtmlContentContext ctx) {
        if (ctx.htmlElement() != null) {
            return visit(ctx.htmlElement());
        } else if (ctx.jinjaElement() != null) {
            return visit(ctx.jinjaElement());
        } else if (ctx.HTML_TEXT() != null) {
            return visitHtmlText(ctx);
        }
        return null;
    }

    // ===== HTML Element =====
    @Override
    public Node visitHtmlElement(TemplateParser.HtmlElementContext ctx) {
        int line = ctx.start.getLine();

        // الحالة 1: عنصر عادي <div>...</div>
        if (ctx.TAG_NAME(0) != null && ctx.TAG_NAME(1) != null) {
            String openTagName = ctx.TAG_NAME(0).getText();
            String closeTagName = ctx.TAG_NAME(1).getText();

            // تحقق من تطابق الأسماء
            if (!openTagName.equals(closeTagName)) {
                System.err.println("Warning: Mismatched tags <" + openTagName + "> and </" + closeTagName + "> at line " + line);
            }

            HtmlElement element = new HtmlElement(openTagName, line);

            // إضافة السمات
            if (ctx.attribute() != null) {
                for (var attrCtx : ctx.attribute()) {
                    Attribute attr = (Attribute) visit(attrCtx);
                    if (attr != null) {
                        element.addAttribute(attr);
                    }
                }
            }

            // إضافة المحتوى
            if (ctx.htmlContent() != null) {
                for (var contentCtx : ctx.htmlContent()) {
                    Node content = visit(contentCtx);
                    if (content != null) {
                        element.addChild(content);
                    }
                }
            }

            return element;
        }
        // الحالة 2: عنصر self-closing <br/>
        else if (ctx.TAG_SLASH_CLOSE() != null && ctx.TAG_NAME(0) != null) {
            String tagName = ctx.TAG_NAME(0).getText();
            HtmlElement element = new HtmlElement(tagName, line);

            // إضافة السمات
            if (ctx.attribute() != null) {
                for (var attrCtx : ctx.attribute()) {
                    Attribute attr = (Attribute) visit(attrCtx);
                    if (attr != null) {
                        element.addAttribute(attr);
                    }
                }
            }

            return element;
        }

        return null;
    }

    // ===== HTML Attributes =====
    @Override
    public Node visitAttribute(TemplateParser.AttributeContext ctx) {
        String name = ctx.ATTR_NAME().getText();
        int line = ctx.start.getLine();

        if (ctx.attributeValue() != null) {
            String value = ctx.attributeValue().getText();
            // إزالة علامات الاقتباس
            if (value.startsWith("\"") && value.endsWith("\"")) {
                value = value.substring(1, value.length() - 1);
            } else if (value.startsWith("'") && value.endsWith("'")) {
                value = value.substring(1, value.length() - 1);
            }
            return new Attribute(name, value, line);
        } else {
            // سمة بدون قيمة (مثل "disabled")
            return new Attribute(name, line);
        }
    }

    @Override
    public Node visitAttributeValue(TemplateParser.AttributeValueContext ctx) {
        // نادراً ما تُستدعى مباشرة، تُعالَج في visitAttribute
        return null;
    }

    // ===== HTML Text =====
    public Node visitHtmlText(TemplateParser.HtmlContentContext ctx) {
        String text = ctx.HTML_TEXT().getText().trim();
        if (!text.isEmpty() && !text.matches("^\\s+$")) {
            return new TextNode(text, ctx.start.getLine());
        }
        return null;
    }

    // ===== Jinja Elements =====
    @Override
    public Node visitJinjaElement(TemplateParser.JinjaElementContext ctx) {
        if (ctx.jinjaExpression() != null) {
            return visit(ctx.jinjaExpression());
        } else if (ctx.jinjaForStatement() != null) {
            return visit(ctx.jinjaForStatement());
        } else if (ctx.jinjaStatement() != null) {
            return visit(ctx.jinjaStatement());
        } else if (ctx.jinjaComment() != null) {
            return visit(ctx.jinjaComment());
        }
        return null;
    }






    // ===== Jinja For Statement =====
    @Override
    public Node visitJinjaForStatement(TemplateParser.JinjaForStatementContext ctx) {
        int line = ctx.start.getLine();

        String iterator = ctx.forOpen().IDENTIFIER_STMT().getText();
        String collection = ctx.forOpen().expr().getText();

        JinjaForStatement forStmt =
                new JinjaForStatement(iterator, collection, line);

        JinjaBlock body = new JinjaBlock(line);

        for (var content : ctx.forBody().htmlContent()) {
            Node node = visit(content);
            if (node != null) {
                body.addStatement(node);
            }
        }

        forStmt.setBody(body);
        return forStmt;
    }



    // ===== Jinja Expression =====
    @Override
    public Node visitJinjaExpression(TemplateParser.JinjaExpressionContext ctx) {
        int line = ctx.start.getLine();
        StringBuilder expression = new StringBuilder();

        // جمع جميع exprContent
        if (ctx.exprContent() != null) {
            for (var exprCtx : ctx.exprContent()) {
                expression.append(exprCtx.getText()).append(" ");
            }
        }

        String exprStr = expression.toString().trim();

        // محاولة تحليل product.name إلى JinjaVariable
        if (exprStr.contains(".")) {
            String[] parts = exprStr.split("\\.");
            if (parts.length == 2) {
                return new JinjaVariable(parts[0], parts[1], line);
            }
        }

        // إذا كان مجرد متغير
        if (exprStr.matches("[a-zA-Z_][a-zA-Z0-9_]*")) {
            return new JinjaVariable(exprStr.trim(), line);
        }

        // إذا كان رقماً
        if (exprStr.matches("\\d+(\\.\\d+)?")) {
            return new JinjaLiteral(exprStr.trim(), "number", line);
        }

        // تعبير عام
        return new JinjaExpression(exprStr.trim(), line);
    }

    // ===== Jinja Statement (عام) =====
    @Override
    public Node visitJinjaStatement(TemplateParser.JinjaStatementContext ctx) {
        int line = ctx.start.getLine();
        StringBuilder statement = new StringBuilder();

        // جمع محتوى الـ statement
        if (ctx.stmtContent() != null) {
            for (var stmtCtx : ctx.stmtContent()) {
                statement.append(stmtCtx.getText()).append(" ");
            }
        }

        String stmtStr = statement.toString().trim();

        // إذا كان endfor، نتجاهله (تم التعامل معه في jinjaForStatement)
        if (stmtStr.equals("endfor")) {
            return null;
        }

        // statement عام
        return new JinjaExpression(stmtStr, line);  // نستخدم JinjaExpression مؤقتاً
    }

    // ===== Jinja Comment =====
    @Override
    public Node visitJinjaComment(TemplateParser.JinjaCommentContext ctx) {
        // نتجاهل التعليقات في AST
        return null;
    }

    // ===== Helper Methods =====

    @Override
    public Node visitExprContent(TemplateParser.ExprContentContext ctx) {
        // لا نحتاج لزيارة exprContent مباشرة
        return null;
    }

    @Override
    public Node visitStmtContent(TemplateParser.StmtContentContext ctx) {
        // لا نحتاج لزيارة stmtContent مباشرة
        return null;
    }

    @Override
    public Node visitExpr(TemplateParser.ExprContext ctx) {
        // لا نحتاج لزيارة expr مباشرة
        return null;
    }

    @Override
    protected Node defaultResult() {
        return null;
    }

    @Override
    protected Node aggregateResult(Node aggregate, Node nextResult) {
        if (aggregate == null) return nextResult;
        if (nextResult == null) return aggregate;
        return aggregate;  // نعيد الأول
    }
}