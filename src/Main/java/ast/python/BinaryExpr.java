package Main.java.ast.python;


import Main.java.visitor.Visitor;

public class BinaryExpr extends Expression {
    private String operator;
    private Expression left;
    private Expression right;

    public BinaryExpr(int lineNumber, String operator, Expression left, Expression right) {
        super("BinaryExpr", lineNumber);
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    public String getOperator() {
        return operator;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}