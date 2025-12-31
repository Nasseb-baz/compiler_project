package Main.java.ast;
import Main.java.visitor.Visitor;
public class KeywordArgExpr extends Expression {
    private String key;
    private Expression value;

    public KeywordArgExpr(int lineNumber, String key, Expression value) {
        super("KeywordArgExpr", lineNumber);
        this.key = key;
        this.value = value;
    }

    public String getKey() {
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