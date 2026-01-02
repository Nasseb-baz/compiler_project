package Main.java.ast.python;


import Main.java.visitor.Visitor;

public class Return extends Statement {
    private Expression value;

    public Return(int lineNumber, Expression value) {
        super("Return", lineNumber);
        this.value = value;
    }

    public Expression getValue() {
        return value;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}