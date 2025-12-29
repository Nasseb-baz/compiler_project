package Compiler.ast.html;


import Compiler.ast.Node;
import Compiler.ast.Visitor;

public class TextNode extends Node {
    private String content;

    public TextNode(String content, int lineNumber) {
        super("TextNode", lineNumber);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return getNodeInfo() + " - \"" + content + "\"";
    }
}
