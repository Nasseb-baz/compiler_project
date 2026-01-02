package Main.java.ast.jinja2;

import Main.java.visitor.Visitor;

public class Jinja2Expression extends Jinja2Node {
    private String expression;

    public Jinja2Expression(int lineNumber, String expression) {
        super("Jinja2Expression", lineNumber);
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
