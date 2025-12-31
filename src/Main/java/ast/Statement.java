package Main.java.ast;

public abstract class Statement extends ASTNode {
    public Statement(String nodeName, int lineNumber) {
        super(nodeName, lineNumber);
    }
}