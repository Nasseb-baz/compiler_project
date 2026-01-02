package Main.java.ast.jinja2;

import Main.java.visitor.Visitor;

import java.util.List;

public class Jinja2ElseBlock extends Jinja2Node {
    private List<Jinja2Node> content;

    public Jinja2ElseBlock(List<Jinja2Node> content, int lineNumber) {
        super("Jinja2ElseBlock", lineNumber);  // Call to parent constructor
        this.content = content;
    }

    // Getters and setters
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