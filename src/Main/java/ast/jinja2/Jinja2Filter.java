package Main.java.ast.jinja2;

import Main.java.visitor.Visitor;
import java.util.List;

public class Jinja2Filter extends Jinja2Node {
    private String name;
    private List<Jinja2Expression> arguments;

    public Jinja2Filter(int lineNumber, String name, List<Jinja2Expression> arguments) {
        super("Jinja2Filter", lineNumber);
        this.name = name;
        this.arguments = arguments;
    }

    public String getName() {
        return name;
    }

    public List<Jinja2Expression> getArguments() {
        return arguments;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
