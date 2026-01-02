package Main.java.ast.python;


import Main.java.ast.ASTNode;

public abstract class Expression extends ASTNode {
    public Expression(String nodeName, int lineNumber) {
        super(nodeName, lineNumber);
    }
}
