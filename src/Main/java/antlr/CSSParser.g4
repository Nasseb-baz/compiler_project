parser grammar CSSParser;

options { tokenVocab=CSSLexer; }

stylesheet: (rule | at_rule | COMMENT)* EOF;

rule: selectors LBRACE declaration* RBRACE;

selectors: selector (COMMA selector)*;

selector: simple_selector (combinator simple_selector)*;

simple_selector: (type_selector | universal) (hash | class | attribute | pseudo)*;

type_selector: IDENT;
universal: STAR;
hash: HASH IDENT;
class: DOT IDENT;
attribute: LBRACK IDENT ( (EQUALS | INCLUDES | DASHMATCH) STRING )? RBRACK;
pseudo: COLON COLON? IDENT (LPAREN (NUMBER | IDENT) RPAREN)?;

combinator: (GT | PLUS | TILDE) | WS;

declaration: property COLON values important? SEMICOLON;

property: IDENT;

values: value (WS value)*;

value: STRING | NUMBER unit? | HEX_COLOR | IDENT | URL;

unit: PX | PT | EM | REM | PERCENT | CM | MM | IN | PC | EX | CH
     | VW | VH | VMIN | VMAX | DEG | RAD | GRAD | TURN | S | MS
     | HZ | KHZ | DPI | DPCM | DPPX;

important: IMPORTANT;

at_rule: AT IDENT WS* (value WS*)* (LBRACE declaration* RBRACE | SEMICOLON);