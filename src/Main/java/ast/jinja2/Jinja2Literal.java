package Main.java.ast.jinja2;

import Main.java.visitor.Visitor;

public class Jinja2Literal extends Jinja2Expression {
    private Object value;
    private String type; // "string" or "number"

    public Jinja2Literal(Object value, String type, int lineNumber) {
        super( lineNumber,"Jinja2Literal");
        this.value = value;
        this.type = type;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Object getValue() { return value; }
    public void setValue(Object value) { this.value = value; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}