package Main.java.ast;


import Main.java.visitor.Visitor;

public class StringExpr extends Expression {
    private String value;

    public StringExpr(int lineNumber, String value) {
        super("StringExpr", lineNumber);
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}