lexer grammar HTMLLexer;

// Tags
TAG_OPEN: '<';
TAG_CLOSE: '>';
SLASH_CLOSE: '/>';
TAG_END_OPEN: '</';
DOCTYPE_OPEN: '<!DOCTYPE' [ \t\r\n];

// Special tags
SCRIPT_OPEN: '<script' [ \t\r\n];
STYLE_OPEN: '<style' [ \t\r\n];
SCRIPT: 'script';
STYLE: 'style';

// Tag names
TAG_NAME: [a-zA-Z_][a-zA-Z0-9_\-]*;

// Attribute related
EQUALS: '=';
STRING: '"' (~["\\\r\n] | '\\' ["\\/bfnrt])* '"'
      | '\'' (~['\\\r\n] | '\\' ['\\/bfnrt])* '\'';

// Attribute names
ATTRIBUTE_NAME: [a-zA-Z_][a-zA-Z0-9_\-:]*;

// Content
TEXT: ~[<]+;

// Comments
HTML_COMMENT: '<!--' .*? '-->' -> skip;

WS: [ \t\r\n]+ -> skip;