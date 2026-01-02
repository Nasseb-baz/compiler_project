package Main.java.visitor;

import Main.java.ast.ASTNode;
import Main.java.ast.jinja2.*;
import Main.java.ast.python.*;

import java.util.*;

public class PrintVisitor implements Visitor {
    private int indentLevel = 0;
    private List<Boolean> isLastStack = new ArrayList<>(); // لتتبع إذا كان العنصر الأخير في المستوى

    private void printIndent() {
        for (int i = 0; i < indentLevel; i++) {
            if (i == indentLevel - 1) {
                // المستوى الأخير: └── أو ├──
                System.out.print(isLastStack.get(i) ? "└── " : "├── ");
            } else {
                // مستويات سابقة: │   أو "    "
                System.out.print(isLastStack.get(i) ? "    " : "│   ");
            }
        }
    }

    private void pushLevel(boolean isLast) {
        isLastStack.add(isLast);
        indentLevel++;
    }

    private void popLevel() {
        isLastStack.remove(indentLevel - 1);
        indentLevel--;
    }

    private String escapeText(String text) {
        return text
                .replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }

    @Override
    public void visit(Program node) {
        printIndent();
        System.out.println("Program (line " + node.getLineNumber() + ")");

        List<ASTNode> children = node.getChildren();
        for (int i = 0; i < children.size(); i++) {
            boolean isLast = (i == children.size() - 1);
            pushLevel(isLast);
            children.get(i).accept(this);
            popLevel();
        }
    }

    @Override
    public void visit(Import node) {
        printIndent();
        if (node.getModule() != null) {
            System.out.println("Import (line " + node.getLineNumber() + ") [from: " + node.getModule() + "]");
        } else {
            System.out.println("Import (line " + node.getLineNumber() + ")");
        }
    }

    @Override
    public void visit(Assign node) {
        printIndent();
        System.out.println("Assign (line " + node.getLineNumber() + ")");

        pushLevel(false); // Target ليست الأخيرة

        printIndent();
        System.out.println("Target:");
        pushLevel(false); // Value تأتي بعدها
        node.getTarget().accept(this);
        popLevel();

        printIndent();
        System.out.println("Value:");
        pushLevel(true); // Value هي الأخيرة
        node.getValue().accept(this);
        popLevel();

        popLevel();
    }

    @Override
    public void visit(FunctionDef node) {
        printIndent();
        System.out.println("FunctionDef: " + node.getName() +
                " (line " + node.getLineNumber() + ")");

        pushLevel(true); // Body هي الأخيرة
        node.getBody().accept(this);
        popLevel();
    }

    @Override
    public void visit(Block node) {
        printIndent();
        System.out.println("Block (line " + node.getLineNumber() + ")");

        List<Statement> statements = node.getStatements();
        for (int i = 0; i < statements.size(); i++) {
            boolean isLast = (i == statements.size() - 1);
            pushLevel(isLast);
            statements.get(i).accept(this);
            popLevel();
        }
    }

    @Override
    public void visit(If node) {
        printIndent();
        System.out.println("If (line " + node.getLineNumber() + ")");

        pushLevel(false); // Condition ليست الأخيرة

        printIndent();
        System.out.println("Condition:");
        pushLevel(false); // Then تأتي بعدها
        node.getCondition().accept(this);
        popLevel();

        printIndent();
        System.out.println("Then:");
        pushLevel(node.getElseBlock() == null); // إذا لا يوجد Else فـ Then هي الأخيرة
        node.getThenBlock().accept(this);
        popLevel();

        if (node.getElseBlock() != null) {
            printIndent();
            System.out.println("Else:");
            pushLevel(true); // Else هي الأخيرة
            node.getElseBlock().accept(this);
            popLevel();
        }

        popLevel();
    }

    @Override
    public void visit(For node) {
        printIndent();
        System.out.println("For (line " + node.getLineNumber() + ")");

        pushLevel(false); // Loop Variable ليست الأخيرة

        printIndent();
        System.out.println("Loop Variable: " + node.getLoopVariable());

        printIndent();
        System.out.println("Iterable:");
        pushLevel(false); // Body تأتي بعدها
        node.getIterable().accept(this);
        popLevel();

        printIndent();
        System.out.println("Body:");
        pushLevel(true); // Body هي الأخيرة
        node.getBody().accept(this);
        popLevel();

        popLevel();
    }

    @Override
    public void visit(Return node) {
        printIndent();
        System.out.print("Return (line " + node.getLineNumber() + ")");

        if (node.getValue() != null) {
            System.out.println();
            pushLevel(true);
            node.getValue().accept(this);
            popLevel();
        } else {
            System.out.println();
        }
    }

