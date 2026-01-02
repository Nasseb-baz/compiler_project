// Generated from C:/Users/laith/IdeaProjects/python_flask_compiler/src/Main/java/antlr/CSSParser.g4 by ANTLR 4.13.2
package Main.java.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CSSParser}.
 */
public interface CSSParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CSSParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void enterStylesheet(CSSParser.StylesheetContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSSParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void exitStylesheet(CSSParser.StylesheetContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSSParser#rule}.
	 * @param ctx the parse tree
	 */
	void enterRule(CSSParser.RuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSSParser#rule}.
	 * @param ctx the parse tree
	 */
	void exitRule(CSSParser.RuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSSParser#selectors}.
	 * @param ctx the parse tree
	 */
	void enterSelectors(CSSParser.SelectorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSSParser#selectors}.
	 * @param ctx the parse tree
	 */
	void exitSelectors(CSSParser.SelectorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSSParser#selector}.
	 * @param ctx the parse tree
	 */
	void enterSelector(CSSParser.SelectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSSParser#selector}.
	 * @param ctx the parse tree
	 */
	void exitSelector(CSSParser.SelectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSSParser#simple_selector}.
	 * @param ctx the parse tree
	 */
	void enterSimple_selector(CSSParser.Simple_selectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSSParser#simple_selector}.
	 * @param ctx the parse tree
	 */
	void exitSimple_selector(CSSParser.Simple_selectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSSParser#type_selector}.
	 * @param ctx the parse tree
	 */
	void enterType_selector(CSSParser.Type_selectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSSParser#type_selector}.
	 * @param ctx the parse tree
	 */
	void exitType_selector(CSSParser.Type_selectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSSParser#universal}.
	 * @param ctx the parse tree
	 */
	void enterUniversal(CSSParser.UniversalContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSSParser#universal}.
	 * @param ctx the parse tree
	 */
	void exitUniversal(CSSParser.UniversalContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSSParser#hash}.
	 * @param ctx the parse tree
	 */
	void enterHash(CSSParser.HashContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSSParser#hash}.
	 * @param ctx the parse tree
	 */
	void exitHash(CSSParser.HashContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSSParser#class}.
	 * @param ctx the parse tree
	 */
	void enterClass(CSSParser.ClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSSParser#class}.
	 * @param ctx the parse tree
	 */
	void exitClass(CSSParser.ClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSSParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(CSSParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSSParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(CSSParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSSParser#pseudo}.
	 * @param ctx the parse tree
	 */
	void enterPseudo(CSSParser.PseudoContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSSParser#pseudo}.
	 * @param ctx the parse tree
	 */
	void exitPseudo(CSSParser.PseudoContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSSParser#combinator}.
	 * @param ctx the parse tree
	 */
	void enterCombinator(CSSParser.CombinatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSSParser#combinator}.
	 * @param ctx the parse tree
	 */
	void exitCombinator(CSSParser.CombinatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSSParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(CSSParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSSParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(CSSParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSSParser#property}.
	 * @param ctx the parse tree
	 */
	void enterProperty(CSSParser.PropertyContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSSParser#property}.
	 * @param ctx the parse tree
	 */
	void exitProperty(CSSParser.PropertyContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSSParser#values}.
	 * @param ctx the parse tree
	 */
	void enterValues(CSSParser.ValuesContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSSParser#values}.
	 * @param ctx the parse tree
	 */
	void exitValues(CSSParser.ValuesContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSSParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(CSSParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSSParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(CSSParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSSParser#unit}.
	 * @param ctx the parse tree
	 */
	void enterUnit(CSSParser.UnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSSParser#unit}.
	 * @param ctx the parse tree
	 */
	void exitUnit(CSSParser.UnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSSParser#important}.
	 * @param ctx the parse tree
	 */
	void enterImportant(CSSParser.ImportantContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSSParser#important}.
	 * @param ctx the parse tree
	 */
	void exitImportant(CSSParser.ImportantContext ctx);
	/**
	 * Enter a parse tree produced by {@link CSSParser#at_rule}.
	 * @param ctx the parse tree
	 */
	void enterAt_rule(CSSParser.At_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link CSSParser#at_rule}.
	 * @param ctx the parse tree
	 */
	void exitAt_rule(CSSParser.At_ruleContext ctx);
}