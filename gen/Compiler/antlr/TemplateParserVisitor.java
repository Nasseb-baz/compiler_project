// Generated from C:/Users/laith/IdeaProjects/JinjaCompProject/src/Compiler/antlr/TemplateParser.g4 by ANTLR 4.13.2
package Compiler.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TemplateParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TemplateParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TemplateParser#document}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocument(TemplateParser.DocumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#htmlContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlContent(TemplateParser.HtmlContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#htmlElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlElement(TemplateParser.HtmlElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(TemplateParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#attributeValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributeValue(TemplateParser.AttributeValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#jinjaElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaElement(TemplateParser.JinjaElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#jinjaExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaExpression(TemplateParser.JinjaExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#exprContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprContent(TemplateParser.ExprContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(TemplateParser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#jinjaForStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaForStatement(TemplateParser.JinjaForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#forOpen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForOpen(TemplateParser.ForOpenContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#forBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForBody(TemplateParser.ForBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#forClose}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForClose(TemplateParser.ForCloseContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#jinjaStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaStatement(TemplateParser.JinjaStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#stmtContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmtContent(TemplateParser.StmtContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(TemplateParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateParser#jinjaComment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaComment(TemplateParser.JinjaCommentContext ctx);
}