    @Override
    public void visit(ExprStmt node) {
        printIndent();
        System.out.println("ExprStmt (line " + node.getLineNumber() + ")");

        pushLevel(true);
        node.getExpression().accept(this);
        popLevel();
    }

    @Override
    public void visit(IdentifierExpr node) {
        printIndent();
        System.out.println("IdentifierExpr: " + node.getName() +
                " (line " + node.getLineNumber() + ")");
    }

    @Override
    public void visit(NumberExpr node) {
        printIndent();
        System.out.println("NumberExpr: " + node.getValue() +
                " (line " + node.getLineNumber() + ")");
    }

    @Override
    public void visit(StringExpr node) {
        printIndent();
        System.out.println("StringExpr: \"" + node.getValue() + "\"" +
                " (line " + node.getLineNumber() + ")");
    }

    @Override
    public void visit(BinaryExpr node) {
        printIndent();
        System.out.println("BinaryExpr: '" + node.getOperator() + "'" +
                " (line " + node.getLineNumber() + ")");

        pushLevel(false); // Left ليست الأخيرة

        printIndent();
        System.out.println("Left:");
        pushLevel(false); // Right تأتي بعدها
        node.getLeft().accept(this);
        popLevel();

        printIndent();
        System.out.println("Right:");
        pushLevel(true); // Right هي الأخيرة
        node.getRight().accept(this);
        popLevel();

        popLevel();
    }

    @Override
    public void visit(AttributeExpr node) {
        printIndent();
        System.out.println("AttributeExpr (line " + node.getLineNumber() + ")");

        pushLevel(false); // Target ليست الأخيرة

        printIndent();
        System.out.println("Target:");
        pushLevel(false); // Attribute تأتي بعدها
        node.getTarget().accept(this);
        popLevel();

        printIndent();
        System.out.println("Attribute: " + node.getAttribute());

        popLevel();
    }

    @Override
    public void visit(FunctionCallExpr node) {
        printIndent();
        System.out.println("FunctionCallExpr (line " + node.getLineNumber() + ")");

        pushLevel(false); // Callee ليست الأخيرة

        printIndent();
        System.out.println("Callee:");
        pushLevel(false); // Args تأتي بعدها
        node.getCallee().accept(this);
        popLevel();

        List<Expression> args = node.getArguments();
        if (!args.isEmpty()) {
            printIndent();
            System.out.println("Args (" + args.size() + "):");
            for (int i = 0; i < args.size(); i++) {
                boolean isLast = (i == args.size() - 1);
                pushLevel(isLast);
                args.get(i).accept(this);
                popLevel();
            }
        }

        popLevel();
    }

    @Override
    public void visit(DictLiteral node) {
        printIndent();
        System.out.println("DictLiteral (line " + node.getLineNumber() + ")");

        List<KeyValue> entries = node.getEntries();
        if (!entries.isEmpty()) {
            for (int i = 0; i < entries.size(); i++) {
                boolean isLast = (i == entries.size() - 1);
                pushLevel(isLast);
                entries.get(i).accept(this);
                popLevel();
            }
        }
    }

    @Override
    public void visit(ArrayLiteral node) {
        printIndent();
        System.out.println("ArrayLiteral (line " + node.getLineNumber() + ")");

        List<Expression> elements = node.getElements();
        if (!elements.isEmpty()) {
            for (int i = 0; i < elements.size(); i++) {
                boolean isLast = (i == elements.size() - 1);
                pushLevel(isLast);
                elements.get(i).accept(this);
                popLevel();
            }
        }
    }

    @Override
    public void visit(KeyValue node) {
        printIndent();
        System.out.println("KeyValue (line " + node.getLineNumber() + ")");

        pushLevel(false); // Key ليست الأخيرة

        printIndent();
        System.out.println("Key:");
        pushLevel(false); // Value تأتي بعدها
        node.getKey().accept(this);
        popLevel();

        printIndent();
        System.out.println("Value:");
        pushLevel(true); // Value هي الأخيرة
        node.getValue().accept(this);
        popLevel();

        popLevel();
    }

    @Override
    public void visit(IndexExpr node) {
        printIndent();
        System.out.println("IndexExpr (line " + node.getLineNumber() + ")");

        pushLevel(false); // Array ليست الأخيرة

        printIndent();
        System.out.println("Array:");
        pushLevel(false); // Index تأتي بعدها
        node.getArray().accept(this);
        popLevel();

        printIndent();
        System.out.println("Index:");
        pushLevel(true); // Index هي الأخيرة
        node.getIndex().accept(this);
        popLevel();

        popLevel();
    }

