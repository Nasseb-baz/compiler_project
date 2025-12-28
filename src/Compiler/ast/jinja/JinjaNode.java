package Compiler.ast.jinja;

import Compiler.ast.Node;

public abstract class JinjaNode extends Node {
    public JinjaNode(String nodeName, int lineNumber) {
        super(nodeName, lineNumber);
    }
}
