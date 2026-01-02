package Main.java.ast.jinja2;

import Main.java.visitor.Visitor;

// For variable/function names (chain for dotted names)
public class Jinja2Identifier extends Jinja2Expression {
    private String name;
    private Jinja2Identifier next; // For chaining: user.name.attribute

    public Jinja2Identifier(String name, int lineNumber) {
        super(lineNumber,"Jinja2Identifier");
        this.name = name;
        this.next = null;
    }

    public Jinja2Identifier(String name, Jinja2Identifier next, int lineNumber) {
        super( lineNumber,"Jinja2Identifier");
        this.name = name;
        this.next = next;
    }

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Jinja2Identifier getNext() { return next; }
    public void setNext(Jinja2Identifier next) { this.next = next; }

    // Helper method to get full path
    public String getFullPath() {
        if (next == null) {
            return name;
        }
        return name + "." + next.getFullPath();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}