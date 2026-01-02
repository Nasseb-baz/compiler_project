// Generated from C:/Users/laith/IdeaProjects/python_flask_compiler/src/Main/java/antlr/Jinja2Parser.g4 by ANTLR 4.13.2
package Main.java.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Jinja2Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Jinja2ParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#document}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocument(Jinja2Parser.DocumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(Jinja2Parser.ElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#html_text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtml_text(Jinja2Parser.Html_textContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(Jinja2Parser.CommentContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(Jinja2Parser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#filter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilter(Jinja2Parser.FilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#filter_arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilter_arguments(Jinja2Parser.Filter_argumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#filter_argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFilter_argument(Jinja2Parser.Filter_argumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(Jinja2Parser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#if_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_block(Jinja2Parser.If_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#elif_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElif_block(Jinja2Parser.Elif_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#else_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_block(Jinja2Parser.Else_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#for_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_block(Jinja2Parser.For_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#block_tag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock_tag(Jinja2Parser.Block_tagContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#extends_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtends_block(Jinja2Parser.Extends_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#include_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclude_block(Jinja2Parser.Include_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#set_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSet_block(Jinja2Parser.Set_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#with_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWith_block(Jinja2Parser.With_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#simple_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_block(Jinja2Parser.Simple_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(Jinja2Parser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(Jinja2Parser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#logical_or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical_or(Jinja2Parser.Logical_orContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#logical_and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical_and(Jinja2Parser.Logical_andContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#equality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality(Jinja2Parser.EqualityContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(Jinja2Parser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(Jinja2Parser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(Jinja2Parser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#unary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary(Jinja2Parser.UnaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(Jinja2Parser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#function_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_call(Jinja2Parser.Function_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#call_arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall_arguments(Jinja2Parser.Call_argumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#call_argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall_argument(Jinja2Parser.Call_argumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(Jinja2Parser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(Jinja2Parser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#string_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString_literal(Jinja2Parser.String_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(Jinja2Parser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#assignments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignments(Jinja2Parser.AssignmentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Jinja2Parser#inner_content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInner_content(Jinja2Parser.Inner_contentContext ctx);
}