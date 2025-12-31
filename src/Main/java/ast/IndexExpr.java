package Main.java.ast;


import Main.java.visitor.Visitor;

public class IndexExpr extends Expression {
    private Expression array;
    private Expression index;

    public IndexExpr(int lineNumber, Expression array, Expression index) {
        super("IndexExpr", lineNumber);
        this.array = array;
        this.index = index;
    }

    public Expression getArray() {
        return array;
    }

    public Expression getIndex() {
        return index;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}