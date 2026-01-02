package Main.java.ast.python;


import Main.java.visitor.Visitor;

public class NumberExpr extends Expression {
    private double value;

    public NumberExpr(int lineNumber, double value) {
        super("NumberExpr", lineNumber);
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}