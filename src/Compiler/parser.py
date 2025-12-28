

from typing import List, Optional
from .lexer import TemplateLexer, Token, TokenType
from .ast import *


class ParseError(Exception):
    def __init__(self, message: str, token: Optional[Token] = None):
        self.message = message
        self.token = token
        super().__init__(f"{message} at line {token.line if token else 'unknown'}")


class TemplateParser:
    
    def __init__(self, tokens: List[Token]):
        self.tokens = tokens
        self.current = 0
    
    def parse(self) -> Document:
        content = []
        
        while not self._is_at_end():
            try:
                node = self._parse_html_content()
                if node:
                    content.append(node)
            except ParseError as e:
                print(f"Parse error: {e}")
                self._synchronize()
        
        return Document(content=content)
    
    
    def _is_at_end(self) -> bool:
        return self._peek().type == TokenType.EOF
    
    def _peek(self) -> Token:
        return self.tokens[self.current]
    
    def _previous(self) -> Token:
        return self.tokens[self.current - 1]
    
    def _advance(self) -> Token:
        if not self._is_at_end():
            self.current += 1
        return self._previous()
    
    def _check(self, token_type: TokenType) -> bool:
        if self._is_at_end():
            return False
        return self._peek().type == token_type
    
    def _match(self, *token_types: TokenType) -> bool:
        for token_type in token_types:
            if self._check(token_type):
                self._advance()
                return True
        return False
    
    def _consume(self, token_type: TokenType, message: str) -> Token:
        if self._check(token_type):
            return self._advance()
        
        raise ParseError(message, self._peek())
    
    def _synchronize(self):
        self._advance()
        
        while not self._is_at_end():
            if self._previous().type == TokenType.JINJA_STMT_CLOSE:
                return
            
            if self._previous().type == TokenType.TAG_CLOSE:
                return
            
            if self._peek().type in [
                TokenType.JINJA_STMT_OPEN,
                TokenType.JINJA_EXPR_OPEN,
                TokenType.HTML_TAG_OPEN,
                TokenType.HTML_TEXT
            ]:
                return
            
            self._advance()
    
    
    def _parse_html_content(self) -> Optional[Node]:
        """htmlContent: htmlElement | jinjaElement | HTML_TEXT"""
        
        if self._check(TokenType.HTML_TAG_OPEN):
            return self._parse_html_element()
        
        elif self._check(TokenType.JINJA_EXPR_OPEN):
            return self._parse_jinja_expression()
        
        elif self._check(TokenType.JINJA_STMT_OPEN):
            return self._parse_jinja_statement_or_control()
        
        elif self._check(TokenType.JINJA_COMMENT_OPEN):
            return self._parse_jinja_comment()
        
        elif self._check(TokenType.HTML_TEXT):
            return self._parse_html_text()
        
        elif self._check(TokenType.WS):
            self._advance()
            return None
        
        return None
    
    def _parse_html_element(self) -> HtmlElement:
        
        self._consume(TokenType.HTML_TAG_OPEN, "Expected '<'")
        
        tag_name_token = self._consume(TokenType.TAG_NAME, "Expected tag name")
        tag_name = tag_name_token.value
        
        attributes = []
        while not self._check(TokenType.TAG_CLOSE) and \
              not self._check(TokenType.TAG_SLASH_CLOSE) and \
              not self._is_at_end():
            attr = self._parse_attribute()
            if attr:
                attributes.append(attr)
        
        self_closing = False
        if self._match(TokenType.TAG_SLASH_CLOSE):
            self_closing = True
        else:
            self._consume(TokenType.TAG_CLOSE, "Expected '>' or '/>'")
        
        children = []
        if not self_closing:
            while not (self._check(TokenType.HTML_TAG_OPEN) and 
                      self._peek().value == '/'):
                child = self._parse_html_content()
                if child:
                    children.append(child)
                
                if self._is_at_end():
                    break
            
            if self._check(TokenType.HTML_TAG_OPEN):
                self._advance()  # Consume '<'
                if self._match(TokenType.TAG_SLASH):
                    closing_name = self._consume(
                        TokenType.TAG_NAME, 
                        "Expected closing tag name"
                    )
                    if closing_name.value != tag_name:
                        raise ParseError(
                            f"Closing tag </{closing_name.value}> doesn't match opening <{tag_name}>",
                            closing_name
                        )
                    self._consume(TokenType.TAG_CLOSE, "Expected '>' after closing tag")
        
        return HtmlElement(
            tag_name=tag_name,
            attributes=attributes,
            children=children,
            self_closing=self_closing
        )
    
    def _parse_attribute(self) -> Optional[Attribute]:
        """attribute: ATTR_NAME (EQUALS attributeValue)?"""
        
        if not self._check(TokenType.ATTR_NAME):
            return None
        
        name_token = self._advance()
        name = name_token.value
        
        value = None
        if self._match(TokenType.EQUALS):
            value = self._parse_attribute_value()
        
        return Attribute(name=name, value=value)
    
    def _parse_attribute_value(self) -> Optional[Union[str, JinjaExpression]]:
        
        if self._check(TokenType.DOUBLE_QUOTE_STRING):
            token = self._advance()
            return token.value[1:-1]  
        
        elif self._check(TokenType.SINGLE_QUOTE_STRING):
            token = self._advance()
            return token.value[1:-1]  
        
        elif self._check(TokenType.UNQUOTED_VALUE):
            token = self._advance()
            return token.value
        
        elif self._check(TokenType.JINJA_EXPR_OPEN):
            return self._parse_jinja_expression()
        
        else:
            raise ParseError("Expected attribute value", self._peek())
    
    def _parse_html_text(self) -> HtmlText:
        """HTML_TEXT content"""
        token = self._advance()
        return HtmlText(content=token.value)
    
    def _parse_jinja_expression(self) -> JinjaExpression:
        """jinjaExpression: JINJA_EXPR_OPEN exprContent* JINJA_EXPR_CLOSE"""
        
        self._consume(TokenType.JINJA_EXPR_OPEN, "Expected '{{'")
        
        content = []
        while not self._check(TokenType.JINJA_EXPR_CLOSE) and not self._is_at_end():
            content.append(self._advance())
        
        self._consume(TokenType.JINJA_EXPR_CLOSE, "Expected '}}'")
        
        return JinjaExpression(content=[])
    
    def _parse_jinja_statement_or_control(self) -> Node:
        """Handle {% ... %} statements"""
        
        self._consume(TokenType.JINJA_STMT_OPEN, "Expected '{%'")
        
        if self._check(TokenType.FOR):
            return self._parse_for_statement()
        elif self._check(TokenType.IF):
            return self._parse_if_statement()
        else:
            return self._parse_generic_statement()
    
    def _parse_for_statement(self) -> JinjaForStatement:
        """jinjaForStatement: FOR IDENTIFIER IN expr ... ENDFOR"""
        
        self._consume(TokenType.FOR, "Expected 'for'")
        
        var_token = self._consume(TokenType.IDENTIFIER, "Expected variable name after 'for'")
        variable = var_token.value
        
        self._consume(TokenType.IN, "Expected 'in' after variable")
        
        expr_tokens = []
        while not self._check(TokenType.JINJA_STMT_CLOSE):
            expr_tokens.append(self._advance())
        
        self._consume(TokenType.JINJA_STMT_CLOSE, "Expected '%}'")
        
        body = []
        while not (self._check(TokenType.JINJA_STMT_OPEN) and 
                  self._check_next(TokenType.ENDFOR)):
            node = self._parse_html_content()
            if node:
                body.append(node)
            
            if self._is_at_end():
                break
        
        self._consume(TokenType.JINJA_STMT_OPEN, "Expected '{% endfor %}'")
        self._consume(TokenType.ENDFOR, "Expected 'endfor'")
        self._consume(TokenType.JINJA_STMT_CLOSE, "Expected '%}' after 'endfor'")
        
        iterable_expr = Identifier(name=expr_tokens[0].value if expr_tokens else "items")
        
        return JinjaForStatement(
            variable=variable,
            iterable=iterable_expr,
            body=body
        )
    
    def _parse_if_statement(self) -> JinjaIfStatement:
        """Parse if/elif/else statements"""
        pass
    
    def _parse_generic_statement(self) -> JinjaStatement:
        """Generic jinjaStatement for set, block, extends, etc."""
        
        keyword_token = self._advance()
        keyword = keyword_token.value
        
        content_tokens = []
        while not self._check(TokenType.JINJA_STMT_CLOSE) and not self._is_at_end():
            content_tokens.append(self._advance())
        
        self._consume(TokenType.JINJA_STMT_CLOSE, "Expected '%}'")
        
        return JinjaStatement(keyword=keyword, content=[])
    
    def _parse_jinja_comment(self) -> JinjaComment:
        
        self._consume(TokenType.JINJA_COMMENT_OPEN, "Expected '{#'")
        
        content = []
        while not self._check(TokenType.JINJA_COMMENT_CLOSE) and not self._is_at_end():
            content.append(self._advance().value)
        
        self._consume(TokenType.JINJA_COMMENT_CLOSE, "Expected '#}'")
        
        return JinjaComment(content="".join(content))
    
    def _check_next(self, token_type: TokenType) -> bool:
        """Check the token after the current one"""
        if self.current + 1 >= len(self.tokens):
            return False
        return self.tokens[self.current + 1].type == token_type


def parse_template(text: str) -> Document:
    """Convenience function to parse template text directly"""
    lexer = TemplateLexer(text)
    return Document(content=[])


if __name__ == "__main__":
    print("Template Parser Structure")
    print("=" * 50)
    
    mock_tokens = [
        Token(TokenType.HTML_TAG_OPEN, "<", 0),
        Token(TokenType.TAG_NAME, "html", 1),
        Token(TokenType.TAG_CLOSE, ">", 5),
        Token(TokenType.HTML_TAG_OPEN, "<", 6),
        Token(TokenType.TAG_SLASH, "/", 7),
        Token(TokenType.TAG_NAME, "html", 8),
        Token(TokenType.TAG_CLOSE, ">", 12),
        Token(TokenType.EOF, "", 13)
    ]
    
    parser = TemplateParser(mock_tokens)
    print("Parser created successfully!")
    print(f"Number of tokens: {len(mock_tokens)}")