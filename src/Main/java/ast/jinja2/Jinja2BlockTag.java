package Main.java.ast.jinja2;


import Main.java.visitor.Visitor;

import java.util.List;

public class Jinja2BlockTag extends Jinja2Node {
    private String name;
    private List<Jinja2Node> content;

    public Jinja2BlockTag(int lineNumber, String name, List<Jinja2Node> content) {
        super("Jinja2BlockTag", lineNumber);
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public List<Jinja2Node>  getContent() {
        return content;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}