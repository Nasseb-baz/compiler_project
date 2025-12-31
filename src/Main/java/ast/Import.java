package Main.java.ast;

import Main.java.visitor.*;
import java.util.List;

public class Import extends Statement {
    private String module;
    private List<String> names;

    public Import(int lineNumber, String module, List<String> names) {
        super("Import", lineNumber);
        this.module = module;
        this.names = names;
    }

    public String getModule() {
        return module;
    }

    public List<String> getNames() {
        return names;
    }


    public void accept(Visitor visitor) {
        visitor.visit(this);
    }


}