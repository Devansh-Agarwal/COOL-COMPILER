
	#include <Token.h>


// Generated from CoolLexer.g4 by ANTLR 4.7.1

#pragma once


#include "antlr4-runtime.h"


	using namespace std;
	using namespace antlr4;


namespace cool {


class  CoolLexer : public antlr4::Lexer {
public:
  enum {
    ERROR = 1, TYPEID = 2, OBJECTID = 3, BOOL_CONST = 4, INT_CONST = 5, 
    STR_CONST = 6, LPAREN = 7, RPAREN = 8, COLON = 9, ATSYM = 10, SEMICOLON = 11, 
    COMMA = 12, PLUS = 13, MINUS = 14, STAR = 15, SLASH = 16, TILDE = 17, 
    LT = 18, EQUALS = 19, LBRACE = 20, RBRACE = 21, DOT = 22, DARROW = 23, 
    LE = 24, ASSIGN = 25, CLASS = 26, ELSE = 27, FI = 28, IF = 29, IN = 30, 
    INHERITS = 31, LET = 32, LOOP = 33, POOL = 34, THEN = 35, WHILE = 36, 
    CASE = 37, ESAC = 38, OF = 39, NEW = 40, ISVOID = 41, NOT = 42, WS = 43, 
    LINE_COMMENT = 44, END_COMMENT = 45, UN_COMMENT = 46, COMMENT = 47, 
    NOTMATCHED = 48, ERROR1 = 49, ERROR2 = 50, BEGINCOMMENT = 51, ENDCOMMENT = 52, 
    COMB = 53, ERROR3 = 54, BECOM = 55, ERROR4 = 56, ERROR5 = 57, ENCOM = 58, 
    COMB2 = 59
  };

  enum {
    STARTCOMMENT = 1, NESTCOM = 2
  };

  CoolLexer(antlr4::CharStream *input);
  ~CoolLexer();



  	/*
  		YOU CAN ADD YOUR MEMBER VARIABLES AND METHODS HERE
  	*/

  	/**
  	* Function to report errors.
  	* Use this function whenever your lexer encounters any erroneous input
  	* DO NOT EDIT THIS FUNCTION
  	*/
  	void reportError(string errorString){
  		setText(errorString);
  		setType(ERROR);
  	}

  	
  	void notMatched()
  	{
  		auto t = _factory->create(make_pair(this, _input), type, _text, channel, tokenStartCharIndex, getCharIndex()-1, tokenStartLine, tokenStartCharPositionInLine);
  		string text = t->getText();
  		reportError(text);
  	}

  	void processString() {
  		auto t = _factory->create(make_pair(this, _input), type, _text, channel, tokenStartCharIndex, getCharIndex()-1, tokenStartLine, tokenStartCharPositionInLine);
  		string text = t->getText();

  		//write your code to test strings here
  		
  					
  		if(text.length() > 1024) // max string length error
  		{
  			reportError(" String constant is bigger than 1024");
  			return;
  		}
  		string str = "";
  		int i = 0;
  		while( i < text.length())
  		{
  			if (text[i] == '\u0000') // null char error
  			{
  			reportError("Null Character present in string");
  				return;

  			}

  			 if(text[i] == '\\')
  			{
  				if(text[i+1] == '0')  // null char error
  			{
  				reportError("Null Character present in string");
  				return;
  			}
  				if(text[i +1] == 't')
  					str += "\t";
  				else if(text[i +1] == 'b')
  					str += "\b";
  				else if(text[i +1] == 'f')
  					str += "\f";
  				else if(text[i +1] == 'n')
  					str += "\n";
  				else if(text[i +1] == '\\')
  					str += '\\';
  				else if(text[i +1] == '"')
  					str += '"';
  				else	
  					str +=  text[ i + 1] ;						
  				i++;	
  			}
  			else
  				str += text[i];
  			i ++;
  		
  		}
  		setText(str);
  		return;
  		}

  	
  virtual std::string getGrammarFileName() const override;
  virtual const std::vector<std::string>& getRuleNames() const override;

  virtual const std::vector<std::string>& getChannelNames() const override;
  virtual const std::vector<std::string>& getModeNames() const override;
  virtual const std::vector<std::string>& getTokenNames() const override; // deprecated, use vocabulary instead
  virtual antlr4::dfa::Vocabulary& getVocabulary() const override;

  virtual const std::vector<uint16_t> getSerializedATN() const override;
  virtual const antlr4::atn::ATN& getATN() const override;

  virtual void action(antlr4::RuleContext *context, size_t ruleIndex, size_t actionIndex) override;
private:
  static std::vector<antlr4::dfa::DFA> _decisionToDFA;
  static antlr4::atn::PredictionContextCache _sharedContextCache;
  static std::vector<std::string> _ruleNames;
  static std::vector<std::string> _tokenNames;
  static std::vector<std::string> _channelNames;
  static std::vector<std::string> _modeNames;

  static std::vector<std::string> _literalNames;
  static std::vector<std::string> _symbolicNames;
  static antlr4::dfa::Vocabulary _vocabulary;
  static antlr4::atn::ATN _atn;
  static std::vector<uint16_t> _serializedATN;


  // Individual action functions triggered by action() above.
  void ERRORAction(antlr4::RuleContext *context, size_t actionIndex);
  void STR_CONSTAction(antlr4::RuleContext *context, size_t actionIndex);
  void END_COMMENTAction(antlr4::RuleContext *context, size_t actionIndex);
  void UN_COMMENTAction(antlr4::RuleContext *context, size_t actionIndex);
  void NOTMATCHEDAction(antlr4::RuleContext *context, size_t actionIndex);
  void ERROR1Action(antlr4::RuleContext *context, size_t actionIndex);
  void ERROR2Action(antlr4::RuleContext *context, size_t actionIndex);
  void ERROR3Action(antlr4::RuleContext *context, size_t actionIndex);
  void ERROR4Action(antlr4::RuleContext *context, size_t actionIndex);
  void ERROR5Action(antlr4::RuleContext *context, size_t actionIndex);

  // Individual semantic predicate functions triggered by sempred() above.

  struct Initializer {
    Initializer();
  };
  static Initializer _init;
};

}  // namespace cool
