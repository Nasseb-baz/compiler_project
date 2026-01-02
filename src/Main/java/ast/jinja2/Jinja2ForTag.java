package Main.java.ast.jinja2;


import Main.java.visitor.Visitor;

import java.util.List;

public class Jinja2ForTag extends Jinja2Node {
    private String variable;
    private Jinja2Expression iterable;
    private List<Jinja2Node>  body;

    public Jinja2ForTag(int lineNumber, String variable, Jinja2Expression iterable, List<Jinja2Node> body) {
        super("Jinja2ForTag", lineNumber);
        this.variable = variable;
        this.iterable = iterable;
        this.body = body;
    }

    public String getVariable() {
        return variable;
    }

    public Jinja2Expression getIterable() {
        return iterable;
    }

    public List<Jinja2Node>  getBody() {
        return body;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
