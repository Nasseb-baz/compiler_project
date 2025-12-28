package Compiler.ast;

import Compiler.ast.html.Attribute;
import Compiler.ast.html.HtmlDocument;
import Compiler.ast.html.HtmlElement;
import Compiler.ast.html.TextNode;
import Compiler.ast.jinja.*;

public interface Visitor {
    // HTML Nodes
    void visit(HtmlDocument node);
    void visit(HtmlElement node);
    void visit(TextNode node);
    void visit(Attribute node);

    // Jinja Nodes
    void visit(JinjaBlock node);
    void visit(JinjaForStatement node);
    void visit(JinjaExpression node);
    void visit(JinjaVariable node);
    void visit(JinjaLiteral node);
}
