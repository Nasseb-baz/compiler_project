from lexer import tokenize

with open("tests/test1.txt", "r", encoding="utf-8") as f:
    text = f.read()

tokens = tokenize(text)

for t in tokens:
    print(f"{t.type:<6} {t.value:<15} line={t.line}")
