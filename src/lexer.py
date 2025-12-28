from dataclasses import dataclass

@dataclass
class Token:
    type: str
    value: str
    line: int

KEYWORDS = {
    "FUNC": "FUNC",
    "RETURN": "RETURN",
}

def tokenize(text: str):
    tokens = []
    lines = text.splitlines()

    for line_num, line in enumerate(lines, start=1):
        line = line.strip()

        # ignore empty lines and comments
        if line == "" or line.startswith("#"):
            continue

        parts = line.split()

        for part in parts:
            if part in KEYWORDS:
                tokens.append(Token(KEYWORDS[part], part, line_num))
            else:
                tokens.append(Token("IDENT", part, line_num))

        tokens.append(Token("EOL", "\\n", line_num))

    tokens.append(Token("EOF", "", len(lines) + 1))
    return tokens
