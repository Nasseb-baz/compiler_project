package Main.java.ast;


import Main.java.visitor.Visitor;
import java.util.List;

public class DictLiteral extends Expression {
    private List<KeyValue> entries;

    public DictLiteral(int lineNumber, List<KeyValue> entries) {
        super("DictLiteral", lineNumber);
        this.entries = entries;
    }

    public List<KeyValue> getEntries() {
        return entries;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}