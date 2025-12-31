package Main.java.ast;


import Main.java.visitor.Visitor;
import java.util.List;

public class FunctionDef extends Statement {
    private String name;
    private List<String> parameters;
    private Block body;

    public FunctionDef(int lineNumber, String name, List<String> parameters, Block body) {
        super("FunctionDef", lineNumber);
        this.name = name;
        this.parameters = parameters;
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public Block getBody() {
        return body;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}