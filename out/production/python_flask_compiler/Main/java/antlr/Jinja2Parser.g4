parser grammar Jinja2Parser;

options { tokenVocab = Jinja2Lexer; }

// ========== ROOT ==========
document : element* EOF ;

// ========== ELEMENTS ==========
element : html_text
        | variable
        | block
        | comment
        ;

html_text : HTML_TEXT ;

comment : OPEN_COMMENT C_TEXT* C_END ;

// ========== VARIABLES ==========
variable : OPEN_VAR expression (V_PIPE filter)* V_END ;

filter : V_ID (V_LPAREN filter_arguments? V_RPAREN)? ;

filter_arguments : filter_argument (V_COMMA filter_argument)* ;

filter_argument : expression | V_ID V_ASSIGN expression ;

// ========== BLOCKS ==========
block : if_block
      | for_block
      | block_tag
      | extends_block
      | include_block
      | set_block
      | with_block
      | simple_block
      ;

// ========== IF BLOCK ==========
if_block : OPEN_BLOCK B_IF condition B_END
           inner_content?
           elif_block*
           else_block?
           OPEN_BLOCK B_ENDIF B_END ;

elif_block : OPEN_BLOCK B_ELIF condition B_END inner_content? ;

else_block : OPEN_BLOCK B_ELSE B_END inner_content? ;

// ========== FOR BLOCK ==========
for_block : OPEN_BLOCK B_FOR B_ID B_IN expression B_END
            inner_content?
            OPEN_BLOCK B_ENDFOR B_END ;

// ========== BLOCK TAG ==========
block_tag : OPEN_BLOCK B_BLOCK B_ID B_END
            inner_content?
            OPEN_BLOCK B_ENDBLOCK B_END ;

// ========== EXTENDS BLOCK ==========
extends_block : OPEN_BLOCK B_EXTENDS string_literal B_END ;

// ========== INCLUDE BLOCK ==========
include_block : OPEN_BLOCK B_INCLUDE string_literal B_END ;

// ========== SET BLOCK ==========
set_block : OPEN_BLOCK B_SET assignment B_END ;

// ========== WITH BLOCK ==========
with_block : OPEN_BLOCK B_WITH assignments? B_END
             inner_content?
             OPEN_BLOCK B_ENDWITH B_END ;

// ========== SIMPLE BLOCK (catch-all) ==========
simple_block : OPEN_BLOCK (B_ID | B_EXTENDS | B_INCLUDE | B_IMPORT | B_FROM | B_MACRO) .*? B_END ;

// ========== EXPRESSIONS ==========
condition : expression ;

expression : logical_or ;

logical_or : logical_and (V_OR logical_and)* ;

logical_and : equality (V_AND equality)* ;

equality : comparison ((V_EQ | V_NE | V_IS) comparison)* ;

comparison : term ((V_LT | V_GT | V_LE | V_GE | V_IN) term)* ;

term : factor ((V_PLUS | V_MINUS) factor)* ;

factor : unary ((V_MULT | V_DIV | V_MOD) unary)* ;

unary : (V_PLUS | V_MINUS | V_NOT)? primary ;

primary : literal
        | identifier
        | function_call
        | V_LPAREN expression V_RPAREN
        ;

// ========== FUNCTION CALLS ==========
function_call : V_ID V_LPAREN call_arguments? V_RPAREN ;

call_arguments : call_argument (V_COMMA call_argument)* ;

call_argument : expression | V_ID V_ASSIGN expression ;

// ========== IDENTIFIERS ==========
identifier : V_ID (V_DOT V_ID)* ;

// ========== LITERALS ==========
literal : string_literal | V_NUMBER ;

string_literal : V_STRING ;

// ========== ASSIGNMENTS ==========
assignment : B_ID B_ASSIGN expression ;

assignments : assignment (B_COMMA assignment)* ;

// ========== CONTENT HELPERS ==========
inner_content : element+ ;