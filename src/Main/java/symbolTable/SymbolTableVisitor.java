package Main.java.symbolTable;
import Main.java.ast.*;
import Main.java.visitor.Visitor;
public class SymbolTableVisitor implements Visitor{
    private SymbolTable symbolTable;

    public SymbolTableVisitor() {
        this.symbolTable = new SymbolTable();
    }

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    public void printSymbolTable() {
        symbolTable.printTable();
    }

    @Override
    public void visit(Program node) {
        // زيارة جميع الأطفال
        for (ASTNode child : node.getChildren()) {
            child.accept(this);
        }
    }

    @Override
    public void visit(Import node) {
        // لا نضيف الـ imports إلى جدول الرموز
        for (String name : node.getNames()) {
            symbolTable.insert(name, "imported", node.getLineNumber());
    }}

    @Override
    public void visit(Assign node) {
        // زيارة القيمة أولاً
        if (node.getValue() != null) {
            node.getValue().accept(this);
        }

        // إضافة المتغير إلى جدول الرموز
        if (node.getTarget() instanceof IdentifierExpr) {
            IdentifierExpr target = (IdentifierExpr) node.getTarget();
            String varName = target.getName();
            String type = inferType(node.getValue());

            symbolTable.insert(varName, type, node.getLineNumber());

        }
    }

    @Override
    public void visit(FunctionDef node) {
        // إضافة اسم الدالة إلى جدول الرموز
        symbolTable.insert(node.getName(), "function", node.getLineNumber());

        // دخول نطاق جديد للدالة
        symbolTable.enterScope(node.getName());

        // إضافة البارامترات
        for (String param : node.getParameters()) {
            symbolTable.insert(param, "parameter", node.getLineNumber());
        }

        // زيارة جسم الدالة
        node.getBody().accept(this);

        // الخروج من نطاق الدالة
        symbolTable.exitScope();
    }

    @Override
    public void visit(Block node) {
        for (Statement stmt : node.getStatements()) {
            stmt.accept(this);
        }
    }

    @Override
    public void visit(If node) {
        // زيارة الشرط
        node.getCondition().accept(this);

        // دخول نطاق الـ if
        symbolTable.enterScope("if_block");
        node.getThenBlock().accept(this);
        symbolTable.exitScope();

        // إذا كان هناك else
        if (node.getElseBlock() != null) {
            symbolTable.enterScope("else_block");
            node.getElseBlock().accept(this);
            symbolTable.exitScope();
        }
    }

    @Override
    public void visit(For node) {
        // إضافة متغير الحلقة
        symbolTable.insert(node.getLoopVariable(), "loop_var", node.getLineNumber());

        // زيارة التكرار
        node.getIterable().accept(this);

        // دخول نطاق الحلقة
        symbolTable.enterScope("for_loop");
        node.getBody().accept(this);
        symbolTable.exitScope();
    }

    @Override
    public void visit(Return node) {
        if (node.getValue() != null) {
            node.getValue().accept(this);
        }
    }

    @Override
    public void visit(ExprStmt node) {
        if (node.getExpression() != null) {
            node.getExpression().accept(this);
        }
    }

    // ========== Expressions ==========

    @Override
    public void visit(IdentifierExpr node) {
        // البحث عن المعرف في جدول الرموز
        Symbol symbol = symbolTable.lookup(node.getName());
        if (symbol != null) {
            //System.out.println("Identifier used: " + node.getName() + " (found in scope: " + symbol.getScope() + ")");
        } else {
           // System.out.println("WARNING: Undefined identifier: " + node.getName() + " at line " + node.getLineNumber());
        }
    }

    @Override
    public void visit(NumberExpr node) {
        // لا شيء للقيام به
    }

    @Override
    public void visit(StringExpr node) {
        // لا شيء للقيام به
    }

    @Override
    public void visit(BinaryExpr node) {
        node.getLeft().accept(this);
        node.getRight().accept(this);
    }

    @Override
    public void visit(AttributeExpr node) {
        node.getTarget().accept(this);
    }

    @Override
    public void visit(FunctionCallExpr node) {
        node.getCallee().accept(this);
        for (Expression argument : node.getArguments()) {
            argument.accept(this);
        }
    }

    @Override
    public void visit(DictLiteral node) {
        for (KeyValue kv : node.getEntries()) {
            kv.accept(this);
        }
    }

    @Override
    public void visit(ArrayLiteral node) {
        for (Expression elem : node.getElements()) {
            elem.accept(this);
        }
    }

    @Override
    public void visit(KeyValue node) {
        node.getKey().accept(this);
        node.getValue().accept(this);
    }

    @Override
    public void visit(IndexExpr node) {
        node.getArray().accept(this);
        node.getIndex().accept(this);
    }

    @Override
    public void visit(KeywordArgExpr node) {
        node.getValue().accept(this);
    }

    // ========== Helper Methods ==========

    private String inferType(Expression expr) {
        if (expr == null) {
            return "unknown";
        }

        if (expr instanceof NumberExpr) {
            return "number";
        } else if (expr instanceof StringExpr) {
            return "string";
        } else if (expr instanceof IdentifierExpr) {
            IdentifierExpr idExpr = (IdentifierExpr) expr;
            if (idExpr.getName().equals("True") || idExpr.getName().equals("False")) {
                return "boolean";
            } else if (idExpr.getName().equals("None")) {
                return "none";
            }
            return "identifier";
        } else if (expr instanceof ArrayLiteral) {
            return "list";
        } else if (expr instanceof DictLiteral) {
            return "dict";
        } else if (expr instanceof FunctionCallExpr) {
            return "function_call";
        } else if (expr instanceof BinaryExpr) {
            return "expression";
        }

        return "unknown";
    }
}
