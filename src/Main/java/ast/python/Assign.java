package Main.java.ast.python;
import Main.java.visitor.Visitor;
public class Assign extends Statement {
    private Expression target;
    private Expression value;

    public Assign(int lineNumber, Expression target, Expression value) {
        super("Assign", lineNumber);
        this.target = target;
        this.value = value;
    }

    public Expression getTarget() {
        return target;
    }

    public Expression getValue() {
        return value;
    }


    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}