    @Override
    public void visit(KeywordArgExpr node) {
        printIndent();
        System.out.println("KeywordArgExpr (line " + node.getLineNumber() + ")");

        printIndent();
        System.out.println("Key: " + node.getKey());

        printIndent();
        System.out.println("Value:");
        pushLevel(true);
        node.getValue().accept(this);
        popLevel();
    }

    @Override
    public void visit(Jinja2Template node) {
        printIndent();
        System.out.println("Jinja2Template (line " + node.getLineNumber() + ")");

        List<Jinja2Node> elements = node.getElements();
        for (int i = 0; i < elements.size(); i++) {
            boolean isLast = (i == elements.size() - 1);
            pushLevel(isLast);
            elements.get(i).accept(this);
            popLevel();
        }
    }

    @Override
    public void visit(Jinja2Text node) {
        printIndent();
        String text = node.getContent();

        // تنظيف النص
        text = cleanText(text);

        // اختصار النص الطويل للعرض
        if (text.length() > 80) {
            text = text.substring(0, 77) + "...";
        }

        // إذا كان النص فارغاً أو مسافات فقط، تخطاه
        if (text.trim().isEmpty()) {
            return;
        }

        System.out.println("Jinja2Text: \"" + text + "\"" +
                " (line " + node.getLineNumber() + ")");
    }

    @Override
    public void visit(Jinja2Variable node) {
        printIndent();
        System.out.println("Jinja2Variable (line " + node.getLineNumber() + ")");

        boolean hasFilters = !node.getFilters().isEmpty();

        pushLevel(!hasFilters); // إذا لا يوجد filters فـ Expression هي الأخيرة

        printIndent();
        System.out.println("Expression:");
        pushLevel(!hasFilters); // نفس الشيء
        node.getExpression().accept(this);
        popLevel();

        if (hasFilters) {
            printIndent();
            System.out.println("Filters (" + node.getFilters().size() + "):");
            for (int i = 0; i < node.getFilters().size(); i++) {
                boolean isLast = (i == node.getFilters().size() - 1);
                pushLevel(isLast);
                node.getFilters().get(i).accept(this);
                popLevel();
            }
        }

        popLevel();
    }

    @Override
    public void visit(Jinja2Expression node) {
        printIndent();
        System.out.println("Jinja2Expression: " + node.getExpression() +
                " (line " + node.getLineNumber() + ")");
    }

    @Override
    public void visit(Jinja2Filter node) {
        printIndent();
        System.out.println("Jinja2Filter: " + node.getName() +
                " (line " + node.getLineNumber() + ")");

        List<Jinja2Expression> args = node.getArguments();
        if (!args.isEmpty()) {
            for (int i = 0; i < args.size(); i++) {
                boolean isLast = (i == args.size() - 1);
                pushLevel(isLast);
                args.get(i).accept(this);
                popLevel();
            }
        }
    }

    @Override
    public void visit(Jinja2ElseBlock node) {
        printIndent();
        System.out.println("Jinja2ElseBlock (line " + node.getLineNumber() + ")");

        List<Jinja2Node> content = node.getContent();
        if (content != null && !content.isEmpty()) {
            for (int i = 0; i < content.size(); i++) {
                boolean isLast = (i == content.size() - 1);
                pushLevel(isLast);
                content.get(i).accept(this);
                popLevel();
            }
        }
    }

    @Override
    public void visit(Jinja2SetTag node) {
        printIndent();
        System.out.println("Jinja2SetTag (line " + node.getLineNumber() + ")");

        pushLevel(false); // Variable ليست الأخيرة

        printIndent();
        System.out.println("Variable:");
        pushLevel(false); // Value تأتي بعدها
        node.getVariable().accept(this);
        popLevel();

        printIndent();
        System.out.println("Value:");
        pushLevel(true); // Value هي الأخيرة
        node.getValue().accept(this);
        popLevel();

        popLevel();
    }

    @Override
    public void visit(Jinja2WithTag node) {
        printIndent();
        System.out.println("Jinja2WithTag (line " + node.getLineNumber() + ")");

        boolean hasContent = node.getContent() != null && !node.getContent().isEmpty();
        boolean hasAssignments = node.getAssignments() != null && !node.getAssignments().isEmpty();

        if (hasAssignments) {
            pushLevel(!hasContent); // إذا لا يوجد content فـ Assignments هي الأخيرة

            printIndent();
            System.out.println("Assignments (" + node.getAssignments().size() + "):");
            for (int i = 0; i < node.getAssignments().size(); i++) {
                boolean isLast = (i == node.getAssignments().size() - 1 && !hasContent);
                pushLevel(isLast);
                node.getAssignments().get(i).accept(this);
                popLevel();
            }

            popLevel();
        }

        if (hasContent) {
            pushLevel(true); // Content هي الأخيرة

            printIndent();
            System.out.println("Content:");
            for (int i = 0; i < node.getContent().size(); i++) {
                boolean isLast = (i == node.getContent().size() - 1);
                pushLevel(isLast);
                node.getContent().get(i).accept(this);
                popLevel();
            }

            popLevel();
        }
    }

