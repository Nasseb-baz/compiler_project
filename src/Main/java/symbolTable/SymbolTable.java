package Main.java.symbolTable;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
public class SymbolTable {
    private Stack<Map<String, Symbol>> scopes;
    private Stack<String> scopeNames;
    private int scopeCounter;

    public SymbolTable() {
        scopes = new Stack<>();
        scopeNames = new Stack<>();
        scopeCounter = 0;
        enterScope("global"); // scope عالمي
    }

    public void enterScope(String scopeName) {
        scopes.push(new HashMap<>());
        scopeNames.push(scopeName);
        scopeCounter++;
    }

    public void exitScope() {
        if (!scopes.isEmpty()) {
            scopes.pop();
            scopeNames.pop();
        }
    }

    public String getCurrentScopeName() {
        return scopeNames.isEmpty() ? "unknown" : scopeNames.peek();
    }

    public void insert(String name, String type, int lineNumber) {
        if (!scopes.isEmpty()) {
            Symbol symbol = new Symbol(name, type, lineNumber, getCurrentScopeName());
            scopes.peek().put(name, symbol);
        }
    }

    public Symbol lookup(String name) {
        // البحث من الأحدث إلى الأقدم (من الداخل إلى الخارج)
        for (int i = scopes.size() - 1; i >= 0; i--) {
            if (scopes.get(i).containsKey(name)) {
                return scopes.get(i).get(name);
            }
        }
        return null;
    }

    public Symbol lookupCurrentScope(String name) {
        if (!scopes.isEmpty()) {
            return scopes.peek().get(name);
        }
        return null;
    }

    public List<Symbol> getAllSymbols() {

        List<Symbol> allSymbols = new ArrayList<>();
        for (Map<String, Symbol> scope : scopes) {
            allSymbols.addAll(scope.values());
        }
        return allSymbols;
    }

    public void printTable() {
        System.out.println("\n=== SYMBOL TABLE ===");
        System.out.println("Current Scope: " + getCurrentScopeName());
        System.out.println("Number of Scopes: " + scopes.size());
        System.out.println("\nAll Symbols:");
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-20s %-15s %-10s %-15s\n", "Name", "Type", "Line", "Scope");
        System.out.println("------------------------------------------------------------");

        for (Symbol symbol : getAllSymbols()) {
            System.out.println(symbol);
        }

        System.out.println("------------------------------------------------------------");
    }
}