lexer grammar CSSLexer;

// Brackets
LBRACE: '{';
RBRACE: '}';
LPAREN: '(';
RPAREN: ')';
LBRACK: '[';
RBRACK: ']';

// Separators
COLON: ':';
SEMICOLON: ';';
COMMA: ',';
DOT: '.';

// Selector combinators
GT: '>';
PLUS: '+';
TILDE: '~';
STAR: '*';
HASH: '#';

// At-rules
AT: '@';

// Important
IMPORTANT: '!important';

// Units
PX: 'px';
PT: 'pt';
EM: 'em';
REM: 'rem';
PERCENT: '%';
CM: 'cm';
MM: 'mm';
IN: 'in';
PC: 'pc';
EX: 'ex';
CH: 'ch';
VW: 'vw';
VH: 'vh';
VMIN: 'vmin';
VMAX: 'vmax';
DEG: 'deg';
RAD: 'rad';
GRAD: 'grad';
TURN: 'turn';
S: 's';
MS: 'ms';
HZ: 'hz';
KHZ: 'khz';
DPI: 'dpi';
DPCM: 'dpcm';
DPPX: 'dppx';

// Values
STRING: '"' (~["\\\r\n] | '\\' ["\\/bfnrt])* '"'
      | '\'' (~['\\\r\n] | '\\' ['\\/bfnrt])* '\'';
NUMBER: [0-9]+ ('.' [0-9]+)?;
HEX_COLOR: '#' [0-9a-fA-F]+;
URL: 'url(' (~[)])* ')';

// Identifiers
IDENT: [a-zA-Z_\-][a-zA-Z0-9_\-]*;

// Comments
COMMENT: '/*' .*? '*/' -> skip;

WS: [ \t\r\n]+ -> skip;
// Add these at the end of CSSLexer.g4
EQUALS: '=';
INCLUDES: '~=';
DASHMATCH: '|=';