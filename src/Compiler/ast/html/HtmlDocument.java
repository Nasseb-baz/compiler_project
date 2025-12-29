package Compiler.ast.html;

import Compiler.ast.Node;
import Compiler.ast.Visitor;
import java.util.ArrayList;
import java.util.List;

public class HtmlDocument extends Node {
    private List<HtmlElement> elements;

    public HtmlDocument(int lineNumber) {
        super("HtmlDocument", lineNumber);
        this.elements = new ArrayList<>();
    }

    public void addChild(HtmlElement element) {
        elements.add(element);
    }

    public List<HtmlElement> getElements() {
        return elements;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getNodeInfo()).append(" {\n");

        for (HtmlElement element : elements) {
            String elementStr = element.toString();
            for (String line : elementStr.split("\n")) {
                sb.append("  ").append(line).append("\n");
            }
        }

        sb.append("}");
        return sb.toString();
    }
}