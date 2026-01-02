package Main.java.ast.python;


import Main.java.visitor.Visitor;

public class IdentifierExpr extends Expression {
    private String name;

    public IdentifierExpr(int lineNumber, String name) {
        super("IdentifierExpr", lineNumber);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}