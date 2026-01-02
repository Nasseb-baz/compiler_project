package Main.java.ast.python;

import Main.java.ast.ASTNode;

public abstract class Statement extends ASTNode {
    public Statement(String nodeName, int lineNumber) {
        super(nodeName, lineNumber);
    }
}