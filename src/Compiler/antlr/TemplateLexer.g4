lexer grammar TemplateLexer;

// ----- HTML Tags and Text -----
HTML_TAG_OPEN  : '<' -> pushMode(HTML_TAG_MODE);
HTML_TEXT      : ~[<{]+ ;

// ----- Jinja2 Delimiters -----
JINJA_EXPR_OPEN  : '{{' -> pushMode(JINJA_EXPR_MODE);
JINJA_STMT_OPEN  : '{%' -> pushMode(JINJA_STMT_MODE);
JINJA_COMMENT_OPEN: '{#' -> pushMode(JINJA_COMMENT_MODE);

// ----- HTML Comments -----
HTML_COMMENT   : '<!--' .*? '-->' -> skip;

// ===== Jinja Expression Mode =====
mode JINJA_EXPR_MODE;
    JINJA_EXPR_CLOSE : '}}' -> popMode;

    // محتوى التعبير
    IDENTIFIER   : [a-zA-Z_][a-zA-Z0-9_]* ;
    DOT          : '.' ;
    LBRACKET     : '[' ;
    RBRACKET     : ']' ;
    LPAREN       : '(' ;
    RPAREN       : ')' ;
    COMMA        : ',' ;
    COLON        : ':' ;
    PIPE         : '|' ;

    // Operators
    PLUS     : '+' ;
    MINUS    : '-' ;
    MULT     : '*' ;
    DIV      : '/' ;
    MOD      : '%' ;
    EQ       : '==' ;
    NEQ      : '!=' ;
    LT       : '<' ;
    GT       : '>' ;
    LTE      : '<=' ;
    GTE      : '>=' ;
    AND      : 'and' ;
    OR       : 'or' ;
    NOT      : 'not' ;

    // Literals
    NUMBER   : [0-9]+ ('.' [0-9]+)? ;
    STRING   : '"' (~["\\] | '\\' .)* '"'
             | '\'' (~['\\] | '\\' .)* '\'' ;

    WS       : [ \t\r\n]+ ->skip ;
    // أي شيء آخر
    OTHER    : . ;

// ===== Jinja Statement Mode =====
mode JINJA_STMT_MODE;
    JINJA_STMT_CLOSE : '%}' -> popMode;

    // Keywords - يجب أن تكون قبل IDENTIFIER!
    ENDFOR  : 'endfor' ;
    ENDIF   : 'endif' ;
    FOR     : 'for' ;
    IN      : 'in' ;
    IF      : 'if' ;
    ELSE    : 'else' ;
    ELIF    : 'elif' ;
    END     : 'end' ;
    SET     : 'set' ;
    BLOCK   : 'block' ;
    EXTENDS : 'extends' ;
    INCLUDE : 'include' ;
    MACRO   : 'macro' ;

    // Identifiers and values
    IDENTIFIER_STMT : [a-zA-Z_][a-zA-Z0-9_]* ;
    DOT_STMT        : '.' ;
    COMMA_STMT      : ',' ;
    COLON_STMT      : ':' ;
    LPAREN_STMT     : '(' ;
    RPAREN_STMT     : ')' ;

    // Literals
    NUMBER_STMT     : [0-9]+ ('.' [0-9]+)? ;
    STRING_STMT     : '"' (~["\\] | '\\' .)* '"'
                    | '\'' (~['\\] | '\\' .)* '\'' ;

    WS_STMT         : [ \t\r\n]+ -> skip ;
    // أي شيء آخر
    OTHER_STMT      : . ;

// ===== Jinja Comment Mode =====
mode JINJA_COMMENT_MODE;
    JINJA_COMMENT_CLOSE : '#}' -> popMode;
    COMMENT_CONTENT : ~'#'+ ;

// ===== HTML Tag Mode (كما هو) =====
mode HTML_TAG_MODE;
    TAG_CLOSE       : '>' -> popMode;
    TAG_SLASH_CLOSE : '/>' -> popMode;
    TAG_SLASH       : '/' ;
    TAG_NAME        : [a-zA-Z][a-zA-Z0-9_-]*;
    TAG_WHITESPACE  : [ \t\r\n]+ -> skip;
    ATTR_NAME       : [a-zA-Z_][a-zA-Z0-9_-]*;
    EQUALS          : '=';
    DOUBLE_QUOTE_STRING : '"' (~["\r\n] | '\\"')* '"';
    SINGLE_QUOTE_STRING : '\'' (~['\r\n] | '\\\'')* '\'';
    UNQUOTED_VALUE      : ~[ \t\r\n>"'=<>/]+ ;
    ATTR_JINJA_EXPR_OPEN : '{{' -> pushMode(JINJA_EXPR_MODE);
    ATTR_JINJA_STMT_OPEN : '{%' -> pushMode(JINJA_STMT_MODE);