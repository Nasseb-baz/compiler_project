lexer grammar PythonLexer;

// Keywords
IMPORT: 'import';
FROM: 'from';
DEF: 'def';
RETURN: 'return';
IF: 'if';
ELSE: 'else';
FOR: 'for';
IN: 'in';
AND: 'and';
OR: 'or';
NOT: 'not';
TRUE: 'True';
FALSE: 'False';
NONE: 'None';

// Decorator
AT: '@';

// Literals
NUMBER: [0-9]+ ('.' [0-9]+)?;
STRING: ('"' (~["\r\n] | '\\"')* '"') | ('\'' (~['\r\n] | '\\\'')* '\'');
IDENTIFIER: [a-zA-Z_][a-zA-Z0-9_]*;

// Operators
PLUS: '+';
MINUS: '-';
MULT: '*';
DIV: '/';
MOD: '%';
ASSIGN: '=';
EQ: '==';
NEQ: '!=';
LT: '<';
GT: '>';
LE: '<=';
GE: '>=';
POW: '**';

// Delimiters
LPAREN: '(';
RPAREN: ')';
LBRACK: '[';
RBRACK: ']';
LBRACE: '{';
RBRACE: '}';
COMMA: ',';
COLON: ':';
DOT: '.';
INDENT: '<INDENT>';
DEDENT: '<DEDENT>';
NEWLINE: '\n';

// Comments and whitespace
COMMENT: '#' ~[\r\n]* -> skip;
WS: [ \t\r]+ -> skip;