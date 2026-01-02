package Main.java.ast.jinja2;

import Main.java.visitor.Visitor;

import java.util.List;

// For {% with %} blocks (handles both with and endwith)
public class Jinja2WithTag extends Jinja2Node {
    private List<Jinja2Assignment> assignments;
    private List<Jinja2Node> content;

    public Jinja2WithTag(List<Jinja2Assignment> assignments, List<Jinja2Node> content, int lineNumber) {
        super("Jinja2WithTag", lineNumber);
        this.assignments = assignments;
        this.content = content;
    }

    // Getters and setters
    public List<Jinja2Assignment> getAssignments() { return assignments; }
    public void setAssignments(List<Jinja2Assignment> assignments) { this.assignments = assignments; }

    public List<Jinja2Node> getContent() { return content; }
    public void setContent(List<Jinja2Node> content) { this.content = content; }

    /**
     * @param visitor
     */
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}