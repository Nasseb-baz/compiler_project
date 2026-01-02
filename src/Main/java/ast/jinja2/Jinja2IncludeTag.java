package Main.java.ast.jinja2;


import Main.java.visitor.Visitor;
import java.util.Map;

public class Jinja2IncludeTag extends Jinja2Node {
    private String templateName;
    private Map<String, Jinja2Expression> context;

    public Jinja2IncludeTag(int lineNumber, String templateName, Map<String, Jinja2Expression> context) {
        super("Jinja2IncludeTag", lineNumber);
        this.templateName = templateName;
        this.context = context;
    }

    public String getTemplateName() {
        return templateName;
    }

    public Map<String, Jinja2Expression> getContext() {
        return context;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}