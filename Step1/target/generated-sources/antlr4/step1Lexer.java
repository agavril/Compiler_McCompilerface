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
		INTLITERAL=1, FLOATLITERAL=2, STRINGLITERAL=3, COMMENT=4, IDENTIFIER=5, 
		WS=6, OPERATOR=7, KEYWORD=8;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"INTLITERAL", "FLOATLITERAL", "STRINGLITERAL", "COMMENT", "IDENTIFIER", 
		"WS", "OPERATOR", "KEYWORD"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "INTLITERAL", "FLOATLITERAL", "STRINGLITERAL", "COMMENT", "IDENTIFIER", 
		"WS", "OPERATOR", "KEYWORD"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\n\u00be\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\3\2\6\2\25"+
		"\n\2\r\2\16\2\26\3\3\7\3\32\n\3\f\3\16\3\35\13\3\3\3\3\3\6\3!\n\3\r\3"+
		"\16\3\"\3\4\3\4\6\4\'\n\4\r\4\16\4(\3\4\3\4\3\5\3\5\3\5\3\5\6\5\61\n\5"+
		"\r\5\16\5\62\3\5\3\5\3\6\3\6\5\69\n\6\3\7\6\7<\n\7\r\7\16\7=\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bL\n\b\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\5\t\u00bd\n\t\2\2\n\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\3\2\n\3\2\62"+
		";\3\2$$\3\2\f\f\4\2C\\c|\5\2\62;C\\c|\5\2\13\f\17\17\"\"\6\2,-//\61\61"+
		"??\6\2*+..=>@@\2\u00dd\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\3\24\3\2\2\2\5\33"+
		"\3\2\2\2\7$\3\2\2\2\t,\3\2\2\2\13\66\3\2\2\2\r;\3\2\2\2\17K\3\2\2\2\21"+
		"\u00bc\3\2\2\2\23\25\t\2\2\2\24\23\3\2\2\2\25\26\3\2\2\2\26\24\3\2\2\2"+
		"\26\27\3\2\2\2\27\4\3\2\2\2\30\32\t\2\2\2\31\30\3\2\2\2\32\35\3\2\2\2"+
		"\33\31\3\2\2\2\33\34\3\2\2\2\34\36\3\2\2\2\35\33\3\2\2\2\36 \7\60\2\2"+
		"\37!\t\2\2\2 \37\3\2\2\2!\"\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#\6\3\2\2\2$"+
		"&\7$\2\2%\'\n\3\2\2&%\3\2\2\2\'(\3\2\2\2(&\3\2\2\2()\3\2\2\2)*\3\2\2\2"+
		"*+\7$\2\2+\b\3\2\2\2,-\7/\2\2-.\7/\2\2.\60\3\2\2\2/\61\n\4\2\2\60/\3\2"+
		"\2\2\61\62\3\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\64\3\2\2\2\64\65\b\5"+
		"\2\2\65\n\3\2\2\2\668\t\5\2\2\679\t\6\2\28\67\3\2\2\29\f\3\2\2\2:<\t\7"+
		"\2\2;:\3\2\2\2<=\3\2\2\2=;\3\2\2\2=>\3\2\2\2>?\3\2\2\2?@\b\7\2\2@\16\3"+
		"\2\2\2AB\7<\2\2BL\7?\2\2CL\t\b\2\2DE\7#\2\2EL\7?\2\2FL\t\t\2\2GH\7>\2"+
		"\2HL\7?\2\2IJ\7@\2\2JL\7?\2\2KA\3\2\2\2KC\3\2\2\2KD\3\2\2\2KF\3\2\2\2"+
		"KG\3\2\2\2KI\3\2\2\2L\20\3\2\2\2MN\7R\2\2NO\7T\2\2OP\7Q\2\2PQ\7I\2\2Q"+
		"R\7T\2\2RS\7C\2\2S\u00bd\7O\2\2TU\7D\2\2UV\7G\2\2VW\7I\2\2WX\7K\2\2X\u00bd"+
		"\7P\2\2YZ\7G\2\2Z[\7P\2\2[\u00bd\7F\2\2\\]\7H\2\2]^\7W\2\2^_\7P\2\2_`"+
		"\7E\2\2`a\7V\2\2ab\7K\2\2bc\7Q\2\2c\u00bd\7P\2\2de\7T\2\2ef\7G\2\2fg\7"+
		"C\2\2g\u00bd\7F\2\2hi\7Y\2\2ij\7T\2\2jk\7K\2\2kl\7V\2\2l\u00bd\7G\2\2"+
		"mn\7K\2\2n\u00bd\7H\2\2op\7G\2\2pq\7N\2\2qr\7U\2\2r\u00bd\7G\2\2st\7G"+
		"\2\2tu\7P\2\2uv\7F\2\2vw\7K\2\2w\u00bd\7H\2\2xy\7Y\2\2yz\7J\2\2z{\7K\2"+
		"\2{|\7N\2\2|\u00bd\7G\2\2}~\7G\2\2~\177\7P\2\2\177\u0080\7F\2\2\u0080"+
		"\u0081\7Y\2\2\u0081\u0082\7J\2\2\u0082\u0083\7K\2\2\u0083\u0084\7N\2\2"+
		"\u0084\u00bd\7G\2\2\u0085\u0086\7T\2\2\u0086\u0087\7G\2\2\u0087\u0088"+
		"\7V\2\2\u0088\u0089\7W\2\2\u0089\u008a\7T\2\2\u008a\u00bd\7P\2\2\u008b"+
		"\u008c\7K\2\2\u008c\u008d\7P\2\2\u008d\u00bd\7V\2\2\u008e\u008f\7X\2\2"+
		"\u008f\u0090\7Q\2\2\u0090\u0091\7K\2\2\u0091\u00bd\7F\2\2\u0092\u0093"+
		"\7U\2\2\u0093\u0094\7V\2\2\u0094\u0095\7T\2\2\u0095\u0096\7K\2\2\u0096"+
		"\u0097\7P\2\2\u0097\u00bd\7I\2\2\u0098\u0099\7H\2\2\u0099\u009a\7N\2\2"+
		"\u009a\u009b\7Q\2\2\u009b\u009c\7C\2\2\u009c\u00bd\7V\2\2\u009d\u009e"+
		"\7V\2\2\u009e\u009f\7T\2\2\u009f\u00a0\7W\2\2\u00a0\u00bd\7G\2\2\u00a1"+
		"\u00a2\7H\2\2\u00a2\u00a3\7C\2\2\u00a3\u00a4\7N\2\2\u00a4\u00a5\7U\2\2"+
		"\u00a5\u00bd\7G\2\2\u00a6\u00a7\7H\2\2\u00a7\u00a8\7Q\2\2\u00a8\u00bd"+
		"\7T\2\2\u00a9\u00aa\7G\2\2\u00aa\u00ab\7P\2\2\u00ab\u00ac\7F\2\2\u00ac"+
		"\u00ad\7H\2\2\u00ad\u00ae\7Q\2\2\u00ae\u00bd\7T\2\2\u00af\u00b0\7E\2\2"+
		"\u00b0\u00b1\7Q\2\2\u00b1\u00b2\7P\2\2\u00b2\u00b3\7V\2\2\u00b3\u00b4"+
		"\7K\2\2\u00b4\u00b5\7P\2\2\u00b5\u00b6\7W\2\2\u00b6\u00bd\7G\2\2\u00b7"+
		"\u00b8\7D\2\2\u00b8\u00b9\7T\2\2\u00b9\u00ba\7G\2\2\u00ba\u00bb\7C\2\2"+
		"\u00bb\u00bd\7M\2\2\u00bcM\3\2\2\2\u00bcT\3\2\2\2\u00bcY\3\2\2\2\u00bc"+
		"\\\3\2\2\2\u00bcd\3\2\2\2\u00bch\3\2\2\2\u00bcm\3\2\2\2\u00bco\3\2\2\2"+
		"\u00bcs\3\2\2\2\u00bcx\3\2\2\2\u00bc}\3\2\2\2\u00bc\u0085\3\2\2\2\u00bc"+
		"\u008b\3\2\2\2\u00bc\u008e\3\2\2\2\u00bc\u0092\3\2\2\2\u00bc\u0098\3\2"+
		"\2\2\u00bc\u009d\3\2\2\2\u00bc\u00a1\3\2\2\2\u00bc\u00a6\3\2\2\2\u00bc"+
		"\u00a9\3\2\2\2\u00bc\u00af\3\2\2\2\u00bc\u00b7\3\2\2\2\u00bd\22\3\2\2"+
		"\2\f\2\26\33\"(\628=K\u00bc\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}