
	#include <Token.h>


// Generated from CoolLexer.g4 by ANTLR 4.7.1


#include "CoolLexer.h"


	using namespace std;
	using namespace antlr4;


using namespace antlr4;

using namespace cool;

CoolLexer::CoolLexer(CharStream *input) : Lexer(input) {
  _interpreter = new atn::LexerATNSimulator(this, _atn, _decisionToDFA, _sharedContextCache);
}

CoolLexer::~CoolLexer() {
  delete _interpreter;
}

std::string CoolLexer::getGrammarFileName() const {
  return "CoolLexer.g4";
}

const std::vector<std::string>& CoolLexer::getRuleNames() const {
  return _ruleNames;
}

const std::vector<std::string>& CoolLexer::getChannelNames() const {
  return _channelNames;
}

const std::vector<std::string>& CoolLexer::getModeNames() const {
  return _modeNames;
}

const std::vector<std::string>& CoolLexer::getTokenNames() const {
  return _tokenNames;
}

dfa::Vocabulary& CoolLexer::getVocabulary() const {
  return _vocabulary;
}

const std::vector<uint16_t> CoolLexer::getSerializedATN() const {
  return _serializedATN;
}

const atn::ATN& CoolLexer::getATN() const {
  return _atn;
}


void CoolLexer::action(RuleContext *context, size_t ruleIndex, size_t actionIndex) {
  switch (ruleIndex) {
    case 0: ERRORAction(dynamic_cast<antlr4::RuleContext *>(context), actionIndex); break;
    case 1: STR_CONSTAction(dynamic_cast<antlr4::RuleContext *>(context), actionIndex); break;
    case 49: END_COMMENTAction(dynamic_cast<antlr4::RuleContext *>(context), actionIndex); break;
    case 50: UN_COMMENTAction(dynamic_cast<antlr4::RuleContext *>(context), actionIndex); break;
    case 52: NOTMATCHEDAction(dynamic_cast<antlr4::RuleContext *>(context), actionIndex); break;
    case 53: ERROR1Action(dynamic_cast<antlr4::RuleContext *>(context), actionIndex); break;
    case 54: ERROR2Action(dynamic_cast<antlr4::RuleContext *>(context), actionIndex); break;
    case 58: ERROR3Action(dynamic_cast<antlr4::RuleContext *>(context), actionIndex); break;
    case 60: ERROR4Action(dynamic_cast<antlr4::RuleContext *>(context), actionIndex); break;
    case 61: ERROR5Action(dynamic_cast<antlr4::RuleContext *>(context), actionIndex); break;

  default:
    break;
  }
}

void CoolLexer::ERRORAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 0:  reportError("Unterminated string constant"); break;
    case 1: reportError("Unescaped new line in string literal"); break;
    case 2: reportError(" EOF in string literal"); break;

  default:
    break;
  }
}

void CoolLexer::STR_CONSTAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 3: processString(); break;

  default:
    break;
  }
}

void CoolLexer::END_COMMENTAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 4: reportError("Unmatched *)"); break;

  default:
    break;
  }
}

void CoolLexer::UN_COMMENTAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 5: reportError("Unmatched *)"); break;

  default:
    break;
  }
}

void CoolLexer::NOTMATCHEDAction(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 6: notMatched(); break;

  default:
    break;
  }
}

void CoolLexer::ERROR1Action(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 7:  reportError("EOF in comment"); break;

  default:
    break;
  }
}

void CoolLexer::ERROR2Action(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 8:  reportError("EOF in comment"); break;

  default:
    break;
  }
}

void CoolLexer::ERROR3Action(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 9: reportError("EOF in comment"); break;

  default:
    break;
  }
}

void CoolLexer::ERROR4Action(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 10: reportError("EOF in comment"); break;

  default:
    break;
  }
}

void CoolLexer::ERROR5Action(antlr4::RuleContext *context, size_t actionIndex) {
  switch (actionIndex) {
    case 11: reportError("EOF in comment"); break;

  default:
    break;
  }
}



// Static vars and initialization.
std::vector<dfa::DFA> CoolLexer::_decisionToDFA;
atn::PredictionContextCache CoolLexer::_sharedContextCache;

// We own the ATN which in turn owns the ATN states.
atn::ATN CoolLexer::_atn;
std::vector<uint16_t> CoolLexer::_serializedATN;

std::vector<std::string> CoolLexer::_ruleNames = {
  u8"ERROR", u8"STR_CONST", u8"ESC_SEQUENCE", u8"SEMICOLON", u8"DARROW", 
  u8"CLASS", u8"ELSE", u8"FI", u8"IF", u8"IN", u8"INHERITS", u8"LET", u8"LOOP", 
  u8"POOL", u8"THEN", u8"WHILE", u8"CASE", u8"ESAC", u8"OF", u8"NEW", u8"ISVOID", 
  u8"NOT", u8"BOOL_CONST", u8"LE", u8"ASSIGN", u8"PLUS", u8"MINUS", u8"STAR", 
  u8"SLASH", u8"LPAREN", u8"RPAREN", u8"COLON", u8"LBRACE", u8"RBRACE", 
  u8"DOT", u8"TILDE", u8"LT", u8"ATSYM", u8"COMMA", u8"EQUALS", u8"WS", 
  u8"DIGIT", u8"LLETTER", u8"ULETTER", u8"LETTER", u8"TYPEID", u8"OBJECTID", 
  u8"INT_CONST", u8"LINE_COMMENT", u8"END_COMMENT", u8"UN_COMMENT", u8"COMMENT", 
  u8"NOTMATCHED", u8"ERROR1", u8"ERROR2", u8"BEGINCOMMENT", u8"ENDCOMMENT", 
  u8"COMB", u8"ERROR3", u8"BECOM", u8"ERROR4", u8"ERROR5", u8"ENCOM", u8"COMB2"
};

std::vector<std::string> CoolLexer::_channelNames = {
  "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
};

std::vector<std::string> CoolLexer::_modeNames = {
  u8"DEFAULT_MODE", u8"STARTCOMMENT", u8"NESTCOM"
};

std::vector<std::string> CoolLexer::_literalNames = {
  "", "", "", "", "", "", "", u8"'('", u8"')'", u8"':'", u8"'@'", u8"';'", 
  u8"','", u8"'+'", u8"'-'", u8"'*'", u8"'/'", u8"'~'", u8"'<'", u8"'='", 
  u8"'{'", u8"'}'", u8"'.'", u8"'=>'", u8"'<='", u8"'<-'", "", "", "", "", 
  "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", 
  "", "", "", "", "", "", "", u8"'C*'"
};

std::vector<std::string> CoolLexer::_symbolicNames = {
  "", u8"ERROR", u8"TYPEID", u8"OBJECTID", u8"BOOL_CONST", u8"INT_CONST", 
  u8"STR_CONST", u8"LPAREN", u8"RPAREN", u8"COLON", u8"ATSYM", u8"SEMICOLON", 
  u8"COMMA", u8"PLUS", u8"MINUS", u8"STAR", u8"SLASH", u8"TILDE", u8"LT", 
  u8"EQUALS", u8"LBRACE", u8"RBRACE", u8"DOT", u8"DARROW", u8"LE", u8"ASSIGN", 
  u8"CLASS", u8"ELSE", u8"FI", u8"IF", u8"IN", u8"INHERITS", u8"LET", u8"LOOP", 
  u8"POOL", u8"THEN", u8"WHILE", u8"CASE", u8"ESAC", u8"OF", u8"NEW", u8"ISVOID", 
  u8"NOT", u8"WS", u8"LINE_COMMENT", u8"END_COMMENT", u8"UN_COMMENT", u8"COMMENT", 
  u8"NOTMATCHED", u8"ERROR1", u8"ERROR2", u8"BEGINCOMMENT", u8"ENDCOMMENT", 
  u8"COMB", u8"ERROR3", u8"BECOM", u8"ERROR4", u8"ERROR5", u8"ENCOM", u8"COMB2"
};

