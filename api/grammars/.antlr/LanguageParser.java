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
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, INT=51, BOOL=52, FLOAT=53, 
		STRING=54, RUNE=55, Nil=56, ID=57, WS=58, LINE_COMMENT=59, BLOCK_COMMENT=60;
	public static final int
		RULE_program = 0, RULE_dcl = 1, RULE_varDcl = 2, RULE_matrix = 3, RULE_slice = 4, 
		RULE_funcDcl = 5, RULE_structDcl = 6, RULE_params = 7, RULE_param = 8, 
		RULE_stmt = 9, RULE_cases = 10, RULE_defaultSwitch = 11, RULE_forInit = 12, 
		RULE_expr = 13, RULE_call = 14, RULE_args = 15, RULE_props = 16, RULE_type = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "dcl", "varDcl", "matrix", "slice", "funcDcl", "structDcl", 
			"params", "param", "stmt", "cases", "defaultSwitch", "forInit", "expr", 
			"call", "args", "props", "type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'var'", "'='", "';'", "':='", "'['", "']'", "'{'", "'}'", "','", 
			"'func'", "'('", "')'", "'type'", "'struct'", "'if'", "'else'", "'switch'", 
			"'for'", "'range'", "'break'", "'continue'", "'fmt.Println('", "'return'", 
			"'case'", "':'", "'default'", "'-'", "'*'", "'/'", "'%'", "'+'", "'>'", 
			"'<'", "'>='", "'<='", "'=='", "'!='", "'&&'", "'||'", "'!'", "'+='", 
			"'-='", "'++'", "'--'", "'.'", "'int'", "'float64'", "'string'", "'bool'", 
			"'rune'", null, null, null, null, null, "'nil'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "INT", "BOOL", "FLOAT", "STRING", "RUNE", "Nil", "ID", 
			"WS", "LINE_COMMENT", "BLOCK_COMMENT"
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
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 285979676000038050L) != 0)) {
				{
				{
				setState(36);
				dcl();
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

	@SuppressWarnings("CheckReturnValue")
	public static class DclContext extends ParserRuleContext {
		public VarDclContext varDcl() {
			return getRuleContext(VarDclContext.class,0);
		}
		public FuncDclContext funcDcl() {
			return getRuleContext(FuncDclContext.class,0);
		}
		public StructDclContext structDcl() {
			return getRuleContext(StructDclContext.class,0);
		}
		public SliceContext slice() {
			return getRuleContext(SliceContext.class,0);
		}
		public MatrixContext matrix() {
			return getRuleContext(MatrixContext.class,0);
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
			setState(48);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				varDcl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				funcDcl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(44);
				structDcl();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(45);
				slice();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(46);
				matrix();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(47);
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
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				match(T__0);
				setState(51);
				match(ID);
				setState(52);
				type();
				setState(53);
				match(T__1);
				setState(54);
				expr(0);
				setState(56);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(55);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(58);
				match(T__0);
				setState(59);
				match(ID);
				setState(60);
				type();
				setState(62);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(61);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(64);
				match(ID);
				setState(65);
				match(T__3);
				setState(66);
				expr(0);
				setState(68);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(67);
					match(T__2);
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(70);
				match(ID);
				setState(71);
				type();
				setState(73);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(72);
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
	public static class MatrixContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<ArgsContext> args() {
			return getRuleContexts(ArgsContext.class);
		}
		public ArgsContext args(int i) {
			return getRuleContext(ArgsContext.class,i);
		}
		public MatrixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matrix; }
	}

	public final MatrixContext matrix() throws RecognitionException {
		MatrixContext _localctx = new MatrixContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_matrix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(ID);
			setState(78);
			match(T__3);
			setState(79);
			match(T__4);
			setState(80);
			match(T__5);
			setState(81);
			match(T__4);
			setState(82);
			match(T__5);
			setState(83);
			type();
			setState(84);
			match(T__6);
			setState(85);
			match(T__6);
			setState(86);
			args();
			setState(87);
			match(T__7);
			setState(88);
			match(T__8);
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(89);
				match(T__6);
				setState(90);
				args();
				setState(91);
				match(T__7);
				setState(92);
				match(T__8);
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(99);
			match(T__7);
			setState(101);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(100);
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
	public static class SliceContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public SliceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slice; }
	}

	public final SliceContext slice() throws RecognitionException {
		SliceContext _localctx = new SliceContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_slice);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(T__0);
			setState(104);
			match(ID);
			setState(105);
			match(T__4);
			setState(106);
			match(T__5);
			setState(107);
			type();
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(108);
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
		enterRule(_localctx, 10, RULE_funcDcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(T__9);
			setState(112);
			match(ID);
			setState(113);
			match(T__10);
			setState(115);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(114);
				params();
				}
			}

			setState(117);
			match(T__11);
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2181431069507584L) != 0)) {
				{
				setState(118);
				type();
				}
			}

			setState(121);
			match(T__6);
			setState(125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 285979676000038050L) != 0)) {
				{
				{
				setState(122);
				dcl();
				}
				}
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(128);
			match(T__7);
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(129);
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
	public static class StructDclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public List<VarDclContext> varDcl() {
			return getRuleContexts(VarDclContext.class);
		}
		public VarDclContext varDcl(int i) {
			return getRuleContext(VarDclContext.class,i);
		}
		public StructDclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structDcl; }
	}

	public final StructDclContext structDcl() throws RecognitionException {
		StructDclContext _localctx = new StructDclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_structDcl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(T__12);
			setState(133);
			match(ID);
			setState(134);
			match(T__13);
			setState(135);
			match(T__6);
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0 || _la==ID) {
				{
				{
				setState(136);
				varDcl();
				}
				}
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(142);
			match(T__7);
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
		enterRule(_localctx, 14, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			param();
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(145);
				match(T__8);
				setState(146);
				param();
				}
				}
				setState(151);
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
		enterRule(_localctx, 16, RULE_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			match(ID);
			setState(153);
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
		enterRule(_localctx, 18, RULE_stmt);
		int _la;
		try {
			setState(233);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				_localctx = new ExprStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				expr(0);
				}
				break;
			case 2:
				_localctx = new BlockStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(156);
				match(T__6);
				setState(160);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 285979676000038050L) != 0)) {
					{
					{
					setState(157);
					dcl();
					}
					}
					setState(162);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(163);
				match(T__7);
				}
				break;
			case 3:
				_localctx = new IfStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(164);
				match(T__14);
				setState(165);
				expr(0);
				setState(166);
				stmt();
				setState(169);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(167);
					match(T__15);
					setState(168);
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
				setState(171);
				match(T__16);
				setState(172);
				expr(0);
				setState(173);
				match(T__6);
				setState(177);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__23) {
					{
					{
					setState(174);
					cases();
					}
					}
					setState(179);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__25) {
					{
					setState(180);
					defaultSwitch();
					}
				}

				setState(183);
				match(T__7);
				}
				break;
			case 5:
				_localctx = new ForStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(185);
				match(T__17);
				setState(186);
				forInit();
				setState(187);
				expr(0);
				setState(188);
				match(T__2);
				setState(189);
				expr(0);
				setState(190);
				stmt();
				}
				break;
			case 6:
				_localctx = new ForCondStmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(192);
				match(T__17);
				setState(193);
				expr(0);
				setState(194);
				stmt();
				}
				break;
			case 7:
				_localctx = new ForRangeContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(196);
				match(T__17);
				setState(197);
				match(ID);
				setState(198);
				match(T__8);
				setState(199);
				match(ID);
				setState(200);
				match(T__3);
				setState(201);
				match(T__18);
				setState(202);
				expr(0);
				setState(203);
				stmt();
				}
				break;
			case 8:
				_localctx = new BreakStmtContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(205);
				match(T__19);
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(206);
					match(T__2);
					}
				}

				}
				break;
			case 9:
				_localctx = new ContinueStmtContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(209);
				match(T__20);
				setState(211);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(210);
					match(T__2);
					}
				}

				}
				break;
			case 10:
				_localctx = new PrintContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(213);
				match(T__21);
				setState(214);
				expr(0);
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(215);
					match(T__8);
					setState(216);
					expr(0);
					}
					}
					setState(221);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(222);
				match(T__11);
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(223);
					match(T__2);
					}
				}

				}
				break;
			case 11:
				_localctx = new ReturnStmtContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(226);
				match(T__22);
				setState(228);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(227);
					expr(0);
					}
					break;
				}
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__2) {
					{
					setState(230);
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
		enterRule(_localctx, 20, RULE_cases);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			match(T__23);
			setState(236);
			expr(0);
			setState(237);
			match(T__24);
			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 285979676000028832L) != 0)) {
				{
				{
				setState(238);
				stmt();
				}
				}
				setState(243);
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
		enterRule(_localctx, 22, RULE_defaultSwitch);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244);
			match(T__25);
			setState(245);
			match(T__24);
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 285979676000028832L) != 0)) {
				{
				{
				setState(246);
				stmt();
				}
				}
				setState(251);
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
		enterRule(_localctx, 24, RULE_forInit);
		try {
			setState(258);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(252);
				varDcl();
				setState(253);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(255);
				expr(0);
				setState(256);
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
	public static class MatrixIndexContext extends ExprContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public MatrixIndexContext(ExprContext ctx) { copyFrom(ctx); }
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
	public static class SlicesContext extends ExprContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public SlicesContext(ExprContext ctx) { copyFrom(ctx); }
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
	public static class InStructContext extends ExprContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public PropsContext props() {
			return getRuleContext(PropsContext.class,0);
		}
		public InStructContext(ExprContext ctx) { copyFrom(ctx); }
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
	public static class IndexContext extends ExprContext {
		public TerminalNode ID() { return getToken(LanguageParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IndexContext(ExprContext ctx) { copyFrom(ctx); }
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
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				_localctx = new NegateContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(261);
				match(T__26);
				setState(262);
				expr(24);
				}
				break;
			case 2:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(263);
				match(T__39);
				setState(264);
				expr(17);
				}
				break;
			case 3:
				{
				_localctx = new IncDecAssignContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(265);
				match(ID);
				setState(266);
				((IncDecAssignContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__40 || _la==T__41) ) {
					((IncDecAssignContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(267);
				expr(16);
				}
				break;
			case 4:
				{
				_localctx = new SlicesContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(268);
				match(T__4);
				setState(269);
				match(T__5);
				setState(270);
				type();
				setState(271);
				match(T__6);
				setState(272);
				args();
				setState(273);
				match(T__7);
				}
				break;
			case 5:
				{
				_localctx = new IndexContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(275);
				match(ID);
				setState(276);
				match(T__4);
				setState(277);
				expr(0);
				setState(278);
				match(T__5);
				}
				break;
			case 6:
				{
				_localctx = new MatrixIndexContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(280);
				match(ID);
				setState(281);
				match(T__4);
				setState(282);
				expr(0);
				setState(283);
				match(T__5);
				setState(284);
				match(T__4);
				setState(285);
				expr(0);
				setState(286);
				match(T__5);
				}
				break;
			case 7:
				{
				_localctx = new IncrementContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(288);
				match(ID);
				setState(289);
				match(T__42);
				}
				break;
			case 8:
				{
				_localctx = new DecrementContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(290);
				match(ID);
				setState(291);
				match(T__43);
				}
				break;
			case 9:
				{
				_localctx = new InStructContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(292);
				match(ID);
				setState(293);
				match(T__6);
				setState(294);
				props();
				setState(295);
				match(T__7);
				}
				break;
			case 10:
				{
				_localctx = new BooleanContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(297);
				match(BOOL);
				}
				break;
			case 11:
				{
				_localctx = new FloatContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(298);
				match(FLOAT);
				}
				break;
			case 12:
				{
				_localctx = new StringContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(299);
				match(STRING);
				}
				break;
			case 13:
				{
				_localctx = new IntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(300);
				match(INT);
				}
				break;
			case 14:
				{
				_localctx = new IdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(301);
				match(ID);
				}
				break;
			case 15:
				{
				_localctx = new NillContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(302);
				match(Nil);
				}
				break;
			case 16:
				{
				_localctx = new RuneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(303);
				match(RUNE);
				}
				break;
			case 17:
				{
				_localctx = new ParensContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(304);
				match(T__10);
				setState(305);
				expr(0);
				setState(306);
				match(T__11);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(339);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(337);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						_localctx = new MulDivModContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(310);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(311);
						((MulDivModContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1879048192L) != 0)) ) {
							((MulDivModContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(312);
						expr(23);
						}
						break;
					case 2:
						{
						_localctx = new AddSubContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(313);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(314);
						((AddSubContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__26 || _la==T__30) ) {
							((AddSubContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(315);
						expr(22);
						}
						break;
					case 3:
						{
						_localctx = new RelationalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(316);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(317);
						((RelationalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 64424509440L) != 0)) ) {
							((RelationalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(318);
						expr(21);
						}
						break;
					case 4:
						{
						_localctx = new EqualityContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(319);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(320);
						((EqualityContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__35 || _la==T__36) ) {
							((EqualityContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(321);
						expr(20);
						}
						break;
					case 5:
						{
						_localctx = new LogicalContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(322);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(323);
						((LogicalContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__37 || _la==T__38) ) {
							((LogicalContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(324);
						expr(19);
						}
						break;
					case 6:
						{
						_localctx = new CalleeContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(325);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(327); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(326);
								call();
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(329); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					case 7:
						{
						_localctx = new AssignContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(331);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(332);
						match(T__1);
						setState(333);
						expr(0);
						setState(335);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
						case 1:
							{
							setState(334);
							match(T__2);
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(341);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
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
		enterRule(_localctx, 28, RULE_call);
		int _la;
		try {
			setState(349);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				_localctx = new FuncCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(342);
				match(T__10);
				setState(344);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 285979675983874080L) != 0)) {
					{
					setState(343);
					args();
					}
				}

				setState(346);
				match(T__11);
				}
				break;
			case T__44:
				_localctx = new GetContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(347);
				match(T__44);
				setState(348);
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
		enterRule(_localctx, 30, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
			expr(0);
			setState(356);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8) {
				{
				{
				setState(352);
				match(T__8);
				setState(353);
				expr(0);
				}
				}
				setState(358);
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
		enterRule(_localctx, 32, RULE_props);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(359);
			match(ID);
			setState(360);
			match(T__24);
			setState(361);
			expr(0);
			setState(362);
			match(T__8);
			setState(370);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(363);
				match(ID);
				setState(364);
				match(T__24);
				setState(365);
				expr(0);
				setState(366);
				match(T__8);
				}
				}
				setState(372);
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
		enterRule(_localctx, 34, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 2181431069507584L) != 0)) ) {
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
		case 13:
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
		"\u0004\u0001<\u0178\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001\u0000\u0005\u0000"+
		"&\b\u0000\n\u0000\f\u0000)\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u00011\b\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"9\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"?\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002"+
		"E\b\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002J\b\u0002\u0003"+
		"\u0002L\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0005\u0003_\b\u0003\n\u0003\f\u0003b\t\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003f\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0003\u0004n\b\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0003\u0005t\b\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005x\b\u0005\u0001\u0005\u0001\u0005\u0005\u0005|\b\u0005"+
		"\n\u0005\f\u0005\u007f\t\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u0083"+
		"\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005"+
		"\u0006\u008a\b\u0006\n\u0006\f\u0006\u008d\t\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u0094\b\u0007\n\u0007"+
		"\f\u0007\u0097\t\u0007\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t"+
		"\u0005\t\u009f\b\t\n\t\f\t\u00a2\t\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\t\u00aa\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u00b0"+
		"\b\t\n\t\f\t\u00b3\t\t\u0001\t\u0003\t\u00b6\b\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0003\t\u00d0\b\t\u0001\t\u0001\t\u0003\t\u00d4"+
		"\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u00da\b\t\n\t\f\t\u00dd\t"+
		"\t\u0001\t\u0001\t\u0003\t\u00e1\b\t\u0001\t\u0001\t\u0003\t\u00e5\b\t"+
		"\u0001\t\u0003\t\u00e8\b\t\u0003\t\u00ea\b\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0005\n\u00f0\b\n\n\n\f\n\u00f3\t\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0005\u000b\u00f8\b\u000b\n\u000b\f\u000b\u00fb\t\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0103\b\f\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0003\r\u0135\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0004\r\u0148\b\r\u000b\r\f\r\u0149\u0001\r\u0001\r\u0001\r"+
		"\u0001\r\u0003\r\u0150\b\r\u0005\r\u0152\b\r\n\r\f\r\u0155\t\r\u0001\u000e"+
		"\u0001\u000e\u0003\u000e\u0159\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u015e\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f"+
		"\u0163\b\u000f\n\u000f\f\u000f\u0166\t\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0005\u0010\u0171\b\u0010\n\u0010\f\u0010\u0174\t\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0000\u0001\u001a\u0012\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"\u0000"+
		"\u0007\u0001\u0000)*\u0001\u0000\u001c\u001e\u0002\u0000\u001b\u001b\u001f"+
		"\u001f\u0001\u0000 #\u0001\u0000$%\u0001\u0000&\'\u0001\u0000.2\u01af"+
		"\u0000\'\u0001\u0000\u0000\u0000\u00020\u0001\u0000\u0000\u0000\u0004"+
		"K\u0001\u0000\u0000\u0000\u0006M\u0001\u0000\u0000\u0000\bg\u0001\u0000"+
		"\u0000\u0000\no\u0001\u0000\u0000\u0000\f\u0084\u0001\u0000\u0000\u0000"+
		"\u000e\u0090\u0001\u0000\u0000\u0000\u0010\u0098\u0001\u0000\u0000\u0000"+
		"\u0012\u00e9\u0001\u0000\u0000\u0000\u0014\u00eb\u0001\u0000\u0000\u0000"+
		"\u0016\u00f4\u0001\u0000\u0000\u0000\u0018\u0102\u0001\u0000\u0000\u0000"+
		"\u001a\u0134\u0001\u0000\u0000\u0000\u001c\u015d\u0001\u0000\u0000\u0000"+
		"\u001e\u015f\u0001\u0000\u0000\u0000 \u0167\u0001\u0000\u0000\u0000\""+
		"\u0175\u0001\u0000\u0000\u0000$&\u0003\u0002\u0001\u0000%$\u0001\u0000"+
		"\u0000\u0000&)\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000\'(\u0001"+
		"\u0000\u0000\u0000(\u0001\u0001\u0000\u0000\u0000)\'\u0001\u0000\u0000"+
		"\u0000*1\u0003\u0004\u0002\u0000+1\u0003\n\u0005\u0000,1\u0003\f\u0006"+
		"\u0000-1\u0003\b\u0004\u0000.1\u0003\u0006\u0003\u0000/1\u0003\u0012\t"+
		"\u00000*\u0001\u0000\u0000\u00000+\u0001\u0000\u0000\u00000,\u0001\u0000"+
		"\u0000\u00000-\u0001\u0000\u0000\u00000.\u0001\u0000\u0000\u00000/\u0001"+
		"\u0000\u0000\u00001\u0003\u0001\u0000\u0000\u000023\u0005\u0001\u0000"+
		"\u000034\u00059\u0000\u000045\u0003\"\u0011\u000056\u0005\u0002\u0000"+
		"\u000068\u0003\u001a\r\u000079\u0005\u0003\u0000\u000087\u0001\u0000\u0000"+
		"\u000089\u0001\u0000\u0000\u00009L\u0001\u0000\u0000\u0000:;\u0005\u0001"+
		"\u0000\u0000;<\u00059\u0000\u0000<>\u0003\"\u0011\u0000=?\u0005\u0003"+
		"\u0000\u0000>=\u0001\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?L\u0001"+
		"\u0000\u0000\u0000@A\u00059\u0000\u0000AB\u0005\u0004\u0000\u0000BD\u0003"+
		"\u001a\r\u0000CE\u0005\u0003\u0000\u0000DC\u0001\u0000\u0000\u0000DE\u0001"+
		"\u0000\u0000\u0000EL\u0001\u0000\u0000\u0000FG\u00059\u0000\u0000GI\u0003"+
		"\"\u0011\u0000HJ\u0005\u0003\u0000\u0000IH\u0001\u0000\u0000\u0000IJ\u0001"+
		"\u0000\u0000\u0000JL\u0001\u0000\u0000\u0000K2\u0001\u0000\u0000\u0000"+
		"K:\u0001\u0000\u0000\u0000K@\u0001\u0000\u0000\u0000KF\u0001\u0000\u0000"+
		"\u0000L\u0005\u0001\u0000\u0000\u0000MN\u00059\u0000\u0000NO\u0005\u0004"+
		"\u0000\u0000OP\u0005\u0005\u0000\u0000PQ\u0005\u0006\u0000\u0000QR\u0005"+
		"\u0005\u0000\u0000RS\u0005\u0006\u0000\u0000ST\u0003\"\u0011\u0000TU\u0005"+
		"\u0007\u0000\u0000UV\u0005\u0007\u0000\u0000VW\u0003\u001e\u000f\u0000"+
		"WX\u0005\b\u0000\u0000X`\u0005\t\u0000\u0000YZ\u0005\u0007\u0000\u0000"+
		"Z[\u0003\u001e\u000f\u0000[\\\u0005\b\u0000\u0000\\]\u0005\t\u0000\u0000"+
		"]_\u0001\u0000\u0000\u0000^Y\u0001\u0000\u0000\u0000_b\u0001\u0000\u0000"+
		"\u0000`^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000ac\u0001\u0000"+
		"\u0000\u0000b`\u0001\u0000\u0000\u0000ce\u0005\b\u0000\u0000df\u0005\u0003"+
		"\u0000\u0000ed\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000f\u0007"+
		"\u0001\u0000\u0000\u0000gh\u0005\u0001\u0000\u0000hi\u00059\u0000\u0000"+
		"ij\u0005\u0005\u0000\u0000jk\u0005\u0006\u0000\u0000km\u0003\"\u0011\u0000"+
		"ln\u0005\u0003\u0000\u0000ml\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000"+
		"\u0000n\t\u0001\u0000\u0000\u0000op\u0005\n\u0000\u0000pq\u00059\u0000"+
		"\u0000qs\u0005\u000b\u0000\u0000rt\u0003\u000e\u0007\u0000sr\u0001\u0000"+
		"\u0000\u0000st\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000uw\u0005"+
		"\f\u0000\u0000vx\u0003\"\u0011\u0000wv\u0001\u0000\u0000\u0000wx\u0001"+
		"\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000y}\u0005\u0007\u0000\u0000"+
		"z|\u0003\u0002\u0001\u0000{z\u0001\u0000\u0000\u0000|\u007f\u0001\u0000"+
		"\u0000\u0000}{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u0080"+
		"\u0001\u0000\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u0080\u0082\u0005"+
		"\b\u0000\u0000\u0081\u0083\u0005\u0003\u0000\u0000\u0082\u0081\u0001\u0000"+
		"\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u000b\u0001\u0000"+
		"\u0000\u0000\u0084\u0085\u0005\r\u0000\u0000\u0085\u0086\u00059\u0000"+
		"\u0000\u0086\u0087\u0005\u000e\u0000\u0000\u0087\u008b\u0005\u0007\u0000"+
		"\u0000\u0088\u008a\u0003\u0004\u0002\u0000\u0089\u0088\u0001\u0000\u0000"+
		"\u0000\u008a\u008d\u0001\u0000\u0000\u0000\u008b\u0089\u0001\u0000\u0000"+
		"\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008e\u0001\u0000\u0000"+
		"\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008e\u008f\u0005\b\u0000\u0000"+
		"\u008f\r\u0001\u0000\u0000\u0000\u0090\u0095\u0003\u0010\b\u0000\u0091"+
		"\u0092\u0005\t\u0000\u0000\u0092\u0094\u0003\u0010\b\u0000\u0093\u0091"+
		"\u0001\u0000\u0000\u0000\u0094\u0097\u0001\u0000\u0000\u0000\u0095\u0093"+
		"\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000\u0096\u000f"+
		"\u0001\u0000\u0000\u0000\u0097\u0095\u0001\u0000\u0000\u0000\u0098\u0099"+
		"\u00059\u0000\u0000\u0099\u009a\u0003\"\u0011\u0000\u009a\u0011\u0001"+
		"\u0000\u0000\u0000\u009b\u00ea\u0003\u001a\r\u0000\u009c\u00a0\u0005\u0007"+
		"\u0000\u0000\u009d\u009f\u0003\u0002\u0001\u0000\u009e\u009d\u0001\u0000"+
		"\u0000\u0000\u009f\u00a2\u0001\u0000\u0000\u0000\u00a0\u009e\u0001\u0000"+
		"\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u00a3\u0001\u0000"+
		"\u0000\u0000\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a3\u00ea\u0005\b\u0000"+
		"\u0000\u00a4\u00a5\u0005\u000f\u0000\u0000\u00a5\u00a6\u0003\u001a\r\u0000"+
		"\u00a6\u00a9\u0003\u0012\t\u0000\u00a7\u00a8\u0005\u0010\u0000\u0000\u00a8"+
		"\u00aa\u0003\u0012\t\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00a9\u00aa"+
		"\u0001\u0000\u0000\u0000\u00aa\u00ea\u0001\u0000\u0000\u0000\u00ab\u00ac"+
		"\u0005\u0011\u0000\u0000\u00ac\u00ad\u0003\u001a\r\u0000\u00ad\u00b1\u0005"+
		"\u0007\u0000\u0000\u00ae\u00b0\u0003\u0014\n\u0000\u00af\u00ae\u0001\u0000"+
		"\u0000\u0000\u00b0\u00b3\u0001\u0000\u0000\u0000\u00b1\u00af\u0001\u0000"+
		"\u0000\u0000\u00b1\u00b2\u0001\u0000\u0000\u0000\u00b2\u00b5\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b1\u0001\u0000\u0000\u0000\u00b4\u00b6\u0003\u0016"+
		"\u000b\u0000\u00b5\u00b4\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7\u00b8\u0005\b\u0000"+
		"\u0000\u00b8\u00ea\u0001\u0000\u0000\u0000\u00b9\u00ba\u0005\u0012\u0000"+
		"\u0000\u00ba\u00bb\u0003\u0018\f\u0000\u00bb\u00bc\u0003\u001a\r\u0000"+
		"\u00bc\u00bd\u0005\u0003\u0000\u0000\u00bd\u00be\u0003\u001a\r\u0000\u00be"+
		"\u00bf\u0003\u0012\t\u0000\u00bf\u00ea\u0001\u0000\u0000\u0000\u00c0\u00c1"+
		"\u0005\u0012\u0000\u0000\u00c1\u00c2\u0003\u001a\r\u0000\u00c2\u00c3\u0003"+
		"\u0012\t\u0000\u00c3\u00ea\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005\u0012"+
		"\u0000\u0000\u00c5\u00c6\u00059\u0000\u0000\u00c6\u00c7\u0005\t\u0000"+
		"\u0000\u00c7\u00c8\u00059\u0000\u0000\u00c8\u00c9\u0005\u0004\u0000\u0000"+
		"\u00c9\u00ca\u0005\u0013\u0000\u0000\u00ca\u00cb\u0003\u001a\r\u0000\u00cb"+
		"\u00cc\u0003\u0012\t\u0000\u00cc\u00ea\u0001\u0000\u0000\u0000\u00cd\u00cf"+
		"\u0005\u0014\u0000\u0000\u00ce\u00d0\u0005\u0003\u0000\u0000\u00cf\u00ce"+
		"\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0\u00ea"+
		"\u0001\u0000\u0000\u0000\u00d1\u00d3\u0005\u0015\u0000\u0000\u00d2\u00d4"+
		"\u0005\u0003\u0000\u0000\u00d3\u00d2\u0001\u0000\u0000\u0000\u00d3\u00d4"+
		"\u0001\u0000\u0000\u0000\u00d4\u00ea\u0001\u0000\u0000\u0000\u00d5\u00d6"+
		"\u0005\u0016\u0000\u0000\u00d6\u00db\u0003\u001a\r\u0000\u00d7\u00d8\u0005"+
		"\t\u0000\u0000\u00d8\u00da\u0003\u001a\r\u0000\u00d9\u00d7\u0001\u0000"+
		"\u0000\u0000\u00da\u00dd\u0001\u0000\u0000\u0000\u00db\u00d9\u0001\u0000"+
		"\u0000\u0000\u00db\u00dc\u0001\u0000\u0000\u0000\u00dc\u00de\u0001\u0000"+
		"\u0000\u0000\u00dd\u00db\u0001\u0000\u0000\u0000\u00de\u00e0\u0005\f\u0000"+
		"\u0000\u00df\u00e1\u0005\u0003\u0000\u0000\u00e0\u00df\u0001\u0000\u0000"+
		"\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1\u00ea\u0001\u0000\u0000"+
		"\u0000\u00e2\u00e4\u0005\u0017\u0000\u0000\u00e3\u00e5\u0003\u001a\r\u0000"+
		"\u00e4\u00e3\u0001\u0000\u0000\u0000\u00e4\u00e5\u0001\u0000\u0000\u0000"+
		"\u00e5\u00e7\u0001\u0000\u0000\u0000\u00e6\u00e8\u0005\u0003\u0000\u0000"+
		"\u00e7\u00e6\u0001\u0000\u0000\u0000\u00e7\u00e8\u0001\u0000\u0000\u0000"+
		"\u00e8\u00ea\u0001\u0000\u0000\u0000\u00e9\u009b\u0001\u0000\u0000\u0000"+
		"\u00e9\u009c\u0001\u0000\u0000\u0000\u00e9\u00a4\u0001\u0000\u0000\u0000"+
		"\u00e9\u00ab\u0001\u0000\u0000\u0000\u00e9\u00b9\u0001\u0000\u0000\u0000"+
		"\u00e9\u00c0\u0001\u0000\u0000\u0000\u00e9\u00c4\u0001\u0000\u0000\u0000"+
		"\u00e9\u00cd\u0001\u0000\u0000\u0000\u00e9\u00d1\u0001\u0000\u0000\u0000"+
		"\u00e9\u00d5\u0001\u0000\u0000\u0000\u00e9\u00e2\u0001\u0000\u0000\u0000"+
		"\u00ea\u0013\u0001\u0000\u0000\u0000\u00eb\u00ec\u0005\u0018\u0000\u0000"+
		"\u00ec\u00ed\u0003\u001a\r\u0000\u00ed\u00f1\u0005\u0019\u0000\u0000\u00ee"+
		"\u00f0\u0003\u0012\t\u0000\u00ef\u00ee\u0001\u0000\u0000\u0000\u00f0\u00f3"+
		"\u0001\u0000\u0000\u0000\u00f1\u00ef\u0001\u0000\u0000\u0000\u00f1\u00f2"+
		"\u0001\u0000\u0000\u0000\u00f2\u0015\u0001\u0000\u0000\u0000\u00f3\u00f1"+
		"\u0001\u0000\u0000\u0000\u00f4\u00f5\u0005\u001a\u0000\u0000\u00f5\u00f9"+
		"\u0005\u0019\u0000\u0000\u00f6\u00f8\u0003\u0012\t\u0000\u00f7\u00f6\u0001"+
		"\u0000\u0000\u0000\u00f8\u00fb\u0001\u0000\u0000\u0000\u00f9\u00f7\u0001"+
		"\u0000\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u0017\u0001"+
		"\u0000\u0000\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000\u00fc\u00fd\u0003"+
		"\u0004\u0002\u0000\u00fd\u00fe\u0005\u0003\u0000\u0000\u00fe\u0103\u0001"+
		"\u0000\u0000\u0000\u00ff\u0100\u0003\u001a\r\u0000\u0100\u0101\u0005\u0003"+
		"\u0000\u0000\u0101\u0103\u0001\u0000\u0000\u0000\u0102\u00fc\u0001\u0000"+
		"\u0000\u0000\u0102\u00ff\u0001\u0000\u0000\u0000\u0103\u0019\u0001\u0000"+
		"\u0000\u0000\u0104\u0105\u0006\r\uffff\uffff\u0000\u0105\u0106\u0005\u001b"+
		"\u0000\u0000\u0106\u0135\u0003\u001a\r\u0018\u0107\u0108\u0005(\u0000"+
		"\u0000\u0108\u0135\u0003\u001a\r\u0011\u0109\u010a\u00059\u0000\u0000"+
		"\u010a\u010b\u0007\u0000\u0000\u0000\u010b\u0135\u0003\u001a\r\u0010\u010c"+
		"\u010d\u0005\u0005\u0000\u0000\u010d\u010e\u0005\u0006\u0000\u0000\u010e"+
		"\u010f\u0003\"\u0011\u0000\u010f\u0110\u0005\u0007\u0000\u0000\u0110\u0111"+
		"\u0003\u001e\u000f\u0000\u0111\u0112\u0005\b\u0000\u0000\u0112\u0135\u0001"+
		"\u0000\u0000\u0000\u0113\u0114\u00059\u0000\u0000\u0114\u0115\u0005\u0005"+
		"\u0000\u0000\u0115\u0116\u0003\u001a\r\u0000\u0116\u0117\u0005\u0006\u0000"+
		"\u0000\u0117\u0135\u0001\u0000\u0000\u0000\u0118\u0119\u00059\u0000\u0000"+
		"\u0119\u011a\u0005\u0005\u0000\u0000\u011a\u011b\u0003\u001a\r\u0000\u011b"+
		"\u011c\u0005\u0006\u0000\u0000\u011c\u011d\u0005\u0005\u0000\u0000\u011d"+
		"\u011e\u0003\u001a\r\u0000\u011e\u011f\u0005\u0006\u0000\u0000\u011f\u0135"+
		"\u0001\u0000\u0000\u0000\u0120\u0121\u00059\u0000\u0000\u0121\u0135\u0005"+
		"+\u0000\u0000\u0122\u0123\u00059\u0000\u0000\u0123\u0135\u0005,\u0000"+
		"\u0000\u0124\u0125\u00059\u0000\u0000\u0125\u0126\u0005\u0007\u0000\u0000"+
		"\u0126\u0127\u0003 \u0010\u0000\u0127\u0128\u0005\b\u0000\u0000\u0128"+
		"\u0135\u0001\u0000\u0000\u0000\u0129\u0135\u00054\u0000\u0000\u012a\u0135"+
		"\u00055\u0000\u0000\u012b\u0135\u00056\u0000\u0000\u012c\u0135\u00053"+
		"\u0000\u0000\u012d\u0135\u00059\u0000\u0000\u012e\u0135\u00058\u0000\u0000"+
		"\u012f\u0135\u00057\u0000\u0000\u0130\u0131\u0005\u000b\u0000\u0000\u0131"+
		"\u0132\u0003\u001a\r\u0000\u0132\u0133\u0005\f\u0000\u0000\u0133\u0135"+
		"\u0001\u0000\u0000\u0000\u0134\u0104\u0001\u0000\u0000\u0000\u0134\u0107"+
		"\u0001\u0000\u0000\u0000\u0134\u0109\u0001\u0000\u0000\u0000\u0134\u010c"+
		"\u0001\u0000\u0000\u0000\u0134\u0113\u0001\u0000\u0000\u0000\u0134\u0118"+
		"\u0001\u0000\u0000\u0000\u0134\u0120\u0001\u0000\u0000\u0000\u0134\u0122"+
		"\u0001\u0000\u0000\u0000\u0134\u0124\u0001\u0000\u0000\u0000\u0134\u0129"+
		"\u0001\u0000\u0000\u0000\u0134\u012a\u0001\u0000\u0000\u0000\u0134\u012b"+
		"\u0001\u0000\u0000\u0000\u0134\u012c\u0001\u0000\u0000\u0000\u0134\u012d"+
		"\u0001\u0000\u0000\u0000\u0134\u012e\u0001\u0000\u0000\u0000\u0134\u012f"+
		"\u0001\u0000\u0000\u0000\u0134\u0130\u0001\u0000\u0000\u0000\u0135\u0153"+
		"\u0001\u0000\u0000\u0000\u0136\u0137\n\u0016\u0000\u0000\u0137\u0138\u0007"+
		"\u0001\u0000\u0000\u0138\u0152\u0003\u001a\r\u0017\u0139\u013a\n\u0015"+
		"\u0000\u0000\u013a\u013b\u0007\u0002\u0000\u0000\u013b\u0152\u0003\u001a"+
		"\r\u0016\u013c\u013d\n\u0014\u0000\u0000\u013d\u013e\u0007\u0003\u0000"+
		"\u0000\u013e\u0152\u0003\u001a\r\u0015\u013f\u0140\n\u0013\u0000\u0000"+
		"\u0140\u0141\u0007\u0004\u0000\u0000\u0141\u0152\u0003\u001a\r\u0014\u0142"+
		"\u0143\n\u0012\u0000\u0000\u0143\u0144\u0007\u0005\u0000\u0000\u0144\u0152"+
		"\u0003\u001a\r\u0013\u0145\u0147\n\u0017\u0000\u0000\u0146\u0148\u0003"+
		"\u001c\u000e\u0000\u0147\u0146\u0001\u0000\u0000\u0000\u0148\u0149\u0001"+
		"\u0000\u0000\u0000\u0149\u0147\u0001\u0000\u0000\u0000\u0149\u014a\u0001"+
		"\u0000\u0000\u0000\u014a\u0152\u0001\u0000\u0000\u0000\u014b\u014c\n\u000f"+
		"\u0000\u0000\u014c\u014d\u0005\u0002\u0000\u0000\u014d\u014f\u0003\u001a"+
		"\r\u0000\u014e\u0150\u0005\u0003\u0000\u0000\u014f\u014e\u0001\u0000\u0000"+
		"\u0000\u014f\u0150\u0001\u0000\u0000\u0000\u0150\u0152\u0001\u0000\u0000"+
		"\u0000\u0151\u0136\u0001\u0000\u0000\u0000\u0151\u0139\u0001\u0000\u0000"+
		"\u0000\u0151\u013c\u0001\u0000\u0000\u0000\u0151\u013f\u0001\u0000\u0000"+
		"\u0000\u0151\u0142\u0001\u0000\u0000\u0000\u0151\u0145\u0001\u0000\u0000"+
		"\u0000\u0151\u014b\u0001\u0000\u0000\u0000\u0152\u0155\u0001\u0000\u0000"+
		"\u0000\u0153\u0151\u0001\u0000\u0000\u0000\u0153\u0154\u0001\u0000\u0000"+
		"\u0000\u0154\u001b\u0001\u0000\u0000\u0000\u0155\u0153\u0001\u0000\u0000"+
		"\u0000\u0156\u0158\u0005\u000b\u0000\u0000\u0157\u0159\u0003\u001e\u000f"+
		"\u0000\u0158\u0157\u0001\u0000\u0000\u0000\u0158\u0159\u0001\u0000\u0000"+
		"\u0000\u0159\u015a\u0001\u0000\u0000\u0000\u015a\u015e\u0005\f\u0000\u0000"+
		"\u015b\u015c\u0005-\u0000\u0000\u015c\u015e\u00059\u0000\u0000\u015d\u0156"+
		"\u0001\u0000\u0000\u0000\u015d\u015b\u0001\u0000\u0000\u0000\u015e\u001d"+
		"\u0001\u0000\u0000\u0000\u015f\u0164\u0003\u001a\r\u0000\u0160\u0161\u0005"+
		"\t\u0000\u0000\u0161\u0163\u0003\u001a\r\u0000\u0162\u0160\u0001\u0000"+
		"\u0000\u0000\u0163\u0166\u0001\u0000\u0000\u0000\u0164\u0162\u0001\u0000"+
		"\u0000\u0000\u0164\u0165\u0001\u0000\u0000\u0000\u0165\u001f\u0001\u0000"+
		"\u0000\u0000\u0166\u0164\u0001\u0000\u0000\u0000\u0167\u0168\u00059\u0000"+
		"\u0000\u0168\u0169\u0005\u0019\u0000\u0000\u0169\u016a\u0003\u001a\r\u0000"+
		"\u016a\u0172\u0005\t\u0000\u0000\u016b\u016c\u00059\u0000\u0000\u016c"+
		"\u016d\u0005\u0019\u0000\u0000\u016d\u016e\u0003\u001a\r\u0000\u016e\u016f"+
		"\u0005\t\u0000\u0000\u016f\u0171\u0001\u0000\u0000\u0000\u0170\u016b\u0001"+
		"\u0000\u0000\u0000\u0171\u0174\u0001\u0000\u0000\u0000\u0172\u0170\u0001"+
		"\u0000\u0000\u0000\u0172\u0173\u0001\u0000\u0000\u0000\u0173!\u0001\u0000"+
		"\u0000\u0000\u0174\u0172\u0001\u0000\u0000\u0000\u0175\u0176\u0007\u0006"+
		"\u0000\u0000\u0176#\u0001\u0000\u0000\u0000\'\'08>DIK`emsw}\u0082\u008b"+
		"\u0095\u00a0\u00a9\u00b1\u00b5\u00cf\u00d3\u00db\u00e0\u00e4\u00e7\u00e9"+
		"\u00f1\u00f9\u0102\u0134\u0149\u014f\u0151\u0153\u0158\u015d\u0164\u0172";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}