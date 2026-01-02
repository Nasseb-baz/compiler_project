package Main.java.ast.jinja2;

import Main.java.visitor.Visitor;

public class Jinja2Operator extends Jinja2Expression {
    private String operator;
    private Jinja2Expression leftOperand;
    private Jinja2Expression rightOperand;

    // For binary operators
    public Jinja2Operator(String operator, Jinja2Expression leftOperand,
                          Jinja2Expression rightOperand, int lineNumber) {
        super(lineNumber,"Jinja2Operator");
        this.operator = operator;
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    // For unary operators (like "not")
    public Jinja2Operator(String operator, Jinja2Expression operand, int lineNumber) {
        super( lineNumber,"Jinja2Operator");
        this.operator = operator;
        this.rightOperand = operand; // Use rightOperand for unary
        this.leftOperand = null;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getOperator() { return operator; }
    public void setOperator(String operator) { this.operator = operator; }

    public Jinja2Expression getLeftOperand() { return leftOperand; }
    public void setLeftOperand(Jinja2Expression leftOperand) { this.leftOperand = leftOperand; }

    public Jinja2Expression getRightOperand() { return rightOperand; }
    public void setRightOperand(Jinja2Expression rightOperand) { this.rightOperand = rightOperand; }

    public boolean isUnary() {
        return leftOperand == null && rightOperand != null;
    }

    public boolean isBinary() {
        return leftOperand != null && rightOperand != null;
    }
}