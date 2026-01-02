lexer grammar Jinja2Lexer;

// ========== DEFAULT MODE (HTML/TEXT) ==========
HTML_TEXT : ~[{%#]+ ;  // Any text that's not Jinja2 delimiter

// Transition to Jinja2 modes
OPEN_VAR     : '{{' -> pushMode(VAR_MODE);
OPEN_BLOCK   : '{%' -> pushMode(BLOCK_MODE);
OPEN_COMMENT : '{#' -> pushMode(COMMENT_MODE);

// ========== COMMENT MODE ==========
mode COMMENT_MODE;
C_TEXT : ~[#]+ ;
C_END  : '#}' -> popMode;

// ========== VARIABLE MODE ==========
mode VAR_MODE;
// Delimiters
V_END : '}}' -> popMode;

// Expression content - matches BLOCK_MODE
V_ID    : [a-zA-Z_][a-zA-Z0-9_]* ;
V_DOT   : '.' ;
V_PIPE  : '|' ;
V_LPAREN : '(' ;
V_RPAREN : ')' ;
V_COMMA : ',' ;
V_ASSIGN : '=' ;

// Operators
V_PLUS  : '+' ;
V_MINUS : '-' ;
V_MULT  : '*' ;
V_DIV   : '/' ;
V_MOD   : '%' ;

// Comparison operators
V_EQ : '==' ;
V_NE : '!=' ;
V_LT : '<' ;
V_GT : '>' ;
V_LE : '<=' ;
V_GE : '>=' ;

// Logical operators
V_AND : 'and' ;
V_OR  : 'or' ;
V_NOT : 'not' ;

// Literals
V_STRING : '"' (~["\\] | '\\' .)* '"'
          | '\'' (~['\\] | '\\' .)* '\'' ;
V_NUMBER : [0-9]+ ('.' [0-9]+)? ;

// Keywords that can appear in expressions
V_IN : 'in' ;
V_IS : 'is' ;

// Ignore whitespace
V_WS : [ \t\r\n]+ -> skip ;

// ========== BLOCK MODE ==========
mode BLOCK_MODE;
// Delimiters
B_END : '%}' -> popMode;

// Block keywords
B_IF : 'if' ;
B_ELSE : 'else' ;
B_ELIF : 'elif' ;
B_ENDIF : 'endif' ;
B_FOR : 'for' ;
B_IN : 'in' ;
B_ENDFOR : 'endfor' ;
B_BLOCK : 'block' ;
B_ENDBLOCK : 'endblock' ;
B_EXTENDS : 'extends' ;
B_INCLUDE : 'include' ;
B_IMPORT : 'import' ;
B_FROM : 'from' ;
B_MACRO : 'macro' ;
B_ENDMACRO : 'endmacro' ;
B_SET : 'set' ;
B_WITH : 'with' ;
B_ENDWITH : 'endwith' ;
B_IS : 'is' ;

// Expression operators (same as VAR_MODE)
B_ID    : [a-zA-Z_][a-zA-Z0-9_]* ;
B_DOT   : '.' ;
B_LPAREN : '(' ;
B_RPAREN : ')' ;
B_COMMA : ',' ;
B_ASSIGN : '=' ;
B_PLUS  : '+' ;
B_MINUS : '-' ;
B_MULT  : '*' ;
B_DIV   : '/' ;
B_MOD   : '%' ;
B_EQ : '==' ;
B_NE : '!=' ;
B_LT : '<' ;
B_GT : '>' ;
B_LE : '<=' ;
B_GE : '>=' ;
B_AND : 'and' ;
B_OR  : 'or' ;
B_NOT : 'not' ;

// Literals
B_STRING : '"' (~["\\] | '\\' .)* '"'
          | '\'' (~['\\] | '\\' .)* '\'' ;
B_NUMBER : [0-9]+ ('.' [0-9]+)? ;

// Ignore whitespace
B_WS : [ \t\r\n]+ -> skip ;