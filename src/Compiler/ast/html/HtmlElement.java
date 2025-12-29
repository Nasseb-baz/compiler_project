package Compiler.ast.html;


import Compiler.ast.Node;
import Compiler.ast.Visitor;
import java.util.ArrayList;
import java.util.List;


public class HtmlElement extends Node {
    private String tagName;
    private List<Attribute> attributes;
    private List<Node> children;

    public HtmlElement(String tagName, int lineNumber) {
        super("HtmlElement", lineNumber);
        this.tagName = tagName;
        this.attributes = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    // Methods
    public void addAttribute(Attribute attr) {
        attributes.add(attr);
    }

    public void addChild(Node child) {
        children.add(child);
    }

    // Getters
    public String getTagName() { return tagName; }
    public List<Attribute> getAttributes() { return attributes; }
    public List<Node> getChildren() { return children; }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getNodeInfo()).append(" - <").append(tagName).append(">");

        if (!attributes.isEmpty()) {
            sb.append(" [");
            for (Attribute attr : attributes) {
                sb.append(attr.toString()).append(", ");
            }
            sb.delete(sb.length()-2, sb.length());
            sb.append("]");
        }

        if (!children.isEmpty()) {
            sb.append(" {\n");
            for (Node child : children) {
                String childStr = child.toString();
                for (String line : childStr.split("\n")) {
                    sb.append("  ").append(line).append("\n");
                }
            }
            sb.append("}");
        }

        return sb.toString();
    }
}
