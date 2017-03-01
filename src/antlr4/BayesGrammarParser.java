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
		T__4=1, T__3=2, T__2=3, T__1=4, T__0=5, TOKEN=6, WS=7, COMMENT=8;
	public static final String[] tokenNames = {
		"<INVALID>", "'P'", "'!'", "'('", "')'", "'|'", "TOKEN", "WS", "COMMENT"
	};
	public static final int
		RULE_program = 0, RULE_condition = 1, RULE_negation = 2, RULE_op1 = 3, 
		RULE_op2 = 4;
	public static final String[] ruleNames = {
		"program", "condition", "negation", "op1", "op2"
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
		public Op1Context op1() {
			return getRuleContext(Op1Context.class,0);
		}
		public Op2Context op2() {
			return getRuleContext(Op2Context.class,0);
		}
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
			setState(10); match(T__4);
			setState(11); match(T__2);
			setState(12); op1();
			setState(16);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(13); condition();
				setState(14); op2();
				}
			}

			setState(18); match(T__1);
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
			setState(20); match(T__0);
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
			setState(22); match(T__3);
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

	public static class Op1Context extends ParserRuleContext {
		public NegationContext negation() {
			return getRuleContext(NegationContext.class,0);
		}
		public TerminalNode TOKEN(int i) {
			return getToken(BayesGrammarParser.TOKEN, i);
		}
		public List<TerminalNode> TOKEN() { return getTokens(BayesGrammarParser.TOKEN); }
		public Op1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op1; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BayesGrammarVisitor ) return ((BayesGrammarVisitor<? extends T>)visitor).visitOp1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op1Context op1() throws RecognitionException {
		Op1Context _localctx = new Op1Context(_ctx, getState());
		enterRule(_localctx, 6, RULE_op1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(24); negation();
				}
			}

			setState(30);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TOKEN) {
				{
				{
				setState(27); match(TOKEN);
				}
				}
				setState(32);
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

	public static class Op2Context extends ParserRuleContext {
		public NegationContext negation() {
			return getRuleContext(NegationContext.class,0);
		}
		public TerminalNode TOKEN(int i) {
			return getToken(BayesGrammarParser.TOKEN, i);
		}
		public List<TerminalNode> TOKEN() { return getTokens(BayesGrammarParser.TOKEN); }
		public Op2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op2; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BayesGrammarVisitor ) return ((BayesGrammarVisitor<? extends T>)visitor).visitOp2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op2Context op2() throws RecognitionException {
		Op2Context _localctx = new Op2Context(_ctx, getState());
		enterRule(_localctx, 8, RULE_op2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(33); negation();
				}
			}

			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TOKEN) {
				{
				{
				setState(36); match(TOKEN);
				}
				}
				setState(41);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\n-\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\2\3\2\3\2\5\2\23\n\2\3\2\3\2"+
		"\3\3\3\3\3\4\3\4\3\5\5\5\34\n\5\3\5\7\5\37\n\5\f\5\16\5\"\13\5\3\6\5\6"+
		"%\n\6\3\6\7\6(\n\6\f\6\16\6+\13\6\3\6\2\2\7\2\4\6\b\n\2\2,\2\f\3\2\2\2"+
		"\4\26\3\2\2\2\6\30\3\2\2\2\b\33\3\2\2\2\n$\3\2\2\2\f\r\7\3\2\2\r\16\7"+
		"\5\2\2\16\22\5\b\5\2\17\20\5\4\3\2\20\21\5\n\6\2\21\23\3\2\2\2\22\17\3"+
		"\2\2\2\22\23\3\2\2\2\23\24\3\2\2\2\24\25\7\6\2\2\25\3\3\2\2\2\26\27\7"+
		"\7\2\2\27\5\3\2\2\2\30\31\7\4\2\2\31\7\3\2\2\2\32\34\5\6\4\2\33\32\3\2"+
		"\2\2\33\34\3\2\2\2\34 \3\2\2\2\35\37\7\b\2\2\36\35\3\2\2\2\37\"\3\2\2"+
		"\2 \36\3\2\2\2 !\3\2\2\2!\t\3\2\2\2\" \3\2\2\2#%\5\6\4\2$#\3\2\2\2$%\3"+
		"\2\2\2%)\3\2\2\2&(\7\b\2\2\'&\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*"+
		"\13\3\2\2\2+)\3\2\2\2\7\22\33 $)";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}