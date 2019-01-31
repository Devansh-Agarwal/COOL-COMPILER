lexer grammar CoolLexer;

tokens{
	ERROR,
	TYPEID,
	OBJECTID,
	BOOL_CONST,
	INT_CONST,
	STR_CONST,
	LPAREN,
	RPAREN,
	COLON,
	ATSYM,
	SEMICOLON,
	COMMA,
	PLUS,
	MINUS,
	STAR,
	SLASH,
	TILDE,
	LT,
	EQUALS,
	LBRACE,
	RBRACE,
	DOT,
	DARROW,
	LE,
	ASSIGN,
	CLASS,
	ELSE,
	FI,
	IF,
	IN,
	INHERITS,
	LET,
	LOOP,
	POOL,
	THEN,
	WHILE,
	CASE,
	ESAC,
	OF,
	NEW,
	ISVOID,
	NOT
}

/*
  DO NOT EDIT CODE ABOVE THIS LINE
*/

@lexer::header {
	#include <Token.h>
}
@lexer::postinclude {
	using namespace std;
	using namespace antlr4;
}
@members{

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

	}
	


/*
	WRITE ALL LEXER RULES BELOW
*/



ERROR 		: '"' ~["\nEOF]* ('\n'){ reportError("Unterminated string constant");}
				| '"' (ESC_SEQUENCE | ~["])* '\n'(.*?) '"' {reportError("Unescaped new line in string literal");}
				| '"' ~[\n"]* (EOF) {reportError(" EOF in string literal");}
				;
STR_CONST   : '"'(ESC_SEQUENCE | ~('\\'|'"'|'\n'))*'"'{processString();};
fragment ESC_SEQUENCE : '\\'.;	

				

SEMICOLON   : ';';
DARROW      : '=>';

/*
	 keywords are not case sensitive this is equivalent -> KeYwOrDs to this-> KeYwOrDs
*/	

CLASS		: [cC][lL][aA][sS][sS];
ELSE        : [eE][lL][sS][eE];
FI 			: [fF][iI];
IF			: [iI][fF];
IN			: [iI][nN];
INHERITS    : [iI][nN][hH][eE][rR][iI][tT][sS];
LET			: [lL][eE][tT];
LOOP		: [lL][oO][oO][pP];
POOL        : [pP][oO][oO][lL];
THEN		: [tT][hH][eE][nN];
WHILE		: [wW][hH][iI][lL][eE];
CASE		: [cC][aA][sS][eE];
ESAC		: [eE][sS][aA][cC];
OF			: [oO][fF];
NEW			: [nN][eE][wW];
ISVOID		: [iI][sS][vV][oO][iI][dD];
NOT			: [nN][oO][tT];
BOOL_CONST  : 't'[rR][uU][eE] | 'f'[aA][lL][sS][eE];
// keywords end
LE 			: '<=';
ASSIGN		: '<-';
PLUS		: '+';
MINUS		: '-';
STAR        : '*';
SLASH 		: '/';
LPAREN		: '(';
RPAREN		: ')';
COLON		: ':';
LBRACE      : '{';
RBRACE		: '}';
DOT			: '.';
TILDE       : '~';
LT 			: '<';
ATSYM       : '@';
COMMA       : ',';
EQUALS		: '=';
WS 			: [ \t\n\r\f]+ -> skip; // whitespaces

fragment DIGIT : '0'..'9';
fragment LLETTER : 'a'..'z';
fragment ULETTER : 'A'..'Z';
fragment LETTER : ('a'..'z' | 'A'..'Z');
TYPEID		: ULETTER(DIGIT|'_'|LETTER)*;
OBJECTID	: LLETTER(DIGIT|'_'|LETTER)*;
INT_CONST   : DIGIT+;


//COMMENTS below
LINE_COMMENT: '--' .*? '\n' -> skip;
END_COMMENT : '*)' EOF{reportError("Unmatched *)");};
UN_COMMENT  : '*)' {reportError("Unmatched *)");};
COMMENT     : '(*' -> pushMode(STARTCOMMENT), skip;
NOTMATCHED   : .{notMatched();};
mode STARTCOMMENT;

ERROR1      : .(EOF){ reportError("EOF in comment");};
ERROR2      : '(*'(EOF){ reportError("EOF in comment");};
BEGINCOMMENT: '(*' ->pushMode(NESTCOM), skip;
ENDCOMMENT  : '*)' -> popMode, skip;
COMB		: . -> skip;

mode NESTCOM;
ERROR3      : .(EOF){reportError("EOF in comment");};
BECOM 		: 'C*' -> pushMode(NESTCOM), skip;
ERROR4      : '*)' EOF {reportError("EOF in comment");};
ERROR5  	: '(*' EOF {reportError("EOF in comment");};
ENCOM 		: '*)' ->popMode, skip;
COMB2		: . -> skip;


  