package Main.java.visitor;


import Main.java.ast.*;

public interface Visitor {
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
}