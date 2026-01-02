package Main.java.ast.jinja2;


import  Main.java.visitor.Visitor;

public class Jinja2ExtendsTag extends Jinja2Node {
    private String templateName;

    public Jinja2ExtendsTag(int lineNumber, String templateName) {
        super("Jinja2ExtendsTag", lineNumber);
        this.templateName = templateName;
    }

    public String getTemplateName() {
        return templateName;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}