    @Override
    public void visit(Jinja2FunctionCall node) {
        printIndent();
        System.out.println("Jinja2FunctionCall (line " + node.getLineNumber() + ")");

        boolean hasPosArgs = node.getPositionalArgs() != null && !node.getPositionalArgs().isEmpty();
        boolean hasKwArgs = node.getKeywordArgs() != null && !node.getKeywordArgs().isEmpty();

        pushLevel(!hasPosArgs && !hasKwArgs); // إذا لا يوجد args فـ FunctionName هي الأخيرة

        printIndent();
        System.out.println("Function Name:");
        pushLevel(!hasPosArgs && !hasKwArgs);
        node.getFunctionName().accept(this);
        popLevel();

        if (hasPosArgs) {
            printIndent();
            System.out.println("Positional Arguments (" + node.getPositionalArgs().size() + "):");
            for (int i = 0; i < node.getPositionalArgs().size(); i++) {
                boolean isLast = (i == node.getPositionalArgs().size() - 1 && !hasKwArgs);
                pushLevel(isLast);
                node.getPositionalArgs().get(i).accept(this);
                popLevel();
            }
        }

        if (hasKwArgs) {
            printIndent();
            System.out.println("Keyword Arguments (" + node.getKeywordArgs().size() + "):");
            for (int i = 0; i < node.getKeywordArgs().size(); i++) {
                boolean isLast = (i == node.getKeywordArgs().size() - 1);
                pushLevel(isLast);
                node.getKeywordArgs().get(i).accept(this);
                popLevel();
            }
        }

        popLevel();
    }

    @Override
    public void visit(Jinja2Assignment node) {
        printIndent();
        System.out.println("Jinja2Assignment (line " + node.getLineNumber() + ")");

        pushLevel(false); // Variable ليست الأخيرة

        printIndent();
        System.out.println("Variable:");
        pushLevel(false); // Value تأتي بعدها
        node.getVariable().accept(this);
        popLevel();

        printIndent();
        System.out.println("Value:");
        pushLevel(true); // Value هي الأخيرة
        node.getValue().accept(this);
        popLevel();

        popLevel();
    }

    @Override
    public void visit(Jinja2Identifier node) {
        printIndent();
        System.out.println("Jinja2Identifier: " + node.getFullPath() +
                " (line " + node.getLineNumber() + ")");
    }

    @Override
    public void visit(Jinja2Literal node) {
        printIndent();
        System.out.println("Jinja2Literal [" + node.getType() + "]: " + node.getValue() +
                " (line " + node.getLineNumber() + ")");
    }

    @Override
    public void visit(Jinja2Operator node) {
        printIndent();
        System.out.println("Jinja2Operator: '" + node.getOperator() + "'" +
                " (line " + node.getLineNumber() + ")");

        if (node.isBinary()) {
            pushLevel(false); // Left ليست الأخيرة

            printIndent();
            System.out.println("Left Operand:");
            pushLevel(false); // Right تأتي بعدها
            node.getLeftOperand().accept(this);
            popLevel();

            printIndent();
            System.out.println("Right Operand:");
            pushLevel(true); // Right هي الأخيرة
            node.getRightOperand().accept(this);
            popLevel();

            popLevel();
        } else if (node.isUnary()) {
            pushLevel(true); // Operand هي الأخيرة

            printIndent();
            System.out.println("Operand:");
            pushLevel(true);
            node.getRightOperand().accept(this);
            popLevel();

            popLevel();
        }
    }

