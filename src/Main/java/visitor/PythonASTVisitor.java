package Main.java.visitor;



import Main.java.antlr.PythonParser;
import Main.java.antlr.PythonParserBaseVisitor;
import Main.java.ast.ASTNode;
import Main.java.ast.python.*;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class PythonASTVisitor extends PythonParserBaseVisitor<ASTNode> {

    @Override
    public ASTNode visitProgram(PythonParser.ProgramContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;
        Program program = new Program(line);

        for (PythonParser.StmtContext stmtCtx : ctx.stmt()) {
            if (stmtCtx != null) {
                ASTNode node = visit(stmtCtx);
                if (node != null) {
                    program.addChild(node);
                }
            }
        }

        return program;
    }

    @Override
    public ASTNode visitImport_stmt(PythonParser.Import_stmtContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;

        if (ctx.FROM() != null) {
            String module = ctx.IDENTIFIER(0).getText();
            List<String> names = new ArrayList<>();

            for (int i = 1; i < ctx.IDENTIFIER().size(); i++) {
                names.add(ctx.IDENTIFIER(i).getText());
            }

            return new Import(line, module, names);
        } else {
            // import statement بدون from
            String module = null;
            List<String> names = new ArrayList<>();

            for (int i = 0; i < ctx.IDENTIFIER().size(); i++) {
                names.add(ctx.IDENTIFIER(i).getText());
            }

            return new Import(line, module, names);
        }
    }

    @Override
    public ASTNode visitAssign_stmt(PythonParser.Assign_stmtContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;
        Expression target = new IdentifierExpr(line, ctx.IDENTIFIER().getText());

        Expression value = null;
        if (ctx.expr() != null) {
            value = (Expression) visit(ctx.expr());
        }

        // إذا كان value فارغًا، أنشئ قيمة افتراضية
        if (value == null) {
            value = new IdentifierExpr(line, "None");
        }

        return new Assign(line, target, value);
    }

    @Override
    public ASTNode visitFuncdef(PythonParser.FuncdefContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;
        String name = ctx.IDENTIFIER().getText();

        List<String> parameters = new ArrayList<>();
        if (ctx.func_args() != null) {
            for (TerminalNode id : ctx.func_args().IDENTIFIER()) {
                parameters.add(id.getText());
            }
        }

        Block body = (Block) visit(ctx.block());
        FunctionDef funcDef = new FunctionDef(line, name, parameters, body);

        // إضافة decorators إذا وجدت
        for (PythonParser.DecoratorContext decoratorCtx : ctx.decorator()) {
            ASTNode decorator = visit(decoratorCtx);
            if (decorator != null) {
                funcDef.addChild(decorator);
            }
        }

        return funcDef;
    }

    @Override
    public ASTNode visitBlock(PythonParser.BlockContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;
        List<Statement> statements = new ArrayList<>();

        for (PythonParser.StmtContext stmtCtx : ctx.stmt()) {
            if (stmtCtx != null) {
                Statement stmt = (Statement) visit(stmtCtx);
                if (stmt != null) {
                    statements.add(stmt);
                }
            }
        }

        return new Block(line, statements);
    }

    @Override
    public ASTNode visitIf_stmt(PythonParser.If_stmtContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;
        Expression condition = (Expression) visit(ctx.expr());
        Block thenBlock = (Block) visit(ctx.block(0));
        Block elseBlock = null;

        if (ctx.block().size() > 1) {
            elseBlock = (Block) visit(ctx.block(1));
        }

        return new If(line, condition, thenBlock, elseBlock);
    }

    @Override
    public ASTNode visitFor_stmt(PythonParser.For_stmtContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;
        String loopVariable = ctx.IDENTIFIER().getText();
        Expression iterable = (Expression) visit(ctx.expr());
        Block body = (Block) visit(ctx.block());

        return new For(line, loopVariable, iterable, body);
    }

    @Override
    public ASTNode visitReturn_stmt(PythonParser.Return_stmtContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;
        Expression value = null;

        if (ctx.expr() != null) {
            value = (Expression) visit(ctx.expr());
        }

        return new Return(line, value);
    }

    @Override
    public ASTNode visitExpr_stmt(PythonParser.Expr_stmtContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;
        Expression expr = (Expression) visit(ctx.expr());

        return new ExprStmt(line, expr);
    }

    @Override
    public ASTNode visitExpr(PythonParser.ExprContext ctx) {
        if (ctx == null){ System.out.println("ExprContext is null!");
            return null;
        }

        int line = ctx.start != null ? ctx.start.getLine() : 1;

        // Literal
        if (ctx.literal() != null) {
            return visit(ctx.literal());
        }

        // Identifier
        if (ctx.IDENTIFIER() != null && ctx.binop() == null && ctx.DOT() == null
                && ctx.LPAREN() == null && ctx.LBRACK() == null && ctx.LBRACE() == null) {
            return new IdentifierExpr(line, ctx.IDENTIFIER().getText());
        }

        // Binary Expression
        if (ctx.binop() != null && ctx.expr().size() == 2) {
            Expression left = (Expression) visit(ctx.expr(0));
            Expression right = (Expression) visit(ctx.expr(1));
            String operator = ctx.binop().getText();

            return new BinaryExpr(line, operator, left, right);
        }

        // Attribute Access: expr DOT IDENTIFIER
        if (ctx.DOT() != null) {
            Expression target = (Expression) visit(ctx.expr(0));
            String attribute = ctx.IDENTIFIER().getText();

            return new AttributeExpr(line, target, attribute);
        }

        // Function Call: expr LPAREN ... RPAREN
        if (ctx.LPAREN() != null && ctx.call_args() != null) {
            Expression callee = (Expression) visit(ctx.expr(0));
            List<Expression> arguments = new ArrayList<>();

            // معالجة arguments
            for (PythonParser.Call_argContext argCtx : ctx.call_args().call_arg()) {
                Expression arg = (Expression) visit(argCtx);
                if (arg != null) {
                    arguments.add(arg);
                }
            }

            return new FunctionCallExpr(line, callee, arguments);
        }

        // Array Index: expr LBRACK expr RBRACK
        if (ctx.LBRACK() != null && ctx.expr().size() == 2) {
            Expression array = (Expression) visit(ctx.expr(0));
            Expression index = (Expression) visit(ctx.expr(1));

            return new IndexExpr(line, array, index);
        }

        // Dict Literal: LBRACE ... RBRACE
        if (ctx.LBRACE() != null) {
            List<KeyValue> entries = new ArrayList<>();

            if (ctx.dict_entries() != null) {
                for (PythonParser.Dict_entryContext entryCtx : ctx.dict_entries().dict_entry()) {
                    KeyValue kv = (KeyValue) visit(entryCtx);
                    if (kv != null) {
                        entries.add(kv);
                    }
                }
            }

            return new DictLiteral(line, entries);
        }

        // Array Literal: LBRACK ... RBRACK (فارغ أو به عناصر)
        if (ctx.LBRACK() != null) {
            List<Expression> elements = new ArrayList<>();

            if (ctx.list_elems() != null) {
                for (PythonParser.ExprContext exprCtx : ctx.list_elems().expr()) {
                    Expression elem = (Expression) visit(exprCtx);
                    if (elem != null) {
                        elements.add(elem);
                    }
                }
            }
            // إذا كانت المصفوفة فارغة []، list_elems() ستكون null
            // ولكن elements ستكون قائمة فارغة وهو الصحيح

            return new ArrayLiteral(line, elements);
        }

        // Parenthesized Expression: (expr)
        if (ctx.LPAREN() != null && ctx.expr().size() == 1 && ctx.call_args() == null) {
            return visit(ctx.expr(0));
        }

        return null;
    }


    @Override
    public ASTNode visitLiteral(PythonParser.LiteralContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;

        if (ctx.NUMBER() != null) {
            double value = Double.parseDouble(ctx.NUMBER().getText());
            return new NumberExpr(line, value);
        }

        if (ctx.STRING() != null) {
            String text = ctx.STRING().getText();
            // إزالة علامات الاقتباس
            String value = text.substring(1, text.length() - 1);
            return new StringExpr(line, value);
        }

        if (ctx.TRUE() != null) {
            return new IdentifierExpr(line, "True");
        }

        if (ctx.FALSE() != null) {
            return new IdentifierExpr(line, "False");
        }

        if (ctx.NONE() != null) {
            return new IdentifierExpr(line, "None");
        }

        return null;
    }

    @Override
    public ASTNode visitDict_entry(PythonParser.Dict_entryContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;
        Expression key = (Expression) visit(ctx.expr(0));
        Expression value = (Expression) visit(ctx.expr(1));

        return new KeyValue(line, key, value);
    }

    @Override
    public ASTNode visitDecorator(PythonParser.DecoratorContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;
        Expression decorator = (Expression) visit(ctx.expr());

        return new ExprStmt(line, decorator);
    }

    @Override
    public ASTNode visitCall_arg(PythonParser.Call_argContext ctx) {
        if (ctx == null) return null;

        if (ctx.expr() != null) {
            return visit(ctx.expr());
        } else if (ctx.keyword_arg() != null) {
            return visit(ctx.keyword_arg());
        }
        return null;
    }

    @Override
    public ASTNode visitKeyword_arg(PythonParser.Keyword_argContext ctx) {
        if (ctx == null) return null;

        int line = ctx.start != null ? ctx.start.getLine() : 1;
        String key = ctx.IDENTIFIER().getText();
        Expression value = (Expression) visit(ctx.expr());

        // استخدام KeywordArgExpr بدلاً من BinaryExpr
        return new KeywordArgExpr(line, key, value);
    }

    // الدوال المساعدة - إرجاع null
    @Override
    public ASTNode visitCall_args(PythonParser.Call_argsContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitDict_entries(PythonParser.Dict_entriesContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitFunc_args(PythonParser.Func_argsContext ctx) {
        return null;
    }

    @Override
    public ASTNode visitList_elems(PythonParser.List_elemsContext ctx) {
        if (ctx == null) return null;

        // لا نحتاج إلى إنشاء عقدة هنا، يتم التعامل معها في visitExpr
        return null;
    }
}