// Generated from C:/Users/laith/IdeaProjects/python_flask_compiler/src/Main/java/antlr/HTMLParser.g4 by ANTLR 4.13.2
package Main.java.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HTMLParser}.
 */
public interface HTMLParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HTMLParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(HTMLParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(HTMLParser.DocumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#doctype}.
	 * @param ctx the parse tree
	 */
	void enterDoctype(HTMLParser.DoctypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#doctype}.
	 * @param ctx the parse tree
	 */
	void exitDoctype(HTMLParser.DoctypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement(HTMLParser.ElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement(HTMLParser.ElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#normal_tag}.
	 * @param ctx the parse tree
	 */
	void enterNormal_tag(HTMLParser.Normal_tagContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#normal_tag}.
	 * @param ctx the parse tree
	 */
	void exitNormal_tag(HTMLParser.Normal_tagContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#self_closing_tag}.
	 * @param ctx the parse tree
	 */
	void enterSelf_closing_tag(HTMLParser.Self_closing_tagContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#self_closing_tag}.
	 * @param ctx the parse tree
	 */
	void exitSelf_closing_tag(HTMLParser.Self_closing_tagContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#script_tag}.
	 * @param ctx the parse tree
	 */
	void enterScript_tag(HTMLParser.Script_tagContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#script_tag}.
	 * @param ctx the parse tree
	 */
	void exitScript_tag(HTMLParser.Script_tagContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#style_tag}.
	 * @param ctx the parse tree
	 */
	void enterStyle_tag(HTMLParser.Style_tagContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#style_tag}.
	 * @param ctx the parse tree
	 */
	void exitStyle_tag(HTMLParser.Style_tagContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#content}.
	 * @param ctx the parse tree
	 */
	void enterContent(HTMLParser.ContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#content}.
	 * @param ctx the parse tree
	 */
	void exitContent(HTMLParser.ContentContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#text}.
	 * @param ctx the parse tree
	 */
	void enterText(HTMLParser.TextContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#text}.
	 * @param ctx the parse tree
	 */
	void exitText(HTMLParser.TextContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(HTMLParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(HTMLParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link HTMLParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(HTMLParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HTMLParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(HTMLParser.CommentContext ctx);
}