    @Override
    public void visit(Jinja2IfTag node) {
        printIndent();
        System.out.println("Jinja2IfTag (line " + node.getLineNumber() + ")");

        boolean hasElif = node.getElifBlocks() != null && !node.getElifBlocks().isEmpty();
        boolean hasElse = node.getElseBlock() != null;

        pushLevel(!hasElif && !hasElse); // إذا لا يوجد elif ولا else فـ Condition هي الأخيرة

        if (node.getCondition() != null) {
            printIndent();
            System.out.println("Condition:");
            pushLevel(!hasElif && !hasElse);
            node.getCondition().accept(this);
            popLevel();
        }

        if (node.getThenBlock() != null && !node.getThenBlock().isEmpty()) {
            printIndent();
            System.out.println("Then Block:");
            for (int i = 0; i < node.getThenBlock().size(); i++) {
                boolean isLast = (i == node.getThenBlock().size() - 1 && !hasElif && !hasElse);
                pushLevel(isLast);
                node.getThenBlock().get(i).accept(this);
                popLevel();
            }
        }

        if (hasElif) {
            printIndent();
            System.out.println("Elif Blocks (" + node.getElifBlocks().size() + "):");
            for (int i = 0; i < node.getElifBlocks().size(); i++) {
                boolean isLast = (i == node.getElifBlocks().size() - 1 && !hasElse);
                pushLevel(isLast);
                node.getElifBlocks().get(i).accept(this);
                popLevel();
            }
        }

        if (hasElse) {
            printIndent();
            System.out.println("Else Block:");
            pushLevel(true); // Else هي الأخيرة
            node.getElseBlock().accept(this);
            popLevel();
        }

        popLevel();
    }

    @Override
    public void visit(Jinja2ElifBlock node) {
        printIndent();
        System.out.println("Jinja2ElifBlock (line " + node.getLineNumber() + ")");

        boolean hasBody = node.getBody() != null && !node.getBody().isEmpty();

        pushLevel(!hasBody); // إذا لا يوجد body فـ Condition هي الأخيرة

        if (node.getCondition() != null) {
            printIndent();
            System.out.println("Condition:");
            pushLevel(!hasBody);
            node.getCondition().accept(this);
            popLevel();
        }

        if (hasBody) {
            printIndent();
            System.out.println("Body:");
            for (int i = 0; i < node.getBody().size(); i++) {
                boolean isLast = (i == node.getBody().size() - 1);
                pushLevel(isLast);
                node.getBody().get(i).accept(this);
                popLevel();
            }
        }

        popLevel();
    }

    @Override
    public void visit(Jinja2ForTag node) {
        printIndent();
        System.out.println("Jinja2ForTag (line " + node.getLineNumber() + ")");

        boolean hasBody = node.getBody() != null && !node.getBody().isEmpty();

        pushLevel(!hasBody); // إذا لا يوجد body فـ Iterable هي الأخيرة

        printIndent();
        System.out.println("Variable: " + node.getVariable());

        if (node.getIterable() != null) {
            printIndent();
            System.out.println("Iterable:");
            pushLevel(!hasBody);
            node.getIterable().accept(this);
            popLevel();
        }

        if (hasBody) {
            printIndent();
            System.out.println("Body:");
            for (int i = 0; i < node.getBody().size(); i++) {
                boolean isLast = (i == node.getBody().size() - 1);
                pushLevel(isLast);
                node.getBody().get(i).accept(this);
                popLevel();
            }
        }

        popLevel();
    }

    @Override
    public void visit(Jinja2BlockTag node) {
        printIndent();
        System.out.println("Jinja2BlockTag: " + node.getName() +
                " (line " + node.getLineNumber() + ")");

        List<Jinja2Node> content = node.getContent();
        if (content != null && !content.isEmpty()) {
            for (int i = 0; i < content.size(); i++) {
                boolean isLast = (i == content.size() - 1);
                pushLevel(isLast);
                content.get(i).accept(this);
                popLevel();
            }
        }
    }

    @Override
    public void visit(Jinja2ExtendsTag node) {
        printIndent();
        System.out.println("Jinja2ExtendsTag: " + node.getTemplateName() +
                " (line " + node.getLineNumber() + ")");
    }

    @Override
    public void visit(Jinja2IncludeTag node) {
        printIndent();
        System.out.println("Jinja2IncludeTag: " + node.getTemplateName() +
                " (line " + node.getLineNumber() + ")");
    }

    @Override
    public void visit(Jinja2Comment node) {
        printIndent();
        String commentText = cleanText(node.getContent());

        if (commentText.length() > 80) {
            commentText = commentText.substring(0, 77) + "...";
        }

        System.out.println("Jinja2Comment: \"" + commentText + "\"" +
                " (line " + node.getLineNumber() + ")");
    }


    private String cleanText(String text) {
        // إزالة الأحرف الخاصة وعرض النص بطريقة مقروءة
        return text
                .replace("\r", "")     // إزالة carriage return
                .replace("\n", " ")    // استبدال newline بمسافة
                .replace("\t", " ")    // استبدال tab بمسافة
                .trim()                // إزالة المسافات الزائدة من البداية والنهاية
                .replaceAll(" +", " "); // استبدال مسافات متعددة بمسافة واحدة
    }
}