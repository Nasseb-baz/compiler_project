package Compiler.ast.jinja;


import Compiler.ast.Node;
import Compiler.ast.Visitor;

public class JinjaForStatement extends JinjaNode {
    private String iterator;
    private String collection;
    private JinjaBlock body;

    public JinjaForStatement(String iterator, String collection, int lineNumber) {
        super("JinjaForStatement", lineNumber);
        this.iterator = iterator;
        this.collection = collection;
    }

    public void setBody(JinjaBlock body) {
        this.body = body;
    }

    public String getIterator() {
        return iterator;
    }

    public String getCollection() {
        return collection;
    }

    public JinjaBlock getBody() {
        return body;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        if (body != null) {
            body.accept(visitor);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getNodeInfo())
                .append(" - for ").append(iterator)
                .append(" in ").append(collection);

        if (body != null && !body.getStatements().isEmpty()) {
            sb.append(" {\n");
            String bodyStr = body.toString();
            for (String line : bodyStr.split("\n")) {
                sb.append("  ").append(line).append("\n");
            }
            sb.append("}");
        }

        return sb.toString();
    }
}