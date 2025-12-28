package Compiler.ast;


public abstract class Node {
    protected String nodeName;
    protected int lineNumber;

    public Node(String nodeName, int lineNumber) {
        this.nodeName = nodeName;
        this.lineNumber = lineNumber;
    }

    // Polymorphic method - كل عقدة تطبقه بشكل مختلف
    public abstract void accept(Visitor visitor);

    // Getters
    public String getNodeName() { return nodeName; }
    public int getLineNumber() { return lineNumber; }

    @Override
    public abstract String toString();

    // طريقة مساعدة
    public String getNodeInfo() {
        return nodeName + " [Line: " + lineNumber + "]";
    }
}