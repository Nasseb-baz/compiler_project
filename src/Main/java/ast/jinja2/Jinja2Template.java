package Main.java.ast.jinja2;

import Main.java.visitor.Visitor;
import java.util.List;

public class Jinja2Template extends Jinja2Node {
    private List<Jinja2Node> elements;

    public Jinja2Template(int lineNumber, List<Jinja2Node> elements) {
        super("Jinja2Template", lineNumber);
        this.elements = elements;
    }

    public List<Jinja2Node> getElements() {
        return elements;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}