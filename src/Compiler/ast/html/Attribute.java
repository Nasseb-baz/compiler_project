package Compiler.ast.html;


import Compiler.ast.Node;
import Compiler.ast.Visitor;

public class Attribute extends Node {
    private String name;
    private String value;

    public Attribute(String name, String value, int lineNumber) {
        super("Attribute", lineNumber);
        this.name = name;
        this.value = value;
    }

    // Constructor بدون قيمة (لسمات boolean مثل 'required')
    public Attribute(String name, int lineNumber) {
        this(name, "", lineNumber);
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public boolean hasValue() {
        return value != null && !value.isEmpty();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        if (hasValue()) {
            return name + "=\"" + value + "\"";
        } else {
            return name;  // لسمات مثل 'disabled', 'required'
        }
    }
}