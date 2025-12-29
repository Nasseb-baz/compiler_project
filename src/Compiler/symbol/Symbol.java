package Compiler.symbol;

public class Symbol {
    private String name;
    private String type; // variable, loop-variable, etc.
    private int line;

    public Symbol(String name, String type, int line) {
        this.name = name;
        this.type = type;
        this.line = line;
    }

    public String getName() { return name; }
    public String getType() { return type; }
    public int getLine() { return line; }

    @Override
    public String toString() {
        return name + " : " + type + " (line " + line + ")";
    }
}
