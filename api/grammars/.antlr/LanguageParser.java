// Generated from /home/alessandro/Escritorio/Proyecto2_OLC2/OLC2_Proyecto2_201902888/api/grammars/Language.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, INT=52, BOOL=53, 
		FLOAT=54, STRING=55, RUNE=56, Nil=57, ID=58, WS=59, LINE_COMMENT=60, BLOCK_COMMENT=61;
	public static final int
		RULE_program = 0, RULE_dcl = 1, RULE_varDcl = 2, RULE_funcDcl = 3, RULE_params = 4, 
		RULE_param = 5, RULE_stmt = 6, RULE_cases = 7, RULE_defaultSwitch = 8, 
		RULE_forInit = 9, RULE_expr = 10, RULE_sliceDcl = 11, RULE_call = 12, 
		RULE_args = 13, RULE_props = 14, RULE_type = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "dcl", "varDcl", "funcDcl", "params", "param", "stmt", "cases", 
			"defaultSwitch", "forInit", "expr", "sliceDcl", "call", "args", "props", 
			"type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "'='", "';'", "':='", "'func'", "'('", "')'", "'{'", "'}'", 
			"','", "'if'", "'else'", "'switch'", "'for'", "'range'", "'break'", "'continue'", 
			"'fmt.Println('", "'slice.Index'", "'['", "']'", "'return'", "'case'", 
			"':'", "'default'", "'-'", "'*'", "'/'", "'%'", "'+'", "'>'", "'<'", 
			"'>='", "'<='", "'=='", "'!='", "'&&'", "'||'", "'!'", "'+='", "'-='", 
			"'strconv.Atoi'", "'strconv.ParseFloat'", "'++'", "'--'", "'.'", "'int'", 
			"'float64'", "'string'", "'bool'", "'rune'", null, null, null, null, 
			null, "'nil'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "INT", "BOOL", "FLOAT", "STRING", "RUNE", "Nil", 
			"ID", "WS", "LINE_COMMENT", "BLOCK_COMMENT"
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
	public String getGrammarFileName() { return "Language.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public List<DclContext> dcl() {
			return getRuleContexts(DclContext.class);
		}
		public DclContext dcl(int i) {
			return getRuleContext(DclContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 571970896643713378L) != 0)) {
				{
				{
				setState(32);
				dcl();
				}
				}
				setState(37);
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
	public static class DclContext extends ParserRuleContext {
		public VarDclContext varDcl() {
			return getRuleContext(VarDclContext.class,0);
		}
		public FuncDclContext funcDcl() {
			return getRuleContext(FuncDclContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public DclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dcl; }
	}

	public final DclContext dcl() throws RecognitionException {
		DclContext _localctx = new DclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dcl);
		try {
			setState(41);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				varDcl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(39);
				funcDcl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(40);
				stmt();
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
	public static class VarDclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDcl; }
	}

	public final VarDclContext varDcl() throws RecognitionException {
		VarDclContext _localctx = new VarDclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_varDcl);
		try {
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				match(T__0);
				setState(44);
				match(ID);
				setState(45);
				type();
				setState(46);
				match(T__1);
				setState(47);
				expr(0);
				setState(49);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(48);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(51);
				match(T__0);
				setState(52);
				match(ID);
				setState(53);
				type();
				setState(55);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(54);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(57);
				match(ID);
				setState(58);
				match(T__3);
				setState(59);
				expr(0);
				setState(61);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(60);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(63);
				match(ID);
				setState(64);
				type();
				setState(66);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(65);
					match(T__2);
					}
					break;
				}
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
	public static class FuncDclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<DclContext> dcl() {
			return getRuleContexts(DclContext.class);
		}
		public DclContext dcl(int i) {
			return getRuleContext(DclContext.class,i);
		}
		public FuncDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDcl; }
	}

	public final FuncDclContext funcDcl() throws RecognitionException {
		FuncDclContext _localctx = new FuncDclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_funcDcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(T__4);
			setState(71);
			match(ID);
			setState(72);
			match(T__5);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(73);
				params();
				}
			}

			setState(76);
			match(T__6);
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4362862139015168L) != 0)) {
				{
				setState(77);
				type();
				}
			}

			setState(80);
			match(T__7);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 571970896643713378L) != 0)) {
				{
				{
				setState(81);
				dcl();
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(87);
			match(T__8);
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(88);
				match(T__2);
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
	public static class ParamsContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			param();
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(92);
				match(T__9);
				setState(93);
				param();
				}
				}
				setState(98);
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
	public static class ParamContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(ID);
			setState(100);
			type();
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
	public static class StmtContext extends ParserRuleContext {
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	 
		public StmtContext() { }
		public void copyFrom(StmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SwitchStmtContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<CasesContext> cases() {
			return getRuleContexts(CasesContext.class);
		}
		public CasesContext cases(int i) {
			return getRuleContext(CasesContext.class,i);
		}
		public DefaultSwitchContext defaultSwitch() {
			return getRuleContext(DefaultSwitchContext.class,0);
		}
		public SwitchStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SliceIndexContext extends StmtContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SliceIndexContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockStmtContext extends StmtContext {
		public List<DclContext> dcl() {
			return getRuleContexts(DclContext.class);
		}
		public DclContext dcl(int i) {
			return getRuleContext(DclContext.class,i);
		}
		public BlockStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForCondStmtContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public ForCondStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForRangeContext extends StmtContext {
		public List<TerminalNode> ID() { return getTokens(LanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LanguageParser.ID, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public ForRangeContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ContinueStmtContext extends StmtContext {
		public ContinueStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintContext extends StmtContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public PrintContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfStmtContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public IfStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprStmtContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BreakStmtContext extends StmtContext {
		public BreakStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SliceAsignContext extends StmtContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SliceAsignContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForStmtContext extends StmtContext {
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public ForStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStmtContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStmtContext(StmtContext ctx) { copyFrom(ctx); }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_stmt);
		int _la;
		try {
			setState(196);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				_localctx = new ExprStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(102);
				expr(0);
				}
				break;
			case 2:
				_localctx = new BlockStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(103);
				match(T__7);
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 571970896643713378L) != 0)) {
					{
					{
					setState(104);
					dcl();
					}
					}
					setState(109);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(110);
				match(T__8);
				}
				break;
			case 3:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(111);
				match(T__10);
				setState(112);
				expr(0);
				setState(113);
				stmt();
				setState(116);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(114);
					match(T__11);
					setState(115);
					stmt();
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new SwitchStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(118);
				match(T__12);
				setState(119);
				expr(0);
				setState(120);
				match(T__7);
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__22) {
					{
					{
					setState(121);
					cases();
					}
					}
					setState(126);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__24) {
					{
					setState(127);
					defaultSwitch();
					}
				}

				setState(130);
				match(T__8);
				}
				break;
			case 5:
				_localctx = new ForStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(132);
				match(T__13);
				setState(133);
				forInit();
				setState(134);
				expr(0);
				setState(135);
				match(T__2);
				setState(136);
				expr(0);
				setState(137);
				stmt();
				}
				break;
			case 6:
				_localctx = new ForCondStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(139);
				match(T__13);
				setState(140);
				expr(0);
				setState(141);
				stmt();
				}
				break;
			case 7:
				_localctx = new ForRangeContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(143);
				match(T__13);
				setState(144);
				match(ID);
				setState(145);
				match(T__9);
				setState(146);
				match(ID);
				setState(147);
				match(T__3);
				setState(148);
				match(T__14);
				setState(149);
				expr(0);
				setState(150);
				stmt();
				}
				break;
			case 8:
				_localctx = new BreakStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(152);
				match(T__15);
				setState(154);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(153);
					match(T__2);
					}
				}

				}
				break;
			case 9:
				_localctx = new ContinueStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(156);
				match(T__16);
				setState(158);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(157);
					match(T__2);
					}
				}

				}
				break;
			case 10:
				_localctx = new PrintContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(160);
				match(T__17);
				setState(161);
				expr(0);
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(162);
					match(T__9);
					setState(163);
					expr(0);
					}
					}
					setState(168);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(169);
				match(T__6);
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(170);
					match(T__2);
					}
				}

				}
				break;
			case 11:
				_localctx = new SliceIndexContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(173);
				match(T__18);
				setState(174);
				match(T__5);
				setState(175);
				expr(0);
				setState(176);
				match(T__9);
				setState(177);
				expr(0);
				setState(178);
				match(T__6);
				}
				break;
			case 12:
				_localctx = new SliceAsignContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(180);
				match(ID);
				setState(181);
				match(T__19);
				setState(182);
				expr(0);
				setState(183);
				match(T__20);
				setState(184);
				match(T__1);
				setState(185);
				expr(0);
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(186);
					match(T__2);
					}
				}

				}
				break;
			case 13:
				_localctx = new ReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(189);
				match(T__21);
				setState(191);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(190);
					expr(0);
					}
					break;
				}
				setState(194);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(193);
					match(T__2);
					}
				}

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
	public static class CasesContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public CasesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cases; }
	}

	public final CasesContext cases() throws RecognitionException {
		CasesContext _localctx = new CasesContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cases);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			match(T__22);
			setState(199);
			expr(0);
			setState(200);
			match(T__23);
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 571970896643713344L) != 0)) {
				{
				{
				setState(201);
				stmt();
				}
				}
				setState(206);
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
	public static class DefaultSwitchContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public DefaultSwitchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultSwitch; }
	}

	public final DefaultSwitchContext defaultSwitch() throws RecognitionException {
		DefaultSwitchContext _localctx = new DefaultSwitchContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_defaultSwitch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(T__24);
			setState(208);
			match(T__23);
			setState(212);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 571970896643713344L) != 0)) {
				{
				{
				setState(209);
				stmt();
				}
				}
				setState(214);
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
	public static class ForInitContext extends ParserRuleContext {
		public VarDclContext varDcl() {
			return getRuleContext(VarDclContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_forInit);
		try {
			setState(221);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				varDcl();
				setState(216);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
				expr(0);
				setState(219);
				match(T__2);
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
	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CalleeContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<CallContext> call() {
			return getRuleContexts(CallContext.class);
		}
		public CallContext call(int i) {
			return getRuleContext(CallContext.class,i);
		}
		public CalleeContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DecrementContext extends ExprContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public DecrementContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IncDecAssignContext extends ExprContext {
		public Token op;
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IncDecAssignContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AddSubContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AddSubContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParensContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParensContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RelationalContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public RelationalContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public LogicalContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SliceDeclStmtContext extends ExprContext {
		public SliceDclContext sliceDcl() {
			return getRuleContext(SliceDclContext.class,0);
		}
		public SliceDeclStmtContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringContext extends ExprContext {
		public TerminalNode STRING() { return getToken(LanguageParser.STRING, 0); }
		public StringContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntContext extends ExprContext {
		public TerminalNode INT() { return getToken(LanguageParser.INT, 0); }
		public IntContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParseFloatCallContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParseFloatCallContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FloatContext extends ExprContext {
		public TerminalNode FLOAT() { return getToken(LanguageParser.FLOAT, 0); }
		public FloatContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NotContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AccesoSliceContext extends ExprContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AccesoSliceContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MulDivModContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MulDivModContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ExprContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public IdentifierContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IncrementContext extends ExprContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public IncrementContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public AssignContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NegateContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public NegateContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AtoiCallContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AtoiCallContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqualityContext extends ExprContext {
		public Token op;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public EqualityContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanContext extends ExprContext {
		public TerminalNode BOOL() { return getToken(LanguageParser.BOOL, 0); }
		public BooleanContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RuneContext extends ExprContext {
		public TerminalNode RUNE() { return getToken(LanguageParser.RUNE, 0); }
		public RuneContext(ExprContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NillContext extends ExprContext {
		public TerminalNode Nil() { return getToken(LanguageParser.Nil, 0); }
		public NillContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(262);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				_localctx = new NegateContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(224);
				match(T__25);
				setState(225);
				expr(24);
				}
				break;
			case 2:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(226);
				match(T__38);
				setState(227);
				expr(17);
				}
				break;
			case 3:
				{
				_localctx = new IncDecAssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(228);
				match(ID);
				setState(229);
				((IncDecAssignContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__39 || _la==T__40) ) {
					((IncDecAssignContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(230);
				expr(16);
				}
				break;
			case 4:
				{
				_localctx = new SliceDeclStmtContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(231);
				sliceDcl();
				}
				break;
			case 5:
				{
				_localctx = new AccesoSliceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(232);
				match(ID);
				setState(233);
				match(T__19);
				setState(234);
				expr(0);
				setState(235);
				match(T__20);
				}
				break;
			case 6:
				{
				_localctx = new AtoiCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(237);
				match(T__41);
				setState(238);
				match(T__5);
				setState(239);
				expr(0);
				setState(240);
				match(T__6);
				}
				break;
			case 7:
				{
				_localctx = new ParseFloatCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(242);
				match(T__42);
				setState(243);
				match(T__5);
				setState(244);
				expr(0);
				setState(245);
				match(T__6);
				}
				break;
			case 8:
				{
				_localctx = new IncrementContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(247);
				match(ID);
				setState(248);
				match(T__43);
				}
				break;
			case 9:
				{
				_localctx = new DecrementContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(249);
				match(ID);
				setState(250);
				match(T__44);
				}
				break;
			case 10:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(251);
				match(BOOL);
				}
				break;
			case 11:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(252);
				match(FLOAT);
				}
				break;
			case 12:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(253);
				match(STRING);
				}
				break;
			case 13:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(254);
				match(INT);
				}
				break;
			case 14:
				{
				_localctx = new IdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(255);
				match(ID);
				}
				break;
			case 15:
				{
				_localctx = new NillContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(256);
				match(Nil);
				}
				break;
			case 16:
				{
				_localctx = new RuneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(257);
				match(RUNE);
				}
				break;
			case 17:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(258);
				match(T__5);
				setState(259);
				expr(0);
				setState(260);
				match(T__6);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(293);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(291);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivModContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(264);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(265);
						((MulDivModContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 939524096L) != 0)) ) {
							((MulDivModContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(266);
						expr(23);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(267);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(268);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__25 || _la==T__29) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(269);
						expr(22);
						}
						break;
					case 3:
						{
						_localctx = new RelationalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(270);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(271);
						((RelationalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 32212254720L) != 0)) ) {
							((RelationalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(272);
						expr(21);
						}
						break;
					case 4:
						{
						_localctx = new EqualityContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(273);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(274);
						((EqualityContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__34 || _la==T__35) ) {
							((EqualityContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(275);
						expr(20);
						}
						break;
					case 5:
						{
						_localctx = new LogicalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(276);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(277);
						((LogicalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__36 || _la==T__37) ) {
							((LogicalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(278);
						expr(19);
						}
						break;
					case 6:
						{
						_localctx = new CalleeContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(279);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(281); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(280);
								call();
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(283); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					case 7:
						{
						_localctx = new AssignContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(285);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(286);
						match(T__1);
						setState(287);
						expr(0);
						setState(289);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
						case 1:
							{
							setState(288);
							match(T__2);
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(295);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SliceDclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SliceDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sliceDcl; }
	}

	public final SliceDclContext sliceDcl() throws RecognitionException {
		SliceDclContext _localctx = new SliceDclContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_sliceDcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(ID);
			setState(297);
			match(T__3);
			setState(298);
			match(T__19);
			setState(299);
			match(T__20);
			setState(300);
			type();
			setState(301);
			match(T__7);
			setState(302);
			expr(0);
			setState(307);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(303);
				match(T__9);
				setState(304);
				expr(0);
				}
				}
				setState(309);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(310);
			match(T__8);
			setState(312);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				{
				setState(311);
				match(T__2);
				}
				break;
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
	public static class CallContext extends ParserRuleContext {
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
	 
		public CallContext() { }
		public void copyFrom(CallContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncCallContext extends CallContext {
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public FuncCallContext(CallContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GetContext extends CallContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public GetContext(CallContext ctx) { copyFrom(ctx); }
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_call);
		int _la;
		try {
			setState(321);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				_localctx = new FuncCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(314);
				match(T__5);
				setState(316);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 571970896638509120L) != 0)) {
					{
					setState(315);
					args();
					}
				}

				setState(318);
				match(T__6);
				}
				break;
			case T__45:
				_localctx = new GetContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(319);
				match(T__45);
				setState(320);
				match(ID);
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
	public static class ArgsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323);
			expr(0);
			setState(328);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(324);
				match(T__9);
				setState(325);
				expr(0);
				}
				}
				setState(330);
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
	public static class PropsContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(LanguageParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(LanguageParser.ID, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public PropsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_props; }
	}

	public final PropsContext props() throws RecognitionException {
		PropsContext _localctx = new PropsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_props);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(331);
			match(ID);
			setState(332);
			match(T__23);
			setState(333);
			expr(0);
			setState(334);
			match(T__9);
			setState(342);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(335);
				match(ID);
				setState(336);
				match(T__23);
				setState(337);
				expr(0);
				setState(338);
				match(T__9);
				}
				}
				setState(344);
				_errHandler.sync(this);
				_la = _input.LA(1);
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
	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4362862139015168L) != 0)) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 22);
		case 1:
			return precpred(_ctx, 21);
		case 2:
			return precpred(_ctx, 20);
		case 3:
			return precpred(_ctx, 19);
		case 4:
			return precpred(_ctx, 18);
		case 5:
			return precpred(_ctx, 23);
		case 6:
			return precpred(_ctx, 15);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001=\u015c\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0001\u0000\u0005\u0000\"\b\u0000\n\u0000\f\u0000%\t\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001*\b\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u00022\b\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u00028\b\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002>\b\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002C\b\u0002\u0003\u0002"+
		"E\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003"+
		"K\b\u0003\u0001\u0003\u0001\u0003\u0003\u0003O\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0005\u0003S\b\u0003\n\u0003\f\u0003V\t\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003Z\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0005"+
		"\u0004_\b\u0004\n\u0004\f\u0004b\t\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006j\b\u0006\n\u0006"+
		"\f\u0006m\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0003\u0006u\b\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0005\u0006{\b\u0006\n\u0006\f\u0006~\t\u0006\u0001"+
		"\u0006\u0003\u0006\u0081\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u009b\b\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006\u009f\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0005\u0006\u00a5\b\u0006\n\u0006\f\u0006\u00a8\t\u0006\u0001\u0006"+
		"\u0001\u0006\u0003\u0006\u00ac\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"\u00bc\b\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00c0\b\u0006\u0001"+
		"\u0006\u0003\u0006\u00c3\b\u0006\u0003\u0006\u00c5\b\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u00cb\b\u0007\n\u0007"+
		"\f\u0007\u00ce\t\u0007\u0001\b\u0001\b\u0001\b\u0005\b\u00d3\b\b\n\b\f"+
		"\b\u00d6\t\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u00de"+
		"\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0003\n\u0107\b\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0004\n\u011a\b\n\u000b\n\f\n\u011b"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0122\b\n\u0005\n\u0124\b\n\n"+
		"\n\f\n\u0127\t\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u0132"+
		"\b\u000b\n\u000b\f\u000b\u0135\t\u000b\u0001\u000b\u0001\u000b\u0003\u000b"+
		"\u0139\b\u000b\u0001\f\u0001\f\u0003\f\u013d\b\f\u0001\f\u0001\f\u0001"+
		"\f\u0003\f\u0142\b\f\u0001\r\u0001\r\u0001\r\u0005\r\u0147\b\r\n\r\f\r"+
		"\u014a\t\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u0155\b\u000e"+
		"\n\u000e\f\u000e\u0158\t\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0000"+
		"\u0001\u0014\u0010\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e\u0000\u0007\u0001\u0000()\u0001\u0000\u001b"+
		"\u001d\u0002\u0000\u001a\u001a\u001e\u001e\u0001\u0000\u001f\"\u0001\u0000"+
		"#$\u0001\u0000%&\u0001\u0000/3\u0193\u0000#\u0001\u0000\u0000\u0000\u0002"+
		")\u0001\u0000\u0000\u0000\u0004D\u0001\u0000\u0000\u0000\u0006F\u0001"+
		"\u0000\u0000\u0000\b[\u0001\u0000\u0000\u0000\nc\u0001\u0000\u0000\u0000"+
		"\f\u00c4\u0001\u0000\u0000\u0000\u000e\u00c6\u0001\u0000\u0000\u0000\u0010"+
		"\u00cf\u0001\u0000\u0000\u0000\u0012\u00dd\u0001\u0000\u0000\u0000\u0014"+
		"\u0106\u0001\u0000\u0000\u0000\u0016\u0128\u0001\u0000\u0000\u0000\u0018"+
		"\u0141\u0001\u0000\u0000\u0000\u001a\u0143\u0001\u0000\u0000\u0000\u001c"+
		"\u014b\u0001\u0000\u0000\u0000\u001e\u0159\u0001\u0000\u0000\u0000 \""+
		"\u0003\u0002\u0001\u0000! \u0001\u0000\u0000\u0000\"%\u0001\u0000\u0000"+
		"\u0000#!\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000$\u0001\u0001"+
		"\u0000\u0000\u0000%#\u0001\u0000\u0000\u0000&*\u0003\u0004\u0002\u0000"+
		"\'*\u0003\u0006\u0003\u0000(*\u0003\f\u0006\u0000)&\u0001\u0000\u0000"+
		"\u0000)\'\u0001\u0000\u0000\u0000)(\u0001\u0000\u0000\u0000*\u0003\u0001"+
		"\u0000\u0000\u0000+,\u0005\u0001\u0000\u0000,-\u0005:\u0000\u0000-.\u0003"+
		"\u001e\u000f\u0000./\u0005\u0002\u0000\u0000/1\u0003\u0014\n\u000002\u0005"+
		"\u0003\u0000\u000010\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u0000"+
		"2E\u0001\u0000\u0000\u000034\u0005\u0001\u0000\u000045\u0005:\u0000\u0000"+
		"57\u0003\u001e\u000f\u000068\u0005\u0003\u0000\u000076\u0001\u0000\u0000"+
		"\u000078\u0001\u0000\u0000\u00008E\u0001\u0000\u0000\u00009:\u0005:\u0000"+
		"\u0000:;\u0005\u0004\u0000\u0000;=\u0003\u0014\n\u0000<>\u0005\u0003\u0000"+
		"\u0000=<\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>E\u0001\u0000"+
		"\u0000\u0000?@\u0005:\u0000\u0000@B\u0003\u001e\u000f\u0000AC\u0005\u0003"+
		"\u0000\u0000BA\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000CE\u0001"+
		"\u0000\u0000\u0000D+\u0001\u0000\u0000\u0000D3\u0001\u0000\u0000\u0000"+
		"D9\u0001\u0000\u0000\u0000D?\u0001\u0000\u0000\u0000E\u0005\u0001\u0000"+
		"\u0000\u0000FG\u0005\u0005\u0000\u0000GH\u0005:\u0000\u0000HJ\u0005\u0006"+
		"\u0000\u0000IK\u0003\b\u0004\u0000JI\u0001\u0000\u0000\u0000JK\u0001\u0000"+
		"\u0000\u0000KL\u0001\u0000\u0000\u0000LN\u0005\u0007\u0000\u0000MO\u0003"+
		"\u001e\u000f\u0000NM\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000"+
		"OP\u0001\u0000\u0000\u0000PT\u0005\b\u0000\u0000QS\u0003\u0002\u0001\u0000"+
		"RQ\u0001\u0000\u0000\u0000SV\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000"+
		"\u0000TU\u0001\u0000\u0000\u0000UW\u0001\u0000\u0000\u0000VT\u0001\u0000"+
		"\u0000\u0000WY\u0005\t\u0000\u0000XZ\u0005\u0003\u0000\u0000YX\u0001\u0000"+
		"\u0000\u0000YZ\u0001\u0000\u0000\u0000Z\u0007\u0001\u0000\u0000\u0000"+
		"[`\u0003\n\u0005\u0000\\]\u0005\n\u0000\u0000]_\u0003\n\u0005\u0000^\\"+
		"\u0001\u0000\u0000\u0000_b\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000"+
		"\u0000`a\u0001\u0000\u0000\u0000a\t\u0001\u0000\u0000\u0000b`\u0001\u0000"+
		"\u0000\u0000cd\u0005:\u0000\u0000de\u0003\u001e\u000f\u0000e\u000b\u0001"+
		"\u0000\u0000\u0000f\u00c5\u0003\u0014\n\u0000gk\u0005\b\u0000\u0000hj"+
		"\u0003\u0002\u0001\u0000ih\u0001\u0000\u0000\u0000jm\u0001\u0000\u0000"+
		"\u0000ki\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000ln\u0001\u0000"+
		"\u0000\u0000mk\u0001\u0000\u0000\u0000n\u00c5\u0005\t\u0000\u0000op\u0005"+
		"\u000b\u0000\u0000pq\u0003\u0014\n\u0000qt\u0003\f\u0006\u0000rs\u0005"+
		"\f\u0000\u0000su\u0003\f\u0006\u0000tr\u0001\u0000\u0000\u0000tu\u0001"+
		"\u0000\u0000\u0000u\u00c5\u0001\u0000\u0000\u0000vw\u0005\r\u0000\u0000"+
		"wx\u0003\u0014\n\u0000x|\u0005\b\u0000\u0000y{\u0003\u000e\u0007\u0000"+
		"zy\u0001\u0000\u0000\u0000{~\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000"+
		"\u0000|}\u0001\u0000\u0000\u0000}\u0080\u0001\u0000\u0000\u0000~|\u0001"+
		"\u0000\u0000\u0000\u007f\u0081\u0003\u0010\b\u0000\u0080\u007f\u0001\u0000"+
		"\u0000\u0000\u0080\u0081\u0001\u0000\u0000\u0000\u0081\u0082\u0001\u0000"+
		"\u0000\u0000\u0082\u0083\u0005\t\u0000\u0000\u0083\u00c5\u0001\u0000\u0000"+
		"\u0000\u0084\u0085\u0005\u000e\u0000\u0000\u0085\u0086\u0003\u0012\t\u0000"+
		"\u0086\u0087\u0003\u0014\n\u0000\u0087\u0088\u0005\u0003\u0000\u0000\u0088"+
		"\u0089\u0003\u0014\n\u0000\u0089\u008a\u0003\f\u0006\u0000\u008a\u00c5"+
		"\u0001\u0000\u0000\u0000\u008b\u008c\u0005\u000e\u0000\u0000\u008c\u008d"+
		"\u0003\u0014\n\u0000\u008d\u008e\u0003\f\u0006\u0000\u008e\u00c5\u0001"+
		"\u0000\u0000\u0000\u008f\u0090\u0005\u000e\u0000\u0000\u0090\u0091\u0005"+
		":\u0000\u0000\u0091\u0092\u0005\n\u0000\u0000\u0092\u0093\u0005:\u0000"+
		"\u0000\u0093\u0094\u0005\u0004\u0000\u0000\u0094\u0095\u0005\u000f\u0000"+
		"\u0000\u0095\u0096\u0003\u0014\n\u0000\u0096\u0097\u0003\f\u0006\u0000"+
		"\u0097\u00c5\u0001\u0000\u0000\u0000\u0098\u009a\u0005\u0010\u0000\u0000"+
		"\u0099\u009b\u0005\u0003\u0000\u0000\u009a\u0099\u0001\u0000\u0000\u0000"+
		"\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u00c5\u0001\u0000\u0000\u0000"+
		"\u009c\u009e\u0005\u0011\u0000\u0000\u009d\u009f\u0005\u0003\u0000\u0000"+
		"\u009e\u009d\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000\u0000"+
		"\u009f\u00c5\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005\u0012\u0000\u0000"+
		"\u00a1\u00a6\u0003\u0014\n\u0000\u00a2\u00a3\u0005\n\u0000\u0000\u00a3"+
		"\u00a5\u0003\u0014\n\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a5\u00a8"+
		"\u0001\u0000\u0000\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a7"+
		"\u0001\u0000\u0000\u0000\u00a7\u00a9\u0001\u0000\u0000\u0000\u00a8\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a9\u00ab\u0005\u0007\u0000\u0000\u00aa\u00ac"+
		"\u0005\u0003\u0000\u0000\u00ab\u00aa\u0001\u0000\u0000\u0000\u00ab\u00ac"+
		"\u0001\u0000\u0000\u0000\u00ac\u00c5\u0001\u0000\u0000\u0000\u00ad\u00ae"+
		"\u0005\u0013\u0000\u0000\u00ae\u00af\u0005\u0006\u0000\u0000\u00af\u00b0"+
		"\u0003\u0014\n\u0000\u00b0\u00b1\u0005\n\u0000\u0000\u00b1\u00b2\u0003"+
		"\u0014\n\u0000\u00b2\u00b3\u0005\u0007\u0000\u0000\u00b3\u00c5\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b5\u0005:\u0000\u0000\u00b5\u00b6\u0005\u0014\u0000"+
		"\u0000\u00b6\u00b7\u0003\u0014\n\u0000\u00b7\u00b8\u0005\u0015\u0000\u0000"+
		"\u00b8\u00b9\u0005\u0002\u0000\u0000\u00b9\u00bb\u0003\u0014\n\u0000\u00ba"+
		"\u00bc\u0005\u0003\u0000\u0000\u00bb\u00ba\u0001\u0000\u0000\u0000\u00bb"+
		"\u00bc\u0001\u0000\u0000\u0000\u00bc\u00c5\u0001\u0000\u0000\u0000\u00bd"+
		"\u00bf\u0005\u0016\u0000\u0000\u00be\u00c0\u0003\u0014\n\u0000\u00bf\u00be"+
		"\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0\u00c2"+
		"\u0001\u0000\u0000\u0000\u00c1\u00c3\u0005\u0003\u0000\u0000\u00c2\u00c1"+
		"\u0001\u0000\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3\u00c5"+
		"\u0001\u0000\u0000\u0000\u00c4f\u0001\u0000\u0000\u0000\u00c4g\u0001\u0000"+
		"\u0000\u0000\u00c4o\u0001\u0000\u0000\u0000\u00c4v\u0001\u0000\u0000\u0000"+
		"\u00c4\u0084\u0001\u0000\u0000\u0000\u00c4\u008b\u0001\u0000\u0000\u0000"+
		"\u00c4\u008f\u0001\u0000\u0000\u0000\u00c4\u0098\u0001\u0000\u0000\u0000"+
		"\u00c4\u009c\u0001\u0000\u0000\u0000\u00c4\u00a0\u0001\u0000\u0000\u0000"+
		"\u00c4\u00ad\u0001\u0000\u0000\u0000\u00c4\u00b4\u0001\u0000\u0000\u0000"+
		"\u00c4\u00bd\u0001\u0000\u0000\u0000\u00c5\r\u0001\u0000\u0000\u0000\u00c6"+
		"\u00c7\u0005\u0017\u0000\u0000\u00c7\u00c8\u0003\u0014\n\u0000\u00c8\u00cc"+
		"\u0005\u0018\u0000\u0000\u00c9\u00cb\u0003\f\u0006\u0000\u00ca\u00c9\u0001"+
		"\u0000\u0000\u0000\u00cb\u00ce\u0001\u0000\u0000\u0000\u00cc\u00ca\u0001"+
		"\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd\u000f\u0001"+
		"\u0000\u0000\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000\u00cf\u00d0\u0005"+
		"\u0019\u0000\u0000\u00d0\u00d4\u0005\u0018\u0000\u0000\u00d1\u00d3\u0003"+
		"\f\u0006\u0000\u00d2\u00d1\u0001\u0000\u0000\u0000\u00d3\u00d6\u0001\u0000"+
		"\u0000\u0000\u00d4\u00d2\u0001\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000"+
		"\u0000\u0000\u00d5\u0011\u0001\u0000\u0000\u0000\u00d6\u00d4\u0001\u0000"+
		"\u0000\u0000\u00d7\u00d8\u0003\u0004\u0002\u0000\u00d8\u00d9\u0005\u0003"+
		"\u0000\u0000\u00d9\u00de\u0001\u0000\u0000\u0000\u00da\u00db\u0003\u0014"+
		"\n\u0000\u00db\u00dc\u0005\u0003\u0000\u0000\u00dc\u00de\u0001\u0000\u0000"+
		"\u0000\u00dd\u00d7\u0001\u0000\u0000\u0000\u00dd\u00da\u0001\u0000\u0000"+
		"\u0000\u00de\u0013\u0001\u0000\u0000\u0000\u00df\u00e0\u0006\n\uffff\uffff"+
		"\u0000\u00e0\u00e1\u0005\u001a\u0000\u0000\u00e1\u0107\u0003\u0014\n\u0018"+
		"\u00e2\u00e3\u0005\'\u0000\u0000\u00e3\u0107\u0003\u0014\n\u0011\u00e4"+
		"\u00e5\u0005:\u0000\u0000\u00e5\u00e6\u0007\u0000\u0000\u0000\u00e6\u0107"+
		"\u0003\u0014\n\u0010\u00e7\u0107\u0003\u0016\u000b\u0000\u00e8\u00e9\u0005"+
		":\u0000\u0000\u00e9\u00ea\u0005\u0014\u0000\u0000\u00ea\u00eb\u0003\u0014"+
		"\n\u0000\u00eb\u00ec\u0005\u0015\u0000\u0000\u00ec\u0107\u0001\u0000\u0000"+
		"\u0000\u00ed\u00ee\u0005*\u0000\u0000\u00ee\u00ef\u0005\u0006\u0000\u0000"+
		"\u00ef\u00f0\u0003\u0014\n\u0000\u00f0\u00f1\u0005\u0007\u0000\u0000\u00f1"+
		"\u0107\u0001\u0000\u0000\u0000\u00f2\u00f3\u0005+\u0000\u0000\u00f3\u00f4"+
		"\u0005\u0006\u0000\u0000\u00f4\u00f5\u0003\u0014\n\u0000\u00f5\u00f6\u0005"+
		"\u0007\u0000\u0000\u00f6\u0107\u0001\u0000\u0000\u0000\u00f7\u00f8\u0005"+
		":\u0000\u0000\u00f8\u0107\u0005,\u0000\u0000\u00f9\u00fa\u0005:\u0000"+
		"\u0000\u00fa\u0107\u0005-\u0000\u0000\u00fb\u0107\u00055\u0000\u0000\u00fc"+
		"\u0107\u00056\u0000\u0000\u00fd\u0107\u00057\u0000\u0000\u00fe\u0107\u0005"+
		"4\u0000\u0000\u00ff\u0107\u0005:\u0000\u0000\u0100\u0107\u00059\u0000"+
		"\u0000\u0101\u0107\u00058\u0000\u0000\u0102\u0103\u0005\u0006\u0000\u0000"+
		"\u0103\u0104\u0003\u0014\n\u0000\u0104\u0105\u0005\u0007\u0000\u0000\u0105"+
		"\u0107\u0001\u0000\u0000\u0000\u0106\u00df\u0001\u0000\u0000\u0000\u0106"+
		"\u00e2\u0001\u0000\u0000\u0000\u0106\u00e4\u0001\u0000\u0000\u0000\u0106"+
		"\u00e7\u0001\u0000\u0000\u0000\u0106\u00e8\u0001\u0000\u0000\u0000\u0106"+
		"\u00ed\u0001\u0000\u0000\u0000\u0106\u00f2\u0001\u0000\u0000\u0000\u0106"+
		"\u00f7\u0001\u0000\u0000\u0000\u0106\u00f9\u0001\u0000\u0000\u0000\u0106"+
		"\u00fb\u0001\u0000\u0000\u0000\u0106\u00fc\u0001\u0000\u0000\u0000\u0106"+
		"\u00fd\u0001\u0000\u0000\u0000\u0106\u00fe\u0001\u0000\u0000\u0000\u0106"+
		"\u00ff\u0001\u0000\u0000\u0000\u0106\u0100\u0001\u0000\u0000\u0000\u0106"+
		"\u0101\u0001\u0000\u0000\u0000\u0106\u0102\u0001\u0000\u0000\u0000\u0107"+
		"\u0125\u0001\u0000\u0000\u0000\u0108\u0109\n\u0016\u0000\u0000\u0109\u010a"+
		"\u0007\u0001\u0000\u0000\u010a\u0124\u0003\u0014\n\u0017\u010b\u010c\n"+
		"\u0015\u0000\u0000\u010c\u010d\u0007\u0002\u0000\u0000\u010d\u0124\u0003"+
		"\u0014\n\u0016\u010e\u010f\n\u0014\u0000\u0000\u010f\u0110\u0007\u0003"+
		"\u0000\u0000\u0110\u0124\u0003\u0014\n\u0015\u0111\u0112\n\u0013\u0000"+
		"\u0000\u0112\u0113\u0007\u0004\u0000\u0000\u0113\u0124\u0003\u0014\n\u0014"+
		"\u0114\u0115\n\u0012\u0000\u0000\u0115\u0116\u0007\u0005\u0000\u0000\u0116"+
		"\u0124\u0003\u0014\n\u0013\u0117\u0119\n\u0017\u0000\u0000\u0118\u011a"+
		"\u0003\u0018\f\u0000\u0119\u0118\u0001\u0000\u0000\u0000\u011a\u011b\u0001"+
		"\u0000\u0000\u0000\u011b\u0119\u0001\u0000\u0000\u0000\u011b\u011c\u0001"+
		"\u0000\u0000\u0000\u011c\u0124\u0001\u0000\u0000\u0000\u011d\u011e\n\u000f"+
		"\u0000\u0000\u011e\u011f\u0005\u0002\u0000\u0000\u011f\u0121\u0003\u0014"+
		"\n\u0000\u0120\u0122\u0005\u0003\u0000\u0000\u0121\u0120\u0001\u0000\u0000"+
		"\u0000\u0121\u0122\u0001\u0000\u0000\u0000\u0122\u0124\u0001\u0000\u0000"+
		"\u0000\u0123\u0108\u0001\u0000\u0000\u0000\u0123\u010b\u0001\u0000\u0000"+
		"\u0000\u0123\u010e\u0001\u0000\u0000\u0000\u0123\u0111\u0001\u0000\u0000"+
		"\u0000\u0123\u0114\u0001\u0000\u0000\u0000\u0123\u0117\u0001\u0000\u0000"+
		"\u0000\u0123\u011d\u0001\u0000\u0000\u0000\u0124\u0127\u0001\u0000\u0000"+
		"\u0000\u0125\u0123\u0001\u0000\u0000\u0000\u0125\u0126\u0001\u0000\u0000"+
		"\u0000\u0126\u0015\u0001\u0000\u0000\u0000\u0127\u0125\u0001\u0000\u0000"+
		"\u0000\u0128\u0129\u0005:\u0000\u0000\u0129\u012a\u0005\u0004\u0000\u0000"+
		"\u012a\u012b\u0005\u0014\u0000\u0000\u012b\u012c\u0005\u0015\u0000\u0000"+
		"\u012c\u012d\u0003\u001e\u000f\u0000\u012d\u012e\u0005\b\u0000\u0000\u012e"+
		"\u0133\u0003\u0014\n\u0000\u012f\u0130\u0005\n\u0000\u0000\u0130\u0132"+
		"\u0003\u0014\n\u0000\u0131\u012f\u0001\u0000\u0000\u0000\u0132\u0135\u0001"+
		"\u0000\u0000\u0000\u0133\u0131\u0001\u0000\u0000\u0000\u0133\u0134\u0001"+
		"\u0000\u0000\u0000\u0134\u0136\u0001\u0000\u0000\u0000\u0135\u0133\u0001"+
		"\u0000\u0000\u0000\u0136\u0138\u0005\t\u0000\u0000\u0137\u0139\u0005\u0003"+
		"\u0000\u0000\u0138\u0137\u0001\u0000\u0000\u0000\u0138\u0139\u0001\u0000"+
		"\u0000\u0000\u0139\u0017\u0001\u0000\u0000\u0000\u013a\u013c\u0005\u0006"+
		"\u0000\u0000\u013b\u013d\u0003\u001a\r\u0000\u013c\u013b\u0001\u0000\u0000"+
		"\u0000\u013c\u013d\u0001\u0000\u0000\u0000\u013d\u013e\u0001\u0000\u0000"+
		"\u0000\u013e\u0142\u0005\u0007\u0000\u0000\u013f\u0140\u0005.\u0000\u0000"+
		"\u0140\u0142\u0005:\u0000\u0000\u0141\u013a\u0001\u0000\u0000\u0000\u0141"+
		"\u013f\u0001\u0000\u0000\u0000\u0142\u0019\u0001\u0000\u0000\u0000\u0143"+
		"\u0148\u0003\u0014\n\u0000\u0144\u0145\u0005\n\u0000\u0000\u0145\u0147"+
		"\u0003\u0014\n\u0000\u0146\u0144\u0001\u0000\u0000\u0000\u0147\u014a\u0001"+
		"\u0000\u0000\u0000\u0148\u0146\u0001\u0000\u0000\u0000\u0148\u0149\u0001"+
		"\u0000\u0000\u0000\u0149\u001b\u0001\u0000\u0000\u0000\u014a\u0148\u0001"+
		"\u0000\u0000\u0000\u014b\u014c\u0005:\u0000\u0000\u014c\u014d\u0005\u0018"+
		"\u0000\u0000\u014d\u014e\u0003\u0014\n\u0000\u014e\u0156\u0005\n\u0000"+
		"\u0000\u014f\u0150\u0005:\u0000\u0000\u0150\u0151\u0005\u0018\u0000\u0000"+
		"\u0151\u0152\u0003\u0014\n\u0000\u0152\u0153\u0005\n\u0000\u0000\u0153"+
		"\u0155\u0001\u0000\u0000\u0000\u0154\u014f\u0001\u0000\u0000\u0000\u0155"+
		"\u0158\u0001\u0000\u0000\u0000\u0156\u0154\u0001\u0000\u0000\u0000\u0156"+
		"\u0157\u0001\u0000\u0000\u0000\u0157\u001d\u0001\u0000\u0000\u0000\u0158"+
		"\u0156\u0001\u0000\u0000\u0000\u0159\u015a\u0007\u0006\u0000\u0000\u015a"+
		"\u001f\u0001\u0000\u0000\u0000&#)17=BDJNTY`kt|\u0080\u009a\u009e\u00a6"+
		"\u00ab\u00bb\u00bf\u00c2\u00c4\u00cc\u00d4\u00dd\u0106\u011b\u0121\u0123"+
		"\u0125\u0133\u0138\u013c\u0141\u0148\u0156";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}