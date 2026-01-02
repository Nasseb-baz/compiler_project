package Main.java;

import Main.java.antlr.Jinja2Lexer;
import Main.java.antlr.Jinja2Parser;
import Main.java.ast.jinja2.Jinja2Node;
import Main.java.visitor.Jinja2Visitor;
import Main.java.visitor.PrintVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("=== Jinja2 AST Parser Test ===\n");

            // قراءة ملف Jinja2 template
            File file = new File("src/Main/resources/test.jinja2"); // تأكد من وجود الملف في نفس المجلد
            if (!file.exists()) {
                System.out.println("Error: template.html not found!");
                System.out.println("Current directory: " + new File(".").getAbsolutePath());
                return;
            }

            System.out.println("Reading template file: " + file.getAbsolutePath());

            InputStream inputStream = new FileInputStream(file);
            CharStream charStream = CharStreams.fromStream(inputStream);

            // إنشاء lexer وparser
            Jinja2Lexer lexer = new Jinja2Lexer(charStream);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            Jinja2Parser parser = new Jinja2Parser(tokens);

            // تحليل المستند
            System.out.println("Parsing template...");
            ParseTree tree = parser.document();

            if (parser.getNumberOfSyntaxErrors() > 0) {
                System.out.println("Parsing errors detected: " + parser.getNumberOfSyntaxErrors());
            } else {
                System.out.println("Parsing successful!");
            }

            // بناء الـ AST باستخدام الزائر
            System.out.println("Building AST...");
            Jinja2Visitor visitor = new Jinja2Visitor();
            Jinja2Node ast = visitor.visit(tree);

            if (ast == null) {
                System.out.println("AST is null! Check visitor implementation.");
                return;
            }

            System.out.println("AST built successfully!");

            // طباعة الـ AST
            System.out.println("\n=== AST Structure ===");
            PrintVisitor printer = new PrintVisitor();
            ast.accept(printer);

            System.out.println("\n=== Test Completed Successfully ===");

        } catch (Exception e) {
            System.err.println("Error occurred:");
            e.printStackTrace();
        }
    }
}