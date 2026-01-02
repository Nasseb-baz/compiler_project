parser grammar PythonParser;

options { tokenVocab=PythonLexer; }

program: (stmt | NEWLINE)* EOF;

stmt: simple_stmt | compound_stmt;

simple_stmt:
      expr_stmt
    | return_stmt
    | import_stmt
    | assign_stmt
    | decorator           // <-- أضف decorator هنا
;

compound_stmt:
      if_stmt
    | for_stmt
    | funcdef
;

// ========== أضف هذه القواعد هنا ==========
decorator: AT decorator_expr NEWLINE;
decorator_expr: expr (NEWLINE | ',')?;

import_stmt: (FROM IDENTIFIER IMPORT IDENTIFIER (COMMA IDENTIFIER)*)
           | (IMPORT IDENTIFIER (COMMA IDENTIFIER)*);
// ==========================================

assign_stmt: IDENTIFIER ASSIGN expr;

expr_stmt: expr;

return_stmt: RETURN expr?;

if_stmt: IF expr COLON block (ELSE COLON block)?;

for_stmt: FOR IDENTIFIER IN expr COLON block;

funcdef: decorator* DEF IDENTIFIER LPAREN (func_args)? RPAREN COLON block;  // <-- decorator* هنا

func_args: IDENTIFIER (COMMA IDENTIFIER)*;

block: INDENT (stmt | NEWLINE)+ DEDENT;

expr:
      literal
    | IDENTIFIER
    | expr binop expr
    | expr DOT IDENTIFIER
    | expr LPAREN (call_args)? RPAREN
    | expr LBRACK expr RBRACK
    | LBRACE (dict_entries)? RBRACE
    | LBRACK (list_elems)? RBRACK
    | LPAREN expr RPAREN
;

call_args: call_arg (COMMA call_arg)*;
call_arg: expr | keyword_arg;
keyword_arg: IDENTIFIER ASSIGN expr;

dict_entries: dict_entry (COMMA dict_entry)*;
dict_entry: expr COLON expr;

list_elems: expr (COMMA expr)*;

literal: NUMBER | STRING | TRUE | FALSE | NONE;

binop: PLUS | MINUS | MULT | DIV | MOD | EQ | NEQ | LT | GT | LE | GE | AND | OR;