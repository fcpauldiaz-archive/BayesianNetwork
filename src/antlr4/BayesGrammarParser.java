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
		T__4=1, T__3=2, T__2=3, T__1=4, T__0=5, NEGATION=6, TOKEN=7, NUM=8, EQUALS=9, 
		WS=10, COMMENT=11;
	public static final String[] tokenNames = {
		"<INVALID>", "'P'", "'('", "')'", "','", "'|'", "'!'", "TOKEN", "NUM", 
		"'='", "WS", "COMMENT"
	};
	public static final int
		RULE_program = 0, RULE_probability = 1, RULE_number = 2, RULE_condition = 3, 
		RULE_negation = 4, RULE_operator = 5, RULE_op = 6, RULE_op2 = 7, RULE_operator2 = 8;
	public static final String[] ruleNames = {
		"program", "probability", "number", "condition", "negation", "operator", 
		"op", "op2", "operator2"
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
		public List<ProbabilityContext> probability() {
			return getRuleContexts(ProbabilityContext.class);
		}
		public ProbabilityContext probability(int i) {
			return getRuleContext(ProbabilityContext.class,i);
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
			setState(19); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(18); probability();
				}
				}
				setState(21); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__4 );
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

	public static class ProbabilityContext extends ParserRuleContext {
		public TerminalNode EQUALS() { return getToken(BayesGrammarParser.EQUALS, 0); }
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public OpContext op() {
			return getRuleContext(OpContext.class,0);
		}
		public Op2Context op2() {
			return getRuleContext(Op2Context.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ProbabilityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_probability; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BayesGrammarVisitor ) return ((BayesGrammarVisitor<? extends T>)visitor).visitProbability(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProbabilityContext probability() throws RecognitionException {
		ProbabilityContext _localctx = new ProbabilityContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_probability);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23); match(T__4);
			setState(24); match(T__3);
			setState(25); op();
			setState(29);
			_la = _input.LA(1);
			if (_la==T__0) {
				{
				setState(26); condition();
				setState(27); op2();
				}
			}

			setState(31); match(T__2);
			setState(32); match(EQUALS);
			setState(33); number();
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

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(BayesGrammarParser.NUM, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BayesGrammarVisitor ) return ((BayesGrammarVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35); match(NUM);
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
		enterRule(_localctx, 6, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(37); match(T__0);
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
		enterRule(_localctx, 8, RULE_negation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39); match(NEGATION);
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
		enterRule(_localctx, 10, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			_la = _input.LA(1);
			if (_la==NEGATION) {
				{
				setState(41); negation();
				}
			}

			setState(44); match(TOKEN);
			setState(46);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(45); match(T__1);
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
		enterRule(_localctx, 12, RULE_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEGATION || _la==TOKEN) {
				{
				{
				setState(48); operator();
				}
				}
				setState(53);
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
		public Operator2Context operator2(int i) {
			return getRuleContext(Operator2Context.class,i);
		}
		public List<Operator2Context> operator2() {
			return getRuleContexts(Operator2Context.class);
		}
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
		enterRule(_localctx, 14, RULE_op2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEGATION || _la==TOKEN) {
				{
				{
				setState(54); operator2();
				}
				}
				setState(59);
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

	public static class Operator2Context extends ParserRuleContext {
		public NegationContext negation() {
			return getRuleContext(NegationContext.class,0);
		}
		public TerminalNode TOKEN() { return getToken(BayesGrammarParser.TOKEN, 0); }
		public Operator2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator2; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BayesGrammarVisitor ) return ((BayesGrammarVisitor<? extends T>)visitor).visitOperator2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Operator2Context operator2() throws RecognitionException {
		Operator2Context _localctx = new Operator2Context(_ctx, getState());
		enterRule(_localctx, 16, RULE_operator2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			_la = _input.LA(1);
			if (_la==NEGATION) {
				{
				setState(60); negation();
				}
			}

			setState(63); match(TOKEN);
			setState(65);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(64); match(T__1);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\rF\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\6\2\26"+
		"\n\2\r\2\16\2\27\3\3\3\3\3\3\3\3\3\3\3\3\5\3 \n\3\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\7\5\7-\n\7\3\7\3\7\5\7\61\n\7\3\b\7\b\64\n\b\f"+
		"\b\16\b\67\13\b\3\t\7\t:\n\t\f\t\16\t=\13\t\3\n\5\n@\n\n\3\n\3\n\5\nD"+
		"\n\n\3\n\2\2\13\2\4\6\b\n\f\16\20\22\2\2D\2\25\3\2\2\2\4\31\3\2\2\2\6"+
		"%\3\2\2\2\b\'\3\2\2\2\n)\3\2\2\2\f,\3\2\2\2\16\65\3\2\2\2\20;\3\2\2\2"+
		"\22?\3\2\2\2\24\26\5\4\3\2\25\24\3\2\2\2\26\27\3\2\2\2\27\25\3\2\2\2\27"+
		"\30\3\2\2\2\30\3\3\2\2\2\31\32\7\3\2\2\32\33\7\4\2\2\33\37\5\16\b\2\34"+
		"\35\5\b\5\2\35\36\5\20\t\2\36 \3\2\2\2\37\34\3\2\2\2\37 \3\2\2\2 !\3\2"+
		"\2\2!\"\7\5\2\2\"#\7\13\2\2#$\5\6\4\2$\5\3\2\2\2%&\7\n\2\2&\7\3\2\2\2"+
		"\'(\7\7\2\2(\t\3\2\2\2)*\7\b\2\2*\13\3\2\2\2+-\5\n\6\2,+\3\2\2\2,-\3\2"+
		"\2\2-.\3\2\2\2.\60\7\t\2\2/\61\7\6\2\2\60/\3\2\2\2\60\61\3\2\2\2\61\r"+
		"\3\2\2\2\62\64\5\f\7\2\63\62\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66"+
		"\3\2\2\2\66\17\3\2\2\2\67\65\3\2\2\28:\5\22\n\298\3\2\2\2:=\3\2\2\2;9"+
		"\3\2\2\2;<\3\2\2\2<\21\3\2\2\2=;\3\2\2\2>@\5\n\6\2?>\3\2\2\2?@\3\2\2\2"+
		"@A\3\2\2\2AC\7\t\2\2BD\7\6\2\2CB\3\2\2\2CD\3\2\2\2D\23\3\2\2\2\n\27\37"+
		",\60\65;?C";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}