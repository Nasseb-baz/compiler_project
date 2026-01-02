package Main.java.ast.jinja2;

import Main.java.visitor.Visitor;

// For assignments in set/with blocks
public class Jinja2Assignment extends Jinja2Node {
    private Jinja2Identifier variable;
    private Jinja2Expression value;

    public Jinja2Assignment(Jinja2Identifier variable, Jinja2Expression value, int lineNumber) {
        super("Jinja2Assignment", lineNumber);
        this.variable = variable;
        this.value = value;
    }

    // Getters and setters
    public Jinja2Identifier getVariable() { return variable; }
    public void setVariable(Jinja2Identifier variable) { this.variable = variable; }

    public Jinja2Expression getValue() { return value; }
    public void setValue(Jinja2Expression value) { this.value = value; }

    /**
     * @param visitor
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}