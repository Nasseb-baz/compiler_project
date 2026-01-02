// Generated from C:/Users/laith/IdeaProjects/python_flask_compiler/src/Main/java/antlr/CSSParser.g4 by ANTLR 4.13.2
package Main.java.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CSSParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CSSParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CSSParser#stylesheet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStylesheet(CSSParser.StylesheetContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSSParser#rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRule(CSSParser.RuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSSParser#selectors}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectors(CSSParser.SelectorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSSParser#selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelector(CSSParser.SelectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSSParser#simple_selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_selector(CSSParser.Simple_selectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSSParser#type_selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_selector(CSSParser.Type_selectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSSParser#universal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniversal(CSSParser.UniversalContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSSParser#hash}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHash(CSSParser.HashContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSSParser#class}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass(CSSParser.ClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSSParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(CSSParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSSParser#pseudo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPseudo(CSSParser.PseudoContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSSParser#combinator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCombinator(CSSParser.CombinatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSSParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(CSSParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSSParser#property}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty(CSSParser.PropertyContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSSParser#values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValues(CSSParser.ValuesContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSSParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(CSSParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSSParser#unit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnit(CSSParser.UnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSSParser#important}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportant(CSSParser.ImportantContext ctx);
	/**
	 * Visit a parse tree produced by {@link CSSParser#at_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAt_rule(CSSParser.At_ruleContext ctx);
}