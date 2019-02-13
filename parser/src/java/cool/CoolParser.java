// Generated from CoolParser.g4 by ANTLR 4.5
package cool;

    import java.util.List;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CoolParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ERROR=1, TYPEID=2, OBJECTID=3, BOOL_CONST=4, INT_CONST=5, STR_CONST=6, 
		LPAREN=7, RPAREN=8, COLON=9, ATSYM=10, SEMICOLON=11, COMMA=12, PLUS=13, 
		MINUS=14, STAR=15, SLASH=16, TILDE=17, LT=18, EQUALS=19, LBRACE=20, RBRACE=21, 
		DOT=22, DARROW=23, LE=24, ASSIGN=25, CLASS=26, ELSE=27, FI=28, IF=29, 
		IN=30, INHERITS=31, LET=32, LOOP=33, POOL=34, THEN=35, WHILE=36, CASE=37, 
		ESAC=38, OF=39, NEW=40, ISVOID=41, NOT=42, WS=43, THEEND=44, SINGLE_COMMENT=45, 
		COMMENT_CLOSE=46, CLOSED=47, COM_EOF=48, NEWLINE=49, ESC=50, ESC_NULL=51, 
		STR_EOF=52, ERR1=53, ERR2=54, ERR3=55, LQUOTE=56, NL=57, TAB=58, BACKSPAC=59, 
		LINEFEED=60, SLASHN=61, ESC_NL=62;
	public static final int
		RULE_program = 0, RULE_class_list = 1, RULE_class_ = 2, RULE_feature_list = 3, 
		RULE_feature = 4, RULE_form_list = 5, RULE_formal = 6, RULE_case_list = 7, 
		RULE_case_single = 8, RULE_expr_block = 9, RULE_expr_comma_expr = 10, 
		RULE_let_base = 11, RULE_let_stmt = 12, RULE_expr = 13;
	public static final String[] ruleNames = {
		"program", "class_list", "class_", "feature_list", "feature", "form_list", 
		"formal", "case_list", "case_single", "expr_block", "expr_comma_expr", 
		"let_base", "let_stmt", "expr"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, null, "'('", "')'", "':'", "'@'", 
		"';'", "','", "'+'", "'-'", "'*'", "'/'", "'~'", "'<'", "'='", "'{'", 
		"'}'", "'.'", "'=>'", "'<='", "'<-'", null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "'*)'", null, null, null, null, null, null, null, null, null, 
		null, null, "'\\t'", "'\\b'", "'\\f'", "'\\n'", "'\\\n'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "ERROR", "TYPEID", "OBJECTID", "BOOL_CONST", "INT_CONST", "STR_CONST", 
		"LPAREN", "RPAREN", "COLON", "ATSYM", "SEMICOLON", "COMMA", "PLUS", "MINUS", 
		"STAR", "SLASH", "TILDE", "LT", "EQUALS", "LBRACE", "RBRACE", "DOT", "DARROW", 
		"LE", "ASSIGN", "CLASS", "ELSE", "FI", "IF", "IN", "INHERITS", "LET", 
		"LOOP", "POOL", "THEN", "WHILE", "CASE", "ESAC", "OF", "NEW", "ISVOID", 
		"NOT", "WS", "THEEND", "SINGLE_COMMENT", "COMMENT_CLOSE", "CLOSED", "COM_EOF", 
		"NEWLINE", "ESC", "ESC_NULL", "STR_EOF", "ERR1", "ERR2", "ERR3", "LQUOTE", 
		"NL", "TAB", "BACKSPAC", "LINEFEED", "SLASHN", "ESC_NL"
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

	@Override
	public String getGrammarFileName() { return "CoolParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    String filename;
	    public void setFilename(String f){
	        filename = f;
	    }

	/*
	    DO NOT EDIT THE FILE ABOVE THIS LINE
	    Add member functions, variables below.
	*/


	public CoolParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public AST.program value;
		public Class_listContext cl;
		public TerminalNode EOF() { return getToken(CoolParser.EOF, 0); }
		public Class_listContext class_list() {
			return getRuleContext(Class_listContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			((ProgramContext)_localctx).cl = class_list();
			setState(29);
			match(EOF);

			        ((ProgramContext)_localctx).value =  new AST.program($(class_list).ast_class_list, ((ProgramContext)_localctx).cl.ast_class_list.get(0).lineNo);
			        //cl.value is the String list containing the names of the classes and the second parameter is the no. of classes.
			    
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

	public static class Class_listContext extends ParserRuleContext {
		public List<AST.class_> ast_class_list;
		public Class_Context cl;
		public List<TerminalNode> SEMICOLON() { return getTokens(CoolParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CoolParser.SEMICOLON, i);
		}
		public List<Class_Context> class_() {
			return getRuleContexts(Class_Context.class);
		}
		public Class_Context class_(int i) {
			return getRuleContext(Class_Context.class,i);
		}
		public Class_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitClass_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_listContext class_list() throws RecognitionException {
		Class_listContext _localctx = new Class_listContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_class_list);
		 ((Class_listContext)_localctx).ast_class_list =  new ArrayList<>(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASS) {
				{
				{
				setState(32);
				((Class_listContext)_localctx).cl = class_();
				setState(33);
				match(SEMICOLON);
				 _localctx.ast_class_list.add(((Class_listContext)_localctx).cl.ast_class);
				}
				}
				setState(40);
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

	public static class Class_Context extends ParserRuleContext {
		public AST.class_ ast_class;
		public Token type;
		public Feature_listContext t_feat_list;
		public Token in_type;
		public TerminalNode CLASS() { return getToken(CoolParser.CLASS, 0); }
		public TerminalNode LBRACE() { return getToken(CoolParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(CoolParser.RBRACE, 0); }
		public List<TerminalNode> TYPEID() { return getTokens(CoolParser.TYPEID); }
		public TerminalNode TYPEID(int i) {
			return getToken(CoolParser.TYPEID, i);
		}
		public Feature_listContext feature_list() {
			return getRuleContext(Feature_listContext.class,0);
		}
		public TerminalNode INHERITS() { return getToken(CoolParser.INHERITS, 0); }
		public Class_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitClass_(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_Context class_() throws RecognitionException {
		Class_Context _localctx = new Class_Context(_ctx, getState());
		enterRule(_localctx, 4, RULE_class_);
		try {
			setState(57);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				match(CLASS);
				setState(42);
				((Class_Context)_localctx).type = match(TYPEID);
				setState(43);
				match(LBRACE);
				setState(44);
				((Class_Context)_localctx).t_feat_list = feature_list();
				setState(45);
				match(RBRACE);

				        ((Class_Context)_localctx).ast_class =  new AST.class_(((Class_Context)_localctx).type.getText(), filename, "Object", ((Class_Context)_localctx).t_feat_list.ast_feat_list, ((Class_Context)_localctx).type.getLine());
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(48);
				match(CLASS);
				setState(49);
				((Class_Context)_localctx).type = match(TYPEID);
				setState(50);
				match(INHERITS);
				setState(51);
				((Class_Context)_localctx).in_type = match(TYPEID);
				setState(52);
				match(LBRACE);
				setState(53);
				((Class_Context)_localctx).t_feat_list = feature_list();
				setState(54);
				match(RBRACE);

				        ((Class_Context)_localctx).ast_class =  new AST.class_(((Class_Context)_localctx).type.getText(), filename, ((Class_Context)_localctx).in_type.getText(), ((Class_Context)_localctx).t_feat_list.ast_feat_list, ((Class_Context)_localctx).type.getLine());
				    
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

	public static class Feature_listContext extends ParserRuleContext {
		public List<AST.feature> ast_feat_list;
		public FeatureContext feat;
		public List<TerminalNode> SEMICOLON() { return getTokens(CoolParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CoolParser.SEMICOLON, i);
		}
		public List<FeatureContext> feature() {
			return getRuleContexts(FeatureContext.class);
		}
		public FeatureContext feature(int i) {
			return getRuleContext(FeatureContext.class,i);
		}
		public Feature_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feature_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitFeature_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Feature_listContext feature_list() throws RecognitionException {
		Feature_listContext _localctx = new Feature_listContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_feature_list);
		 ((Feature_listContext)_localctx).ast_feat_list =  new ArrayList<>(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OBJECTID) {
				{
				{
				setState(59);
				((Feature_listContext)_localctx).feat = feature();
				setState(60);
				match(SEMICOLON);
				 _localctx.ast_feat_list.add(((Feature_listContext)_localctx).feat.value); 
				}
				}
				setState(67);
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

	public static class FeatureContext extends ParserRuleContext {
		public AST.feature value;
		public Token obj;
		public Token type;
		public ExprContext e;
		public Form_listContext f_list;
		public TerminalNode LPAREN() { return getToken(CoolParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CoolParser.RPAREN, 0); }
		public TerminalNode COLON() { return getToken(CoolParser.COLON, 0); }
		public TerminalNode LBRACE() { return getToken(CoolParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(CoolParser.RBRACE, 0); }
		public TerminalNode OBJECTID() { return getToken(CoolParser.OBJECTID, 0); }
		public TerminalNode TYPEID() { return getToken(CoolParser.TYPEID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Form_listContext form_list() {
			return getRuleContext(Form_listContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(CoolParser.ASSIGN, 0); }
		public FeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feature; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitFeature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FeatureContext feature() throws RecognitionException {
		FeatureContext _localctx = new FeatureContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_feature);
		try {
			setState(100);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				((FeatureContext)_localctx).obj = match(OBJECTID);
				setState(69);
				match(LPAREN);
				setState(70);
				match(RPAREN);
				setState(71);
				match(COLON);
				setState(72);
				((FeatureContext)_localctx).type = match(TYPEID);
				setState(73);
				match(LBRACE);
				setState(74);
				((FeatureContext)_localctx).e = expr(0);
				setState(75);
				match(RBRACE);

				        ((FeatureContext)_localctx).value =  new AST.method(((FeatureContext)_localctx).obj.getText(),new ArrayList<AST.formal>(), ((FeatureContext)_localctx).type.getText(), ((FeatureContext)_localctx).e.value, ((FeatureContext)_localctx).obj.getLine());
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(78);
				((FeatureContext)_localctx).obj = match(OBJECTID);
				setState(79);
				match(LPAREN);
				setState(80);
				((FeatureContext)_localctx).f_list = form_list();
				setState(81);
				match(RPAREN);
				setState(82);
				match(COLON);
				setState(83);
				((FeatureContext)_localctx).type = match(TYPEID);
				setState(84);
				match(LBRACE);
				setState(85);
				((FeatureContext)_localctx).e = expr(0);
				setState(86);
				match(RBRACE);

				        ((FeatureContext)_localctx).value =  new AST.method(((FeatureContext)_localctx).obj.getText(),((FeatureContext)_localctx).f_list.value, ((FeatureContext)_localctx).type.getText(), ((FeatureContext)_localctx).e.value, ((FeatureContext)_localctx).obj.getLine());
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(89);
				((FeatureContext)_localctx).obj = match(OBJECTID);
				setState(90);
				match(COLON);
				setState(91);
				((FeatureContext)_localctx).type = match(TYPEID);

				        ((FeatureContext)_localctx).value =  new AST.attr(((FeatureContext)_localctx).obj.getText(), ((FeatureContext)_localctx).type.getText(), new AST.no_expr(((FeatureContext)_localctx).obj.getLine()), ((FeatureContext)_localctx).obj.getLine());
				    
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(93);
				((FeatureContext)_localctx).obj = match(OBJECTID);
				setState(94);
				match(COLON);
				setState(95);
				((FeatureContext)_localctx).type = match(TYPEID);
				setState(96);
				match(ASSIGN);
				setState(97);
				((FeatureContext)_localctx).e = expr(0);

				        ((FeatureContext)_localctx).value =  new AST.attr(((FeatureContext)_localctx).obj.getText(), ((FeatureContext)_localctx).type.getText(), ((FeatureContext)_localctx).e.value, ((FeatureContext)_localctx).obj.getLine());
				    
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

	public static class Form_listContext extends ParserRuleContext {
		public List<AST.formal> value;
		public FormalContext form;
		public FormalContext form_extra;
		public List<FormalContext> formal() {
			return getRuleContexts(FormalContext.class);
		}
		public FormalContext formal(int i) {
			return getRuleContext(FormalContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CoolParser.COMMA, i);
		}
		public Form_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_form_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitForm_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Form_listContext form_list() throws RecognitionException {
		Form_listContext _localctx = new Form_listContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_form_list);
		 ((Form_listContext)_localctx).value =  new ArrayList<>(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			((Form_listContext)_localctx).form = formal();
			 _localctx.value.add(((Form_listContext)_localctx).form.value); 
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(104);
				match(COMMA);
				setState(105);
				((Form_listContext)_localctx).form_extra = formal();
				 _localctx.value.add(((Form_listContext)_localctx).form_extra.value); 
				}
				}
				setState(112);
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

	public static class FormalContext extends ParserRuleContext {
		public AST.formal value;
		public Token obj;
		public Token type;
		public TerminalNode COLON() { return getToken(CoolParser.COLON, 0); }
		public TerminalNode OBJECTID() { return getToken(CoolParser.OBJECTID, 0); }
		public TerminalNode TYPEID() { return getToken(CoolParser.TYPEID, 0); }
		public FormalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formal; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitFormal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalContext formal() throws RecognitionException {
		FormalContext _localctx = new FormalContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_formal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			((FormalContext)_localctx).obj = match(OBJECTID);
			setState(114);
			match(COLON);
			setState(115);
			((FormalContext)_localctx).type = match(TYPEID);

			        ((FormalContext)_localctx).value =  new AST.formal(((FormalContext)_localctx).obj.getText(), ((FormalContext)_localctx).type.getText(), ((FormalContext)_localctx).obj.getLine());
			    
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

	public static class Case_listContext extends ParserRuleContext {
		public List<AST.branch> value;
		public Case_singleContext c;
		public List<Case_singleContext> case_single() {
			return getRuleContexts(Case_singleContext.class);
		}
		public Case_singleContext case_single(int i) {
			return getRuleContext(Case_singleContext.class,i);
		}
		public Case_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_list; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitCase_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Case_listContext case_list() throws RecognitionException {
		Case_listContext _localctx = new Case_listContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_case_list);
		 ((Case_listContext)_localctx).value =  new ArrayList<>(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(118);
				((Case_listContext)_localctx).c = case_single();
				_localctx.value.add(((Case_listContext)_localctx).c.value); 
				}
				}
				setState(123); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OBJECTID );
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

	public static class Case_singleContext extends ParserRuleContext {
		public AST.branch value;
		public Token obj;
		public Token type;
		public ExprContext e;
		public TerminalNode COLON() { return getToken(CoolParser.COLON, 0); }
		public TerminalNode DARROW() { return getToken(CoolParser.DARROW, 0); }
		public TerminalNode SEMICOLON() { return getToken(CoolParser.SEMICOLON, 0); }
		public TerminalNode OBJECTID() { return getToken(CoolParser.OBJECTID, 0); }
		public TerminalNode TYPEID() { return getToken(CoolParser.TYPEID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Case_singleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_single; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitCase_single(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Case_singleContext case_single() throws RecognitionException {
		Case_singleContext _localctx = new Case_singleContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_case_single);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			((Case_singleContext)_localctx).obj = match(OBJECTID);
			setState(126);
			match(COLON);
			setState(127);
			((Case_singleContext)_localctx).type = match(TYPEID);
			setState(128);
			match(DARROW);
			setState(129);
			((Case_singleContext)_localctx).e = expr(0);
			setState(130);
			match(SEMICOLON);

			        ((Case_singleContext)_localctx).value =  new AST.branch(((Case_singleContext)_localctx).obj.getText(), ((Case_singleContext)_localctx).type.getText(), ((Case_singleContext)_localctx).e.value, ((Case_singleContext)_localctx).obj.getLine());
			    
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

	public static class Expr_blockContext extends ParserRuleContext {
		public List<AST.expression> value;
		public ExprContext e;
		public List<TerminalNode> SEMICOLON() { return getTokens(CoolParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(CoolParser.SEMICOLON, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Expr_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitExpr_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_blockContext expr_block() throws RecognitionException {
		Expr_blockContext _localctx = new Expr_blockContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expr_block);
		 ((Expr_blockContext)_localctx).value =  new ArrayList<>(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(133);
				((Expr_blockContext)_localctx).e = expr(0);
				setState(134);
				match(SEMICOLON);
				_localctx.value.add(((Expr_blockContext)_localctx).e.value);
				}
				}
				setState(139); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OBJECTID) | (1L << BOOL_CONST) | (1L << INT_CONST) | (1L << STR_CONST) | (1L << LPAREN) | (1L << TILDE) | (1L << LBRACE) | (1L << IF) | (1L << LET) | (1L << WHILE) | (1L << CASE) | (1L << NEW) | (1L << ISVOID) | (1L << NOT))) != 0) );
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

	public static class Expr_comma_exprContext extends ParserRuleContext {
		public List<AST.expression> value;
		public ExprContext e1st;
		public ExprContext e2nd;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CoolParser.COMMA, i);
		}
		public Expr_comma_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_comma_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitExpr_comma_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_comma_exprContext expr_comma_expr() throws RecognitionException {
		Expr_comma_exprContext _localctx = new Expr_comma_exprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_expr_comma_expr);
		 ((Expr_comma_exprContext)_localctx).value =  new ArrayList<>(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << OBJECTID) | (1L << BOOL_CONST) | (1L << INT_CONST) | (1L << STR_CONST) | (1L << LPAREN) | (1L << TILDE) | (1L << LBRACE) | (1L << IF) | (1L << LET) | (1L << WHILE) | (1L << CASE) | (1L << NEW) | (1L << ISVOID) | (1L << NOT))) != 0)) {
				{
				setState(141);
				((Expr_comma_exprContext)_localctx).e1st = expr(0);
				_localctx.value.add(((Expr_comma_exprContext)_localctx).e1st.value);
				setState(149);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(143);
					match(COMMA);
					setState(144);
					((Expr_comma_exprContext)_localctx).e2nd = expr(0);
					_localctx.value.add(((Expr_comma_exprContext)_localctx).e2nd.value);
					}
					}
					setState(151);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class Let_baseContext extends ParserRuleContext {
		public ArrayList<AST.attr> value;
		public Let_stmtContext let1st;
		public Let_stmtContext letExtra;
		public List<Let_stmtContext> let_stmt() {
			return getRuleContexts(Let_stmtContext.class);
		}
		public Let_stmtContext let_stmt(int i) {
			return getRuleContext(Let_stmtContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(CoolParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(CoolParser.COMMA, i);
		}
		public Let_baseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let_base; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitLet_base(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Let_baseContext let_base() throws RecognitionException {
		Let_baseContext _localctx = new Let_baseContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_let_base);
		 ((Let_baseContext)_localctx).value =  new ArrayList<AST.attr>(); 
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			((Let_baseContext)_localctx).let1st = let_stmt();
			 _localctx.value.add(((Let_baseContext)_localctx).let1st.value); 
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(156);
				match(COMMA);
				setState(157);
				((Let_baseContext)_localctx).letExtra = let_stmt();
				 _localctx.value.add(((Let_baseContext)_localctx).letExtra.value); 
				}
				}
				setState(164);
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

	public static class Let_stmtContext extends ParserRuleContext {
		public AST.attr value;
		public Token obj;
		public Token type;
		public ExprContext e;
		public TerminalNode COLON() { return getToken(CoolParser.COLON, 0); }
		public TerminalNode OBJECTID() { return getToken(CoolParser.OBJECTID, 0); }
		public TerminalNode TYPEID() { return getToken(CoolParser.TYPEID, 0); }
		public TerminalNode ASSIGN() { return getToken(CoolParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Let_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let_stmt; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitLet_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Let_stmtContext let_stmt() throws RecognitionException {
		Let_stmtContext _localctx = new Let_stmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_let_stmt);
		try {
			setState(176);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(165);
				((Let_stmtContext)_localctx).obj = match(OBJECTID);
				setState(166);
				match(COLON);
				setState(167);
				((Let_stmtContext)_localctx).type = match(TYPEID);
				 
				        ((Let_stmtContext)_localctx).value =  new AST.attr(((Let_stmtContext)_localctx).obj.getText(), ((Let_stmtContext)_localctx).type.getText(), new AST.no_expr(((Let_stmtContext)_localctx).obj.getLine()), ((Let_stmtContext)_localctx).obj.getLine());
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
				((Let_stmtContext)_localctx).obj = match(OBJECTID);
				setState(170);
				match(COLON);
				setState(171);
				((Let_stmtContext)_localctx).type = match(TYPEID);
				setState(172);
				match(ASSIGN);
				setState(173);
				((Let_stmtContext)_localctx).e = expr(0);
				 
				        ((Let_stmtContext)_localctx).value =  new AST.attr(((Let_stmtContext)_localctx).obj.getText(), ((Let_stmtContext)_localctx).type.getText(), ((Let_stmtContext)_localctx).e.value, ((Let_stmtContext)_localctx).obj.getLine());
				    
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

	public static class ExprContext extends ParserRuleContext {
		public AST.expression value;
		public ExprContext e;
		public ExprContext e_l;
		public Token l;
		public Let_baseContext lb;
		public Token t;
		public Token i;
		public Token n;
		public Token obj;
		public Expr_comma_exprContext e_opt;
		public ExprContext e_if;
		public ExprContext e_then;
		public ExprContext e_else;
		public Token w;
		public ExprContext e_cond;
		public ExprContext e_loop;
		public Expr_blockContext eb;
		public Token c_line;
		public Case_listContext c;
		public Token type;
		public Token str;
		public Token b;
		public ExprContext e_r;
		public TerminalNode IN() { return getToken(CoolParser.IN, 0); }
		public TerminalNode LET() { return getToken(CoolParser.LET, 0); }
		public Let_baseContext let_base() {
			return getRuleContext(Let_baseContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode TILDE() { return getToken(CoolParser.TILDE, 0); }
		public TerminalNode ISVOID() { return getToken(CoolParser.ISVOID, 0); }
		public TerminalNode NOT() { return getToken(CoolParser.NOT, 0); }
		public TerminalNode ASSIGN() { return getToken(CoolParser.ASSIGN, 0); }
		public TerminalNode OBJECTID() { return getToken(CoolParser.OBJECTID, 0); }
		public TerminalNode LPAREN() { return getToken(CoolParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(CoolParser.RPAREN, 0); }
		public Expr_comma_exprContext expr_comma_expr() {
			return getRuleContext(Expr_comma_exprContext.class,0);
		}
		public TerminalNode THEN() { return getToken(CoolParser.THEN, 0); }
		public TerminalNode ELSE() { return getToken(CoolParser.ELSE, 0); }
		public TerminalNode FI() { return getToken(CoolParser.FI, 0); }
		public TerminalNode IF() { return getToken(CoolParser.IF, 0); }
		public TerminalNode LOOP() { return getToken(CoolParser.LOOP, 0); }
		public TerminalNode POOL() { return getToken(CoolParser.POOL, 0); }
		public TerminalNode WHILE() { return getToken(CoolParser.WHILE, 0); }
		public TerminalNode RBRACE() { return getToken(CoolParser.RBRACE, 0); }
		public TerminalNode LBRACE() { return getToken(CoolParser.LBRACE, 0); }
		public Expr_blockContext expr_block() {
			return getRuleContext(Expr_blockContext.class,0);
		}
		public TerminalNode OF() { return getToken(CoolParser.OF, 0); }
		public TerminalNode ESAC() { return getToken(CoolParser.ESAC, 0); }
		public TerminalNode CASE() { return getToken(CoolParser.CASE, 0); }
		public Case_listContext case_list() {
			return getRuleContext(Case_listContext.class,0);
		}
		public TerminalNode NEW() { return getToken(CoolParser.NEW, 0); }
		public TerminalNode TYPEID() { return getToken(CoolParser.TYPEID, 0); }
		public TerminalNode INT_CONST() { return getToken(CoolParser.INT_CONST, 0); }
		public TerminalNode STR_CONST() { return getToken(CoolParser.STR_CONST, 0); }
		public TerminalNode BOOL_CONST() { return getToken(CoolParser.BOOL_CONST, 0); }
		public TerminalNode STAR() { return getToken(CoolParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(CoolParser.SLASH, 0); }
		public TerminalNode PLUS() { return getToken(CoolParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(CoolParser.MINUS, 0); }
		public TerminalNode LT() { return getToken(CoolParser.LT, 0); }
		public TerminalNode LE() { return getToken(CoolParser.LE, 0); }
		public TerminalNode EQUALS() { return getToken(CoolParser.EQUALS, 0); }
		public TerminalNode DOT() { return getToken(CoolParser.DOT, 0); }
		public TerminalNode ATSYM() { return getToken(CoolParser.ATSYM, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CoolParserVisitor ) return ((CoolParserVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
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
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(179);
				((ExprContext)_localctx).l = match(LET);
				setState(180);
				((ExprContext)_localctx).lb = let_base();
				setState(181);
				match(IN);
				setState(182);
				((ExprContext)_localctx).e = expr(19);

				        ((ExprContext)_localctx).value =  ((ExprContext)_localctx).e.value;
				        AST.attr thia;
				        for(int i = ((ExprContext)_localctx).lb.value.size() - 1; i>=0; --i){
				            thia = ((ExprContext)_localctx).lb.value.get(i);
				            ((ExprContext)_localctx).value =  new AST.let(thia.name, thia.typeid, thia.value, _localctx.value, ((ExprContext)_localctx).l.getLine());
				        }
				    
				}
				break;
			case 2:
				{
				setState(185);
				((ExprContext)_localctx).t = match(TILDE);
				setState(186);
				((ExprContext)_localctx).e = expr(16);

				        ((ExprContext)_localctx).value =  new AST.comp(((ExprContext)_localctx).e.value, ((ExprContext)_localctx).t.getLine());
				    
				}
				break;
			case 3:
				{
				setState(189);
				((ExprContext)_localctx).i = match(ISVOID);
				setState(190);
				((ExprContext)_localctx).e = expr(15);

				        ((ExprContext)_localctx).value =  new AST.isvoid(((ExprContext)_localctx).e.value, ((ExprContext)_localctx).i.getLine());
				    
				}
				break;
			case 4:
				{
				setState(193);
				((ExprContext)_localctx).n = match(NOT);
				setState(194);
				((ExprContext)_localctx).e = expr(7);

				        ((ExprContext)_localctx).value =  new AST.neg(((ExprContext)_localctx).e.value, ((ExprContext)_localctx).n.getLine());
				    
				}
				break;
			case 5:
				{
				setState(197);
				((ExprContext)_localctx).obj = match(OBJECTID);
				setState(198);
				match(ASSIGN);
				setState(199);
				((ExprContext)_localctx).e = expr(6);

				        ((ExprContext)_localctx).value =  new AST.assign(((ExprContext)_localctx).obj.getText(), ((ExprContext)_localctx).e.value, ((ExprContext)_localctx).obj.getLine());
				    
				}
				break;
			case 6:
				{
				setState(202);
				((ExprContext)_localctx).obj = match(OBJECTID);
				setState(203);
				match(LPAREN);
				setState(204);
				((ExprContext)_localctx).e_opt = expr_comma_expr();
				setState(205);
				match(RPAREN);

				        ((ExprContext)_localctx).value =  new AST.dispatch(new AST.object("self", ((ExprContext)_localctx).obj.getLine()), ((ExprContext)_localctx).obj.getText(), ((ExprContext)_localctx).e_opt.value, ((ExprContext)_localctx).obj.getLine());
				    
				}
				break;
			case 7:
				{
				setState(208);
				((ExprContext)_localctx).i = match(IF);
				setState(209);
				((ExprContext)_localctx).e_if = expr(0);
				setState(210);
				match(THEN);
				setState(211);
				((ExprContext)_localctx).e_then = expr(0);
				setState(212);
				match(ELSE);
				setState(213);
				((ExprContext)_localctx).e_else = expr(0);
				setState(214);
				match(FI);

				         ((ExprContext)_localctx).value =  new AST.cond(((ExprContext)_localctx).e_if.value, ((ExprContext)_localctx).e_then.value, ((ExprContext)_localctx).e_else.value, ((ExprContext)_localctx).i.getLine());
				    
				}
				break;
			case 8:
				{
				setState(217);
				((ExprContext)_localctx).w = match(WHILE);
				setState(218);
				((ExprContext)_localctx).e_cond = expr(0);
				setState(219);
				match(LOOP);
				setState(220);
				((ExprContext)_localctx).e_loop = expr(0);
				setState(221);
				match(POOL);

				        ((ExprContext)_localctx).value =  new AST.loop (((ExprContext)_localctx).e_cond.value, ((ExprContext)_localctx).e_loop.value, ((ExprContext)_localctx).w.getLine());
				    
				}
				break;
			case 9:
				{
				setState(224);
				((ExprContext)_localctx).l = match(LBRACE);
				setState(225);
				((ExprContext)_localctx).eb = expr_block();
				setState(226);
				match(RBRACE);

				        ((ExprContext)_localctx).value =  new AST.block(((ExprContext)_localctx).eb.value,((ExprContext)_localctx).l.getLine());
				    
				}
				break;
			case 10:
				{
				setState(229);
				((ExprContext)_localctx).c_line = match(CASE);
				setState(230);
				((ExprContext)_localctx).e = expr(0);
				setState(231);
				match(OF);
				setState(232);
				((ExprContext)_localctx).c = case_list();
				setState(233);
				match(ESAC);

				        ((ExprContext)_localctx).value =  new AST.typcase(((ExprContext)_localctx).e.value, ((ExprContext)_localctx).c.value, ((ExprContext)_localctx).c_line.getLine());
				    
				}
				break;
			case 11:
				{
				setState(236);
				((ExprContext)_localctx).n = match(NEW);
				setState(237);
				((ExprContext)_localctx).type = match(TYPEID);

				        ((ExprContext)_localctx).value =  new AST.new_(((ExprContext)_localctx).type.getText(), ((ExprContext)_localctx).n.getLine());
				    
				}
				break;
			case 12:
				{
				setState(239);
				match(LPAREN);
				setState(240);
				((ExprContext)_localctx).e = expr(0);
				setState(241);
				match(RPAREN);

				        ((ExprContext)_localctx).value =  ((ExprContext)_localctx).e.value;
				    
				}
				break;
			case 13:
				{
				setState(244);
				((ExprContext)_localctx).obj = match(OBJECTID);

				        ((ExprContext)_localctx).value =  new AST.object(((ExprContext)_localctx).obj.getText(), ((ExprContext)_localctx).obj.getLine());
				    
				}
				break;
			case 14:
				{
				setState(246);
				((ExprContext)_localctx).i = match(INT_CONST);

				        ((ExprContext)_localctx).value =  new AST.int_const(Integer.parseInt(((ExprContext)_localctx).i.getText()), ((ExprContext)_localctx).i.getLine());
				    
				}
				break;
			case 15:
				{
				setState(248);
				((ExprContext)_localctx).str = match(STR_CONST);

				        ((ExprContext)_localctx).value =  new AST.string_const(((ExprContext)_localctx).str.getText(), ((ExprContext)_localctx).str.getLine());
				    
				}
				break;
			case 16:
				{
				setState(250);
				((ExprContext)_localctx).b = match(BOOL_CONST);

				        ((ExprContext)_localctx).value =  new AST.bool_const(((ExprContext)_localctx).b.getText().charAt(0)=='t', ((ExprContext)_localctx).b.getLine());
				    
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(309);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(307);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e_l = _prevctx;
						_localctx.e_l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(254);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(255);
						match(STAR);
						setState(256);
						((ExprContext)_localctx).e_r = expr(15);

						                  ((ExprContext)_localctx).value =  new AST.mul(((ExprContext)_localctx).e_l.value, ((ExprContext)_localctx).e_r.value, ((ExprContext)_localctx).e_l.value.lineNo);
						              
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e_l = _prevctx;
						_localctx.e_l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(259);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(260);
						match(SLASH);
						setState(261);
						((ExprContext)_localctx).e_r = expr(14);

						                  ((ExprContext)_localctx).value =  new AST.divide(((ExprContext)_localctx).e_l.value, ((ExprContext)_localctx).e_r.value, ((ExprContext)_localctx).e_l.value.lineNo);
						              
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e_l = _prevctx;
						_localctx.e_l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(264);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(265);
						match(PLUS);
						setState(266);
						((ExprContext)_localctx).e_r = expr(13);

						                  ((ExprContext)_localctx).value =  new AST.plus(((ExprContext)_localctx).e_l.value, ((ExprContext)_localctx).e_r.value, ((ExprContext)_localctx).e_l.value.lineNo);
						              
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e_l = _prevctx;
						_localctx.e_l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(269);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(270);
						match(MINUS);
						setState(271);
						((ExprContext)_localctx).e_r = expr(12);

						                  ((ExprContext)_localctx).value =  new AST.sub(((ExprContext)_localctx).e_l.value, ((ExprContext)_localctx).e_r.value, ((ExprContext)_localctx).e_l.value.lineNo);
						              
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e_l = _prevctx;
						_localctx.e_l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(274);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(275);
						match(LT);
						setState(276);
						((ExprContext)_localctx).e_r = expr(11);

						                  ((ExprContext)_localctx).value =  new AST.lt(((ExprContext)_localctx).e_l.value, ((ExprContext)_localctx).e_r.value, ((ExprContext)_localctx).e_l.value.lineNo);
						              
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e_l = _prevctx;
						_localctx.e_l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(279);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(280);
						match(LE);
						setState(281);
						((ExprContext)_localctx).e_r = expr(10);

						                  ((ExprContext)_localctx).value =  new AST.leq(((ExprContext)_localctx).e_l.value, ((ExprContext)_localctx).e_r.value, ((ExprContext)_localctx).e_l.value.lineNo);
						              
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e_l = _prevctx;
						_localctx.e_l = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(284);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(285);
						match(EQUALS);
						setState(286);
						((ExprContext)_localctx).e_r = expr(9);

						                  ((ExprContext)_localctx).value =  new AST.eq(((ExprContext)_localctx).e_l.value, ((ExprContext)_localctx).e_r.value, ((ExprContext)_localctx).e_l.value.lineNo);
						              
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e = _prevctx;
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(289);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(290);
						match(DOT);
						setState(291);
						((ExprContext)_localctx).obj = match(OBJECTID);
						setState(292);
						match(LPAREN);
						setState(293);
						((ExprContext)_localctx).e_opt = expr_comma_expr();
						setState(294);
						match(RPAREN);

						                  ((ExprContext)_localctx).value =  new AST.dispatch(((ExprContext)_localctx).e.value, ((ExprContext)_localctx).obj.getText(), ((ExprContext)_localctx).e_opt.value, ((ExprContext)_localctx).e.value.lineNo);
						              
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						_localctx.e = _prevctx;
						_localctx.e = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(297);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(298);
						match(ATSYM);
						setState(299);
						((ExprContext)_localctx).type = match(TYPEID);
						setState(300);
						match(DOT);
						setState(301);
						((ExprContext)_localctx).obj = match(OBJECTID);
						setState(302);
						match(LPAREN);
						setState(303);
						((ExprContext)_localctx).e_opt = expr_comma_expr();
						setState(304);
						match(RPAREN);

						                  ((ExprContext)_localctx).value =  new AST.static_dispatch(((ExprContext)_localctx).e.value, ((ExprContext)_localctx).type.getText(), ((ExprContext)_localctx).obj.getText(), ((ExprContext)_localctx).e_opt.value, ((ExprContext)_localctx).e.value.lineNo);
						              
						}
						break;
					}
					} 
				}
				setState(311);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
			return precpred(_ctx, 14);
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 10);
		case 5:
			return precpred(_ctx, 9);
		case 6:
			return precpred(_ctx, 8);
		case 7:
			return precpred(_ctx, 25);
		case 8:
			return precpred(_ctx, 24);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3@\u013b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3"+
		"\3\7\3\'\n\3\f\3\16\3*\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\5\4<\n\4\3\5\3\5\3\5\3\5\7\5B\n\5\f\5\16\5E\13"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6g\n\6"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\7\7o\n\7\f\7\16\7r\13\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\t\3\t\3\t\6\t|\n\t\r\t\16\t}\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\6\13\u008c\n\13\r\13\16\13\u008d\3\f\3\f\3\f\3\f\3\f\3\f\7"+
		"\f\u0096\n\f\f\f\16\f\u0099\13\f\5\f\u009b\n\f\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\7\r\u00a3\n\r\f\r\16\r\u00a6\13\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\5\16\u00b3\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00ff\n\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u0136\n\17"+
		"\f\17\16\17\u0139\13\17\3\17\2\3\34\20\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\2\2\u0151\2\36\3\2\2\2\4(\3\2\2\2\6;\3\2\2\2\bC\3\2\2\2\nf\3\2\2\2"+
		"\fh\3\2\2\2\16s\3\2\2\2\20{\3\2\2\2\22\177\3\2\2\2\24\u008b\3\2\2\2\26"+
		"\u009a\3\2\2\2\30\u009c\3\2\2\2\32\u00b2\3\2\2\2\34\u00fe\3\2\2\2\36\37"+
		"\5\4\3\2\37 \7\2\2\3 !\b\2\1\2!\3\3\2\2\2\"#\5\6\4\2#$\7\r\2\2$%\b\3\1"+
		"\2%\'\3\2\2\2&\"\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)\5\3\2\2\2*(\3"+
		"\2\2\2+,\7\34\2\2,-\7\4\2\2-.\7\26\2\2./\5\b\5\2/\60\7\27\2\2\60\61\b"+
		"\4\1\2\61<\3\2\2\2\62\63\7\34\2\2\63\64\7\4\2\2\64\65\7!\2\2\65\66\7\4"+
		"\2\2\66\67\7\26\2\2\678\5\b\5\289\7\27\2\29:\b\4\1\2:<\3\2\2\2;+\3\2\2"+
		"\2;\62\3\2\2\2<\7\3\2\2\2=>\5\n\6\2>?\7\r\2\2?@\b\5\1\2@B\3\2\2\2A=\3"+
		"\2\2\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2D\t\3\2\2\2EC\3\2\2\2FG\7\5\2\2GH"+
		"\7\t\2\2HI\7\n\2\2IJ\7\13\2\2JK\7\4\2\2KL\7\26\2\2LM\5\34\17\2MN\7\27"+
		"\2\2NO\b\6\1\2Og\3\2\2\2PQ\7\5\2\2QR\7\t\2\2RS\5\f\7\2ST\7\n\2\2TU\7\13"+
		"\2\2UV\7\4\2\2VW\7\26\2\2WX\5\34\17\2XY\7\27\2\2YZ\b\6\1\2Zg\3\2\2\2["+
		"\\\7\5\2\2\\]\7\13\2\2]^\7\4\2\2^g\b\6\1\2_`\7\5\2\2`a\7\13\2\2ab\7\4"+
		"\2\2bc\7\33\2\2cd\5\34\17\2de\b\6\1\2eg\3\2\2\2fF\3\2\2\2fP\3\2\2\2f["+
		"\3\2\2\2f_\3\2\2\2g\13\3\2\2\2hi\5\16\b\2ip\b\7\1\2jk\7\16\2\2kl\5\16"+
		"\b\2lm\b\7\1\2mo\3\2\2\2nj\3\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2q\r\3"+
		"\2\2\2rp\3\2\2\2st\7\5\2\2tu\7\13\2\2uv\7\4\2\2vw\b\b\1\2w\17\3\2\2\2"+
		"xy\5\22\n\2yz\b\t\1\2z|\3\2\2\2{x\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2\2"+
		"\2~\21\3\2\2\2\177\u0080\7\5\2\2\u0080\u0081\7\13\2\2\u0081\u0082\7\4"+
		"\2\2\u0082\u0083\7\31\2\2\u0083\u0084\5\34\17\2\u0084\u0085\7\r\2\2\u0085"+
		"\u0086\b\n\1\2\u0086\23\3\2\2\2\u0087\u0088\5\34\17\2\u0088\u0089\7\r"+
		"\2\2\u0089\u008a\b\13\1\2\u008a\u008c\3\2\2\2\u008b\u0087\3\2\2\2\u008c"+
		"\u008d\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\25\3\2\2"+
		"\2\u008f\u0090\5\34\17\2\u0090\u0097\b\f\1\2\u0091\u0092\7\16\2\2\u0092"+
		"\u0093\5\34\17\2\u0093\u0094\b\f\1\2\u0094\u0096\3\2\2\2\u0095\u0091\3"+
		"\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098"+
		"\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u008f\3\2\2\2\u009a\u009b\3\2"+
		"\2\2\u009b\27\3\2\2\2\u009c\u009d\5\32\16\2\u009d\u00a4\b\r\1\2\u009e"+
		"\u009f\7\16\2\2\u009f\u00a0\5\32\16\2\u00a0\u00a1\b\r\1\2\u00a1\u00a3"+
		"\3\2\2\2\u00a2\u009e\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4"+
		"\u00a5\3\2\2\2\u00a5\31\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00a8\7\5\2"+
		"\2\u00a8\u00a9\7\13\2\2\u00a9\u00aa\7\4\2\2\u00aa\u00b3\b\16\1\2\u00ab"+
		"\u00ac\7\5\2\2\u00ac\u00ad\7\13\2\2\u00ad\u00ae\7\4\2\2\u00ae\u00af\7"+
		"\33\2\2\u00af\u00b0\5\34\17\2\u00b0\u00b1\b\16\1\2\u00b1\u00b3\3\2\2\2"+
		"\u00b2\u00a7\3\2\2\2\u00b2\u00ab\3\2\2\2\u00b3\33\3\2\2\2\u00b4\u00b5"+
		"\b\17\1\2\u00b5\u00b6\7\"\2\2\u00b6\u00b7\5\30\r\2\u00b7\u00b8\7 \2\2"+
		"\u00b8\u00b9\5\34\17\25\u00b9\u00ba\b\17\1\2\u00ba\u00ff\3\2\2\2\u00bb"+
		"\u00bc\7\23\2\2\u00bc\u00bd\5\34\17\22\u00bd\u00be\b\17\1\2\u00be\u00ff"+
		"\3\2\2\2\u00bf\u00c0\7+\2\2\u00c0\u00c1\5\34\17\21\u00c1\u00c2\b\17\1"+
		"\2\u00c2\u00ff\3\2\2\2\u00c3\u00c4\7,\2\2\u00c4\u00c5\5\34\17\t\u00c5"+
		"\u00c6\b\17\1\2\u00c6\u00ff\3\2\2\2\u00c7\u00c8\7\5\2\2\u00c8\u00c9\7"+
		"\33\2\2\u00c9\u00ca\5\34\17\b\u00ca\u00cb\b\17\1\2\u00cb\u00ff\3\2\2\2"+
		"\u00cc\u00cd\7\5\2\2\u00cd\u00ce\7\t\2\2\u00ce\u00cf\5\26\f\2\u00cf\u00d0"+
		"\7\n\2\2\u00d0\u00d1\b\17\1\2\u00d1\u00ff\3\2\2\2\u00d2\u00d3\7\37\2\2"+
		"\u00d3\u00d4\5\34\17\2\u00d4\u00d5\7%\2\2\u00d5\u00d6\5\34\17\2\u00d6"+
		"\u00d7\7\35\2\2\u00d7\u00d8\5\34\17\2\u00d8\u00d9\7\36\2\2\u00d9\u00da"+
		"\b\17\1\2\u00da\u00ff\3\2\2\2\u00db\u00dc\7&\2\2\u00dc\u00dd\5\34\17\2"+
		"\u00dd\u00de\7#\2\2\u00de\u00df\5\34\17\2\u00df\u00e0\7$\2\2\u00e0\u00e1"+
		"\b\17\1\2\u00e1\u00ff\3\2\2\2\u00e2\u00e3\7\26\2\2\u00e3\u00e4\5\24\13"+
		"\2\u00e4\u00e5\7\27\2\2\u00e5\u00e6\b\17\1\2\u00e6\u00ff\3\2\2\2\u00e7"+
		"\u00e8\7\'\2\2\u00e8\u00e9\5\34\17\2\u00e9\u00ea\7)\2\2\u00ea\u00eb\5"+
		"\20\t\2\u00eb\u00ec\7(\2\2\u00ec\u00ed\b\17\1\2\u00ed\u00ff\3\2\2\2\u00ee"+
		"\u00ef\7*\2\2\u00ef\u00f0\7\4\2\2\u00f0\u00ff\b\17\1\2\u00f1\u00f2\7\t"+
		"\2\2\u00f2\u00f3\5\34\17\2\u00f3\u00f4\7\n\2\2\u00f4\u00f5\b\17\1\2\u00f5"+
		"\u00ff\3\2\2\2\u00f6\u00f7\7\5\2\2\u00f7\u00ff\b\17\1\2\u00f8\u00f9\7"+
		"\7\2\2\u00f9\u00ff\b\17\1\2\u00fa\u00fb\7\b\2\2\u00fb\u00ff\b\17\1\2\u00fc"+
		"\u00fd\7\6\2\2\u00fd\u00ff\b\17\1\2\u00fe\u00b4\3\2\2\2\u00fe\u00bb\3"+
		"\2\2\2\u00fe\u00bf\3\2\2\2\u00fe\u00c3\3\2\2\2\u00fe\u00c7\3\2\2\2\u00fe"+
		"\u00cc\3\2\2\2\u00fe\u00d2\3\2\2\2\u00fe\u00db\3\2\2\2\u00fe\u00e2\3\2"+
		"\2\2\u00fe\u00e7\3\2\2\2\u00fe\u00ee\3\2\2\2\u00fe\u00f1\3\2\2\2\u00fe"+
		"\u00f6\3\2\2\2\u00fe\u00f8\3\2\2\2\u00fe\u00fa\3\2\2\2\u00fe\u00fc\3\2"+
		"\2\2\u00ff\u0137\3\2\2\2\u0100\u0101\f\20\2\2\u0101\u0102\7\21\2\2\u0102"+
		"\u0103\5\34\17\21\u0103\u0104\b\17\1\2\u0104\u0136\3\2\2\2\u0105\u0106"+
		"\f\17\2\2\u0106\u0107\7\22\2\2\u0107\u0108\5\34\17\20\u0108\u0109\b\17"+
		"\1\2\u0109\u0136\3\2\2\2\u010a\u010b\f\16\2\2\u010b\u010c\7\17\2\2\u010c"+
		"\u010d\5\34\17\17\u010d\u010e\b\17\1\2\u010e\u0136\3\2\2\2\u010f\u0110"+
		"\f\r\2\2\u0110\u0111\7\20\2\2\u0111\u0112\5\34\17\16\u0112\u0113\b\17"+
		"\1\2\u0113\u0136\3\2\2\2\u0114\u0115\f\f\2\2\u0115\u0116\7\24\2\2\u0116"+
		"\u0117\5\34\17\r\u0117\u0118\b\17\1\2\u0118\u0136\3\2\2\2\u0119\u011a"+
		"\f\13\2\2\u011a\u011b\7\32\2\2\u011b\u011c\5\34\17\f\u011c\u011d\b\17"+
		"\1\2\u011d\u0136\3\2\2\2\u011e\u011f\f\n\2\2\u011f\u0120\7\25\2\2\u0120"+
		"\u0121\5\34\17\13\u0121\u0122\b\17\1\2\u0122\u0136\3\2\2\2\u0123\u0124"+
		"\f\33\2\2\u0124\u0125\7\30\2\2\u0125\u0126\7\5\2\2\u0126\u0127\7\t\2\2"+
		"\u0127\u0128\5\26\f\2\u0128\u0129\7\n\2\2\u0129\u012a\b\17\1\2\u012a\u0136"+
		"\3\2\2\2\u012b\u012c\f\32\2\2\u012c\u012d\7\f\2\2\u012d\u012e\7\4\2\2"+
		"\u012e\u012f\7\30\2\2\u012f\u0130\7\5\2\2\u0130\u0131\7\t\2\2\u0131\u0132"+
		"\5\26\f\2\u0132\u0133\7\n\2\2\u0133\u0134\b\17\1\2\u0134\u0136\3\2\2\2"+
		"\u0135\u0100\3\2\2\2\u0135\u0105\3\2\2\2\u0135\u010a\3\2\2\2\u0135\u010f"+
		"\3\2\2\2\u0135\u0114\3\2\2\2\u0135\u0119\3\2\2\2\u0135\u011e\3\2\2\2\u0135"+
		"\u0123\3\2\2\2\u0135\u012b\3\2\2\2\u0136\u0139\3\2\2\2\u0137\u0135\3\2"+
		"\2\2\u0137\u0138\3\2\2\2\u0138\35\3\2\2\2\u0139\u0137\3\2\2\2\20(;Cfp"+
		"}\u008d\u0097\u009a\u00a4\u00b2\u00fe\u0135\u0137";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}