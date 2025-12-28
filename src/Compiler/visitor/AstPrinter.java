package Compiler.visitor;


import Compiler.ast.*;
import Compiler.ast.html.*;
import Compiler.ast.jinja.*;

public class AstPrinter implements Visitor {
    private int indentLevel = 0;

    private String getIndent() {
        return "  ".repeat(indentLevel);
    }

    @Override
    public void visit(HtmlDocument node) {
        System.out.println(getIndent() + node.getNodeInfo() + " {");
        indentLevel++;

        for (HtmlElement element : node.getElements()) {
            element.accept(this);
        }

        indentLevel--;
        System.out.println(getIndent() + "}");
    }

    @Override
    public void visit(HtmlElement node) {
        System.out.print(getIndent() + node.getNodeInfo() + " - <" + node.getTagName() + ">");

        if (!node.getAttributes().isEmpty()) {
            System.out.print(" [");
            for (int i = 0; i < node.getAttributes().size(); i++) {
                if (i > 0) System.out.print(", ");
                node.getAttributes().get(i).accept(this);
            }
            System.out.print("]");
        }

        if (!node.getChildren().isEmpty()) {
            System.out.println(" {");
            indentLevel++;

            for (Node child : node.getChildren()) {
                child.accept(this);
            }

            indentLevel--;
            System.out.println(getIndent() + "}");
        } else {
            System.out.println();
        }
    }

    @Override
    public void visit(TextNode node) {
        System.out.println(getIndent() + node.getNodeInfo() + " - \"" + node.getContent() + "\"");
    }

    @Override
    public void visit(Attribute node) {
        if (node.hasValue()) {
            System.out.print(node.getName() + "=\"" + node.getValue() + "\"");
        } else {
            System.out.print(node.getName());
        }
    }

    @Override
    public void visit(JinjaBlock node) {
        System.out.println(getIndent() + node.getNodeInfo() + " {");
        indentLevel++;

        for (Node stmt : node.getStatements()) {
            stmt.accept(this);
        }

        indentLevel--;
        System.out.println(getIndent() + "}");
    }

    @Override
    public void visit(JinjaForStatement node) {
        System.out.print(getIndent() + node.getNodeInfo() + " - for " +
                node.getIterator() + " in " + node.getCollection());

        if (node.getBody() != null && !node.getBody().getStatements().isEmpty()) {
            System.out.println(" {");
            indentLevel++;
            node.getBody().accept(this);
            indentLevel--;
            System.out.println(getIndent() + "}");
        } else {
            System.out.println();
        }
    }

    @Override
    public void visit(JinjaExpression node) {
        System.out.println(getIndent() + node.getNodeInfo() + " - {{ " +
                node.getExpression() + " }}");
    }

    @Override
    public void visit(JinjaVariable node) {
        if (node.hasProperty()) {
            System.out.println(getIndent() + node.getNodeInfo() + " - " +
                    node.getName() + "." + node.getProperty());
        } else {
            System.out.println(getIndent() + node.getNodeInfo() + " - " + node.getName());
        }
    }

    @Override
    public void visit(JinjaLiteral node) {
        System.out.println(getIndent() + node.getNodeInfo() + " - " +
                node.getType() + ": " + node.getValue());
    }
}