package Main.java.ast.python;


import Main.java.visitor.Visitor;

public class KeyValue extends Expression {
    private Expression key;
    private Expression value;

    public KeyValue(int lineNumber, Expression key, Expression value) {
        super("KeyValue", lineNumber);
        this.key = key;
        this.value = value;
    }

    public Expression getKey() {
        return key;
    }

    public Expression getValue() {
        return value;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}