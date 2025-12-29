package Compiler.ast.jinja;

import Compiler.ast.Node;
import Compiler.ast.Visitor;

public class JinjaLiteral extends JinjaNode {
    private String value;
    private String type;  // "string", "number", "boolean"

    public JinjaLiteral(String value, String type, int lineNumber) {
        super("JinjaLiteral", lineNumber);
        this.value = value;
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return getNodeInfo() + " - " + type + ": " + value;
    }
}