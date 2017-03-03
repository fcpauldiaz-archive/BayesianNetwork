// Generated from /Users/SDX/NetBeansProjects/BayesianNetwork/src/antlr4/BayesGrammar.g4 by ANTLR 4.4
package antlr4;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BayesGrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__3=1, T__2=2, T__1=3, T__0=4, NEGATION=5, TOKEN=6, NUM=7, EQUALS=8, 
		WS=9, COMMENT=10;
	public static final String[] tokenNames = {
		"<INVALID>", "'P'", "'('", "')'", "'|'", "'!'", "TOKEN", "NUM", "'='", 
		"WS", "COMMENT"
	};
	public static final int
		RULE_program = 0, RULE_condition = 1, RULE_negation = 2, RULE_operator = 3, 
		RULE_op = 4;
	public static final String[] ruleNames = {
		"program", "condition", "negation", "operator", "op"
	};

	@Override
	public String getGrammarFileName() { return "BayesGrammar.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BayesGrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public OpContext op(int i) {
			return getRuleContext(OpContext.class,i);
		}
		public TerminalNode EQUALS() { return getToken(BayesGrammarParser.EQUALS, 0); }
		public List<OpContext> op() {
			return getRuleContexts(OpContext.class);
		}
		public TerminalNode NUM() { return getToken(BayesGrammarParser.NUM, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BayesGrammarVisitor ) return ((BayesGrammarVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10); match(T__3);
			setState(11); match(T__2);
			setState(12); op();
			setState(16);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(13); condition();
				setState(14); op();
				}
			}

			setState(18); match(T__1);
			setState(19); match(EQUALS);
			setState(20); match(NUM);
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

	public static class ConditionContext extends ParserRuleContext {
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BayesGrammarVisitor ) return ((BayesGrammarVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(22); match(T__0);
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

	public static class NegationContext extends ParserRuleContext {
		public TerminalNode NEGATION() { return getToken(BayesGrammarParser.NEGATION, 0); }
		public NegationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BayesGrammarVisitor ) return ((BayesGrammarVisitor<? extends T>)visitor).visitNegation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NegationContext negation() throws RecognitionException {
		NegationContext _localctx = new NegationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_negation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24); match(NEGATION);
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

	public static class OperatorContext extends ParserRuleContext {
		public NegationContext negation() {
			return getRuleContext(NegationContext.class,0);
		}
		public TerminalNode TOKEN() { return getToken(BayesGrammarParser.TOKEN, 0); }
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BayesGrammarVisitor ) return ((BayesGrammarVisitor<? extends T>)visitor).visitOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			_la = _input.LA(1);
			if (_la==NEGATION) {
				{
				setState(26); negation();
				}
			}

			setState(29); match(TOKEN);
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

	public static class OpContext extends ParserRuleContext {
		public OperatorContext operator(int i) {
			return getRuleContext(OperatorContext.class,i);
		}
		public List<OperatorContext> operator() {
			return getRuleContexts(OperatorContext.class);
		}
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BayesGrammarVisitor ) return ((BayesGrammarVisitor<? extends T>)visitor).visitOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEGATION || _la==TOKEN) {
				{
				{
				setState(31); operator();
				}
				}
				setState(36);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\f(\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\2\3\2\5\2\23\n\2\3\2\3\2"+
		"\3\2\3\2\3\3\3\3\3\4\3\4\3\5\5\5\36\n\5\3\5\3\5\3\6\7\6#\n\6\f\6\16\6"+
		"&\13\6\3\6\2\2\7\2\4\6\b\n\2\2%\2\f\3\2\2\2\4\30\3\2\2\2\6\32\3\2\2\2"+
		"\b\35\3\2\2\2\n$\3\2\2\2\f\r\7\3\2\2\r\16\7\4\2\2\16\22\5\n\6\2\17\20"+
		"\5\4\3\2\20\21\5\n\6\2\21\23\3\2\2\2\22\17\3\2\2\2\22\23\3\2\2\2\23\24"+
		"\3\2\2\2\24\25\7\5\2\2\25\26\7\n\2\2\26\27\7\t\2\2\27\3\3\2\2\2\30\31"+
		"\7\6\2\2\31\5\3\2\2\2\32\33\7\7\2\2\33\7\3\2\2\2\34\36\5\6\4\2\35\34\3"+
		"\2\2\2\35\36\3\2\2\2\36\37\3\2\2\2\37 \7\b\2\2 \t\3\2\2\2!#\5\b\5\2\""+
		"!\3\2\2\2#&\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%\13\3\2\2\2&$\3\2\2\2\5\22\35"+
		"$";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}