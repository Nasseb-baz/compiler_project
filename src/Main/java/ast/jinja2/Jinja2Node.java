package Main.java.ast.jinja2;
import Main.java.ast.ASTNode;
import Main.java.visitor.Visitor;
public abstract class Jinja2Node extends ASTNode {
    public Jinja2Node(String nodeName, int lineNumber) {
        super(nodeName, lineNumber);
    }

    @Override
    public abstract void accept(Visitor visitor);
}
