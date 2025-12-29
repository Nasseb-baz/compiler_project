package Compiler.symbol;

import java.util.*;

public class SymbolTable {
    private Deque<Map<String, Symbol>> scopes = new ArrayDeque<>();

    public SymbolTable() {
        enterScope(); // global scope
    }

    public void enterScope() {
        scopes.push(new HashMap<>());
    }

    public void exitScope() {
        scopes.pop();
    }

    public boolean define(Symbol symbol) {
        Map<String, Symbol> current = scopes.peek();
        if (current.containsKey(symbol.getName()))
            return false;
        current.put(symbol.getName(), symbol);
        return true;
    }

    public Symbol resolve(String name) {
        for (Map<String, Symbol> scope : scopes) {
            if (scope.containsKey(name))
                return scope.get(name);
        }
        return null;
    }

    public void print() {
        int level = scopes.size();
        for (Map<String, Symbol> scope : scopes) {
            System.out.println("Scope level " + level--);
            for (Symbol s : scope.values()) {
                System.out.println("  " + s);
            }
        }
    }
}
