package Main.java.ast;



import Main.java.visitor.Visitor;

public class If extends Statement {
    private Expression condition;
    private Block thenBlock;
    private Block elseBlock;

    public If(int lineNumber, Expression condition, Block thenBlock, Block elseBlock) {
        super("If", lineNumber);
        this.condition = condition;
        this.thenBlock = thenBlock;
        this.elseBlock = elseBlock;
    }

    public Expression getCondition() {
        return condition;
    }

    public Block getThenBlock() {
        return thenBlock;
    }

    public Block getElseBlock() {
        return elseBlock;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}