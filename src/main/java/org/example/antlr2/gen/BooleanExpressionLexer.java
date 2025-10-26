// Generated from D:/IdeaProject/java-feature-demo/src/main/java/org/example/antlr2/BooleanExpression.g4 by ANTLR 4.13.2
package org.example.antlr2.gen;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class BooleanExpressionLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		BOOLEAN=1, NUMBER=2, STRING=3, ID=4, PLUS=5, MINUS=6, MULT=7, DIV=8, MOD=9, 
		NOT=10, AND=11, OR=12, LT=13, LE=14, GT=15, GE=16, EQ=17, NE=18, IN=19, 
		LPAREN=20, RPAREN=21, LBRACE=22, RBRACE=23, COMMA=24, WS=25;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"BOOLEAN", "NUMBER", "STRING", "ID", "PLUS", "MINUS", "MULT", "DIV", 
			"MOD", "NOT", "AND", "OR", "LT", "LE", "GT", "GE", "EQ", "NE", "IN", 
			"LPAREN", "RPAREN", "LBRACE", "RBRACE", "COMMA", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'+'", "'-'", "'*'", "'/'", "'%'", "'!'", 
			"'&&'", "'||'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='", "'in'", 
			"'('", "')'", "'{'", "'}'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "BOOLEAN", "NUMBER", "STRING", "ID", "PLUS", "MINUS", "MULT", "DIV", 
			"MOD", "NOT", "AND", "OR", "LT", "LE", "GT", "GE", "EQ", "NE", "IN", 
			"LPAREN", "RPAREN", "LBRACE", "RBRACE", "COMMA", "WS"
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


	public BooleanExpressionLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BooleanExpression.g4"; }

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
		"\u0004\u0000\u0019\u0093\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0003\u0000"+
		"=\b\u0000\u0001\u0001\u0004\u0001@\b\u0001\u000b\u0001\f\u0001A\u0001"+
		"\u0001\u0001\u0001\u0004\u0001F\b\u0001\u000b\u0001\f\u0001G\u0003\u0001"+
		"J\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"P\b\u0002\n\u0002\f\u0002S\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0005\u0003Y\b\u0003\n\u0003\f\u0003\\\t\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r"+
		"\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0018\u0004\u0018\u008e\b\u0018\u000b\u0018\f\u0018\u008f\u0001"+
		"\u0018\u0001\u0018\u0000\u0000\u0019\u0001\u0001\u0003\u0002\u0005\u0003"+
		"\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015"+
		"\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012"+
		"%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u0019\u0001\u0000\u0005\u0001"+
		"\u000009\u0002\u0000\"\"\\\\\u0003\u0000AZ__az\u0004\u000009AZ__az\u0003"+
		"\u0000\t\n\r\r  \u009a\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000"+
		"\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000"+
		"\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000"+
		"\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000"+
		"\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000"+
		"\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000"+
		"\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000"+
		")\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001"+
		"\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000"+
		"\u0000\u0001<\u0001\u0000\u0000\u0000\u0003?\u0001\u0000\u0000\u0000\u0005"+
		"K\u0001\u0000\u0000\u0000\u0007V\u0001\u0000\u0000\u0000\t]\u0001\u0000"+
		"\u0000\u0000\u000b_\u0001\u0000\u0000\u0000\ra\u0001\u0000\u0000\u0000"+
		"\u000fc\u0001\u0000\u0000\u0000\u0011e\u0001\u0000\u0000\u0000\u0013g"+
		"\u0001\u0000\u0000\u0000\u0015i\u0001\u0000\u0000\u0000\u0017l\u0001\u0000"+
		"\u0000\u0000\u0019o\u0001\u0000\u0000\u0000\u001bq\u0001\u0000\u0000\u0000"+
		"\u001dt\u0001\u0000\u0000\u0000\u001fv\u0001\u0000\u0000\u0000!y\u0001"+
		"\u0000\u0000\u0000#|\u0001\u0000\u0000\u0000%\u007f\u0001\u0000\u0000"+
		"\u0000\'\u0082\u0001\u0000\u0000\u0000)\u0084\u0001\u0000\u0000\u0000"+
		"+\u0086\u0001\u0000\u0000\u0000-\u0088\u0001\u0000\u0000\u0000/\u008a"+
		"\u0001\u0000\u0000\u00001\u008d\u0001\u0000\u0000\u000034\u0005t\u0000"+
		"\u000045\u0005r\u0000\u000056\u0005u\u0000\u00006=\u0005e\u0000\u0000"+
		"78\u0005f\u0000\u000089\u0005a\u0000\u00009:\u0005l\u0000\u0000:;\u0005"+
		"s\u0000\u0000;=\u0005e\u0000\u0000<3\u0001\u0000\u0000\u0000<7\u0001\u0000"+
		"\u0000\u0000=\u0002\u0001\u0000\u0000\u0000>@\u0007\u0000\u0000\u0000"+
		"?>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000"+
		"\u0000AB\u0001\u0000\u0000\u0000BI\u0001\u0000\u0000\u0000CE\u0005.\u0000"+
		"\u0000DF\u0007\u0000\u0000\u0000ED\u0001\u0000\u0000\u0000FG\u0001\u0000"+
		"\u0000\u0000GE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HJ\u0001"+
		"\u0000\u0000\u0000IC\u0001\u0000\u0000\u0000IJ\u0001\u0000\u0000\u0000"+
		"J\u0004\u0001\u0000\u0000\u0000KQ\u0005\"\u0000\u0000LP\b\u0001\u0000"+
		"\u0000MN\u0005\\\u0000\u0000NP\t\u0000\u0000\u0000OL\u0001\u0000\u0000"+
		"\u0000OM\u0001\u0000\u0000\u0000PS\u0001\u0000\u0000\u0000QO\u0001\u0000"+
		"\u0000\u0000QR\u0001\u0000\u0000\u0000RT\u0001\u0000\u0000\u0000SQ\u0001"+
		"\u0000\u0000\u0000TU\u0005\"\u0000\u0000U\u0006\u0001\u0000\u0000\u0000"+
		"VZ\u0007\u0002\u0000\u0000WY\u0007\u0003\u0000\u0000XW\u0001\u0000\u0000"+
		"\u0000Y\\\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000Z[\u0001\u0000"+
		"\u0000\u0000[\b\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000]^\u0005"+
		"+\u0000\u0000^\n\u0001\u0000\u0000\u0000_`\u0005-\u0000\u0000`\f\u0001"+
		"\u0000\u0000\u0000ab\u0005*\u0000\u0000b\u000e\u0001\u0000\u0000\u0000"+
		"cd\u0005/\u0000\u0000d\u0010\u0001\u0000\u0000\u0000ef\u0005%\u0000\u0000"+
		"f\u0012\u0001\u0000\u0000\u0000gh\u0005!\u0000\u0000h\u0014\u0001\u0000"+
		"\u0000\u0000ij\u0005&\u0000\u0000jk\u0005&\u0000\u0000k\u0016\u0001\u0000"+
		"\u0000\u0000lm\u0005|\u0000\u0000mn\u0005|\u0000\u0000n\u0018\u0001\u0000"+
		"\u0000\u0000op\u0005<\u0000\u0000p\u001a\u0001\u0000\u0000\u0000qr\u0005"+
		"<\u0000\u0000rs\u0005=\u0000\u0000s\u001c\u0001\u0000\u0000\u0000tu\u0005"+
		">\u0000\u0000u\u001e\u0001\u0000\u0000\u0000vw\u0005>\u0000\u0000wx\u0005"+
		"=\u0000\u0000x \u0001\u0000\u0000\u0000yz\u0005=\u0000\u0000z{\u0005="+
		"\u0000\u0000{\"\u0001\u0000\u0000\u0000|}\u0005!\u0000\u0000}~\u0005="+
		"\u0000\u0000~$\u0001\u0000\u0000\u0000\u007f\u0080\u0005i\u0000\u0000"+
		"\u0080\u0081\u0005n\u0000\u0000\u0081&\u0001\u0000\u0000\u0000\u0082\u0083"+
		"\u0005(\u0000\u0000\u0083(\u0001\u0000\u0000\u0000\u0084\u0085\u0005)"+
		"\u0000\u0000\u0085*\u0001\u0000\u0000\u0000\u0086\u0087\u0005{\u0000\u0000"+
		"\u0087,\u0001\u0000\u0000\u0000\u0088\u0089\u0005}\u0000\u0000\u0089."+
		"\u0001\u0000\u0000\u0000\u008a\u008b\u0005,\u0000\u0000\u008b0\u0001\u0000"+
		"\u0000\u0000\u008c\u008e\u0007\u0004\u0000\u0000\u008d\u008c\u0001\u0000"+
		"\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000"+
		"\u0000\u0000\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000"+
		"\u0000\u0000\u0091\u0092\u0006\u0018\u0000\u0000\u00922\u0001\u0000\u0000"+
		"\u0000\t\u0000<AGIOQZ\u008f\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}