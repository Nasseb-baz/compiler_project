package Compiler.ast.jinja;


import Compiler.ast.Node;
import Compiler.ast.Visitor;

public class JinjaVariable extends JinjaNode {
    private String name;
    private String property;  // مثل "name" في "product.name"

    public JinjaVariable(String name, int lineNumber) {
        this(name, null, lineNumber);
    }

    public JinjaVariable(String name, String property, int lineNumber) {
        super("JinjaVariable", lineNumber);
        this.name = name;
        this.property = property;
    }

    public String getName() {
        return name;
    }

    public String getProperty() {
        return property;
    }

    public boolean hasProperty() {
        return property != null && !property.isEmpty();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        if (hasProperty()) {
            return getNodeInfo() + " - " + name + "." + property;
        } else {
            return getNodeInfo() + " - " + name;
        }
    }
}