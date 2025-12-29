import Compiler.ast.*;
import Compiler.ast.html.*;
import Compiler.builder.AstBuilder;
import Compiler.visitor.AstPrinter;
import Compiler.visitor.SymbolTableBuilder;
import org.antlr.v4.runtime.*;
import Compiler.antlr.TemplateParser;
import Compiler.antlr.TemplateLexer;

public class Main {
    public static void main(String[] args) {
        // النص المطلوب تحليله
        String input = "{% for cat in categories %}" +
                "<h2>{{ cat.name }}</h2>" +
                "{% for product in cat.products %}" +
                "<p>{{ product.name }}</p>"+
                "{% endfor %}"+
                "{% endfor %}";

        System.out.println("=== INPUT ===");
        System.out.println(input);
        System.out.println();

        try {
            // 1. تحليل النص
            CharStream chars = CharStreams.fromString(input);
            TemplateLexer lexer = new TemplateLexer(chars);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            TemplateParser parser = new TemplateParser(tokens);

            // 2. بناء Parse Tree
            TemplateParser.DocumentContext parseTree = parser.document();
            System.out.println("✓ Parse Tree built successfully");

            // 3. بناء AST من Parse Tree
            AstBuilder builder = new AstBuilder();
            Node ast = builder.visit(parseTree);

            if (ast == null) {
                System.err.println("✗ Failed to build AST");
                return;
            }

            System.out.println("✓ AST built successfully");
            System.out.println();

            // 4. طباعة AST
            System.out.println("=== ABSTRACT SYNTAX TREE ===");

            if (ast instanceof HtmlDocument) {
                AstPrinter printer = new AstPrinter();
                ast.accept(printer);
            } else {
                System.out.println(ast.toString());
            }

            // 5. طباعة AST كـ String
            System.out.println();
            System.out.println("=== AST AS STRING ===");
            System.out.println(ast.toString());

            System.out.println("=== SYMBOL TABLE ===");
            SymbolTableBuilder symBuilder = new SymbolTableBuilder();
            ast.accept(symBuilder);
            symBuilder.getSymbolTable().print();


        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}