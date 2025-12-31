package Main.java.ast;


import Main.java.visitor.Visitor;

public class ExprStmt extends Statement {
    private Expression expression;

    public ExprStmt(int lineNumber, Expression expression) {
        super("ExprStmt", lineNumber);
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}