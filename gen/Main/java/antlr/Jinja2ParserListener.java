// Generated from C:/Users/laith/IdeaProjects/python_flask_compiler/src/Main/java/antlr/Jinja2Parser.g4 by ANTLR 4.13.2
package Main.java.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Jinja2Parser}.
 */
public interface Jinja2ParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(Jinja2Parser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(Jinja2Parser.DocumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement(Jinja2Parser.ElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement(Jinja2Parser.ElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#html_text}.
	 * @param ctx the parse tree
	 */
	void enterHtml_text(Jinja2Parser.Html_textContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#html_text}.
	 * @param ctx the parse tree
	 */
	void exitHtml_text(Jinja2Parser.Html_textContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(Jinja2Parser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(Jinja2Parser.CommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(Jinja2Parser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(Jinja2Parser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#filter}.
	 * @param ctx the parse tree
	 */
	void enterFilter(Jinja2Parser.FilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#filter}.
	 * @param ctx the parse tree
	 */
	void exitFilter(Jinja2Parser.FilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#filter_arguments}.
	 * @param ctx the parse tree
	 */
	void enterFilter_arguments(Jinja2Parser.Filter_argumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#filter_arguments}.
	 * @param ctx the parse tree
	 */
	void exitFilter_arguments(Jinja2Parser.Filter_argumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#filter_argument}.
	 * @param ctx the parse tree
	 */
	void enterFilter_argument(Jinja2Parser.Filter_argumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#filter_argument}.
	 * @param ctx the parse tree
	 */
	void exitFilter_argument(Jinja2Parser.Filter_argumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(Jinja2Parser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(Jinja2Parser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#if_block}.
	 * @param ctx the parse tree
	 */
	void enterIf_block(Jinja2Parser.If_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#if_block}.
	 * @param ctx the parse tree
	 */
	void exitIf_block(Jinja2Parser.If_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#elif_block}.
	 * @param ctx the parse tree
	 */
	void enterElif_block(Jinja2Parser.Elif_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#elif_block}.
	 * @param ctx the parse tree
	 */
	void exitElif_block(Jinja2Parser.Elif_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#else_block}.
	 * @param ctx the parse tree
	 */
	void enterElse_block(Jinja2Parser.Else_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#else_block}.
	 * @param ctx the parse tree
	 */
	void exitElse_block(Jinja2Parser.Else_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#for_block}.
	 * @param ctx the parse tree
	 */
	void enterFor_block(Jinja2Parser.For_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#for_block}.
	 * @param ctx the parse tree
	 */
	void exitFor_block(Jinja2Parser.For_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#block_tag}.
	 * @param ctx the parse tree
	 */
	void enterBlock_tag(Jinja2Parser.Block_tagContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#block_tag}.
	 * @param ctx the parse tree
	 */
	void exitBlock_tag(Jinja2Parser.Block_tagContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#extends_block}.
	 * @param ctx the parse tree
	 */
	void enterExtends_block(Jinja2Parser.Extends_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#extends_block}.
	 * @param ctx the parse tree
	 */
	void exitExtends_block(Jinja2Parser.Extends_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#include_block}.
	 * @param ctx the parse tree
	 */
	void enterInclude_block(Jinja2Parser.Include_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#include_block}.
	 * @param ctx the parse tree
	 */
	void exitInclude_block(Jinja2Parser.Include_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#set_block}.
	 * @param ctx the parse tree
	 */
	void enterSet_block(Jinja2Parser.Set_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#set_block}.
	 * @param ctx the parse tree
	 */
	void exitSet_block(Jinja2Parser.Set_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#with_block}.
	 * @param ctx the parse tree
	 */
	void enterWith_block(Jinja2Parser.With_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#with_block}.
	 * @param ctx the parse tree
	 */
	void exitWith_block(Jinja2Parser.With_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#simple_block}.
	 * @param ctx the parse tree
	 */
	void enterSimple_block(Jinja2Parser.Simple_blockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#simple_block}.
	 * @param ctx the parse tree
	 */
	void exitSimple_block(Jinja2Parser.Simple_blockContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(Jinja2Parser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(Jinja2Parser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(Jinja2Parser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(Jinja2Parser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#logical_or}.
	 * @param ctx the parse tree
	 */
	void enterLogical_or(Jinja2Parser.Logical_orContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#logical_or}.
	 * @param ctx the parse tree
	 */
	void exitLogical_or(Jinja2Parser.Logical_orContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#logical_and}.
	 * @param ctx the parse tree
	 */
	void enterLogical_and(Jinja2Parser.Logical_andContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#logical_and}.
	 * @param ctx the parse tree
	 */
	void exitLogical_and(Jinja2Parser.Logical_andContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#equality}.
	 * @param ctx the parse tree
	 */
	void enterEquality(Jinja2Parser.EqualityContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#equality}.
	 * @param ctx the parse tree
	 */
	void exitEquality(Jinja2Parser.EqualityContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(Jinja2Parser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(Jinja2Parser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(Jinja2Parser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(Jinja2Parser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(Jinja2Parser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(Jinja2Parser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#unary}.
	 * @param ctx the parse tree
	 */
	void enterUnary(Jinja2Parser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#unary}.
	 * @param ctx the parse tree
	 */
	void exitUnary(Jinja2Parser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(Jinja2Parser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(Jinja2Parser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#function_call}.
	 * @param ctx the parse tree
	 */
	void enterFunction_call(Jinja2Parser.Function_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#function_call}.
	 * @param ctx the parse tree
	 */
	void exitFunction_call(Jinja2Parser.Function_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#call_arguments}.
	 * @param ctx the parse tree
	 */
	void enterCall_arguments(Jinja2Parser.Call_argumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#call_arguments}.
	 * @param ctx the parse tree
	 */
	void exitCall_arguments(Jinja2Parser.Call_argumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#call_argument}.
	 * @param ctx the parse tree
	 */
	void enterCall_argument(Jinja2Parser.Call_argumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#call_argument}.
	 * @param ctx the parse tree
	 */
	void exitCall_argument(Jinja2Parser.Call_argumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(Jinja2Parser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(Jinja2Parser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(Jinja2Parser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(Jinja2Parser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#string_literal}.
	 * @param ctx the parse tree
	 */
	void enterString_literal(Jinja2Parser.String_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#string_literal}.
	 * @param ctx the parse tree
	 */
	void exitString_literal(Jinja2Parser.String_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(Jinja2Parser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(Jinja2Parser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#assignments}.
	 * @param ctx the parse tree
	 */
	void enterAssignments(Jinja2Parser.AssignmentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#assignments}.
	 * @param ctx the parse tree
	 */
	void exitAssignments(Jinja2Parser.AssignmentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Jinja2Parser#inner_content}.
	 * @param ctx the parse tree
	 */
	void enterInner_content(Jinja2Parser.Inner_contentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Jinja2Parser#inner_content}.
	 * @param ctx the parse tree
	 */
	void exitInner_content(Jinja2Parser.Inner_contentContext ctx);
}