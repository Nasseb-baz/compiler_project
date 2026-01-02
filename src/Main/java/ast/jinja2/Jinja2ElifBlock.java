package Main.java.ast.jinja2;

import Main.java.visitor.Visitor;
import java.util.*;
public class Jinja2ElifBlock extends Jinja2Node {
    private Jinja2Expression condition;
    private List<Jinja2Node> body ;

    public Jinja2ElifBlock(int lineNumber, Jinja2Expression condition, List<Jinja2Node> body) {
        super("Jinja2ElifBlock", lineNumber);
        this.condition = condition;
        this.body = body;
    }

    public Jinja2Expression getCondition() {
        return condition;
    }

    public List<Jinja2Node> getBody() {
        return body;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}