dfa::Vocabulary CoolLexer::_vocabulary(_literalNames, _symbolicNames);

std::vector<std::string> CoolLexer::_tokenNames;

CoolLexer::Initializer::Initializer() {
  // This code could be in a static initializer lambda, but VS doesn't allow access to private class members from there.
	for (size_t i = 0; i < _symbolicNames.size(); ++i) {
		std::string name = _vocabulary.getLiteralName(i);
		if (name.empty()) {
			name = _vocabulary.getSymbolicName(i);
		}

		if (name.empty()) {
			_tokenNames.push_back("<INVALID>");
		} else {
      _tokenNames.push_back(name);
    }
	}

  _serializedATN = {
    0x3, 0x608b, 0xa72a, 0x8133, 0xb9ed, 0x417c, 0x3be7, 0x7786, 0x5964, 
    0x2, 0x3d, 0x1bf, 0x8, 0x1, 0x8, 0x1, 0x8, 0x1, 0x4, 0x2, 0x9, 0x2, 
    0x4, 0x3, 0x9, 0x3, 0x4, 0x4, 0x9, 0x4, 0x4, 0x5, 0x9, 0x5, 0x4, 0x6, 
    0x9, 0x6, 0x4, 0x7, 0x9, 0x7, 0x4, 0x8, 0x9, 0x8, 0x4, 0x9, 0x9, 0x9, 
    0x4, 0xa, 0x9, 0xa, 0x4, 0xb, 0x9, 0xb, 0x4, 0xc, 0x9, 0xc, 0x4, 0xd, 
    0x9, 0xd, 0x4, 0xe, 0x9, 0xe, 0x4, 0xf, 0x9, 0xf, 0x4, 0x10, 0x9, 0x10, 
    0x4, 0x11, 0x9, 0x11, 0x4, 0x12, 0x9, 0x12, 0x4, 0x13, 0x9, 0x13, 0x4, 
    0x14, 0x9, 0x14, 0x4, 0x15, 0x9, 0x15, 0x4, 0x16, 0x9, 0x16, 0x4, 0x17, 
    0x9, 0x17, 0x4, 0x18, 0x9, 0x18, 0x4, 0x19, 0x9, 0x19, 0x4, 0x1a, 0x9, 
    0x1a, 0x4, 0x1b, 0x9, 0x1b, 0x4, 0x1c, 0x9, 0x1c, 0x4, 0x1d, 0x9, 0x1d, 
    0x4, 0x1e, 0x9, 0x1e, 0x4, 0x1f, 0x9, 0x1f, 0x4, 0x20, 0x9, 0x20, 0x4, 
    0x21, 0x9, 0x21, 0x4, 0x22, 0x9, 0x22, 0x4, 0x23, 0x9, 0x23, 0x4, 0x24, 
    0x9, 0x24, 0x4, 0x25, 0x9, 0x25, 0x4, 0x26, 0x9, 0x26, 0x4, 0x27, 0x9, 
    0x27, 0x4, 0x28, 0x9, 0x28, 0x4, 0x29, 0x9, 0x29, 0x4, 0x2a, 0x9, 0x2a, 
    0x4, 0x2b, 0x9, 0x2b, 0x4, 0x2c, 0x9, 0x2c, 0x4, 0x2d, 0x9, 0x2d, 0x4, 
    0x2e, 0x9, 0x2e, 0x4, 0x2f, 0x9, 0x2f, 0x4, 0x30, 0x9, 0x30, 0x4, 0x31, 
    0x9, 0x31, 0x4, 0x32, 0x9, 0x32, 0x4, 0x33, 0x9, 0x33, 0x4, 0x34, 0x9, 
    0x34, 0x4, 0x35, 0x9, 0x35, 0x4, 0x36, 0x9, 0x36, 0x4, 0x37, 0x9, 0x37, 
    0x4, 0x38, 0x9, 0x38, 0x4, 0x39, 0x9, 0x39, 0x4, 0x3a, 0x9, 0x3a, 0x4, 
    0x3b, 0x9, 0x3b, 0x4, 0x3c, 0x9, 0x3c, 0x4, 0x3d, 0x9, 0x3d, 0x4, 0x3e, 
    0x9, 0x3e, 0x4, 0x3f, 0x9, 0x3f, 0x4, 0x40, 0x9, 0x40, 0x4, 0x41, 0x9, 
    0x41, 0x3, 0x2, 0x3, 0x2, 0x7, 0x2, 0x88, 0xa, 0x2, 0xc, 0x2, 0xe, 0x2, 
    0x8b, 0xb, 0x2, 0x3, 0x2, 0x3, 0x2, 0x3, 0x2, 0x3, 0x2, 0x3, 0x2, 0x7, 
    0x2, 0x92, 0xa, 0x2, 0xc, 0x2, 0xe, 0x2, 0x95, 0xb, 0x2, 0x3, 0x2, 0x3, 
    0x2, 0x7, 0x2, 0x99, 0xa, 0x2, 0xc, 0x2, 0xe, 0x2, 0x9c, 0xb, 0x2, 0x3, 
    0x2, 0x3, 0x2, 0x3, 0x2, 0x3, 0x2, 0x7, 0x2, 0xa2, 0xa, 0x2, 0xc, 0x2, 
    0xe, 0x2, 0xa5, 0xb, 0x2, 0x3, 0x2, 0x3, 0x2, 0x5, 0x2, 0xa9, 0xa, 0x2, 
    0x3, 0x3, 0x3, 0x3, 0x3, 0x3, 0x7, 0x3, 0xae, 0xa, 0x3, 0xc, 0x3, 0xe, 
    0x3, 0xb1, 0xb, 0x3, 0x3, 0x3, 0x3, 0x3, 0x3, 0x3, 0x3, 0x4, 0x3, 0x4, 
    0x3, 0x4, 0x3, 0x5, 0x3, 0x5, 0x3, 0x6, 0x3, 0x6, 0x3, 0x6, 0x3, 0x7, 
    0x3, 0x7, 0x3, 0x7, 0x3, 0x7, 0x3, 0x7, 0x3, 0x7, 0x3, 0x8, 0x3, 0x8, 
    0x3, 0x8, 0x3, 0x8, 0x3, 0x8, 0x3, 0x9, 0x3, 0x9, 0x3, 0x9, 0x3, 0xa, 
    0x3, 0xa, 0x3, 0xa, 0x3, 0xb, 0x3, 0xb, 0x3, 0xb, 0x3, 0xc, 0x3, 0xc, 
    0x3, 0xc, 0x3, 0xc, 0x3, 0xc, 0x3, 0xc, 0x3, 0xc, 0x3, 0xc, 0x3, 0xc, 
    0x3, 0xd, 0x3, 0xd, 0x3, 0xd, 0x3, 0xd, 0x3, 0xe, 0x3, 0xe, 0x3, 0xe, 
    0x3, 0xe, 0x3, 0xe, 0x3, 0xf, 0x3, 0xf, 0x3, 0xf, 0x3, 0xf, 0x3, 0xf, 
    0x3, 0x10, 0x3, 0x10, 0x3, 0x10, 0x3, 0x10, 0x3, 0x10, 0x3, 0x11, 0x3, 
    0x11, 0x3, 0x11, 0x3, 0x11, 0x3, 0x11, 0x3, 0x11, 0x3, 0x12, 0x3, 0x12, 
    0x3, 0x12, 0x3, 0x12, 0x3, 0x12, 0x3, 0x13, 0x3, 0x13, 0x3, 0x13, 0x3, 
    0x13, 0x3, 0x13, 0x3, 0x14, 0x3, 0x14, 0x3, 0x14, 0x3, 0x15, 0x3, 0x15, 
    0x3, 0x15, 0x3, 0x15, 0x3, 0x16, 0x3, 0x16, 0x3, 0x16, 0x3, 0x16, 0x3, 
    0x16, 0x3, 0x16, 0x3, 0x16, 0x3, 0x17, 0x3, 0x17, 0x3, 0x17, 0x3, 0x17, 
    0x3, 0x18, 0x3, 0x18, 0x3, 0x18, 0x3, 0x18, 0x3, 0x18, 0x3, 0x18, 0x3, 
    0x18, 0x3, 0x18, 0x3, 0x18, 0x5, 0x18, 0x119, 0xa, 0x18, 0x3, 0x19, 
    0x3, 0x19, 0x3, 0x19, 0x3, 0x1a, 0x3, 0x1a, 0x3, 0x1a, 0x3, 0x1b, 0x3, 
    0x1b, 0x3, 0x1c, 0x3, 0x1c, 0x3, 0x1d, 0x3, 0x1d, 0x3, 0x1e, 0x3, 0x1e, 
    0x3, 0x1f, 0x3, 0x1f, 0x3, 0x20, 0x3, 0x20, 0x3, 0x21, 0x3, 0x21, 0x3, 
    0x22, 0x3, 0x22, 0x3, 0x23, 0x3, 0x23, 0x3, 0x24, 0x3, 0x24, 0x3, 0x25, 
    0x3, 0x25, 0x3, 0x26, 0x3, 0x26, 0x3, 0x27, 0x3, 0x27, 0x3, 0x28, 0x3, 
    0x28, 0x3, 0x29, 0x3, 0x29, 0x3, 0x2a, 0x6, 0x2a, 0x140, 0xa, 0x2a, 
    0xd, 0x2a, 0xe, 0x2a, 0x141, 0x3, 0x2a, 0x3, 0x2a, 0x3, 0x2b, 0x3, 0x2b, 
    0x3, 0x2c, 0x3, 0x2c, 0x3, 0x2d, 0x3, 0x2d, 0x3, 0x2e, 0x3, 0x2e, 0x3, 
    0x2f, 0x3, 0x2f, 0x3, 0x2f, 0x3, 0x2f, 0x7, 0x2f, 0x152, 0xa, 0x2f, 
    0xc, 0x2f, 0xe, 0x2f, 0x155, 0xb, 0x2f, 0x3, 0x30, 0x3, 0x30, 0x3, 0x30, 
    0x3, 0x30, 0x7, 0x30, 0x15b, 0xa, 0x30, 0xc, 0x30, 0xe, 0x30, 0x15e, 
    0xb, 0x30, 0x3, 0x31, 0x6, 0x31, 0x161, 0xa, 0x31, 0xd, 0x31, 0xe, 0x31, 
    0x162, 0x3, 0x32, 0x3, 0x32, 0x3, 0x32, 0x3, 0x32, 0x7, 0x32, 0x169, 
    0xa, 0x32, 0xc, 0x32, 0xe, 0x32, 0x16c, 0xb, 0x32, 0x3, 0x32, 0x3, 0x32, 
    0x3, 0x32, 0x3, 0x32, 0x3, 0x33, 0x3, 0x33, 0x3, 0x33, 0x3, 0x33, 0x3, 
    0x33, 0x3, 0x33, 0x3, 0x34, 0x3, 0x34, 0x3, 0x34, 0x3, 0x34, 0x3, 0x34, 
    0x3, 0x35, 0x3, 0x35, 0x3, 0x35, 0x3, 0x35, 0x3, 0x35, 0x3, 0x35, 0x3, 
    0x36, 0x3, 0x36, 0x3, 0x36, 0x3, 0x37, 0x3, 0x37, 0x3, 0x37, 0x3, 0x37, 
    0x3, 0x38, 0x3, 0x38, 0x3, 0x38, 0x3, 0x38, 0x3, 0x38, 0x3, 0x38, 0x3, 
    0x39, 0x3, 0x39, 0x3, 0x39, 0x3, 0x39, 0x3, 0x39, 0x3, 0x39, 0x3, 0x3a, 
    0x3, 0x3a, 0x3, 0x3a, 0x3, 0x3a, 0x3, 0x3a, 0x3, 0x3a, 0x3, 0x3b, 0x3, 
    0x3b, 0x3, 0x3b, 0x3, 0x3b, 0x3, 0x3c, 0x3, 0x3c, 0x3, 0x3c, 0x3, 0x3c, 
    0x3, 0x3d, 0x3, 0x3d, 0x3, 0x3d, 0x3, 0x3d, 0x3, 0x3d, 0x3, 0x3d, 0x3, 
    0x3e, 0x3, 0x3e, 0x3, 0x3e, 0x3, 0x3e, 0x3, 0x3e, 0x3, 0x3e, 0x3, 0x3f, 
    0x3, 0x3f, 0x3, 0x3f, 0x3, 0x3f, 0x3, 0x3f, 0x3, 0x3f, 0x3, 0x40, 0x3, 
    0x40, 0x3, 0x40, 0x3, 0x40, 0x3, 0x40, 0x3, 0x40, 0x3, 0x41, 0x3, 0x41, 
    0x3, 0x41, 0x3, 0x41, 0x4, 0x9a, 0x16a, 0x2, 0x42, 0x5, 0x3, 0x7, 0x8, 
    0x9, 0x2, 0xb, 0xd, 0xd, 0x19, 0xf, 0x1c, 0x11, 0x1d, 0x13, 0x1e, 0x15, 
    0x1f, 0x17, 0x20, 0x19, 0x21, 0x1b, 0x22, 0x1d, 0x23, 0x1f, 0x24, 0x21, 
    0x25, 0x23, 0x26, 0x25, 0x27, 0x27, 0x28, 0x29, 0x29, 0x2b, 0x2a, 0x2d, 
    0x2b, 0x2f, 0x2c, 0x31, 0x6, 0x33, 0x1a, 0x35, 0x1b, 0x37, 0xf, 0x39, 
    0x10, 0x3b, 0x11, 0x3d, 0x12, 0x3f, 0x9, 0x41, 0xa, 0x43, 0xb, 0x45, 
    0x16, 0x47, 0x17, 0x49, 0x18, 0x4b, 0x13, 0x4d, 0x14, 0x4f, 0xc, 0x51, 
    0xe, 0x53, 0x15, 0x55, 0x2d, 0x57, 0x2, 0x59, 0x2, 0x5b, 0x2, 0x5d, 
    0x2, 0x5f, 0x4, 0x61, 0x5, 0x63, 0x7, 0x65, 0x2e, 0x67, 0x2f, 0x69, 
    0x30, 0x6b, 0x31, 0x6d, 0x32, 0x6f, 0x33, 0x71, 0x34, 0x73, 0x35, 0x75, 
    0x36, 0x77, 0x37, 0x79, 0x38, 0x7b, 0x39, 0x7d, 0x3a, 0x7f, 0x3b, 0x81, 
    0x3c, 0x83, 0x3d, 0x5, 0x2, 0x3, 0x4, 0x19, 0x6, 0x2, 0xc, 0xc, 0x24, 
    0x24, 0x47, 0x48, 0x51, 0x51, 0x3, 0x2, 0x24, 0x24, 0x4, 0x2, 0xc, 0xc, 
    0x24, 0x24, 0x5, 0x2, 0xc, 0xc, 0x24, 0x24, 0x5e, 0x5e, 0x4, 0x2, 0x45, 
    0x45, 0x65, 0x65, 0x4, 0x2, 0x4e, 0x4e, 0x6e, 0x6e, 0x4, 0x2, 0x43, 
    0x43, 0x63, 0x63, 0x4, 0x2, 0x55, 0x55, 0x75, 0x75, 0x4, 0x2, 0x47, 
    0x47, 0x67, 0x67, 0x4, 0x2, 0x48, 0x48, 0x68, 0x68, 0x4, 0x2, 0x4b, 
    0x4b, 0x6b, 0x6b, 0x4, 0x2, 0x50, 0x50, 0x70, 0x70, 0x4, 0x2, 0x4a, 
    0x4a, 0x6a, 0x6a, 0x4, 0x2, 0x54, 0x54, 0x74, 0x74, 0x4, 0x2, 0x56, 
    0x56, 0x76, 0x76, 0x4, 0x2, 0x51, 0x51, 0x71, 0x71, 0x4, 0x2, 0x52, 
    0x52, 0x72, 0x72, 0x4, 0x2, 0x59, 0x59, 0x79, 0x79, 0x4, 0x2, 0x58, 
    0x58, 0x78, 0x78, 0x4, 0x2, 0x46, 0x46, 0x66, 0x66, 0x4, 0x2, 0x57, 
    0x57, 0x77, 0x77, 0x5, 0x2, 0xb, 0xc, 0xe, 0xf, 0x22, 0x22, 0x4, 0x2, 
    0x43, 0x5c, 0x63, 0x7c, 0x2, 0x1ca, 0x2, 0x5, 0x3, 0x2, 0x2, 0x2, 0x2, 
    0x7, 0x3, 0x2, 0x2, 0x2, 0x2, 0xb, 0x3, 0x2, 0x2, 0x2, 0x2, 0xd, 0x3, 
    0x2, 0x2, 0x2, 0x2, 0xf, 0x3, 0x2, 0x2, 0x2, 0x2, 0x11, 0x3, 0x2, 0x2, 
    0x2, 0x2, 0x13, 0x3, 0x2, 0x2, 0x2, 0x2, 0x15, 0x3, 0x2, 0x2, 0x2, 0x2, 
    0x17, 0x3, 0x2, 0x2, 0x2, 0x2, 0x19, 0x3, 0x2, 0x2, 0x2, 0x2, 0x1b, 
    0x3, 0x2, 0x2, 0x2, 0x2, 0x1d, 0x3, 0x2, 0x2, 0x2, 0x2, 0x1f, 0x3, 0x2, 
    0x2, 0x2, 0x2, 0x21, 0x3, 0x2, 0x2, 0x2, 0x2, 0x23, 0x3, 0x2, 0x2, 0x2, 
    0x2, 0x25, 0x3, 0x2, 0x2, 0x2, 0x2, 0x27, 0x3, 0x2, 0x2, 0x2, 0x2, 0x29, 
    0x3, 0x2, 0x2, 0x2, 0x2, 0x2b, 0x3, 0x2, 0x2, 0x2, 0x2, 0x2d, 0x3, 0x2, 
    0x2, 0x2, 0x2, 0x2f, 0x3, 0x2, 0x2, 0x2, 0x2, 0x31, 0x3, 0x2, 0x2, 0x2, 
    0x2, 0x33, 0x3, 0x2, 0x2, 0x2, 0x2, 0x35, 0x3, 0x2, 0x2, 0x2, 0x2, 0x37, 
    0x3, 0x2, 0x2, 0x2, 0x2, 0x39, 0x3, 0x2, 0x2, 0x2, 0x2, 0x3b, 0x3, 0x2, 
    0x2, 0x2, 0x2, 0x3d, 0x3, 0x2, 0x2, 0x2, 0x2, 0x3f, 0x3, 0x2, 0x2, 0x2, 
    0x2, 0x41, 0x3, 0x2, 0x2, 0x2, 0x2, 0x43, 0x3, 0x2, 0x2, 0x2, 0x2, 0x45, 
    0x3, 0x2, 0x2, 0x2, 0x2, 0x47, 0x3, 0x2, 0x2, 0x2, 0x2, 0x49, 0x3, 0x2, 
    0x2, 0x2, 0x2, 0x4b, 0x3, 0x2, 0x2, 0x2, 0x2, 0x4d, 0x3, 0x2, 0x2, 0x2, 
    0x2, 0x4f, 0x3, 0x2, 0x2, 0x2, 0x2, 0x51, 0x3, 0x2, 0x2, 0x2, 0x2, 0x53, 
    0x3, 0x2, 0x2, 0x2, 0x2, 0x55, 0x3, 0x2, 0x2, 0x2, 0x2, 0x5f, 0x3, 0x2, 
    0x2, 0x2, 0x2, 0x61, 0x3, 0x2, 0x2, 0x2, 0x2, 0x63, 0x3, 0x2, 0x2, 0x2, 
    0x2, 0x65, 0x3, 0x2, 0x2, 0x2, 0x2, 0x67, 0x3, 0x2, 0x2, 0x2, 0x2, 0x69, 
    0x3, 0x2, 0x2, 0x2, 0x2, 0x6b, 0x3, 0x2, 0x2, 0x2, 0x2, 0x6d, 0x3, 0x2, 
    0x2, 0x2, 0x3, 0x6f, 0x3, 0x2, 0x2, 0x2, 0x3, 0x71, 0x3, 0x2, 0x2, 0x2, 
    0x3, 0x73, 0x3, 0x2, 0x2, 0x2, 0x3, 0x75, 0x3, 0x2, 0x2, 0x2, 0x3, 0x77, 
    0x3, 0x2, 0x2, 0x2, 0x4, 0x79, 0x3, 0x2, 0x2, 0x2, 0x4, 0x7b, 0x3, 0x2, 
    0x2, 0x2, 0x4, 0x7d, 0x3, 0x2, 0x2, 0x2, 0x4, 0x7f, 0x3, 0x2, 0x2, 0x2, 
    0x4, 0x81, 0x3, 0x2, 0x2, 0x2, 0x4, 0x83, 0x3, 0x2, 0x2, 0x2, 0x5, 0xa8, 
    0x3, 0x2, 0x2, 0x2, 0x7, 0xaa, 0x3, 0x2, 0x2, 0x2, 0x9, 0xb5, 0x3, 0x2, 
    0x2, 0x2, 0xb, 0xb8, 0x3, 0x2, 0x2, 0x2, 0xd, 0xba, 0x3, 0x2, 0x2, 0x2, 
    0xf, 0xbd, 0x3, 0x2, 0x2, 0x2, 0x11, 0xc3, 0x3, 0x2, 0x2, 0x2, 0x13, 
    0xc8, 0x3, 0x2, 0x2, 0x2, 0x15, 0xcb, 0x3, 0x2, 0x2, 0x2, 0x17, 0xce, 
    0x3, 0x2, 0x2, 0x2, 0x19, 0xd1, 0x3, 0x2, 0x2, 0x2, 0x1b, 0xda, 0x3, 
    0x2, 0x2, 0x2, 0x1d, 0xde, 0x3, 0x2, 0x2, 0x2, 0x1f, 0xe3, 0x3, 0x2, 
    0x2, 0x2, 0x21, 0xe8, 0x3, 0x2, 0x2, 0x2, 0x23, 0xed, 0x3, 0x2, 0x2, 
    0x2, 0x25, 0xf3, 0x3, 0x2, 0x2, 0x2, 0x27, 0xf8, 0x3, 0x2, 0x2, 0x2, 
    0x29, 0xfd, 0x3, 0x2, 0x2, 0x2, 0x2b, 0x100, 0x3, 0x2, 0x2, 0x2, 0x2d, 
    0x104, 0x3, 0x2, 0x2, 0x2, 0x2f, 0x10b, 0x3, 0x2, 0x2, 0x2, 0x31, 0x118, 
    0x3, 0x2, 0x2, 0x2, 0x33, 0x11a, 0x3, 0x2, 0x2, 0x2, 0x35, 0x11d, 0x3, 
    0x2, 0x2, 0x2, 0x37, 0x120, 0x3, 0x2, 0x2, 0x2, 0x39, 0x122, 0x3, 0x2, 
    0x2, 0x2, 0x3b, 0x124, 0x3, 0x2, 0x2, 0x2, 0x3d, 0x126, 0x3, 0x2, 0x2, 
    0x2, 0x3f, 0x128, 0x3, 0x2, 0x2, 0x2, 0x41, 0x12a, 0x3, 0x2, 0x2, 0x2, 
    0x43, 0x12c, 0x3, 0x2, 0x2, 0x2, 0x45, 0x12e, 0x3, 0x2, 0x2, 0x2, 0x47, 
    0x130, 0x3, 0x2, 0x2, 0x2, 0x49, 0x132, 0x3, 0x2, 0x2, 0x2, 0x4b, 0x134, 
    0x3, 0x2, 0x2, 0x2, 0x4d, 0x136, 0x3, 0x2, 0x2, 0x2, 0x4f, 0x138, 0x3, 
    0x2, 0x2, 0x2, 0x51, 0x13a, 0x3, 0x2, 0x2, 0x2, 0x53, 0x13c, 0x3, 0x2, 
    0x2, 0x2, 0x55, 0x13f, 0x3, 0x2, 0x2, 0x2, 0x57, 0x145, 0x3, 0x2, 0x2, 
    0x2, 0x59, 0x147, 0x3, 0x2, 0x2, 0x2, 0x5b, 0x149, 0x3, 0x2, 0x2, 0x2, 
    0x5d, 0x14b, 0x3, 0x2, 0x2, 0x2, 0x5f, 0x14d, 0x3, 0x2, 0x2, 0x2, 0x61, 
    0x156, 0x3, 0x2, 0x2, 0x2, 0x63, 0x160, 0x3, 0x2, 0x2, 0x2, 0x65, 0x164, 
    0x3, 0x2, 0x2, 0x2, 0x67, 0x171, 0x3, 0x2, 0x2, 0x2, 0x69, 0x177, 0x3, 
    0x2, 0x2, 0x2, 0x6b, 0x17c, 0x3, 0x2, 0x2, 0x2, 0x6d, 0x182, 0x3, 0x2, 
    0x2, 0x2, 0x6f, 0x185, 0x3, 0x2, 0x2, 0x2, 0x71, 0x189, 0x3, 0x2, 0x2, 
    0x2, 0x73, 0x18f, 0x3, 0x2, 0x2, 0x2, 0x75, 0x195, 0x3, 0x2, 0x2, 0x2, 
    0x77, 0x19b, 0x3, 0x2, 0x2, 0x2, 0x79, 0x19f, 0x3, 0x2, 0x2, 0x2, 0x7b, 
    0x1a3, 0x3, 0x2, 0x2, 0x2, 0x7d, 0x1a9, 0x3, 0x2, 0x2, 0x2, 0x7f, 0x1af, 
    0x3, 0x2, 0x2, 0x2, 0x81, 0x1b5, 0x3, 0x2, 0x2, 0x2, 0x83, 0x1bb, 0x3, 
    0x2, 0x2, 0x2, 0x85, 0x89, 0x7, 0x24, 0x2, 0x2, 0x86, 0x88, 0xa, 0x2, 
    0x2, 0x2, 0x87, 0x86, 0x3, 0x2, 0x2, 0x2, 0x88, 0x8b, 0x3, 0x2, 0x2, 
    0x2, 0x89, 0x87, 0x3, 0x2, 0x2, 0x2, 0x89, 0x8a, 0x3, 0x2, 0x2, 0x2, 
    0x8a, 0x8c, 0x3, 0x2, 0x2, 0x2, 0x8b, 0x89, 0x3, 0x2, 0x2, 0x2, 0x8c, 
    0x8d, 0x7, 0xc, 0x2, 0x2, 0x8d, 0xa9, 0x8, 0x2, 0x2, 0x2, 0x8e, 0x93, 
    0x7, 0x24, 0x2, 0x2, 0x8f, 0x92, 0x5, 0x9, 0x4, 0x2, 0x90, 0x92, 0xa, 
    0x3, 0x2, 0x2, 0x91, 0x8f, 0x3, 0x2, 0x2, 0x2, 0x91, 0x90, 0x3, 0x2, 
    0x2, 0x2, 0x92, 0x95, 0x3, 0x2, 0x2, 0x2, 0x93, 0x91, 0x3, 0x2, 0x2, 
    0x2, 0x93, 0x94, 0x3, 0x2, 0x2, 0x2, 0x94, 0x96, 0x3, 0x2, 0x2, 0x2, 
    0x95, 0x93, 0x3, 0x2, 0x2, 0x2, 0x96, 0x9a, 0x7, 0xc, 0x2, 0x2, 0x97, 
    0x99, 0xb, 0x2, 0x2, 0x2, 0x98, 0x97, 0x3, 0x2, 0x2, 0x2, 0x99, 0x9c, 
    0x3, 0x2, 0x2, 0x2, 0x9a, 0x9b, 0x3, 0x2, 0x2, 0x2, 0x9a, 0x98, 0x3, 
    0x2, 0x2, 0x2, 0x9b, 0x9d, 0x3, 0x2, 0x2, 0x2, 0x9c, 0x9a, 0x3, 0x2, 
    0x2, 0x2, 0x9d, 0x9e, 0x7, 0x24, 0x2, 0x2, 0x9e, 0xa9, 0x8, 0x2, 0x3, 
    0x2, 0x9f, 0xa3, 0x7, 0x24, 0x2, 0x2, 0xa0, 0xa2, 0xa, 0x4, 0x2, 0x2, 
    0xa1, 0xa0, 0x3, 0x2, 0x2, 0x2, 0xa2, 0xa5, 0x3, 0x2, 0x2, 0x2, 0xa3, 
    0xa1, 0x3, 0x2, 0x2, 0x2, 0xa3, 0xa4, 0x3, 0x2, 0x2, 0x2, 0xa4, 0xa6, 
    0x3, 0x2, 0x2, 0x2, 0xa5, 0xa3, 0x3, 0x2, 0x2, 0x2, 0xa6, 0xa7, 0x7, 
    0x2, 0x2, 0x3, 0xa7, 0xa9, 0x8, 0x2, 0x4, 0x2, 0xa8, 0x85, 0x3, 0x2, 
    0x2, 0x2, 0xa8, 0x8e, 0x3, 0x2, 0x2, 0x2, 0xa8, 0x9f, 0x3, 0x2, 0x2, 
    0x2, 0xa9, 0x6, 0x3, 0x2, 0x2, 0x2, 0xaa, 0xaf, 0x7, 0x24, 0x2, 0x2, 
    0xab, 0xae, 0x5, 0x9, 0x4, 0x2, 0xac, 0xae, 0xa, 0x5, 0x2, 0x2, 0xad, 
    0xab, 0x3, 0x2, 0x2, 0x2, 0xad, 0xac, 0x3, 0x2, 0x2, 0x2, 0xae, 0xb1, 
    0x3, 0x2, 0x2, 0x2, 0xaf, 0xad, 0x3, 0x2, 0x2, 0x2, 0xaf, 0xb0, 0x3, 
    0x2, 0x2, 0x2, 0xb0, 0xb2, 0x3, 0x2, 0x2, 0x2, 0xb1, 0xaf, 0x3, 0x2, 
    0x2, 0x2, 0xb2, 0xb3, 0x7, 0x24, 0x2, 0x2, 0xb3, 0xb4, 0x8, 0x3, 0x5, 
    0x2, 0xb4, 0x8, 0x3, 0x2, 0x2, 0x2, 0xb5, 0xb6, 0x7, 0x5e, 0x2, 0x2, 
    0xb6, 0xb7, 0xb, 0x2, 0x2, 0x2, 0xb7, 0xa, 0x3, 0x2, 0x2, 0x2, 0xb8, 
    0xb9, 0x7, 0x3d, 0x2, 0x2, 0xb9, 0xc, 0x3, 0x2, 0x2, 0x2, 0xba, 0xbb, 
    0x7, 0x3f, 0x2, 0x2, 0xbb, 0xbc, 0x7, 0x40, 0x2, 0x2, 0xbc, 0xe, 0x3, 
    0x2, 0x2, 0x2, 0xbd, 0xbe, 0x9, 0x6, 0x2, 0x2, 0xbe, 0xbf, 0x9, 0x7, 
    0x2, 0x2, 0xbf, 0xc0, 0x9, 0x8, 0x2, 0x2, 0xc0, 0xc1, 0x9, 0x9, 0x2, 
    0x2, 0xc1, 0xc2, 0x9, 0x9, 0x2, 0x2, 0xc2, 0x10, 0x3, 0x2, 0x2, 0x2, 
    0xc3, 0xc4, 0x9, 0xa, 0x2, 0x2, 0xc4, 0xc5, 0x9, 0x7, 0x2, 0x2, 0xc5, 
    0xc6, 0x9, 0x9, 0x2, 0x2, 0xc6, 0xc7, 0x9, 0xa, 0x2, 0x2, 0xc7, 0x12, 
    0x3, 0x2, 0x2, 0x2, 0xc8, 0xc9, 0x9, 0xb, 0x2, 0x2, 0xc9, 0xca, 0x9, 
    0xc, 0x2, 0x2, 0xca, 0x14, 0x3, 0x2, 0x2, 0x2, 0xcb, 0xcc, 0x9, 0xc, 
    0x2, 0x2, 0xcc, 0xcd, 0x9, 0xb, 0x2, 0x2, 0xcd, 0x16, 0x3, 0x2, 0x2, 
    0x2, 0xce, 0xcf, 0x9, 0xc, 0x2, 0x2, 0xcf, 0xd0, 0x9, 0xd, 0x2, 0x2, 
    0xd0, 0x18, 0x3, 0x2, 0x2, 0x2, 0xd1, 0xd2, 0x9, 0xc, 0x2, 0x2, 0xd2, 
    0xd3, 0x9, 0xd, 0x2, 0x2, 0xd3, 0xd4, 0x9, 0xe, 0x2, 0x2, 0xd4, 0xd5, 
    0x9, 0xa, 0x2, 0x2, 0xd5, 0xd6, 0x9, 0xf, 0x2, 0x2, 0xd6, 0xd7, 0x9, 
    0xc, 0x2, 0x2, 0xd7, 0xd8, 0x9, 0x10, 0x2, 0x2, 0xd8, 0xd9, 0x9, 0x9, 
    0x2, 0x2, 0xd9, 0x1a, 0x3, 0x2, 0x2, 0x2, 0xda, 0xdb, 0x9, 0x7, 0x2, 
    0x2, 0xdb, 0xdc, 0x9, 0xa, 0x2, 0x2, 0xdc, 0xdd, 0x9, 0x10, 0x2, 0x2, 
    0xdd, 0x1c, 0x3, 0x2, 0x2, 0x2, 0xde, 0xdf, 0x9, 0x7, 0x2, 0x2, 0xdf, 
    0xe0, 0x9, 0x11, 0x2, 0x2, 0xe0, 0xe1, 0x9, 0x11, 0x2, 0x2, 0xe1, 0xe2, 
    0x9, 0x12, 0x2, 0x2, 0xe2, 0x1e, 0x3, 0x2, 0x2, 0x2, 0xe3, 0xe4, 0x9, 
    0x12, 0x2, 0x2, 0xe4, 0xe5, 0x9, 0x11, 0x2, 0x2, 0xe5, 0xe6, 0x9, 0x11, 
    0x2, 0x2, 0xe6, 0xe7, 0x9, 0x7, 0x2, 0x2, 0xe7, 0x20, 0x3, 0x2, 0x2, 
    0x2, 0xe8, 0xe9, 0x9, 0x10, 0x2, 0x2, 0xe9, 0xea, 0x9, 0xe, 0x2, 0x2, 
    0xea, 0xeb, 0x9, 0xa, 0x2, 0x2, 0xeb, 0xec, 0x9, 0xd, 0x2, 0x2, 0xec, 
    0x22, 0x3, 0x2, 0x2, 0x2, 0xed, 0xee, 0x9, 0x13, 0x2, 0x2, 0xee, 0xef, 
    0x9, 0xe, 0x2, 0x2, 0xef, 0xf0, 0x9, 0xc, 0x2, 0x2, 0xf0, 0xf1, 0x9, 
    0x7, 0x2, 0x2, 0xf1, 0xf2, 0x9, 0xa, 0x2, 0x2, 0xf2, 0x24, 0x3, 0x2, 
    0x2, 0x2, 0xf3, 0xf4, 0x9, 0x6, 0x2, 0x2, 0xf4, 0xf5, 0x9, 0x8, 0x2, 
    0x2, 0xf5, 0xf6, 0x9, 0x9, 0x2, 0x2, 0xf6, 0xf7, 0x9, 0xa, 0x2, 0x2, 
    0xf7, 0x26, 0x3, 0x2, 0x2, 0x2, 0xf8, 0xf9, 0x9, 0xa, 0x2, 0x2, 0xf9, 
    0xfa, 0x9, 0x9, 0x2, 0x2, 0xfa, 0xfb, 0x9, 0x8, 0x2, 0x2, 0xfb, 0xfc, 
    0x9, 0x6, 0x2, 0x2, 0xfc, 0x28, 0x3, 0x2, 0x2, 0x2, 0xfd, 0xfe, 0x9, 
    0x11, 0x2, 0x2, 0xfe, 0xff, 0x9, 0xb, 0x2, 0x2, 0xff, 0x2a, 0x3, 0x2, 
    0x2, 0x2, 0x100, 0x101, 0x9, 0xd, 0x2, 0x2, 0x101, 0x102, 0x9, 0xa, 
    0x2, 0x2, 0x102, 0x103, 0x9, 0x13, 0x2, 0x2, 0x103, 0x2c, 0x3, 0x2, 
    0x2, 0x2, 0x104, 0x105, 0x9, 0xc, 0x2, 0x2, 0x105, 0x106, 0x9, 0x9, 
    0x2, 0x2, 0x106, 0x107, 0x9, 0x14, 0x2, 0x2, 0x107, 0x108, 0x9, 0x11, 
    0x2, 0x2, 0x108, 0x109, 0x9, 0xc, 0x2, 0x2, 0x109, 0x10a, 0x9, 0x15, 
    0x2, 0x2, 0x10a, 0x2e, 0x3, 0x2, 0x2, 0x2, 0x10b, 0x10c, 0x9, 0xd, 0x2, 
    0x2, 0x10c, 0x10d, 0x9, 0x11, 0x2, 0x2, 0x10d, 0x10e, 0x9, 0x10, 0x2, 
    0x2, 0x10e, 0x30, 0x3, 0x2, 0x2, 0x2, 0x10f, 0x110, 0x7, 0x76, 0x2, 
    0x2, 0x110, 0x111, 0x9, 0xf, 0x2, 0x2, 0x111, 0x112, 0x9, 0x16, 0x2, 
    0x2, 0x112, 0x119, 0x9, 0xa, 0x2, 0x2, 0x113, 0x114, 0x7, 0x68, 0x2, 
    0x2, 0x114, 0x115, 0x9, 0x8, 0x2, 0x2, 0x115, 0x116, 0x9, 0x7, 0x2, 
    0x2, 0x116, 0x117, 0x9, 0x9, 0x2, 0x2, 0x117, 0x119, 0x9, 0xa, 0x2, 
    0x2, 0x118, 0x10f, 0x3, 0x2, 0x2, 0x2, 0x118, 0x113, 0x3, 0x2, 0x2, 
    0x2, 0x119, 0x32, 0x3, 0x2, 0x2, 0x2, 0x11a, 0x11b, 0x7, 0x3e, 0x2, 
    0x2, 0x11b, 0x11c, 0x7, 0x3f, 0x2, 0x2, 0x11c, 0x34, 0x3, 0x2, 0x2, 
    0x2, 0x11d, 0x11e, 0x7, 0x3e, 0x2, 0x2, 0x11e, 0x11f, 0x7, 0x2f, 0x2, 
    0x2, 0x11f, 0x36, 0x3, 0x2, 0x2, 0x2, 0x120, 0x121, 0x7, 0x2d, 0x2, 
    0x2, 0x121, 0x38, 0x3, 0x2, 0x2, 0x2, 0x122, 0x123, 0x7, 0x2f, 0x2, 
    0x2, 0x123, 0x3a, 0x3, 0x2, 0x2, 0x2, 0x124, 0x125, 0x7, 0x2c, 0x2, 
    0x2, 0x125, 0x3c, 0x3, 0x2, 0x2, 0x2, 0x126, 0x127, 0x7, 0x31, 0x2, 
    0x2, 0x127, 0x3e, 0x3, 0x2, 0x2, 0x2, 0x128, 0x129, 0x7, 0x2a, 0x2, 
    0x2, 0x129, 0x40, 0x3, 0x2, 0x2, 0x2, 0x12a, 0x12b, 0x7, 0x2b, 0x2, 
    0x2, 0x12b, 0x42, 0x3, 0x2, 0x2, 0x2, 0x12c, 0x12d, 0x7, 0x3c, 0x2, 
    0x2, 0x12d, 0x44, 0x3, 0x2, 0x2, 0x2, 0x12e, 0x12f, 0x7, 0x7d, 0x2, 
    0x2, 0x12f, 0x46, 0x3, 0x2, 0x2, 0x2, 0x130, 0x131, 0x7, 0x7f, 0x2, 
    0x2, 0x131, 0x48, 0x3, 0x2, 0x2, 0x2, 0x132, 0x133, 0x7, 0x30, 0x2, 
    0x2, 0x133, 0x4a, 0x3, 0x2, 0x2, 0x2, 0x134, 0x135, 0x7, 0x80, 0x2, 
    0x2, 0x135, 0x4c, 0x3, 0x2, 0x2, 0x2, 0x136, 0x137, 0x7, 0x3e, 0x2, 
    0x2, 0x137, 0x4e, 0x3, 0x2, 0x2, 0x2, 0x138, 0x139, 0x7, 0x42, 0x2, 
    0x2, 0x139, 0x50, 0x3, 0x2, 0x2, 0x2, 0x13a, 0x13b, 0x7, 0x2e, 0x2, 
    0x2, 0x13b, 0x52, 0x3, 0x2, 0x2, 0x2, 0x13c, 0x13d, 0x7, 0x3f, 0x2, 
    0x2, 0x13d, 0x54, 0x3, 0x2, 0x2, 0x2, 0x13e, 0x140, 0x9, 0x17, 0x2, 
    0x2, 0x13f, 0x13e, 0x3, 0x2, 0x2, 0x2, 0x140, 0x141, 0x3, 0x2, 0x2, 
    0x2, 0x141, 0x13f, 0x3, 0x2, 0x2, 0x2, 0x141, 0x142, 0x3, 0x2, 0x2, 
    0x2, 0x142, 0x143, 0x3, 0x2, 0x2, 0x2, 0x143, 0x144, 0x8, 0x2a, 0x6, 
    0x2, 0x144, 0x56, 0x3, 0x2, 0x2, 0x2, 0x145, 0x146, 0x4, 0x32, 0x3b, 
    0x2, 0x146, 0x58, 0x3, 0x2, 0x2, 0x2, 0x147, 0x148, 0x4, 0x63, 0x7c, 
    0x2, 0x148, 0x5a, 0x3, 0x2, 0x2, 0x2, 0x149, 0x14a, 0x4, 0x43, 0x5c, 
    0x2, 0x14a, 0x5c, 0x3, 0x2, 0x2, 0x2, 0x14b, 0x14c, 0x9, 0x18, 0x2, 
    0x2, 0x14c, 0x5e, 0x3, 0x2, 0x2, 0x2, 0x14d, 0x153, 0x5, 0x5b, 0x2d, 
    0x2, 0x14e, 0x152, 0x5, 0x57, 0x2b, 0x2, 0x14f, 0x152, 0x7, 0x61, 0x2, 
    0x2, 0x150, 0x152, 0x5, 0x5d, 0x2e, 0x2, 0x151, 0x14e, 0x3, 0x2, 0x2, 
    0x2, 0x151, 0x14f, 0x3, 0x2, 0x2, 0x2, 0x151, 0x150, 0x3, 0x2, 0x2, 
    0x2, 0x152, 0x155, 0x3, 0x2, 0x2, 0x2, 0x153, 0x151, 0x3, 0x2, 0x2, 
    0x2, 0x153, 0x154, 0x3, 0x2, 0x2, 0x2, 0x154, 0x60, 0x3, 0x2, 0x2, 0x2, 
    0x155, 0x153, 0x3, 0x2, 0x2, 0x2, 0x156, 0x15c, 0x5, 0x59, 0x2c, 0x2, 
    0x157, 0x15b, 0x5, 0x57, 0x2b, 0x2, 0x158, 0x15b, 0x7, 0x61, 0x2, 0x2, 
    0x159, 0x15b, 0x5, 0x5d, 0x2e, 0x2, 0x15a, 0x157, 0x3, 0x2, 0x2, 0x2, 
    0x15a, 0x158, 0x3, 0x2, 0x2, 0x2, 0x15a, 0x159, 0x3, 0x2, 0x2, 0x2, 
    0x15b, 0x15e, 0x3, 0x2, 0x2, 0x2, 0x15c, 0x15a, 0x3, 0x2, 0x2, 0x2, 
    0x15c, 0x15d, 0x3, 0x2, 0x2, 0x2, 0x15d, 0x62, 0x3, 0x2, 0x2, 0x2, 0x15e, 
    0x15c, 0x3, 0x2, 0x2, 0x2, 0x15f, 0x161, 0x5, 0x57, 0x2b, 0x2, 0x160, 
    0x15f, 0x3, 0x2, 0x2, 0x2, 0x161, 0x162, 0x3, 0x2, 0x2, 0x2, 0x162, 
    0x160, 0x3, 0x2, 0x2, 0x2, 0x162, 0x163, 0x3, 0x2, 0x2, 0x2, 0x163, 
    0x64, 0x3, 0x2, 0x2, 0x2, 0x164, 0x165, 0x7, 0x2f, 0x2, 0x2, 0x165, 
    0x166, 0x7, 0x2f, 0x2, 0x2, 0x166, 0x16a, 0x3, 0x2, 0x2, 0x2, 0x167, 
    0x169, 0xb, 0x2, 0x2, 0x2, 0x168, 0x167, 0x3, 0x2, 0x2, 0x2, 0x169, 
    0x16c, 0x3, 0x2, 0x2, 0x2, 0x16a, 0x16b, 0x3, 0x2, 0x2, 0x2, 0x16a, 
    0x168, 0x3, 0x2, 0x2, 0x2, 0x16b, 0x16d, 0x3, 0x2, 0x2, 0x2, 0x16c, 
    0x16a, 0x3, 0x2, 0x2, 0x2, 0x16d, 0x16e, 0x7, 0xc, 0x2, 0x2, 0x16e, 
    0x16f, 0x3, 0x2, 0x2, 0x2, 0x16f, 0x170, 0x8, 0x32, 0x6, 0x2, 0x170, 
    0x66, 0x3, 0x2, 0x2, 0x2, 0x171, 0x172, 0x7, 0x2c, 0x2, 0x2, 0x172, 
    0x173, 0x7, 0x2b, 0x2, 0x2, 0x173, 0x174, 0x3, 0x2, 0x2, 0x2, 0x174, 
    0x175, 0x7, 0x2, 0x2, 0x3, 0x175, 0x176, 0x8, 0x33, 0x7, 0x2, 0x176, 
    0x68, 0x3, 0x2, 0x2, 0x2, 0x177, 0x178, 0x7, 0x2c, 0x2, 0x2, 0x178, 
    0x179, 0x7, 0x2b, 0x2, 0x2, 0x179, 0x17a, 0x3, 0x2, 0x2, 0x2, 0x17a, 
    0x17b, 0x8, 0x34, 0x8, 0x2, 0x17b, 0x6a, 0x3, 0x2, 0x2, 0x2, 0x17c, 
    0x17d, 0x7, 0x2a, 0x2, 0x2, 0x17d, 0x17e, 0x7, 0x2c, 0x2, 0x2, 0x17e, 
    0x17f, 0x3, 0x2, 0x2, 0x2, 0x17f, 0x180, 0x8, 0x35, 0x9, 0x2, 0x180, 
    0x181, 0x8, 0x35, 0x6, 0x2, 0x181, 0x6c, 0x3, 0x2, 0x2, 0x2, 0x182, 
    0x183, 0xb, 0x2, 0x2, 0x2, 0x183, 0x184, 0x8, 0x36, 0xa, 0x2, 0x184, 
    0x6e, 0x3, 0x2, 0x2, 0x2, 0x185, 0x186, 0xb, 0x2, 0x2, 0x2, 0x186, 0x187, 
    0x7, 0x2, 0x2, 0x3, 0x187, 0x188, 0x8, 0x37, 0xb, 0x2, 0x188, 0x70, 
    0x3, 0x2, 0x2, 0x2, 0x189, 0x18a, 0x7, 0x2a, 0x2, 0x2, 0x18a, 0x18b, 
    0x7, 0x2c, 0x2, 0x2, 0x18b, 0x18c, 0x3, 0x2, 0x2, 0x2, 0x18c, 0x18d, 
    0x7, 0x2, 0x2, 0x3, 0x18d, 0x18e, 0x8, 0x38, 0xc, 0x2, 0x18e, 0x72, 
    0x3, 0x2, 0x2, 0x2, 0x18f, 0x190, 0x7, 0x2a, 0x2, 0x2, 0x190, 0x191, 
    0x7, 0x2c, 0x2, 0x2, 0x191, 0x192, 0x3, 0x2, 0x2, 0x2, 0x192, 0x193, 
    0x8, 0x39, 0xd, 0x2, 0x193, 0x194, 0x8, 0x39, 0x6, 0x2, 0x194, 0x74, 
    0x3, 0x2, 0x2, 0x2, 0x195, 0x196, 0x7, 0x2c, 0x2, 0x2, 0x196, 0x197, 
    0x7, 0x2b, 0x2, 0x2, 0x197, 0x198, 0x3, 0x2, 0x2, 0x2, 0x198, 0x199, 
    0x8, 0x3a, 0xe, 0x2, 0x199, 0x19a, 0x8, 0x3a, 0x6, 0x2, 0x19a, 0x76, 
    0x3, 0x2, 0x2, 0x2, 0x19b, 0x19c, 0xb, 0x2, 0x2, 0x2, 0x19c, 0x19d, 
    0x3, 0x2, 0x2, 0x2, 0x19d, 0x19e, 0x8, 0x3b, 0x6, 0x2, 0x19e, 0x78, 
    0x3, 0x2, 0x2, 0x2, 0x19f, 0x1a0, 0xb, 0x2, 0x2, 0x2, 0x1a0, 0x1a1, 
    0x7, 0x2, 0x2, 0x3, 0x1a1, 0x1a2, 0x8, 0x3c, 0xf, 0x2, 0x1a2, 0x7a, 
    0x3, 0x2, 0x2, 0x2, 0x1a3, 0x1a4, 0x7, 0x45, 0x2, 0x2, 0x1a4, 0x1a5, 
    0x7, 0x2c, 0x2, 0x2, 0x1a5, 0x1a6, 0x3, 0x2, 0x2, 0x2, 0x1a6, 0x1a7, 
    0x8, 0x3d, 0xd, 0x2, 0x1a7, 0x1a8, 0x8, 0x3d, 0x6, 0x2, 0x1a8, 0x7c, 
    0x3, 0x2, 0x2, 0x2, 0x1a9, 0x1aa, 0x7, 0x2c, 0x2, 0x2, 0x1aa, 0x1ab, 
    0x7, 0x2b, 0x2, 0x2, 0x1ab, 0x1ac, 0x3, 0x2, 0x2, 0x2, 0x1ac, 0x1ad, 
    0x7, 0x2, 0x2, 0x3, 0x1ad, 0x1ae, 0x8, 0x3e, 0x10, 0x2, 0x1ae, 0x7e, 
    0x3, 0x2, 0x2, 0x2, 0x1af, 0x1b0, 0x7, 0x2a, 0x2, 0x2, 0x1b0, 0x1b1, 
    0x7, 0x2c, 0x2, 0x2, 0x1b1, 0x1b2, 0x3, 0x2, 0x2, 0x2, 0x1b2, 0x1b3, 
    0x7, 0x2, 0x2, 0x3, 0x1b3, 0x1b4, 0x8, 0x3f, 0x11, 0x2, 0x1b4, 0x80, 
    0x3, 0x2, 0x2, 0x2, 0x1b5, 0x1b6, 0x7, 0x2c, 0x2, 0x2, 0x1b6, 0x1b7, 
    0x7, 0x2b, 0x2, 0x2, 0x1b7, 0x1b8, 0x3, 0x2, 0x2, 0x2, 0x1b8, 0x1b9, 
    0x8, 0x40, 0xe, 0x2, 0x1b9, 0x1ba, 0x8, 0x40, 0x6, 0x2, 0x1ba, 0x82, 
    0x3, 0x2, 0x2, 0x2, 0x1bb, 0x1bc, 0xb, 0x2, 0x2, 0x2, 0x1bc, 0x1bd, 
    0x3, 0x2, 0x2, 0x2, 0x1bd, 0x1be, 0x8, 0x41, 0x6, 0x2, 0x1be, 0x84, 
    0x3, 0x2, 0x2, 0x2, 0x15, 0x2, 0x3, 0x4, 0x89, 0x91, 0x93, 0x9a, 0xa3, 
    0xa8, 0xad, 0xaf, 0x118, 0x141, 0x151, 0x153, 0x15a, 0x15c, 0x162, 0x16a, 
    0x12, 0x3, 0x2, 0x2, 0x3, 0x2, 0x3, 0x3, 0x2, 0x4, 0x3, 0x3, 0x5, 0x8, 
    0x2, 0x2, 0x3, 0x33, 0x6, 0x3, 0x34, 0x7, 0x7, 0x3, 0x2, 0x3, 0x36, 
    0x8, 0x3, 0x37, 0x9, 0x3, 0x38, 0xa, 0x7, 0x4, 0x2, 0x6, 0x2, 0x2, 0x3, 
    0x3c, 0xb, 0x3, 0x3e, 0xc, 0x3, 0x3f, 0xd, 
  };

  atn::ATNDeserializer deserializer;
  _atn = deserializer.deserialize(_serializedATN);

  size_t count = _atn.getNumberOfDecisions();
  _decisionToDFA.reserve(count);
  for (size_t i = 0; i < count; i++) { 
    _decisionToDFA.emplace_back(_atn.getDecisionState(i), i);
  }
}

CoolLexer::Initializer CoolLexer::_init;