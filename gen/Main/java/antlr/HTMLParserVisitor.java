// Generated from C:/Users/laith/IdeaProjects/python_flask_compiler/src/Main/java/antlr/HTMLParser.g4 by ANTLR 4.13.2
package Main.java.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link HTMLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface HTMLParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link HTMLParser#document}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocument(HTMLParser.DocumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#doctype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoctype(HTMLParser.DoctypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(HTMLParser.ElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#normal_tag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormal_tag(HTMLParser.Normal_tagContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#self_closing_tag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelf_closing_tag(HTMLParser.Self_closing_tagContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#script_tag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScript_tag(HTMLParser.Script_tagContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#style_tag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStyle_tag(HTMLParser.Style_tagContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContent(HTMLParser.ContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#text}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText(HTMLParser.TextContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(HTMLParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link HTMLParser#comment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComment(HTMLParser.CommentContext ctx);
}