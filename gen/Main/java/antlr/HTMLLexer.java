// Generated from C:/Users/laith/IdeaProjects/python_flask_compiler/src/Main/java/antlr/HTMLLexer.g4 by ANTLR 4.13.2
package Main.java.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class HTMLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TAG_OPEN=1, TAG_CLOSE=2, SLASH_CLOSE=3, TAG_END_OPEN=4, DOCTYPE_OPEN=5, 
		SCRIPT_OPEN=6, STYLE_OPEN=7, SCRIPT=8, STYLE=9, TAG_NAME=10, EQUALS=11, 
		STRING=12, ATTRIBUTE_NAME=13, TEXT=14, HTML_COMMENT=15, WS=16;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"TAG_OPEN", "TAG_CLOSE", "SLASH_CLOSE", "TAG_END_OPEN", "DOCTYPE_OPEN", 
			"SCRIPT_OPEN", "STYLE_OPEN", "SCRIPT", "STYLE", "TAG_NAME", "EQUALS", 
			"STRING", "ATTRIBUTE_NAME", "TEXT", "HTML_COMMENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'<'", "'>'", "'/>'", "'</'", null, null, null, "'script'", "'style'", 
			null, "'='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TAG_OPEN", "TAG_CLOSE", "SLASH_CLOSE", "TAG_END_OPEN", "DOCTYPE_OPEN", 
			"SCRIPT_OPEN", "STYLE_OPEN", "SCRIPT", "STYLE", "TAG_NAME", "EQUALS", 
			"STRING", "ATTRIBUTE_NAME", "TEXT", "HTML_COMMENT", "WS"
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


	public HTMLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "HTMLLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0010\u009a\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\t\u0001\t\u0005\tZ\b\t\n\t\f\t]\t\t\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000be\b\u000b\n\u000b\f\u000b"+
		"h\t\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0005\u000bo\b\u000b\n\u000b\f\u000br\t\u000b\u0001\u000b\u0003\u000b"+
		"u\b\u000b\u0001\f\u0001\f\u0005\fy\b\f\n\f\f\f|\t\f\u0001\r\u0004\r\u007f"+
		"\b\r\u000b\r\f\r\u0080\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0005\u000e\u0089\b\u000e\n\u000e\f\u000e\u008c"+
		"\t\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0004\u000f\u0095\b\u000f\u000b\u000f\f\u000f\u0096"+
		"\u0001\u000f\u0001\u000f\u0001\u008a\u0000\u0010\u0001\u0001\u0003\u0002"+
		"\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013"+
		"\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010\u0001"+
		"\u0000\t\u0003\u0000\t\n\r\r  \u0003\u0000AZ__az\u0005\u0000--09AZ__a"+
		"z\u0004\u0000\n\n\r\r\"\"\\\\\b\u0000\"\"//\\\\bbffnnrrtt\u0004\u0000"+
		"\n\n\r\r\'\'\\\\\b\u0000\'\'//\\\\bbffnnrrtt\u0005\u0000--0:AZ__az\u0001"+
		"\u0000<<\u00a3\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0001!\u0001\u0000\u0000\u0000\u0003#\u0001\u0000\u0000\u0000\u0005%"+
		"\u0001\u0000\u0000\u0000\u0007(\u0001\u0000\u0000\u0000\t+\u0001\u0000"+
		"\u0000\u0000\u000b7\u0001\u0000\u0000\u0000\rA\u0001\u0000\u0000\u0000"+
		"\u000fJ\u0001\u0000\u0000\u0000\u0011Q\u0001\u0000\u0000\u0000\u0013W"+
		"\u0001\u0000\u0000\u0000\u0015^\u0001\u0000\u0000\u0000\u0017t\u0001\u0000"+
		"\u0000\u0000\u0019v\u0001\u0000\u0000\u0000\u001b~\u0001\u0000\u0000\u0000"+
		"\u001d\u0082\u0001\u0000\u0000\u0000\u001f\u0094\u0001\u0000\u0000\u0000"+
		"!\"\u0005<\u0000\u0000\"\u0002\u0001\u0000\u0000\u0000#$\u0005>\u0000"+
		"\u0000$\u0004\u0001\u0000\u0000\u0000%&\u0005/\u0000\u0000&\'\u0005>\u0000"+
		"\u0000\'\u0006\u0001\u0000\u0000\u0000()\u0005<\u0000\u0000)*\u0005/\u0000"+
		"\u0000*\b\u0001\u0000\u0000\u0000+,\u0005<\u0000\u0000,-\u0005!\u0000"+
		"\u0000-.\u0005D\u0000\u0000./\u0005O\u0000\u0000/0\u0005C\u0000\u0000"+
		"01\u0005T\u0000\u000012\u0005Y\u0000\u000023\u0005P\u0000\u000034\u0005"+
		"E\u0000\u000045\u0001\u0000\u0000\u000056\u0007\u0000\u0000\u00006\n\u0001"+
		"\u0000\u0000\u000078\u0005<\u0000\u000089\u0005s\u0000\u00009:\u0005c"+
		"\u0000\u0000:;\u0005r\u0000\u0000;<\u0005i\u0000\u0000<=\u0005p\u0000"+
		"\u0000=>\u0005t\u0000\u0000>?\u0001\u0000\u0000\u0000?@\u0007\u0000\u0000"+
		"\u0000@\f\u0001\u0000\u0000\u0000AB\u0005<\u0000\u0000BC\u0005s\u0000"+
		"\u0000CD\u0005t\u0000\u0000DE\u0005y\u0000\u0000EF\u0005l\u0000\u0000"+
		"FG\u0005e\u0000\u0000GH\u0001\u0000\u0000\u0000HI\u0007\u0000\u0000\u0000"+
		"I\u000e\u0001\u0000\u0000\u0000JK\u0005s\u0000\u0000KL\u0005c\u0000\u0000"+
		"LM\u0005r\u0000\u0000MN\u0005i\u0000\u0000NO\u0005p\u0000\u0000OP\u0005"+
		"t\u0000\u0000P\u0010\u0001\u0000\u0000\u0000QR\u0005s\u0000\u0000RS\u0005"+
		"t\u0000\u0000ST\u0005y\u0000\u0000TU\u0005l\u0000\u0000UV\u0005e\u0000"+
		"\u0000V\u0012\u0001\u0000\u0000\u0000W[\u0007\u0001\u0000\u0000XZ\u0007"+
		"\u0002\u0000\u0000YX\u0001\u0000\u0000\u0000Z]\u0001\u0000\u0000\u0000"+
		"[Y\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\\u0014\u0001\u0000"+
		"\u0000\u0000][\u0001\u0000\u0000\u0000^_\u0005=\u0000\u0000_\u0016\u0001"+
		"\u0000\u0000\u0000`f\u0005\"\u0000\u0000ae\b\u0003\u0000\u0000bc\u0005"+
		"\\\u0000\u0000ce\u0007\u0004\u0000\u0000da\u0001\u0000\u0000\u0000db\u0001"+
		"\u0000\u0000\u0000eh\u0001\u0000\u0000\u0000fd\u0001\u0000\u0000\u0000"+
		"fg\u0001\u0000\u0000\u0000gi\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000"+
		"\u0000iu\u0005\"\u0000\u0000jp\u0005\'\u0000\u0000ko\b\u0005\u0000\u0000"+
		"lm\u0005\\\u0000\u0000mo\u0007\u0006\u0000\u0000nk\u0001\u0000\u0000\u0000"+
		"nl\u0001\u0000\u0000\u0000or\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000"+
		"\u0000pq\u0001\u0000\u0000\u0000qs\u0001\u0000\u0000\u0000rp\u0001\u0000"+
		"\u0000\u0000su\u0005\'\u0000\u0000t`\u0001\u0000\u0000\u0000tj\u0001\u0000"+
		"\u0000\u0000u\u0018\u0001\u0000\u0000\u0000vz\u0007\u0001\u0000\u0000"+
		"wy\u0007\u0007\u0000\u0000xw\u0001\u0000\u0000\u0000y|\u0001\u0000\u0000"+
		"\u0000zx\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{\u001a\u0001"+
		"\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000}\u007f\b\b\u0000\u0000~}"+
		"\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080~\u0001"+
		"\u0000\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u001c\u0001"+
		"\u0000\u0000\u0000\u0082\u0083\u0005<\u0000\u0000\u0083\u0084\u0005!\u0000"+
		"\u0000\u0084\u0085\u0005-\u0000\u0000\u0085\u0086\u0005-\u0000\u0000\u0086"+
		"\u008a\u0001\u0000\u0000\u0000\u0087\u0089\t\u0000\u0000\u0000\u0088\u0087"+
		"\u0001\u0000\u0000\u0000\u0089\u008c\u0001\u0000\u0000\u0000\u008a\u008b"+
		"\u0001\u0000\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008b\u008d"+
		"\u0001\u0000\u0000\u0000\u008c\u008a\u0001\u0000\u0000\u0000\u008d\u008e"+
		"\u0005-\u0000\u0000\u008e\u008f\u0005-\u0000\u0000\u008f\u0090\u0005>"+
		"\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091\u0092\u0006\u000e"+
		"\u0000\u0000\u0092\u001e\u0001\u0000\u0000\u0000\u0093\u0095\u0007\u0000"+
		"\u0000\u0000\u0094\u0093\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000"+
		"\u0000\u0000\u0096\u0094\u0001\u0000\u0000\u0000\u0096\u0097\u0001\u0000"+
		"\u0000\u0000\u0097\u0098\u0001\u0000\u0000\u0000\u0098\u0099\u0006\u000f"+
		"\u0000\u0000\u0099 \u0001\u0000\u0000\u0000\u000b\u0000[dfnptz\u0080\u008a"+
		"\u0096\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}