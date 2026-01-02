package Main.java.visitor;


import Main.java.ast.jinja2.*;
import Main.java.ast.python.*;

public interface Visitor {
    // Python AST nodes
    void visit(Program node);
    void visit(Import node);
    void visit(Assign node);
    void visit(FunctionDef node);
    void visit(Block node);
    void visit(If node);
    void visit(For node);
    void visit(Return node);
    void visit(ExprStmt node);

    void visit(IdentifierExpr node);
    void visit(NumberExpr node);
    void visit(StringExpr node);
    void visit(BinaryExpr node);
    void visit(AttributeExpr node);
    void visit(FunctionCallExpr node);
    void visit(DictLiteral node);
    void visit(ArrayLiteral node);
    void visit(KeyValue node);
    void visit(IndexExpr node);
    void visit(KeywordArgExpr node);

    // Jinja2 AST nodes
    void visit(Jinja2Template node);
    void visit(Jinja2Text node);
    void visit(Jinja2Variable node);
    void visit(Jinja2Expression node);
    void visit(Jinja2Comment node);
    void visit(Jinja2IfTag node);
    void visit(Jinja2ElifBlock node);
    void visit(Jinja2ForTag node);
    void visit(Jinja2BlockTag node);
    void visit(Jinja2ExtendsTag node);
    void visit(Jinja2IncludeTag node);
    void visit(Jinja2Filter node);
    void visit(Jinja2ElseBlock node);
    void visit(Jinja2SetTag node);
    void visit(Jinja2WithTag node);
    void visit(Jinja2FunctionCall node);
    void visit(Jinja2Assignment node);
    void visit(Jinja2Identifier node);
    void visit(Jinja2Literal node);
    void visit(Jinja2Operator node);
}