// Generated from C:/Users/laith/IdeaProjects/python_flask_compiler/src/Main/java/antlr/PythonParser.g4 by ANTLR 4.13.2
package Main.java.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PythonParser}.
 */
public interface PythonParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PythonParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(PythonParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(PythonParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(PythonParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(PythonParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#simple_stmt}.
	 * @param ctx the parse tree
	 */
	void enterSimple_stmt(PythonParser.Simple_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#simple_stmt}.
	 * @param ctx the parse tree
	 */
	void exitSimple_stmt(PythonParser.Simple_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void enterCompound_stmt(PythonParser.Compound_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#compound_stmt}.
	 * @param ctx the parse tree
	 */
	void exitCompound_stmt(PythonParser.Compound_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#decorator}.
	 * @param ctx the parse tree
	 */
	void enterDecorator(PythonParser.DecoratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#decorator}.
	 * @param ctx the parse tree
	 */
	void exitDecorator(PythonParser.DecoratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#import_stmt}.
	 * @param ctx the parse tree
	 */
	void enterImport_stmt(PythonParser.Import_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#import_stmt}.
	 * @param ctx the parse tree
	 */
	void exitImport_stmt(PythonParser.Import_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void enterAssign_stmt(PythonParser.Assign_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#assign_stmt}.
	 * @param ctx the parse tree
	 */
	void exitAssign_stmt(PythonParser.Assign_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#expr_stmt}.
	 * @param ctx the parse tree
	 */
	void enterExpr_stmt(PythonParser.Expr_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#expr_stmt}.
	 * @param ctx the parse tree
	 */
	void exitExpr_stmt(PythonParser.Expr_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void enterReturn_stmt(PythonParser.Return_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#return_stmt}.
	 * @param ctx the parse tree
	 */
	void exitReturn_stmt(PythonParser.Return_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(PythonParser.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(PythonParser.If_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void enterFor_stmt(PythonParser.For_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void exitFor_stmt(PythonParser.For_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#funcdef}.
	 * @param ctx the parse tree
	 */
	void enterFuncdef(PythonParser.FuncdefContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#funcdef}.
	 * @param ctx the parse tree
	 */
	void exitFuncdef(PythonParser.FuncdefContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#func_args}.
	 * @param ctx the parse tree
	 */
	void enterFunc_args(PythonParser.Func_argsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#func_args}.
	 * @param ctx the parse tree
	 */
	void exitFunc_args(PythonParser.Func_argsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(PythonParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(PythonParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(PythonParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(PythonParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#call_args}.
	 * @param ctx the parse tree
	 */
	void enterCall_args(PythonParser.Call_argsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#call_args}.
	 * @param ctx the parse tree
	 */
	void exitCall_args(PythonParser.Call_argsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#call_arg}.
	 * @param ctx the parse tree
	 */
	void enterCall_arg(PythonParser.Call_argContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#call_arg}.
	 * @param ctx the parse tree
	 */
	void exitCall_arg(PythonParser.Call_argContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#keyword_arg}.
	 * @param ctx the parse tree
	 */
	void enterKeyword_arg(PythonParser.Keyword_argContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#keyword_arg}.
	 * @param ctx the parse tree
	 */
	void exitKeyword_arg(PythonParser.Keyword_argContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#dict_entries}.
	 * @param ctx the parse tree
	 */
	void enterDict_entries(PythonParser.Dict_entriesContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#dict_entries}.
	 * @param ctx the parse tree
	 */
	void exitDict_entries(PythonParser.Dict_entriesContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#dict_entry}.
	 * @param ctx the parse tree
	 */
	void enterDict_entry(PythonParser.Dict_entryContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#dict_entry}.
	 * @param ctx the parse tree
	 */
	void exitDict_entry(PythonParser.Dict_entryContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#list_elems}.
	 * @param ctx the parse tree
	 */
	void enterList_elems(PythonParser.List_elemsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#list_elems}.
	 * @param ctx the parse tree
	 */
	void exitList_elems(PythonParser.List_elemsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(PythonParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(PythonParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link PythonParser#binop}.
	 * @param ctx the parse tree
	 */
	void enterBinop(PythonParser.BinopContext ctx);
	/**
	 * Exit a parse tree produced by {@link PythonParser#binop}.
	 * @param ctx the parse tree
	 */
	void exitBinop(PythonParser.BinopContext ctx);
}