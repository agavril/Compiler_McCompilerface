// Generated from step1.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class step1Lexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INTLITERAL=1, FLOATLITERAL=2, STRINGLITERAL=3, COMMENT=4, WS=5, OPERATOR=6, 
		KEYWORD=7, IDENTIFIER=8;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"INTLITERAL", "FLOATLITERAL", "STRINGLITERAL", "COMMENT", "WS", "OPERATOR", 
		"KEYWORD", "IDENTIFIER"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "INTLITERAL", "FLOATLITERAL", "STRINGLITERAL", "COMMENT", "WS", 
		"OPERATOR", "KEYWORD", "IDENTIFIER"
	};
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


	public step1Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "step1.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\n\u00c1\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\6\2\25"+
		"\n\2\r\2\16\2\26\3\3\7\3\32\n\3\f\3\16\3\35\13\3\3\3\3\3\6\3!\n\3\r\3"+
		"\16\3\"\3\4\3\4\6\4\'\n\4\r\4\16\4(\3\4\3\4\3\5\3\5\3\5\3\5\6\5\61\n\5"+
		"\r\5\16\5\62\3\5\3\5\3\6\6\68\n\6\r\6\16\69\3\6\3\6\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\5\7H\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00b9\n\b"+
		"\3\t\3\t\7\t\u00bd\n\t\f\t\16\t\u00c0\13\t\2\2\n\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\3\2\n\3\2\62;\3\2$$\3\2\f\f\5\2\13\f\17\17\"\"\6\2,-//"+
		"\61\61??\6\2*+..=>@@\4\2C\\c|\5\2\62;C\\c|\2\u00e1\2\3\3\2\2\2\2\5\3\2"+
		"\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\3\24\3\2\2\2\5\33\3\2\2\2\7$\3\2\2\2\t,\3\2\2\2\13\67\3\2\2\2"+
		"\rG\3\2\2\2\17\u00b8\3\2\2\2\21\u00ba\3\2\2\2\23\25\t\2\2\2\24\23\3\2"+
		"\2\2\25\26\3\2\2\2\26\24\3\2\2\2\26\27\3\2\2\2\27\4\3\2\2\2\30\32\t\2"+
		"\2\2\31\30\3\2\2\2\32\35\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\36\3\2"+
		"\2\2\35\33\3\2\2\2\36 \7\60\2\2\37!\t\2\2\2 \37\3\2\2\2!\"\3\2\2\2\" "+
		"\3\2\2\2\"#\3\2\2\2#\6\3\2\2\2$&\7$\2\2%\'\n\3\2\2&%\3\2\2\2\'(\3\2\2"+
		"\2(&\3\2\2\2()\3\2\2\2)*\3\2\2\2*+\7$\2\2+\b\3\2\2\2,-\7/\2\2-.\7/\2\2"+
		".\60\3\2\2\2/\61\n\4\2\2\60/\3\2\2\2\61\62\3\2\2\2\62\60\3\2\2\2\62\63"+
		"\3\2\2\2\63\64\3\2\2\2\64\65\b\5\2\2\65\n\3\2\2\2\668\t\5\2\2\67\66\3"+
		"\2\2\289\3\2\2\29\67\3\2\2\29:\3\2\2\2:;\3\2\2\2;<\b\6\2\2<\f\3\2\2\2"+
		"=>\7<\2\2>H\7?\2\2?H\t\6\2\2@A\7#\2\2AH\7?\2\2BH\t\7\2\2CD\7>\2\2DH\7"+
		"?\2\2EF\7@\2\2FH\7?\2\2G=\3\2\2\2G?\3\2\2\2G@\3\2\2\2GB\3\2\2\2GC\3\2"+
		"\2\2GE\3\2\2\2H\16\3\2\2\2IJ\7R\2\2JK\7T\2\2KL\7Q\2\2LM\7I\2\2MN\7T\2"+
		"\2NO\7C\2\2O\u00b9\7O\2\2PQ\7D\2\2QR\7G\2\2RS\7I\2\2ST\7K\2\2T\u00b9\7"+
		"P\2\2UV\7G\2\2VW\7P\2\2W\u00b9\7F\2\2XY\7H\2\2YZ\7W\2\2Z[\7P\2\2[\\\7"+
		"E\2\2\\]\7V\2\2]^\7K\2\2^_\7Q\2\2_\u00b9\7P\2\2`a\7T\2\2ab\7G\2\2bc\7"+
		"C\2\2c\u00b9\7F\2\2de\7Y\2\2ef\7T\2\2fg\7K\2\2gh\7V\2\2h\u00b9\7G\2\2"+
		"ij\7K\2\2j\u00b9\7H\2\2kl\7G\2\2lm\7N\2\2mn\7U\2\2n\u00b9\7G\2\2op\7G"+
		"\2\2pq\7P\2\2qr\7F\2\2rs\7K\2\2s\u00b9\7H\2\2tu\7Y\2\2uv\7J\2\2vw\7K\2"+
		"\2wx\7N\2\2x\u00b9\7G\2\2yz\7G\2\2z{\7P\2\2{|\7F\2\2|}\7Y\2\2}~\7J\2\2"+
		"~\177\7K\2\2\177\u0080\7N\2\2\u0080\u00b9\7G\2\2\u0081\u0082\7T\2\2\u0082"+
		"\u0083\7G\2\2\u0083\u0084\7V\2\2\u0084\u0085\7W\2\2\u0085\u0086\7T\2\2"+
		"\u0086\u00b9\7P\2\2\u0087\u0088\7K\2\2\u0088\u0089\7P\2\2\u0089\u00b9"+
		"\7V\2\2\u008a\u008b\7X\2\2\u008b\u008c\7Q\2\2\u008c\u008d\7K\2\2\u008d"+
		"\u00b9\7F\2\2\u008e\u008f\7U\2\2\u008f\u0090\7V\2\2\u0090\u0091\7T\2\2"+
		"\u0091\u0092\7K\2\2\u0092\u0093\7P\2\2\u0093\u00b9\7I\2\2\u0094\u0095"+
		"\7H\2\2\u0095\u0096\7N\2\2\u0096\u0097\7Q\2\2\u0097\u0098\7C\2\2\u0098"+
		"\u00b9\7V\2\2\u0099\u009a\7V\2\2\u009a\u009b\7T\2\2\u009b\u009c\7W\2\2"+
		"\u009c\u00b9\7G\2\2\u009d\u009e\7H\2\2\u009e\u009f\7C\2\2\u009f\u00a0"+
		"\7N\2\2\u00a0\u00a1\7U\2\2\u00a1\u00b9\7G\2\2\u00a2\u00a3\7H\2\2\u00a3"+
		"\u00a4\7Q\2\2\u00a4\u00b9\7T\2\2\u00a5\u00a6\7G\2\2\u00a6\u00a7\7P\2\2"+
		"\u00a7\u00a8\7F\2\2\u00a8\u00a9\7H\2\2\u00a9\u00aa\7Q\2\2\u00aa\u00b9"+
		"\7T\2\2\u00ab\u00ac\7E\2\2\u00ac\u00ad\7Q\2\2\u00ad\u00ae\7P\2\2\u00ae"+
		"\u00af\7V\2\2\u00af\u00b0\7K\2\2\u00b0\u00b1\7P\2\2\u00b1\u00b2\7W\2\2"+
		"\u00b2\u00b9\7G\2\2\u00b3\u00b4\7D\2\2\u00b4\u00b5\7T\2\2\u00b5\u00b6"+
		"\7G\2\2\u00b6\u00b7\7C\2\2\u00b7\u00b9\7M\2\2\u00b8I\3\2\2\2\u00b8P\3"+
		"\2\2\2\u00b8U\3\2\2\2\u00b8X\3\2\2\2\u00b8`\3\2\2\2\u00b8d\3\2\2\2\u00b8"+
		"i\3\2\2\2\u00b8k\3\2\2\2\u00b8o\3\2\2\2\u00b8t\3\2\2\2\u00b8y\3\2\2\2"+
		"\u00b8\u0081\3\2\2\2\u00b8\u0087\3\2\2\2\u00b8\u008a\3\2\2\2\u00b8\u008e"+
		"\3\2\2\2\u00b8\u0094\3\2\2\2\u00b8\u0099\3\2\2\2\u00b8\u009d\3\2\2\2\u00b8"+
		"\u00a2\3\2\2\2\u00b8\u00a5\3\2\2\2\u00b8\u00ab\3\2\2\2\u00b8\u00b3\3\2"+
		"\2\2\u00b9\20\3\2\2\2\u00ba\u00be\t\b\2\2\u00bb\u00bd\t\t\2\2\u00bc\u00bb"+
		"\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf"+
		"\22\3\2\2\2\u00c0\u00be\3\2\2\2\r\2\26\33\"(\629G\u00b8\u00bc\u00be\3"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}