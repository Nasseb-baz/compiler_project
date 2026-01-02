package Main.java.ast.jinja2;

import Main.java.visitor.Visitor;

public class
Jinja2Text extends Jinja2Node {
    private String content;

    public Jinja2Text(int lineNumber, String content) {
        super("Jinja2Text", lineNumber);
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