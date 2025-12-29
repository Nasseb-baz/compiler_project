// Generated from C:/Users/laith/IdeaProjects/JinjaCompProject/src/Compiler/antlr/TemplateParser.g4 by ANTLR 4.13.2
package Compiler.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class TemplateParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		HTML_TAG_OPEN=1, HTML_TEXT=2, JINJA_EXPR_OPEN=3, JINJA_STMT_OPEN=4, JINJA_COMMENT_OPEN=5, 
		HTML_COMMENT=6, JINJA_EXPR_CLOSE=7, IDENTIFIER=8, DOT=9, LBRACKET=10, 
		RBRACKET=11, LPAREN=12, RPAREN=13, COMMA=14, COLON=15, PIPE=16, PLUS=17, 
		MINUS=18, MULT=19, DIV=20, MOD=21, EQ=22, NEQ=23, LT=24, GT=25, LTE=26, 
		GTE=27, AND=28, OR=29, NOT=30, NUMBER=31, STRING=32, WS=33, OTHER=34, 
		JINJA_STMT_CLOSE=35, ENDFOR=36, ENDIF=37, FOR=38, IN=39, IF=40, ELSE=41, 
		ELIF=42, END=43, SET=44, BLOCK=45, EXTENDS=46, INCLUDE=47, MACRO=48, IDENTIFIER_STMT=49, 
		DOT_STMT=50, COMMA_STMT=51, COLON_STMT=52, LPAREN_STMT=53, RPAREN_STMT=54, 
		NUMBER_STMT=55, STRING_STMT=56, WS_STMT=57, OTHER_STMT=58, JINJA_COMMENT_CLOSE=59, 
		COMMENT_CONTENT=60, TAG_CLOSE=61, TAG_SLASH_CLOSE=62, TAG_SLASH=63, TAG_NAME=64, 
		TAG_WHITESPACE=65, ATTR_NAME=66, EQUALS=67, DOUBLE_QUOTE_STRING=68, SINGLE_QUOTE_STRING=69, 
		UNQUOTED_VALUE=70, ATTR_JINJA_EXPR_OPEN=71, ATTR_JINJA_STMT_OPEN=72;
	public static final int
		RULE_document = 0, RULE_htmlContent = 1, RULE_htmlElement = 2, RULE_attribute = 3, 
		RULE_attributeValue = 4, RULE_jinjaElement = 5, RULE_jinjaExpression = 6, 
		RULE_exprContent = 7, RULE_operator = 8, RULE_jinjaForStatement = 9, RULE_forOpen = 10, 
		RULE_forBody = 11, RULE_forClose = 12, RULE_jinjaStatement = 13, RULE_stmtContent = 14, 
		RULE_expr = 15, RULE_jinjaComment = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"document", "htmlContent", "htmlElement", "attribute", "attributeValue", 
			"jinjaElement", "jinjaExpression", "exprContent", "operator", "jinjaForStatement", 
			"forOpen", "forBody", "forClose", "jinjaStatement", "stmtContent", "expr", 
			"jinjaComment"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'{#'", null, "'}}'", null, null, "'['", 
			"']'", null, null, null, null, "'|'", "'+'", "'-'", "'*'", null, "'%'", 
			"'=='", "'!='", null, null, "'<='", "'>='", "'and'", "'or'", "'not'", 
			null, null, null, null, "'%}'", "'endfor'", "'endif'", "'for'", "'in'", 
			"'if'", "'else'", "'elif'", "'end'", "'set'", "'block'", "'extends'", 
			"'include'", "'macro'", null, null, null, null, null, null, null, null, 
			null, null, "'#}'", null, null, "'/>'", null, null, null, null, "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "HTML_TAG_OPEN", "HTML_TEXT", "JINJA_EXPR_OPEN", "JINJA_STMT_OPEN", 
			"JINJA_COMMENT_OPEN", "HTML_COMMENT", "JINJA_EXPR_CLOSE", "IDENTIFIER", 
			"DOT", "LBRACKET", "RBRACKET", "LPAREN", "RPAREN", "COMMA", "COLON", 
			"PIPE", "PLUS", "MINUS", "MULT", "DIV", "MOD", "EQ", "NEQ", "LT", "GT", 
			"LTE", "GTE", "AND", "OR", "NOT", "NUMBER", "STRING", "WS", "OTHER", 
			"JINJA_STMT_CLOSE", "ENDFOR", "ENDIF", "FOR", "IN", "IF", "ELSE", "ELIF", 
			"END", "SET", "BLOCK", "EXTENDS", "INCLUDE", "MACRO", "IDENTIFIER_STMT", 
			"DOT_STMT", "COMMA_STMT", "COLON_STMT", "LPAREN_STMT", "RPAREN_STMT", 
			"NUMBER_STMT", "STRING_STMT", "WS_STMT", "OTHER_STMT", "JINJA_COMMENT_CLOSE", 
			"COMMENT_CONTENT", "TAG_CLOSE", "TAG_SLASH_CLOSE", "TAG_SLASH", "TAG_NAME", 
			"TAG_WHITESPACE", "ATTR_NAME", "EQUALS", "DOUBLE_QUOTE_STRING", "SINGLE_QUOTE_STRING", 
			"UNQUOTED_VALUE", "ATTR_JINJA_EXPR_OPEN", "ATTR_JINJA_STMT_OPEN"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "TemplateParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TemplateParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DocumentContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(TemplateParser.EOF, 0); }
		public List<HtmlContentContext> htmlContent() {
			return getRuleContexts(HtmlContentContext.class);
		}
		public HtmlContentContext htmlContent(int i) {
			return getRuleContext(HtmlContentContext.class,i);
		}
		public DocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_document; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitDocument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitDocument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DocumentContext document() throws RecognitionException {
		DocumentContext _localctx = new DocumentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_document);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 62L) != 0)) {
				{
				{
				setState(34);
				htmlContent();
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(40);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlContentContext extends ParserRuleContext {
		public HtmlElementContext htmlElement() {
			return getRuleContext(HtmlElementContext.class,0);
		}
		public JinjaElementContext jinjaElement() {
			return getRuleContext(JinjaElementContext.class,0);
		}
		public TerminalNode HTML_TEXT() { return getToken(TemplateParser.HTML_TEXT, 0); }
		public HtmlContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterHtmlContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitHtmlContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitHtmlContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlContentContext htmlContent() throws RecognitionException {
		HtmlContentContext _localctx = new HtmlContentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_htmlContent);
		try {
			setState(45);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HTML_TAG_OPEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				htmlElement();
				}
				break;
			case JINJA_EXPR_OPEN:
			case JINJA_STMT_OPEN:
			case JINJA_COMMENT_OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				jinjaElement();
				}
				break;
			case HTML_TEXT:
				enterOuterAlt(_localctx, 3);
				{
				setState(44);
				match(HTML_TEXT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlElementContext extends ParserRuleContext {
		public List<TerminalNode> HTML_TAG_OPEN() { return getTokens(TemplateParser.HTML_TAG_OPEN); }
		public TerminalNode HTML_TAG_OPEN(int i) {
			return getToken(TemplateParser.HTML_TAG_OPEN, i);
		}
		public List<TerminalNode> TAG_NAME() { return getTokens(TemplateParser.TAG_NAME); }
		public TerminalNode TAG_NAME(int i) {
			return getToken(TemplateParser.TAG_NAME, i);
		}
		public List<TerminalNode> TAG_CLOSE() { return getTokens(TemplateParser.TAG_CLOSE); }
		public TerminalNode TAG_CLOSE(int i) {
			return getToken(TemplateParser.TAG_CLOSE, i);
		}
		public TerminalNode TAG_SLASH() { return getToken(TemplateParser.TAG_SLASH, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public List<HtmlContentContext> htmlContent() {
			return getRuleContexts(HtmlContentContext.class);
		}
		public HtmlContentContext htmlContent(int i) {
			return getRuleContext(HtmlContentContext.class,i);
		}
		public TerminalNode TAG_SLASH_CLOSE() { return getToken(TemplateParser.TAG_SLASH_CLOSE, 0); }
		public HtmlElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterHtmlElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitHtmlElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitHtmlElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlElementContext htmlElement() throws RecognitionException {
		HtmlElementContext _localctx = new HtmlElementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_htmlElement);
		int _la;
		try {
			int _alt;
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				match(HTML_TAG_OPEN);
				setState(48);
				match(TAG_NAME);
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ATTR_NAME) {
					{
					{
					setState(49);
					attribute();
					}
					}
					setState(54);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(55);
				match(TAG_CLOSE);
				setState(59);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(56);
						htmlContent();
						}
						} 
					}
					setState(61);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				}
				setState(62);
				match(HTML_TAG_OPEN);
				setState(63);
				match(TAG_SLASH);
				setState(64);
				match(TAG_NAME);
				setState(65);
				match(TAG_CLOSE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				match(HTML_TAG_OPEN);
				setState(67);
				match(TAG_NAME);
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ATTR_NAME) {
					{
					{
					setState(68);
					attribute();
					}
					}
					setState(73);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(74);
				match(TAG_SLASH_CLOSE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttributeContext extends ParserRuleContext {
		public TerminalNode ATTR_NAME() { return getToken(TemplateParser.ATTR_NAME, 0); }
		public TerminalNode EQUALS() { return getToken(TemplateParser.EQUALS, 0); }
		public AttributeValueContext attributeValue() {
			return getRuleContext(AttributeValueContext.class,0);
		}
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitAttribute(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitAttribute(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_attribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(ATTR_NAME);
			setState(80);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUALS) {
				{
				setState(78);
				match(EQUALS);
				setState(79);
				attributeValue();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttributeValueContext extends ParserRuleContext {
		public TerminalNode DOUBLE_QUOTE_STRING() { return getToken(TemplateParser.DOUBLE_QUOTE_STRING, 0); }
		public TerminalNode SINGLE_QUOTE_STRING() { return getToken(TemplateParser.SINGLE_QUOTE_STRING, 0); }
		public TerminalNode UNQUOTED_VALUE() { return getToken(TemplateParser.UNQUOTED_VALUE, 0); }
		public JinjaElementContext jinjaElement() {
			return getRuleContext(JinjaElementContext.class,0);
		}
		public AttributeValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterAttributeValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitAttributeValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitAttributeValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttributeValueContext attributeValue() throws RecognitionException {
		AttributeValueContext _localctx = new AttributeValueContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_attributeValue);
		try {
			setState(86);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOUBLE_QUOTE_STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				match(DOUBLE_QUOTE_STRING);
				}
				break;
			case SINGLE_QUOTE_STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				match(SINGLE_QUOTE_STRING);
				}
				break;
			case UNQUOTED_VALUE:
				enterOuterAlt(_localctx, 3);
				{
				setState(84);
				match(UNQUOTED_VALUE);
				}
				break;
			case JINJA_EXPR_OPEN:
			case JINJA_STMT_OPEN:
			case JINJA_COMMENT_OPEN:
				enterOuterAlt(_localctx, 4);
				{
				setState(85);
				jinjaElement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaElementContext extends ParserRuleContext {
		public JinjaExpressionContext jinjaExpression() {
			return getRuleContext(JinjaExpressionContext.class,0);
		}
		public JinjaForStatementContext jinjaForStatement() {
			return getRuleContext(JinjaForStatementContext.class,0);
		}
		public JinjaStatementContext jinjaStatement() {
			return getRuleContext(JinjaStatementContext.class,0);
		}
		public JinjaCommentContext jinjaComment() {
			return getRuleContext(JinjaCommentContext.class,0);
		}
		public JinjaElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterJinjaElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitJinjaElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitJinjaElement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaElementContext jinjaElement() throws RecognitionException {
		JinjaElementContext _localctx = new JinjaElementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_jinjaElement);
		try {
			setState(92);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				jinjaExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				jinjaForStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(90);
				jinjaStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(91);
				jinjaComment();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaExpressionContext extends ParserRuleContext {
		public TerminalNode JINJA_EXPR_OPEN() { return getToken(TemplateParser.JINJA_EXPR_OPEN, 0); }
		public TerminalNode JINJA_EXPR_CLOSE() { return getToken(TemplateParser.JINJA_EXPR_CLOSE, 0); }
		public List<ExprContentContext> exprContent() {
			return getRuleContexts(ExprContentContext.class);
		}
		public ExprContentContext exprContent(int i) {
			return getRuleContext(ExprContentContext.class,i);
		}
		public JinjaExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterJinjaExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitJinjaExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitJinjaExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaExpressionContext jinjaExpression() throws RecognitionException {
		JinjaExpressionContext _localctx = new JinjaExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_jinjaExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(JINJA_EXPR_OPEN);
			setState(98);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34359738112L) != 0)) {
				{
				{
				setState(95);
				exprContent();
				}
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(101);
			match(JINJA_EXPR_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContentContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(TemplateParser.IDENTIFIER, 0); }
		public TerminalNode DOT() { return getToken(TemplateParser.DOT, 0); }
		public TerminalNode NUMBER() { return getToken(TemplateParser.NUMBER, 0); }
		public TerminalNode STRING() { return getToken(TemplateParser.STRING, 0); }
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(TemplateParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(TemplateParser.RPAREN, 0); }
		public TerminalNode LBRACKET() { return getToken(TemplateParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(TemplateParser.RBRACKET, 0); }
		public TerminalNode COMMA() { return getToken(TemplateParser.COMMA, 0); }
		public TerminalNode COLON() { return getToken(TemplateParser.COLON, 0); }
		public TerminalNode PIPE() { return getToken(TemplateParser.PIPE, 0); }
		public TerminalNode WS() { return getToken(TemplateParser.WS, 0); }
		public TerminalNode OTHER() { return getToken(TemplateParser.OTHER, 0); }
		public ExprContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterExprContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitExprContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitExprContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContentContext exprContent() throws RecognitionException {
		ExprContentContext _localctx = new ExprContentContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_exprContent);
		try {
			setState(117);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				match(IDENTIFIER);
				}
				break;
			case DOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				match(DOT);
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 3);
				{
				setState(105);
				match(NUMBER);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(106);
				match(STRING);
				}
				break;
			case PLUS:
			case MINUS:
			case MULT:
			case DIV:
			case MOD:
			case EQ:
			case NEQ:
			case LT:
			case GT:
			case LTE:
			case GTE:
			case AND:
			case OR:
			case NOT:
				enterOuterAlt(_localctx, 5);
				{
				setState(107);
				operator();
				}
				break;
			case LPAREN:
				enterOuterAlt(_localctx, 6);
				{
				setState(108);
				match(LPAREN);
				}
				break;
			case RPAREN:
				enterOuterAlt(_localctx, 7);
				{
				setState(109);
				match(RPAREN);
				}
				break;
			case LBRACKET:
				enterOuterAlt(_localctx, 8);
				{
				setState(110);
				match(LBRACKET);
				}
				break;
			case RBRACKET:
				enterOuterAlt(_localctx, 9);
				{
				setState(111);
				match(RBRACKET);
				}
				break;
			case COMMA:
				enterOuterAlt(_localctx, 10);
				{
				setState(112);
				match(COMMA);
				}
				break;
			case COLON:
				enterOuterAlt(_localctx, 11);
				{
				setState(113);
				match(COLON);
				}
				break;
			case PIPE:
				enterOuterAlt(_localctx, 12);
				{
				setState(114);
				match(PIPE);
				}
				break;
			case WS:
				enterOuterAlt(_localctx, 13);
				{
				setState(115);
				match(WS);
				}
				break;
			case OTHER:
				enterOuterAlt(_localctx, 14);
				{
				setState(116);
				match(OTHER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OperatorContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(TemplateParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(TemplateParser.MINUS, 0); }
		public TerminalNode MULT() { return getToken(TemplateParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(TemplateParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(TemplateParser.MOD, 0); }
		public TerminalNode EQ() { return getToken(TemplateParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(TemplateParser.NEQ, 0); }
		public TerminalNode LT() { return getToken(TemplateParser.LT, 0); }
		public TerminalNode GT() { return getToken(TemplateParser.GT, 0); }
		public TerminalNode LTE() { return getToken(TemplateParser.LTE, 0); }
		public TerminalNode GTE() { return getToken(TemplateParser.GTE, 0); }
		public TerminalNode AND() { return getToken(TemplateParser.AND, 0); }
		public TerminalNode OR() { return getToken(TemplateParser.OR, 0); }
		public TerminalNode NOT() { return getToken(TemplateParser.NOT, 0); }
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitOperator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2147352576L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaForStatementContext extends ParserRuleContext {
		public ForOpenContext forOpen() {
			return getRuleContext(ForOpenContext.class,0);
		}
		public ForBodyContext forBody() {
			return getRuleContext(ForBodyContext.class,0);
		}
		public ForCloseContext forClose() {
			return getRuleContext(ForCloseContext.class,0);
		}
		public JinjaForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaForStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterJinjaForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitJinjaForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitJinjaForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaForStatementContext jinjaForStatement() throws RecognitionException {
		JinjaForStatementContext _localctx = new JinjaForStatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_jinjaForStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			forOpen();
			setState(122);
			forBody();
			setState(123);
			forClose();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForOpenContext extends ParserRuleContext {
		public TerminalNode JINJA_STMT_OPEN() { return getToken(TemplateParser.JINJA_STMT_OPEN, 0); }
		public TerminalNode FOR() { return getToken(TemplateParser.FOR, 0); }
		public TerminalNode IDENTIFIER_STMT() { return getToken(TemplateParser.IDENTIFIER_STMT, 0); }
		public TerminalNode IN() { return getToken(TemplateParser.IN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode JINJA_STMT_CLOSE() { return getToken(TemplateParser.JINJA_STMT_CLOSE, 0); }
		public ForOpenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forOpen; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterForOpen(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitForOpen(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitForOpen(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForOpenContext forOpen() throws RecognitionException {
		ForOpenContext _localctx = new ForOpenContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_forOpen);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(JINJA_STMT_OPEN);
			setState(126);
			match(FOR);
			setState(127);
			match(IDENTIFIER_STMT);
			setState(128);
			match(IN);
			setState(129);
			expr();
			setState(130);
			match(JINJA_STMT_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForBodyContext extends ParserRuleContext {
		public List<HtmlContentContext> htmlContent() {
			return getRuleContexts(HtmlContentContext.class);
		}
		public HtmlContentContext htmlContent(int i) {
			return getRuleContext(HtmlContentContext.class,i);
		}
		public ForBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterForBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitForBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitForBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForBodyContext forBody() throws RecognitionException {
		ForBodyContext _localctx = new ForBodyContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_forBody);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(132);
					htmlContent();
					}
					} 
				}
				setState(137);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForCloseContext extends ParserRuleContext {
		public TerminalNode JINJA_STMT_OPEN() { return getToken(TemplateParser.JINJA_STMT_OPEN, 0); }
		public TerminalNode ENDFOR() { return getToken(TemplateParser.ENDFOR, 0); }
		public TerminalNode JINJA_STMT_CLOSE() { return getToken(TemplateParser.JINJA_STMT_CLOSE, 0); }
		public ForCloseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forClose; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterForClose(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitForClose(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitForClose(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForCloseContext forClose() throws RecognitionException {
		ForCloseContext _localctx = new ForCloseContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_forClose);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(138);
			match(JINJA_STMT_OPEN);
			setState(139);
			match(ENDFOR);
			setState(140);
			match(JINJA_STMT_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaStatementContext extends ParserRuleContext {
		public TerminalNode JINJA_STMT_OPEN() { return getToken(TemplateParser.JINJA_STMT_OPEN, 0); }
		public TerminalNode JINJA_STMT_CLOSE() { return getToken(TemplateParser.JINJA_STMT_CLOSE, 0); }
		public List<StmtContentContext> stmtContent() {
			return getRuleContexts(StmtContentContext.class);
		}
		public StmtContentContext stmtContent(int i) {
			return getRuleContext(StmtContentContext.class,i);
		}
		public JinjaStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterJinjaStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitJinjaStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitJinjaStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaStatementContext jinjaStatement() throws RecognitionException {
		JinjaStatementContext _localctx = new JinjaStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_jinjaStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(JINJA_STMT_OPEN);
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 576460683583946752L) != 0)) {
				{
				{
				setState(143);
				stmtContent();
				}
				}
				setState(148);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(149);
			match(JINJA_STMT_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StmtContentContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(TemplateParser.FOR, 0); }
		public TerminalNode IN() { return getToken(TemplateParser.IN, 0); }
		public TerminalNode IF() { return getToken(TemplateParser.IF, 0); }
		public TerminalNode ELSE() { return getToken(TemplateParser.ELSE, 0); }
		public TerminalNode ELIF() { return getToken(TemplateParser.ELIF, 0); }
		public TerminalNode END() { return getToken(TemplateParser.END, 0); }
		public TerminalNode ENDFOR() { return getToken(TemplateParser.ENDFOR, 0); }
		public TerminalNode ENDIF() { return getToken(TemplateParser.ENDIF, 0); }
		public TerminalNode SET() { return getToken(TemplateParser.SET, 0); }
		public TerminalNode BLOCK() { return getToken(TemplateParser.BLOCK, 0); }
		public TerminalNode EXTENDS() { return getToken(TemplateParser.EXTENDS, 0); }
		public TerminalNode INCLUDE() { return getToken(TemplateParser.INCLUDE, 0); }
		public TerminalNode MACRO() { return getToken(TemplateParser.MACRO, 0); }
		public TerminalNode IDENTIFIER_STMT() { return getToken(TemplateParser.IDENTIFIER_STMT, 0); }
		public TerminalNode DOT_STMT() { return getToken(TemplateParser.DOT_STMT, 0); }
		public TerminalNode COMMA_STMT() { return getToken(TemplateParser.COMMA_STMT, 0); }
		public TerminalNode COLON_STMT() { return getToken(TemplateParser.COLON_STMT, 0); }
		public TerminalNode LPAREN_STMT() { return getToken(TemplateParser.LPAREN_STMT, 0); }
		public TerminalNode RPAREN_STMT() { return getToken(TemplateParser.RPAREN_STMT, 0); }
		public TerminalNode NUMBER_STMT() { return getToken(TemplateParser.NUMBER_STMT, 0); }
		public TerminalNode STRING_STMT() { return getToken(TemplateParser.STRING_STMT, 0); }
		public TerminalNode WS_STMT() { return getToken(TemplateParser.WS_STMT, 0); }
		public TerminalNode OTHER_STMT() { return getToken(TemplateParser.OTHER_STMT, 0); }
		public StmtContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmtContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterStmtContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitStmtContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitStmtContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContentContext stmtContent() throws RecognitionException {
		StmtContentContext _localctx = new StmtContentContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_stmtContent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 576460683583946752L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER_STMT() { return getTokens(TemplateParser.IDENTIFIER_STMT); }
		public TerminalNode IDENTIFIER_STMT(int i) {
			return getToken(TemplateParser.IDENTIFIER_STMT, i);
		}
		public TerminalNode NUMBER_STMT() { return getToken(TemplateParser.NUMBER_STMT, 0); }
		public TerminalNode STRING_STMT() { return getToken(TemplateParser.STRING_STMT, 0); }
		public List<TerminalNode> DOT_STMT() { return getTokens(TemplateParser.DOT_STMT); }
		public TerminalNode DOT_STMT(int i) {
			return getToken(TemplateParser.DOT_STMT, i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 108649341010313216L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT_STMT) {
				{
				{
				setState(154);
				match(DOT_STMT);
				setState(155);
				match(IDENTIFIER_STMT);
				}
				}
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaCommentContext extends ParserRuleContext {
		public TerminalNode JINJA_COMMENT_OPEN() { return getToken(TemplateParser.JINJA_COMMENT_OPEN, 0); }
		public TerminalNode JINJA_COMMENT_CLOSE() { return getToken(TemplateParser.JINJA_COMMENT_CLOSE, 0); }
		public List<TerminalNode> COMMENT_CONTENT() { return getTokens(TemplateParser.COMMENT_CONTENT); }
		public TerminalNode COMMENT_CONTENT(int i) {
			return getToken(TemplateParser.COMMENT_CONTENT, i);
		}
		public JinjaCommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaComment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).enterJinjaComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateParserListener ) ((TemplateParserListener)listener).exitJinjaComment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateParserVisitor ) return ((TemplateParserVisitor<? extends T>)visitor).visitJinjaComment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaCommentContext jinjaComment() throws RecognitionException {
		JinjaCommentContext _localctx = new JinjaCommentContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_jinjaComment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(JINJA_COMMENT_OPEN);
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMENT_CONTENT) {
				{
				{
				setState(162);
				match(COMMENT_CONTENT);
				}
				}
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(168);
			match(JINJA_COMMENT_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001H\u00ab\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0001\u0000\u0005\u0000$\b\u0000\n\u0000\f\u0000"+
		"\'\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001.\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"3\b\u0002\n\u0002\f\u00026\t\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		":\b\u0002\n\u0002\f\u0002=\t\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002F\b\u0002"+
		"\n\u0002\f\u0002I\t\u0002\u0001\u0002\u0003\u0002L\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003Q\b\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004W\b\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0003\u0005]\b\u0005\u0001\u0006\u0001\u0006"+
		"\u0005\u0006a\b\u0006\n\u0006\f\u0006d\t\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0003\u0007v\b\u0007\u0001\b\u0001\b\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0005\u000b\u0086\b\u000b\n\u000b\f\u000b\u0089"+
		"\t\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0005\r\u0091"+
		"\b\r\n\r\f\r\u0094\t\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0005\u000f\u009d\b\u000f\n\u000f\f\u000f\u00a0"+
		"\t\u000f\u0001\u0010\u0001\u0010\u0005\u0010\u00a4\b\u0010\n\u0010\f\u0010"+
		"\u00a7\t\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0000\u0000\u0011\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \u0000\u0003\u0001\u0000\u0011\u001e\u0001\u0000$:\u0002\u0000"+
		"1178\u00b9\u0000%\u0001\u0000\u0000\u0000\u0002-\u0001\u0000\u0000\u0000"+
		"\u0004K\u0001\u0000\u0000\u0000\u0006M\u0001\u0000\u0000\u0000\bV\u0001"+
		"\u0000\u0000\u0000\n\\\u0001\u0000\u0000\u0000\f^\u0001\u0000\u0000\u0000"+
		"\u000eu\u0001\u0000\u0000\u0000\u0010w\u0001\u0000\u0000\u0000\u0012y"+
		"\u0001\u0000\u0000\u0000\u0014}\u0001\u0000\u0000\u0000\u0016\u0087\u0001"+
		"\u0000\u0000\u0000\u0018\u008a\u0001\u0000\u0000\u0000\u001a\u008e\u0001"+
		"\u0000\u0000\u0000\u001c\u0097\u0001\u0000\u0000\u0000\u001e\u0099\u0001"+
		"\u0000\u0000\u0000 \u00a1\u0001\u0000\u0000\u0000\"$\u0003\u0002\u0001"+
		"\u0000#\"\u0001\u0000\u0000\u0000$\'\u0001\u0000\u0000\u0000%#\u0001\u0000"+
		"\u0000\u0000%&\u0001\u0000\u0000\u0000&(\u0001\u0000\u0000\u0000\'%\u0001"+
		"\u0000\u0000\u0000()\u0005\u0000\u0000\u0001)\u0001\u0001\u0000\u0000"+
		"\u0000*.\u0003\u0004\u0002\u0000+.\u0003\n\u0005\u0000,.\u0005\u0002\u0000"+
		"\u0000-*\u0001\u0000\u0000\u0000-+\u0001\u0000\u0000\u0000-,\u0001\u0000"+
		"\u0000\u0000.\u0003\u0001\u0000\u0000\u0000/0\u0005\u0001\u0000\u0000"+
		"04\u0005@\u0000\u000013\u0003\u0006\u0003\u000021\u0001\u0000\u0000\u0000"+
		"36\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u000045\u0001\u0000\u0000"+
		"\u000057\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u00007;\u0005=\u0000"+
		"\u00008:\u0003\u0002\u0001\u000098\u0001\u0000\u0000\u0000:=\u0001\u0000"+
		"\u0000\u0000;9\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<>\u0001"+
		"\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000>?\u0005\u0001\u0000\u0000"+
		"?@\u0005?\u0000\u0000@A\u0005@\u0000\u0000AL\u0005=\u0000\u0000BC\u0005"+
		"\u0001\u0000\u0000CG\u0005@\u0000\u0000DF\u0003\u0006\u0003\u0000ED\u0001"+
		"\u0000\u0000\u0000FI\u0001\u0000\u0000\u0000GE\u0001\u0000\u0000\u0000"+
		"GH\u0001\u0000\u0000\u0000HJ\u0001\u0000\u0000\u0000IG\u0001\u0000\u0000"+
		"\u0000JL\u0005>\u0000\u0000K/\u0001\u0000\u0000\u0000KB\u0001\u0000\u0000"+
		"\u0000L\u0005\u0001\u0000\u0000\u0000MP\u0005B\u0000\u0000NO\u0005C\u0000"+
		"\u0000OQ\u0003\b\u0004\u0000PN\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000"+
		"\u0000Q\u0007\u0001\u0000\u0000\u0000RW\u0005D\u0000\u0000SW\u0005E\u0000"+
		"\u0000TW\u0005F\u0000\u0000UW\u0003\n\u0005\u0000VR\u0001\u0000\u0000"+
		"\u0000VS\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000VU\u0001\u0000"+
		"\u0000\u0000W\t\u0001\u0000\u0000\u0000X]\u0003\f\u0006\u0000Y]\u0003"+
		"\u0012\t\u0000Z]\u0003\u001a\r\u0000[]\u0003 \u0010\u0000\\X\u0001\u0000"+
		"\u0000\u0000\\Y\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000\\["+
		"\u0001\u0000\u0000\u0000]\u000b\u0001\u0000\u0000\u0000^b\u0005\u0003"+
		"\u0000\u0000_a\u0003\u000e\u0007\u0000`_\u0001\u0000\u0000\u0000ad\u0001"+
		"\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000"+
		"ce\u0001\u0000\u0000\u0000db\u0001\u0000\u0000\u0000ef\u0005\u0007\u0000"+
		"\u0000f\r\u0001\u0000\u0000\u0000gv\u0005\b\u0000\u0000hv\u0005\t\u0000"+
		"\u0000iv\u0005\u001f\u0000\u0000jv\u0005 \u0000\u0000kv\u0003\u0010\b"+
		"\u0000lv\u0005\f\u0000\u0000mv\u0005\r\u0000\u0000nv\u0005\n\u0000\u0000"+
		"ov\u0005\u000b\u0000\u0000pv\u0005\u000e\u0000\u0000qv\u0005\u000f\u0000"+
		"\u0000rv\u0005\u0010\u0000\u0000sv\u0005!\u0000\u0000tv\u0005\"\u0000"+
		"\u0000ug\u0001\u0000\u0000\u0000uh\u0001\u0000\u0000\u0000ui\u0001\u0000"+
		"\u0000\u0000uj\u0001\u0000\u0000\u0000uk\u0001\u0000\u0000\u0000ul\u0001"+
		"\u0000\u0000\u0000um\u0001\u0000\u0000\u0000un\u0001\u0000\u0000\u0000"+
		"uo\u0001\u0000\u0000\u0000up\u0001\u0000\u0000\u0000uq\u0001\u0000\u0000"+
		"\u0000ur\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000ut\u0001\u0000"+
		"\u0000\u0000v\u000f\u0001\u0000\u0000\u0000wx\u0007\u0000\u0000\u0000"+
		"x\u0011\u0001\u0000\u0000\u0000yz\u0003\u0014\n\u0000z{\u0003\u0016\u000b"+
		"\u0000{|\u0003\u0018\f\u0000|\u0013\u0001\u0000\u0000\u0000}~\u0005\u0004"+
		"\u0000\u0000~\u007f\u0005&\u0000\u0000\u007f\u0080\u00051\u0000\u0000"+
		"\u0080\u0081\u0005\'\u0000\u0000\u0081\u0082\u0003\u001e\u000f\u0000\u0082"+
		"\u0083\u0005#\u0000\u0000\u0083\u0015\u0001\u0000\u0000\u0000\u0084\u0086"+
		"\u0003\u0002\u0001\u0000\u0085\u0084\u0001\u0000\u0000\u0000\u0086\u0089"+
		"\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0087\u0088"+
		"\u0001\u0000\u0000\u0000\u0088\u0017\u0001\u0000\u0000\u0000\u0089\u0087"+
		"\u0001\u0000\u0000\u0000\u008a\u008b\u0005\u0004\u0000\u0000\u008b\u008c"+
		"\u0005$\u0000\u0000\u008c\u008d\u0005#\u0000\u0000\u008d\u0019\u0001\u0000"+
		"\u0000\u0000\u008e\u0092\u0005\u0004\u0000\u0000\u008f\u0091\u0003\u001c"+
		"\u000e\u0000\u0090\u008f\u0001\u0000\u0000\u0000\u0091\u0094\u0001\u0000"+
		"\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000"+
		"\u0000\u0000\u0093\u0095\u0001\u0000\u0000\u0000\u0094\u0092\u0001\u0000"+
		"\u0000\u0000\u0095\u0096\u0005#\u0000\u0000\u0096\u001b\u0001\u0000\u0000"+
		"\u0000\u0097\u0098\u0007\u0001\u0000\u0000\u0098\u001d\u0001\u0000\u0000"+
		"\u0000\u0099\u009e\u0007\u0002\u0000\u0000\u009a\u009b\u00052\u0000\u0000"+
		"\u009b\u009d\u00051\u0000\u0000\u009c\u009a\u0001\u0000\u0000\u0000\u009d"+
		"\u00a0\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000\u009e"+
		"\u009f\u0001\u0000\u0000\u0000\u009f\u001f\u0001\u0000\u0000\u0000\u00a0"+
		"\u009e\u0001\u0000\u0000\u0000\u00a1\u00a5\u0005\u0005\u0000\u0000\u00a2"+
		"\u00a4\u0005<\u0000\u0000\u00a3\u00a2\u0001\u0000\u0000\u0000\u00a4\u00a7"+
		"\u0001\u0000\u0000\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a6\u00a8\u0001\u0000\u0000\u0000\u00a7\u00a5"+
		"\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005;\u0000\u0000\u00a9!\u0001\u0000"+
		"\u0000\u0000\u000f%-4;GKPV\\bu\u0087\u0092\u009e\u00a5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}