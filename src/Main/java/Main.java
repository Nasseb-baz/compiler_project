package Main.java;

import Main.java.antlr.PythonLexer;
import Main.java.antlr.PythonParser;

import Main.java.ast.ASTNode;
import Main.java.symbolTable.SymbolTableVisitor;
import Main.java.visitor.PrintVisitor;
import Main.java.visitor.PythonASTVisitor;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {
        try {
            // قراءة ملف الإدخال
            String inputFile = "src/main/resources/test.py";
            FileInputStream inputStream = new FileInputStream(inputFile);

            // إنشاء Lexer و Parser
            ANTLRInputStream input = new ANTLRInputStream(inputStream);
            PythonLexer lexer = new PythonLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            PythonParser parser = new PythonParser(tokens);

            // البدء بقاعدة البرنامج
            ParseTree tree = parser.program();

            // زيارة الشجرة وإنشاء AST
            PythonASTVisitor astVisitor = new PythonASTVisitor();
            ASTNode ast = astVisitor.visit(tree);

            // طباعة AST
            System.out.println("=== Abstract Syntax Tree (AST) ===");
            PrintVisitor printVisitor = new PrintVisitor();
            ast.accept(printVisitor);



            SymbolTableVisitor symbolVisitor = new SymbolTableVisitor();
            ast.accept(symbolVisitor);
            symbolVisitor.printSymbolTable();

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}