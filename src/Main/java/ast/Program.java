package Main.java.ast;
import Main.java.visitor.Visitor;

public class Program extends Statement {
    public Program(int lineNumber) {
        super("Program", lineNumber);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}