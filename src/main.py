from lexer import tokenize
from parser import Parser

with open("tests/test1.txt", "r", encoding="utf-8") as f:
    text = f.read()

tokens = tokenize(text)
parser = Parser(tokens)

ast = parser.parse()
ast.print_tree()
