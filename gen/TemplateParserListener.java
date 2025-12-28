// Generated from C:/compiler_project/src/Compiler/antlr/TemplateParser.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TemplateParser}.
 */
public interface TemplateParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TemplateParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(TemplateParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(TemplateParser.DocumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void enterHtmlContent(TemplateParser.HtmlContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void exitHtmlContent(TemplateParser.HtmlContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterHtmlElement(TemplateParser.HtmlElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitHtmlElement(TemplateParser.HtmlElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(TemplateParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(TemplateParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#attributeValue}.
	 * @param ctx the parse tree
	 */
	void enterAttributeValue(TemplateParser.AttributeValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#attributeValue}.
	 * @param ctx the parse tree
	 */
	void exitAttributeValue(TemplateParser.AttributeValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#jinjaElement}.
	 * @param ctx the parse tree
	 */
	void enterJinjaElement(TemplateParser.JinjaElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#jinjaElement}.
	 * @param ctx the parse tree
	 */
	void exitJinjaElement(TemplateParser.JinjaElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#jinjaExpression}.
	 * @param ctx the parse tree
	 */
	void enterJinjaExpression(TemplateParser.JinjaExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#jinjaExpression}.
	 * @param ctx the parse tree
	 */
	void exitJinjaExpression(TemplateParser.JinjaExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#exprContent}.
	 * @param ctx the parse tree
	 */
	void enterExprContent(TemplateParser.ExprContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#exprContent}.
	 * @param ctx the parse tree
	 */
	void exitExprContent(TemplateParser.ExprContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#operator}.
	 * @param ctx the parse tree
	 */
	void enterOperator(TemplateParser.OperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#operator}.
	 * @param ctx the parse tree
	 */
	void exitOperator(TemplateParser.OperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#jinjaForStatement}.
	 * @param ctx the parse tree
	 */
	void enterJinjaForStatement(TemplateParser.JinjaForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#jinjaForStatement}.
	 * @param ctx the parse tree
	 */
	void exitJinjaForStatement(TemplateParser.JinjaForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#jinjaStatement}.
	 * @param ctx the parse tree
	 */
	void enterJinjaStatement(TemplateParser.JinjaStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#jinjaStatement}.
	 * @param ctx the parse tree
	 */
	void exitJinjaStatement(TemplateParser.JinjaStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#stmtContent}.
	 * @param ctx the parse tree
	 */
	void enterStmtContent(TemplateParser.StmtContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#stmtContent}.
	 * @param ctx the parse tree
	 */
	void exitStmtContent(TemplateParser.StmtContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(TemplateParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(TemplateParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateParser#jinjaComment}.
	 * @param ctx the parse tree
	 */
	void enterJinjaComment(TemplateParser.JinjaCommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateParser#jinjaComment}.
	 * @param ctx the parse tree
	 */
	void exitJinjaComment(TemplateParser.JinjaCommentContext ctx);
}