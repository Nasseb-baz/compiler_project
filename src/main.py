from ast_nodes import ProgramNode, FunctionNode, ReturnNode

program = ProgramNode()

func = FunctionNode("show_products", 1)
ret = ReturnNode(2)

func.add_child(ret)
program.add_child(func)

program.print_tree()
