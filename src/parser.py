from ast_nodes import ProgramNode, FunctionNode, ReturnNode

class Parser:
    def __init__(self, tokens):
        self.tokens = tokens
        self.pos = 0

    def current(self):
        return self.tokens[self.pos]

    def eat(self, token_type):
        token = self.current()
        if token.type == token_type:
            self.pos += 1
            return token
        else:
            raise SyntaxError(
                f"Expected {token_type}, got {token.type} at line {token.line}"
            )

    def parse(self):
        program = ProgramNode()

        while self.current().type != "EOF":
            if self.current().type == "FUNC":
                func = self.parse_function()
                program.add_child(func)
            else:
                self.pos += 1  

        return program

    def parse_function(self):
        self.eat("FUNC")
        name_token = self.eat("IDENT")
        func_node = FunctionNode(name_token.value, name_token.line)

        self.eat("EOL")

        if self.current().type == "RETURN":
            ret_node = self.parse_return()
            func_node.add_child(ret_node)

        return func_node

    def parse_return(self):
        ret_token = self.eat("RETURN")
        self.eat("IDENT")
        self.eat("EOL")
        return ReturnNode(ret_token.line)
