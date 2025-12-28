parser grammar TemplateParser;

options {
    tokenVocab=TemplateLexer;
}

// القاعدة الرئيسية
document: htmlContent* EOF;

// محتوى HTML
htmlContent:
    htmlElement
    | jinjaElement
    | HTML_TEXT
    ;

// عنصر HTML
htmlElement:
    HTML_TAG_OPEN TAG_NAME attribute* TAG_CLOSE
    htmlContent*
    HTML_TAG_OPEN TAG_SLASH TAG_NAME TAG_CLOSE
    | HTML_TAG_OPEN TAG_NAME attribute* TAG_SLASH_CLOSE
    ;

// سمات
attribute:
    ATTR_NAME (EQUALS attributeValue)?
    ;

attributeValue:
    DOUBLE_QUOTE_STRING
    | SINGLE_QUOTE_STRING
    | UNQUOTED_VALUE
    | jinjaElement
    ;

// عناصر Jinja
jinjaElement:
    jinjaExpression
    | jinjaForStatement  // ← استخدم jinjaForStatement مباشرة!
    | jinjaStatement
    | jinjaComment
    ;

// ===== Jinja Expression =====
jinjaExpression:
    JINJA_EXPR_OPEN exprContent* JINJA_EXPR_CLOSE
    ;

exprContent:
    IDENTIFIER
    | DOT
    | NUMBER
    | STRING
    | operator
    | LPAREN | RPAREN
    | LBRACKET | RBRACKET
    | COMMA | COLON | PIPE
    | WS
    | OTHER
    ;

operator:
    PLUS | MINUS | MULT | DIV | MOD
    | EQ | NEQ | LT | GT | LTE | GTE
    | AND | OR | NOT
    ;

// ===== Jinja For Statement =====
jinjaForStatement:
    JINJA_STMT_OPEN FOR IDENTIFIER_STMT IN expr JINJA_STMT_CLOSE
    htmlContent*
    JINJA_STMT_OPEN ENDFOR JINJA_STMT_CLOSE
    ;

// ===== Jinja Statement العام (لـ if, set, block, etc) =====
jinjaStatement:
    JINJA_STMT_OPEN stmtContent* JINJA_STMT_CLOSE
    ;

stmtContent:
    // Keywords - مع ENDFOR و ENDIF
    FOR | IN | IF | ELSE | ELIF | END
    | ENDFOR | ENDIF  // ← مهم!
    | SET | BLOCK | EXTENDS | INCLUDE | MACRO

    | IDENTIFIER_STMT
    | DOT_STMT | COMMA_STMT | COLON_STMT
    | LPAREN_STMT | RPAREN_STMT
    | NUMBER_STMT | STRING_STMT
    | WS_STMT
    | OTHER_STMT
    ;

// قاعدة مساعدة للتعبيرات
expr:
    (IDENTIFIER_STMT | NUMBER_STMT | STRING_STMT)
    (DOT_STMT IDENTIFIER_STMT)*
    ;

// Jinja Comment
jinjaComment:
    JINJA_COMMENT_OPEN COMMENT_CONTENT* JINJA_COMMENT_CLOSE
    ;