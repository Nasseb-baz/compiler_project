package Main.java.ast.python;



import Main.java.visitor.Visitor;
import java.util.List;

public class Block extends Statement {
    private List<Statement> statements;

    public Block(int lineNumber, List<Statement> statements) {
        super("Block", lineNumber);
        this.statements = statements;
    }

    public List<Statement> getStatements() {
        return statements;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}