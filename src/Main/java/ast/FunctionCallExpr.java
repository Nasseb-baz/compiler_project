package Main.java.ast;


import Main.java.visitor.Visitor;
import java.util.List;

public class FunctionCallExpr extends Expression {
    private Expression callee;
    private List<Expression> arguments;

    public FunctionCallExpr(int lineNumber, Expression callee, List<Expression> arguments) {
        super("FunctionCallExpr", lineNumber);
        this.callee = callee;
        this.arguments = arguments;
    }

    public Expression getCallee() {
        return callee;
    }

    public List<Expression> getArguments() {
        return arguments;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}