package Main.java.visitor;


import Main.java.ast.*;
import java.util.List;

public class PrintVisitor implements Visitor {
    private int indentLevel = 0;

    private void printIndent() {
        for (int i = 0; i < indentLevel; i++) {
            System.out.print("  ");
        }
    }

    @Override
    public void visit(Program node) {
        printIndent();
        System.out.println("Program (line " + node.getLineNumber() + ")");
        indentLevel++;
        for (ASTNode child : node.getChildren()) {
            child.accept(this);
        }
        indentLevel--;
    }

    @Override
    public void visit(Import node) {
        printIndent();
        System.out.print("Import (line " + node.getLineNumber() + ")");
        if (node.getModule() != null) {
            System.out.print("\n");
            indentLevel++;
            printIndent();
            System.out.println("From: " + node.getModule());
            printIndent();
            System.out.print("Names: ");
            System.out.println(String.join(", ", node.getNames()));
            indentLevel--;
        } else {
            System.out.print(" Names: ");
            System.out.println(String.join(", ", node.getNames()));
        }
    }

    @Override
    public void visit(Assign node) {
        printIndent();
        System.out.println("Assign (line " + node.getLineNumber() + ")");
        indentLevel++;
        printIndent();
        System.out.println("Target:");
        indentLevel++;
        node.getTarget().accept(this);
        indentLevel--;
        printIndent();
        System.out.println("Value:");
        indentLevel++;
        node.getValue().accept(this);
        indentLevel--;
        indentLevel--;
    }

    @Override
    public void visit(FunctionDef node) {
        printIndent();
        System.out.print("FunctionDef " + node.getName() + "[");
        System.out.print(String.join(", ", node.getParameters()));
        System.out.println("] (line " + node.getLineNumber() + ")");
        indentLevel++;
        node.getBody().accept(this);
        indentLevel--;
    }

    @Override
    public void visit(Block node) {
        printIndent();
        System.out.println("Block (line " + node.getLineNumber() + ")");
        indentLevel++;
        for (Statement stmt : node.getStatements()) {
            stmt.accept(this);
        }
        indentLevel--;
    }

    @Override
    public void visit(If node) {
        printIndent();
        System.out.println("If (line " + node.getLineNumber() + ")");
        indentLevel++;
        printIndent();
        System.out.println("Condition:");
        indentLevel++;
        node.getCondition().accept(this);
        indentLevel--;
        printIndent();
        System.out.println("Then:");
        indentLevel++;
        node.getThenBlock().accept(this);
        indentLevel--;
        if (node.getElseBlock() != null) {
            printIndent();
            System.out.println("Else:");
            indentLevel++;
            node.getElseBlock().accept(this);
            indentLevel--;
        }
        indentLevel--;
    }

    @Override
    public void visit(For node) {
        printIndent();
        System.out.println("For (line " + node.getLineNumber() + ")");
        indentLevel++;
        printIndent();
        System.out.println("Loop Variable:");
        indentLevel++;
        System.out.println(node.getLoopVariable());
        indentLevel--;
        printIndent();
        System.out.println("Iterable:");
        indentLevel++;
        node.getIterable().accept(this);
        indentLevel--;
        printIndent();
        System.out.println("Body:");
        indentLevel++;
        node.getBody().accept(this);
        indentLevel--;
        indentLevel--;
    }

    @Override
    public void visit(Return node) {
        printIndent();
        System.out.println("Return (line " + node.getLineNumber() + ")");
        if (node.getValue() != null) {
            indentLevel++;
            node.getValue().accept(this);
            indentLevel--;
        }
    }

    @Override
    public void visit(ExprStmt node) {
        printIndent();
        System.out.println("ExprStmt (line " + node.getLineNumber() + ")");
        indentLevel++;
        node.getExpression().accept(this);
        indentLevel--;
    }

    @Override
    public void visit(IdentifierExpr node) {
        printIndent();
        System.out.println("IdentifierExpr (line " + node.getLineNumber() + ") " + node.getName());
    }

    @Override
    public void visit(NumberExpr node) {
        printIndent();
        System.out.println("NumberExpr (line " + node.getLineNumber() + ") " + node.getValue());
    }

    @Override
    public void visit(StringExpr node) {
        printIndent();
        System.out.println("StringExpr (line " + node.getLineNumber() + ") \"" + node.getValue() + "\"");
    }

    @Override
    public void visit(BinaryExpr node) {
        printIndent();
        System.out.println("BinaryExpr '" + node.getOperator() + "' (line " + node.getLineNumber() + ")");
        indentLevel++;
        printIndent();
        System.out.println("Left:");
        indentLevel++;
        node.getLeft().accept(this);
        indentLevel--;
        printIndent();
        System.out.println("Right:");
        indentLevel++;
        node.getRight().accept(this);
        indentLevel--;
        indentLevel--;
    }

    @Override
    public void visit(AttributeExpr node) {
        printIndent();
        System.out.println("AttributeExpr (line " + node.getLineNumber() + ")");
        indentLevel++;
        printIndent();
        System.out.println("Target:");
        indentLevel++;
        node.getTarget().accept(this);
        indentLevel--;
        printIndent();
        System.out.println("Attribute: " + node.getAttribute());
        indentLevel--;
    }

    @Override
    public void visit(FunctionCallExpr node) {
        printIndent();
        System.out.println("FunctionCallExpr (line " + node.getLineNumber() + ")");
        indentLevel++;
        printIndent();
        System.out.println("Callee:");
        indentLevel++;
        node.getCallee().accept(this);
        indentLevel--;
        printIndent();
        System.out.println("Args:");
        indentLevel++;
        for (Expression arg : node.getArguments()) {
            arg.accept(this);
        }
        indentLevel--;
        indentLevel--;
    }

    @Override
    public void visit(DictLiteral node) {
        printIndent();
        System.out.println("DictLiteral (line " + node.getLineNumber() + ")");
        indentLevel++;
        for (KeyValue kv : node.getEntries()) {
            kv.accept(this);
        }
        indentLevel--;
    }

    @Override
    public void visit(ArrayLiteral node) {
        printIndent();
        System.out.println("ArrayLiteral (line " + node.getLineNumber() + ")");
        indentLevel++;
        for (Expression elem : node.getElements()) {
            elem.accept(this);
        }
        indentLevel--;
    }

    @Override
    public void visit(KeyValue node) {
        printIndent();
        System.out.println("KeyValue (line " + node.getLineNumber() + ")");
        indentLevel++;
        printIndent();
        System.out.println("Key:");
        indentLevel++;
        node.getKey().accept(this);
        indentLevel--;
        printIndent();
        System.out.println("Value:");
        indentLevel++;
        node.getValue().accept(this);
        indentLevel--;
        indentLevel--;
    }

    @Override
    public void visit(IndexExpr node) {
        printIndent();
        System.out.println("IndexExpr (line " + node.getLineNumber() + ")");
        indentLevel++;
        printIndent();
        System.out.println("Array:");
        indentLevel++;
        node.getArray().accept(this);
        indentLevel--;
        printIndent();
        System.out.println("Index:");
        indentLevel++;
        node.getIndex().accept(this);
        indentLevel--;
        indentLevel--;
    }

    @Override
    public void visit(KeywordArgExpr node) {
        printIndent();
        System.out.println("KeywordArgExpr (line " + node.getLineNumber() + ")");
        indentLevel++;
        printIndent();
        System.out.println("Key: " + node.getKey());
        printIndent();
        System.out.println("Value:");
        indentLevel++;
        node.getValue().accept(this);
        indentLevel--;
        indentLevel--;
    }
}