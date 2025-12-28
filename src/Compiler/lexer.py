from enum import Enum
from dataclasses import dataclass
from typing import List, Optional

# ===== Token Types =====
class TokenType(Enum):
    # HTML Tokens
    HTML_TAG_OPEN = "HTML_TAG_OPEN"
    HTML_TEXT = "HTML_TEXT"
    TAG_CLOSE = "TAG_CLOSE"
    TAG_SLASH_CLOSE = "TAG_SLASH_CLOSE"
    TAG_SLASH = "TAG_SLASH"
    TAG_NAME = "TAG_NAME"
    ATTR_NAME = "ATTR_NAME"
    EQUALS = "EQUALS"
    DOUBLE_QUOTE_STRING = "DOUBLE_QUOTE_STRING"
    SINGLE_QUOTE_STRING = "SINGLE_QUOTE_STRING"
    UNQUOTED_VALUE = "UNQUOTED_VALUE"
    
    # Jinja Delimiters
    JINJA_EXPR_OPEN = "JINJA_EXPR_OPEN"
    JINJA_EXPR_CLOSE = "JINJA_EXPR_CLOSE"
    JINJA_STMT_OPEN = "JINJA_STMT_OPEN"
    JINJA_STMT_CLOSE = "JINJA_STMT_CLOSE"
    JINJA_COMMENT_OPEN = "JINJA_COMMENT_OPEN"
    JINJA_COMMENT_CLOSE = "JINJA_COMMENT_CLOSE"
    
    # Keywords (from statement mode)
    FOR = "FOR"
    IN = "IN"
    IF = "IF"
    ELSE = "ELSE"
    ELIF = "ELIF"
    END = "END"
    ENDFOR = "ENDFOR"
    ENDIF = "ENDIF"
    SET = "SET"
    BLOCK = "BLOCK"
    EXTENDS = "EXTENDS"
    INCLUDE = "INCLUDE"
    MACRO = "MACRO"
    
    # Identifiers and Literals
    IDENTIFIER = "IDENTIFIER"
    DOT = "DOT"
    NUMBER = "NUMBER"
    STRING = "STRING"
    
    # Operators
    PLUS = "PLUS"
    MINUS = "MINUS"
    MULT = "MULT"
    DIV = "DIV"
    MOD = "MOD"
    EQ = "EQ"
    NEQ = "NEQ"
    LT = "LT"
    GT = "GT"
    LTE = "LTE"
    GTE = "GTE"
    AND = "AND"
    OR = "OR"
    NOT = "NOT"
    
    # Punctuation
    LBRACKET = "LBRACKET"
    RBRACKET = "RBRACKET"
    LPAREN = "LPAREN"
    RPAREN = "RPAREN"
    COMMA = "COMMA"
    COLON = "COLON"
    PIPE = "PIPE"
    
    # Special
    WS = "WS"
    EOF = "EOF"


@dataclass
class Token:
    type: TokenType
    value: str
    position: int
    line: int = 1
    column: int = 1
    
    def __repr__(self):
        return f"Token({self.type.name}, '{self.value}', pos={self.position})"


class LexerState(Enum):
    """Different lexing modes similar to ANTLR modes"""
    DEFAULT = "DEFAULT"
    HTML_TAG = "HTML_TAG"
    JINJA_EXPR = "JINJA_EXPR"
    JINJA_STMT = "JINJA_STMT"
    JINJA_COMMENT = "JINJA_COMMENT"


class TemplateLexer:
    """Lexer for Jinja-like template language"""
    
    def __init__(self, text: str):
        self.text = text
        self.pos = 0
        self.line = 1
        self.column = 1
        self.tokens: List[Token] = []
        self.state = LexerState.DEFAULT
        self.state_stack = []  # For tracking mode changes
        
    def _push_state(self, new_state: LexerState):
        """Push current state onto stack and enter new state"""
        self.state_stack.append(self.state)
        self.state = new_state
        
    def _pop_state(self) -> LexerState:
        """Pop and return to previous state"""
        if self.state_stack:
            self.state = self.state_stack.pop()
        return self.state
    
    def _add_token(self, token_type: TokenType, value: str = None):
        """Helper to add a token"""
        if value is None:
            value = self.text[self.pos-1:self.pos] if self.pos > 0 else ""
        
        token = Token(
            type=token_type,
            value=value,
            position=self.pos - len(value),
            line=self.line,
            column=self.column - len(value)
        )
        self.tokens.append(token)
        return token
    
    def _is_at_end(self) -> bool:
        """Check if we've reached the end of input"""
        return self.pos >= len(self.text)
    
    def _peek(self) -> str:
        """Look at next character without consuming it"""
        if self.is_at_end():
            return '\0'
        return self.text[self.pos]
    
    def _advance(self) -> str:
        """Consume and return next character"""
        if self.is_at_end():
            return '\0'
        
        char = self.text[self.pos]
        self.pos += 1
        
        if char == '\n':
            self.line += 1
            self.column = 1
        else:
            self.column += 1
            
        return char
    
    def _match(self, expected: str) -> bool:
        """Consume character if it matches expected"""
        if self.is_at_end():
            return False
        if self.text[self.pos] != expected:
            return False
            
        self._advance()
        return True
    
    # Add missing method
    def is_at_end(self) -> bool:
        return self.pos >= len(self.text)


# We'll implement the actual lexing logic in the next step

if __name__ == "__main__":
    # Quick test
    lexer = TemplateLexer("Hello {{ name }}")
    print("Lexer created successfully!")