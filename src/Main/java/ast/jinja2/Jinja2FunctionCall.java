package Main.java.ast.jinja2;

import Main.java.visitor.Visitor;
import java.util.List;

public class Jinja2FunctionCall extends Jinja2Expression {
    private Jinja2Identifier functionName;
    private List<Jinja2Expression> positionalArgs;
    private List<Jinja2Assignment> keywordArgs;

    public Jinja2FunctionCall(Jinja2Identifier functionName,
                              List<Jinja2Expression> positionalArgs,
                              List<Jinja2Assignment> keywordArgs,
                              int lineNumber) {
        super(  lineNumber,"Jinja2FunctionCall");  // Calls Jinja2Expression constructor
        this.functionName = functionName;
        this.positionalArgs = positionalArgs;
        this.keywordArgs = keywordArgs;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public Jinja2Identifier getFunctionName() { return functionName; }
    public void setFunctionName(Jinja2Identifier functionName) { this.functionName = functionName; }

    public List<Jinja2Expression> getPositionalArgs() { return positionalArgs; }
    public void setPositionalArgs(List<Jinja2Expression> positionalArgs) { this.positionalArgs = positionalArgs; }

    public List<Jinja2Assignment> getKeywordArgs() { return keywordArgs; }
    public void setKeywordArgs(List<Jinja2Assignment> keywordArgs) { this.keywordArgs = keywordArgs; }
}