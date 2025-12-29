package Compiler.ast.jinja;

import Compiler.ast.Node;
import Compiler.ast.Visitor;

public class JinjaExpression extends JinjaNode {
    private String expression;

    public JinjaExpression(String expression, int lineNumber) {
        super("JinjaExpression", lineNumber);
        this.expression = expression;
    }

    public String getExpression() {
        return expression;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return getNodeInfo() + " - {{ " + expression + " }}";
    }
}
