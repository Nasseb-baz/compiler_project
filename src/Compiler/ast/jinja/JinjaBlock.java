package Compiler.ast.jinja;

import Compiler.ast.Node;
import Compiler.ast.Visitor;
import java.util.ArrayList;
import java.util.List;

public class JinjaBlock extends JinjaNode {
    private List<Node> statements;

    public JinjaBlock(int lineNumber) {
        super("JinjaBlock", lineNumber);
        this.statements = new ArrayList<>();
    }

    public void addStatement(Node statement) {
        statements.add(statement);
    }

    public List<Node> getStatements() {
        return statements;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getNodeInfo()).append(" {\n");

        for (Node stmt : statements) {
            String stmtStr = stmt.toString();
            for (String line : stmtStr.split("\n")) {
                sb.append("  ").append(line).append("\n");
            }
        }

        sb.append("}");
        return sb.toString();
    }
}