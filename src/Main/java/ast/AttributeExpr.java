package Main.java.ast;


import Main.java.visitor.Visitor;

public class AttributeExpr extends Expression {
    private Expression target;
    private String attribute;

    public AttributeExpr(int lineNumber, Expression target, String attribute) {
        super("AttributeExpr", lineNumber);
        this.target = target;
        this.attribute = attribute;
    }

    public Expression getTarget() {
        return target;
    }

    public String getAttribute() {
        return attribute;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}