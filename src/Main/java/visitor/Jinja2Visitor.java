package Main.java.visitor;

import Main.java.antlr.Jinja2Parser;
import Main.java.antlr.Jinja2ParserBaseVisitor;
import Main.java.ast.jinja2.*;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class Jinja2Visitor extends Jinja2ParserBaseVisitor<Jinja2Node> {

    @Override
    public Jinja2Node visitDocument(Jinja2Parser.DocumentContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;
        List<Jinja2Node> elements = new ArrayList<>();

        for (Jinja2Parser.ElementContext elementCtx : ctx.element()) {
            Jinja2Node element = visitElement(elementCtx);
            if (element != null) {
                elements.add(element);
            }
        }

        return new Jinja2Template(line, elements);
    }

    @Override
    public Jinja2Node visitElement(Jinja2Parser.ElementContext ctx) {
        if (ctx == null) return null;

        if (ctx.html_text() != null) {
            return visitHtml_text(ctx.html_text());
        } else if (ctx.variable() != null) {
            return visitVariable(ctx.variable());
        } else if (ctx.block() != null) {
            return visitBlock(ctx.block());
        } else if (ctx.comment() != null) {
            return visitComment(ctx.comment());
        }

        return null;
    }

    @Override
    public Jinja2Node visitHtml_text(Jinja2Parser.Html_textContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;
        String text = ctx.HTML_TEXT() != null ? ctx.HTML_TEXT().getText() : "";

        return new Jinja2Text( line,text);
    }

    @Override
    public Jinja2Node visitComment(Jinja2Parser.CommentContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;
        StringBuilder content = new StringBuilder();

        if (ctx.C_TEXT() != null) {
            for (TerminalNode textNode : ctx.C_TEXT()) {
                content.append(textNode.getText());
            }
        }

        return new Jinja2Comment(line,content.toString());
    }

    @Override
    public Jinja2Node visitVariable(Jinja2Parser.VariableContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;

        Jinja2Expression expression = (Jinja2Expression) visitExpression(ctx.expression());

        List<Jinja2Filter> filters = new ArrayList<>();
        if (ctx.filter() != null) {
            for (Jinja2Parser.FilterContext filterCtx : ctx.filter()) {
                Jinja2Filter filter = (Jinja2Filter) visitFilter(filterCtx);
                if (filter != null) {
                    filters.add(filter);
                }
            }
        }

        return new Jinja2Variable( line,expression, filters);
    }

    @Override
    public Jinja2Node visitFilter(Jinja2Parser.FilterContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;
        String filterName = ctx.V_ID() != null ? ctx.V_ID().getText() : "";

        List<Jinja2Expression> arguments = new ArrayList<>();
        if (ctx.filter_arguments() != null) {
            for (Jinja2Parser.Filter_argumentContext argCtx : ctx.filter_arguments().filter_argument()) {
                Jinja2Expression arg = (Jinja2Expression) visitFilter_argument(argCtx);
                if (arg != null) {
                    arguments.add(arg);
                }
            }
        }

        return new Jinja2Filter( line,filterName, arguments);
    }

    @Override
    public Jinja2Node visitFilter_argument(Jinja2Parser.Filter_argumentContext ctx) {
        if (ctx == null) return null;

        if (ctx.expression() != null) {
            return visitExpression(ctx.expression());
        } else if (ctx.V_ID() != null && ctx.expression() != null) {
            int line = ctx.start != null ? ctx.start.getLine() : 1;
            String key = ctx.V_ID().getText();
            Jinja2Expression value = (Jinja2Expression) visitExpression(ctx.expression());

            Jinja2Identifier identifier = new Jinja2Identifier(key, line);
            return new Jinja2Assignment(identifier, value, line);
        }

        return null;
    }

    @Override
    public Jinja2Node visitBlock(Jinja2Parser.BlockContext ctx) {
        if (ctx == null) return null;

        if (ctx.if_block() != null) {
            return visitIf_block(ctx.if_block());
        } else if (ctx.for_block() != null) {
            return visitFor_block(ctx.for_block());
        } else if (ctx.block_tag() != null) {
            return visitBlock_tag(ctx.block_tag());
        } else if (ctx.extends_block() != null) {
            return visitExtends_block(ctx.extends_block());
        } else if (ctx.include_block() != null) {
            return visitInclude_block(ctx.include_block());
        } else if (ctx.set_block() != null) {
            return visitSet_block(ctx.set_block());
        } else if (ctx.with_block() != null) {
            return visitWith_block(ctx.with_block());
        } else if (ctx.simple_block() != null) {
            return visitSimple_block(ctx.simple_block());
        }

        return null;
    }

    @Override
    public Jinja2Node visitIf_block(Jinja2Parser.If_blockContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;

        Jinja2Expression condition = (Jinja2Expression) visitCondition(ctx.condition());

        // الحصول على محتوى then block
        List<Jinja2Node> thenContent = new ArrayList<>();
        if (ctx.inner_content() != null && !ctx.inner_content().isEmpty()) {
            // الحصول على أول inner_content (قد يكون هناك واحد فقط)
            Jinja2Parser.Inner_contentContext innerCtx = null;
            if (ctx.inner_content() != null && !ctx.inner_content().isEmpty()) {
                innerCtx = ctx.inner_content();
            }
            if (innerCtx != null) {
                for (Jinja2Parser.ElementContext elementCtx : innerCtx.element()) {
                    Jinja2Node element = visitElement(elementCtx);
                    if (element != null) {
                        thenContent.add(element);
                    }
                }
            }
        }

        // الحصول على elif blocks
        List<Jinja2ElifBlock> elifBlocks = new ArrayList<>();
        if (ctx.elif_block() != null) {
            for (Jinja2Parser.Elif_blockContext elifCtx : ctx.elif_block()) {
                Jinja2ElifBlock elifBlock = (Jinja2ElifBlock) visitElif_block(elifCtx);
                if (elifBlock != null) {
                    elifBlocks.add(elifBlock);
                }
            }
        }

        // الحصول على else block
        Jinja2ElseBlock elseBlock = null;
        if (ctx.else_block() != null) {
            elseBlock = (Jinja2ElseBlock) visitElse_block(ctx.else_block());
        }

        return new Jinja2IfTag(line, condition, thenContent, elifBlocks, elseBlock);
    }

    @Override
    public Jinja2Node visitElif_block(Jinja2Parser.Elif_blockContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;

        Jinja2Expression condition = (Jinja2Expression) visitCondition(ctx.condition());

        List<Jinja2Node> content = new ArrayList<>();
        if (ctx.inner_content() != null) {
            for (Jinja2Parser.ElementContext elementCtx : ctx.inner_content().element()) {
                Jinja2Node element = visitElement(elementCtx);
                if (element != null) {
                    content.add(element);
                }
            }
        }

        return new Jinja2ElifBlock(line, condition, content);
    }

    @Override
    public Jinja2Node visitElse_block(Jinja2Parser.Else_blockContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;

        List<Jinja2Node> content = new ArrayList<>();
        if (ctx.inner_content() != null) {
            for (Jinja2Parser.ElementContext elementCtx : ctx.inner_content().element()) {
                Jinja2Node element = visitElement(elementCtx);
                if (element != null) {
                    content.add(element);
                }
            }
        }

        return new Jinja2ElseBlock( content,line);
    }

    @Override
    public Jinja2Node visitFor_block(Jinja2Parser.For_blockContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;

        String variable = ctx.B_ID() != null ? ctx.B_ID().getText() : "";

        Jinja2Expression iterable = (Jinja2Expression) visitExpression(ctx.expression());

        List<Jinja2Node> content = new ArrayList<>();
        if (ctx.inner_content() != null) {
            for (Jinja2Parser.ElementContext elementCtx : ctx.inner_content().element()) {
                Jinja2Node element = visitElement(elementCtx);
                if (element != null) {
                    content.add(element);
                }
            }
        }

        return new Jinja2ForTag(line, variable, iterable, content);
    }

    @Override
    public Jinja2Node visitBlock_tag(Jinja2Parser.Block_tagContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;

        String blockName = ctx.B_ID() != null ? ctx.B_ID().getText() : "";

        List<Jinja2Node> content = new ArrayList<>();
        if (ctx.inner_content() != null) {
            for (Jinja2Parser.ElementContext elementCtx : ctx.inner_content().element()) {
                Jinja2Node element = visitElement(elementCtx);
                if (element != null) {
                    content.add(element);
                }
            }
        }

        return new Jinja2BlockTag(line, blockName, content);
    }

    @Override
    public Jinja2Node visitExtends_block(Jinja2Parser.Extends_blockContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;

        String templateName = "";
        if (ctx.string_literal() != null && ctx.string_literal().V_STRING() != null) {
            templateName = ctx.string_literal().V_STRING().getText();
            // إزالة علامات الاقتباس
            if (templateName.length() >= 2) {
                templateName = templateName.substring(1, templateName.length() - 1);
            }
        }

        return new Jinja2ExtendsTag( line,templateName);
    }

    @Override
    public Jinja2Node visitInclude_block(Jinja2Parser.Include_blockContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;

        String templateName = "";
        if (ctx.string_literal() != null && ctx.string_literal().V_STRING() != null) {
            templateName = ctx.string_literal().V_STRING().getText();
            // إزالة علامات الاقتباس
            if (templateName.length() >= 2) {
                templateName = templateName.substring(1, templateName.length() - 1);
            }
        }

        return new Jinja2IncludeTag( line,templateName, null);
    }

    @Override
    public Jinja2Node visitSet_block(Jinja2Parser.Set_blockContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;

        Jinja2Assignment assignment = (Jinja2Assignment) visitAssignment(ctx.assignment());

        return new Jinja2SetTag(assignment.getVariable(), assignment.getValue(), line);
    }

    @Override
    public Jinja2Node visitWith_block(Jinja2Parser.With_blockContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;

        List<Jinja2Assignment> assignments = new ArrayList<>();
        if (ctx.assignments() != null) {
            for (Jinja2Parser.AssignmentContext assignCtx : ctx.assignments().assignment()) {
                Jinja2Assignment assignment = (Jinja2Assignment) visitAssignment(assignCtx);
                if (assignment != null) {
                    assignments.add(assignment);
                }
            }
        }

        List<Jinja2Node> content = new ArrayList<>();
        if (ctx.inner_content() != null) {
            for (Jinja2Parser.ElementContext elementCtx : ctx.inner_content().element()) {
                Jinja2Node element = visitElement(elementCtx);
                if (element != null) {
                    content.add(element);
                }
            }
        }

        return new Jinja2WithTag( assignments, content,line);
    }

    @Override
    public Jinja2Node visitSimple_block(Jinja2Parser.Simple_blockContext ctx) {
        return null;
    }

    @Override
    public Jinja2Node visitExpression(Jinja2Parser.ExpressionContext ctx) {
        if (ctx == null) return null;

        if (ctx.logical_or() != null) {
            return visitLogical_or(ctx.logical_or());
        }

        return null;
    }

    @Override
    public Jinja2Node visitLogical_or(Jinja2Parser.Logical_orContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;

        List<Jinja2Parser.Logical_andContext> andCtxs = ctx.logical_and();

        if (andCtxs.size() == 1) {
            return visitLogical_and(andCtxs.get(0));
        } else {
            Jinja2Expression left = (Jinja2Expression) visitLogical_and(andCtxs.get(0));
            for (int i = 1; i < andCtxs.size(); i++) {
                Jinja2Expression right = (Jinja2Expression) visitLogical_and(andCtxs.get(i));
                left = new Jinja2Operator("or", left, right, line);
            }
            return left;
        }
    }

    @Override
    public Jinja2Node visitLogical_and(Jinja2Parser.Logical_andContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;

        List<Jinja2Parser.EqualityContext> equalityCtxs = ctx.equality();

        if (equalityCtxs.size() == 1) {
            return visitEquality(equalityCtxs.get(0));
        } else {
            Jinja2Expression left = (Jinja2Expression) visitEquality(equalityCtxs.get(0));
            for (int i = 1; i < equalityCtxs.size(); i++) {
                Jinja2Expression right = (Jinja2Expression) visitEquality(equalityCtxs.get(i));
                left = new Jinja2Operator("and", left, right, line);
            }
            return left;
        }
    }

    @Override
    public Jinja2Node visitEquality(Jinja2Parser.EqualityContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;

        Jinja2Expression left = (Jinja2Expression) visitComparison(ctx.comparison(0));

        if (ctx.comparison().size() > 1) {
            String operator = "";
            if (ctx.V_EQ() != null) operator = "==";
            else if (ctx.V_NE() != null) operator = "!=";
            else if (ctx.V_IS() != null) operator = "is";

            Jinja2Expression right = (Jinja2Expression) visitComparison(ctx.comparison(1));
            return new Jinja2Operator(operator, left, right, line);
        }

        return left;
    }

    @Override
    public Jinja2Node visitComparison(Jinja2Parser.ComparisonContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;

        Jinja2Expression left = (Jinja2Expression) visitTerm(ctx.term(0));

        if (ctx.term().size() > 1) {
            String operator = "";
            if (ctx.V_LT() != null) operator = "<";
            else if (ctx.V_GT() != null) operator = ">";
            else if (ctx.V_LE() != null) operator = "<=";
            else if (ctx.V_GE() != null) operator = ">=";
            else if (ctx.V_IN() != null) operator = "in";

            Jinja2Expression right = (Jinja2Expression) visitTerm(ctx.term(1));
            return new Jinja2Operator(operator, left, right, line);
        }

        return left;
    }

    @Override
    public Jinja2Node visitTerm(Jinja2Parser.TermContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;

        Jinja2Expression left = (Jinja2Expression) visitFactor(ctx.factor(0));

        for (int i = 1; i < ctx.factor().size(); i++) {
            String operator = "";
            if (i-1 < ctx.V_PLUS().size() && ctx.V_PLUS(i-1) != null) operator = "+";
            else if (i-1 < ctx.V_MINUS().size() && ctx.V_MINUS(i-1) != null) operator = "-";

            Jinja2Expression right = (Jinja2Expression) visitFactor(ctx.factor(i));
            left = new Jinja2Operator(operator, left, right, line);
        }

        return left;
    }

    @Override
    public Jinja2Node visitFactor(Jinja2Parser.FactorContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;

        Jinja2Expression left = (Jinja2Expression) visitUnary(ctx.unary(0));

        for (int i = 1; i < ctx.unary().size(); i++) {
            String operator = "";
            if (i-1 < ctx.V_MULT().size() && ctx.V_MULT(i-1) != null) operator = "*";
            else if (i-1 < ctx.V_DIV().size() && ctx.V_DIV(i-1) != null) operator = "/";
            else if (i-1 < ctx.V_MOD().size() && ctx.V_MOD(i-1) != null) operator = "%";

            Jinja2Expression right = (Jinja2Expression) visitUnary(ctx.unary(i));
            left = new Jinja2Operator(operator, left, right, line);
        }

        return left;
    }

    @Override
    public Jinja2Node visitUnary(Jinja2Parser.UnaryContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;

        Jinja2Expression primary = (Jinja2Expression) visitPrimary(ctx.primary());

        if (ctx.V_PLUS() != null) {
            return new Jinja2Operator("+", primary, line);
        } else if (ctx.V_MINUS() != null) {
            return new Jinja2Operator("-", primary, line);
        } else if (ctx.V_NOT() != null) {
            return new Jinja2Operator("not", primary, line);
        }

        return primary;
    }

    @Override
    public Jinja2Node visitPrimary(Jinja2Parser.PrimaryContext ctx) {
        if (ctx == null) return null;

        if (ctx.literal() != null) {
            return visitLiteral(ctx.literal());
        } else if (ctx.identifier() != null) {
            return visitIdentifier(ctx.identifier());
        } else if (ctx.function_call() != null) {
            return visitFunction_call(ctx.function_call());
        } else if (ctx.expression() != null) {
            return visitExpression(ctx.expression());
        }

        return null;
    }

    @Override
    public Jinja2Node visitLiteral(Jinja2Parser.LiteralContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;

        if (ctx.string_literal() != null && ctx.string_literal().V_STRING() != null) {
            String value = ctx.string_literal().V_STRING().getText();
            // إزالة علامات الاقتباس
            if (value.length() >= 2) {
                value = value.substring(1, value.length() - 1);
            }
            return new Jinja2Literal(value, "string", line);
        } else if (ctx.V_NUMBER() != null) {
            String numberText = ctx.V_NUMBER().getText();
            // محاولة التحليل كـ double أو integer
            try {
                if (numberText.contains(".")) {
                    return new Jinja2Literal(Double.parseDouble(numberText), "number", line);
                } else {
                    return new Jinja2Literal(Integer.parseInt(numberText), "number", line);
                }
            } catch (NumberFormatException e) {
                return new Jinja2Literal(numberText, "number", line);
            }
        }

        return null;
    }

    @Override
    public Jinja2Node visitIdentifier(Jinja2Parser.IdentifierContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;

        List<TerminalNode> idNodes = ctx.V_ID();
        if (idNodes.isEmpty()) return null;

        Jinja2Identifier result = new Jinja2Identifier(idNodes.get(0).getText(), line);
        Jinja2Identifier current = result;

        for (int i = 1; i < idNodes.size(); i++) {
            Jinja2Identifier next = new Jinja2Identifier(idNodes.get(i).getText(), line);
            current.setNext(next);
            current = next;
        }

        return result;
    }

    @Override
    public Jinja2Node visitFunction_call(Jinja2Parser.Function_callContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;

        String functionName = ctx.V_ID() != null ? ctx.V_ID().getText() : "";
        Jinja2Identifier funcId = new Jinja2Identifier(functionName, line);

        List<Jinja2Expression> positionalArgs = new ArrayList<>();
        List<Jinja2Assignment> keywordArgs = new ArrayList<>();

        if (ctx.call_arguments() != null) {
            for (Jinja2Parser.Call_argumentContext argCtx : ctx.call_arguments().call_argument()) {
                if (argCtx.expression() != null && argCtx.V_ID() == null) {
                    // Positional argument
                    Jinja2Expression arg = (Jinja2Expression) visitExpression(argCtx.expression());
                    if (arg != null) {
                        positionalArgs.add(arg);
                    }
                } else if (argCtx.V_ID() != null && argCtx.expression() != null) {
                    // Keyword argument
                    String key = argCtx.V_ID().getText();
                    Jinja2Expression value = (Jinja2Expression) visitExpression(argCtx.expression());
                    Jinja2Identifier keyId = new Jinja2Identifier(key, line);
                    Jinja2Assignment assignment = new Jinja2Assignment(keyId, value, line);
                    keywordArgs.add(assignment);
                }
            }
        }

        return new Jinja2FunctionCall(funcId, positionalArgs, keywordArgs, line);
    }

    @Override
    public Jinja2Node visitAssignment(Jinja2Parser.AssignmentContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;

        String varName = ctx.B_ID() != null ? ctx.B_ID().getText() : "";
        Jinja2Identifier variable = new Jinja2Identifier(varName, line);

        Jinja2Expression value = (Jinja2Expression) visitExpression(ctx.expression());

        return new Jinja2Assignment(variable, value, line);
    }

    @Override
    public Jinja2Node visitCondition(Jinja2Parser.ConditionContext ctx) {
        if (ctx == null) return null;

        return visitExpression(ctx.expression());
    }

    @Override
    public Jinja2Node visitString_literal(Jinja2Parser.String_literalContext ctx) {
        // يتم التعامل مع string_literal في visitLiteral
        return null;
    }

    @Override
    protected Jinja2Node aggregateResult(Jinja2Node aggregate, Jinja2Node nextResult) {
        return nextResult == null ? aggregate : nextResult;
    }
}