package Main.java.ast.jinja2;

import Main.java.visitor.Visitor;

public class Jinja2Comment extends Jinja2Node {
    private String content;

    public Jinja2Comment(int lineNumber, String content) {
        super("Jinja2Comment", lineNumber);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}