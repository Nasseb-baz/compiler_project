class ASTNode:
    def __init__(self, node_name, line):
        self.node_name = node_name
        self.line = line
        self.children = []

    def add_child(self, child):
        self.children.append(child)

    def print_tree(self, indent=0):
        print("  " * indent + f"{self.node_name} (line {self.line})")
        for child in self.children:
            child.print_tree(indent + 1)


class ProgramNode(ASTNode):
    def __init__(self):
        super().__init__("Program", 0)


class FunctionNode(ASTNode):
    def __init__(self, name, line):
        super().__init__(f"Function: {name}", line)


class ReturnNode(ASTNode):
    def __init__(self, line):
        super().__init__("Return", line)
