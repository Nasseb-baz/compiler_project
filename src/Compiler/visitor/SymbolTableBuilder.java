package Compiler.visitor;

import Compiler.ast.*;
import Compiler.ast.html.*;
import Compiler.ast.jinja.*;
import Compiler.symbol.*;

public class SymbolTableBuilder implements Visitor {

    private SymbolTable table = new SymbolTable();

    public SymbolTable getSymbolTable() {
        return table;
    }

    @Override
    public void visit(HtmlDocument node) {
        for (HtmlElement el : node.getElements()) {
            el.accept(this);
        }
    }


    @Override
    public void visit(JinjaForStatement node) {


        table.enterScope();

        table.define(new Symbol(
                node.getIterator().trim(),
                "loop-variable",
                node.getLineNumber()
        ));

        if (node.getBody() != null) {
            node.getBody().accept(this);
        }

    }



    @Override
    public void visit(JinjaVariable node) {
        Symbol s = table.resolve(node.getName());
        if (s == null) {
            System.out.println(
                    "Warning: undefined variable '" +
                            node.getName() + "' at line " +
                            node.getLineNumber()
            );
        }
    }

    // باقي العقد لا تحتاج منطق خاص
    @Override
    public void visit(HtmlElement node) {
        for (Node child : node.getChildren()) {
            child.accept(this);
        }
    }

    @Override
    public void visit(JinjaBlock node) {
        for (Node stmt : node.getStatements()) {
            stmt.accept(this);
        }
    }

    @Override public void visit(TextNode n){}
    @Override public void visit(Attribute n){}
    @Override public void visit(JinjaExpression n){}
    @Override public void visit(JinjaLiteral n){}
}
