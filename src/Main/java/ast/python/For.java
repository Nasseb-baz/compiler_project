package Main.java.ast.python;


import  Main.java.visitor.Visitor;

public class For extends Statement {
    private String loopVariable;
    private Expression iterable;
    private Block body;

    public For(int lineNumber, String loopVariable, Expression iterable, Block body) {
        super("For", lineNumber);
        this.loopVariable = loopVariable;
        this.iterable = iterable;
        this.body = body;
    }

    public String getLoopVariable() {
        return loopVariable;
    }

    public Expression getIterable() {
        return iterable;
    }

    public Block getBody() {
        return body;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}