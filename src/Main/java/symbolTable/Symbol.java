package Main.java.symbolTable;

public class Symbol {
    private String name;
    private String type;
    private int lineNumber;
    private String scope;

    public Symbol(String name, String type, int lineNumber, String scope) {
        this.name = name;
        this.type = type;
        this.lineNumber = lineNumber;
        this.scope = scope;
    }

    // Getters
    public String getName() { return name; }
    public String getType() { return type; }
    public int getLineNumber() { return lineNumber; }
    public String getScope() { return scope; }

    // Setters
    public void setType(String type) { this.type = type; }

    @Override
    public String toString() {
        return String.format("%-20s %-15s %-10d %-15s",
                name, type, lineNumber, scope);
    }
}