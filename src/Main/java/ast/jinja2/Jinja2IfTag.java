package Main.java.ast.jinja2;

import Main.java.visitor.Visitor;
import java.util.List;

public class Jinja2IfTag extends Jinja2Node {
    private Jinja2Expression condition;
    private List<Jinja2Node> thenBlock;
    private List<Jinja2ElifBlock> elifBlocks;
    private Jinja2ElseBlock elseBlock;

    public Jinja2IfTag(int lineNumber, Jinja2Expression condition,  List<Jinja2Node> thenBlock,
                       List<Jinja2ElifBlock> elifBlocks, Jinja2ElseBlock elseBlock) {
        super("Jinja2IfTag", lineNumber);
        this.condition = condition;
        this.thenBlock = thenBlock;
        this.elifBlocks = elifBlocks;
        this.elseBlock = elseBlock;
    }

    public Jinja2Expression getCondition() {
        return condition;
    }

    public List<Jinja2Node> getThenBlock() {
        return thenBlock;
    }

    public List<Jinja2ElifBlock> getElifBlocks() {
        return elifBlocks;
    }

    public Jinja2ElseBlock getElseBlock() {
        return elseBlock;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
