package Main.java.ast.jinja2;

import Main.java.visitor.Visitor;
import java.util.List;

public class Jinja2Variable extends Jinja2Node {
    private Jinja2Expression expression;
    private List<Jinja2Filter> filters;

    public Jinja2Variable(int lineNumber, Jinja2Expression expression, List<Jinja2Filter> filters) {
        super("Jinja2Variable", lineNumber);
        this.expression = expression;
        this.filters = filters;
    }

    public Jinja2Expression getExpression() {
        return expression;
    }

    public List<Jinja2Filter> getFilters() {
        return filters;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}