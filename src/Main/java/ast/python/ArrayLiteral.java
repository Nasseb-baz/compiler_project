package Main.java.ast.python;


import Main.java.visitor.Visitor;
import java.util.List;

public class ArrayLiteral extends Expression {
    private List<Expression> elements;

    public ArrayLiteral(int lineNumber, List<Expression> elements) {
        super("ArrayLiteral", lineNumber);
        this.elements = elements;
    }

    public List<Expression> getElements() {
        return elements;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}