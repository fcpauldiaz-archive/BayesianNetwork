package antlr4;

// Generated from /Users/SDX/NetBeansProjects/BayesianNetwork/src/bayesiannetwork/antlr4/BayesGrammar.g4 by ANTLR 4.4
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BayesGrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__2=1, T__1=2, T__0=3, TOKEN=4, WS=5, COMMENT=6;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'"
	};
	public static final String[] ruleNames = {
		"T__2", "T__1", "T__0", "LETTER", "TOKEN", "WS", "COMMENT"
	};


	public BayesGrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "BayesGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\bE\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\7\6\36\n\6\f\6\16\6!\13\6\3\7\6\7$\n\7\r\7\16"+
		"\7%\3\7\3\7\3\b\3\b\3\b\3\b\7\b.\n\b\f\b\16\b\61\13\b\3\b\5\b\64\n\b\3"+
		"\b\3\b\3\b\3\b\3\b\7\b;\n\b\f\b\16\b>\13\b\3\b\3\b\5\bB\n\b\3\b\3\b\3"+
		"<\2\t\3\3\5\4\7\5\t\2\13\6\r\7\17\b\3\2\5\4\2C\\c|\5\2\13\f\16\17\"\""+
		"\4\2\f\f\17\17I\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\13\3\2\2\2\2\r\3"+
		"\2\2\2\2\17\3\2\2\2\3\21\3\2\2\2\5\23\3\2\2\2\7\25\3\2\2\2\t\27\3\2\2"+
		"\2\13\31\3\2\2\2\r#\3\2\2\2\17A\3\2\2\2\21\22\7*\2\2\22\4\3\2\2\2\23\24"+
		"\7+\2\2\24\6\3\2\2\2\25\26\7~\2\2\26\b\3\2\2\2\27\30\t\2\2\2\30\n\3\2"+
		"\2\2\31\32\7#\2\2\32\37\5\t\5\2\33\34\7#\2\2\34\36\5\t\5\2\35\33\3\2\2"+
		"\2\36!\3\2\2\2\37\35\3\2\2\2\37 \3\2\2\2 \f\3\2\2\2!\37\3\2\2\2\"$\t\3"+
		"\2\2#\"\3\2\2\2$%\3\2\2\2%#\3\2\2\2%&\3\2\2\2&\'\3\2\2\2\'(\b\7\2\2(\16"+
		"\3\2\2\2)*\7\61\2\2*+\7\61\2\2+/\3\2\2\2,.\n\4\2\2-,\3\2\2\2.\61\3\2\2"+
		"\2/-\3\2\2\2/\60\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\62\64\7\17\2\2\63\62"+
		"\3\2\2\2\63\64\3\2\2\2\64\65\3\2\2\2\65B\7\f\2\2\66\67\7\61\2\2\678\7"+
		",\2\28<\3\2\2\29;\13\2\2\2:9\3\2\2\2;>\3\2\2\2<=\3\2\2\2<:\3\2\2\2=?\3"+
		"\2\2\2><\3\2\2\2?@\7,\2\2@B\7\61\2\2A)\3\2\2\2A\66\3\2\2\2BC\3\2\2\2C"+
		"D\b\b\2\2D\20\3\2\2\2\t\2\37%/\63<A\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}