/*
PLEASE DO NOT EDIT THIS FILE
*/

#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <cstdlib>
#include <utility>

#include <ANTLRInputStream.h>
#include <CommonTokenStream.h>
#include <Token.h>
#include <BaseErrorListener.h>
#include <Recognizer.h>
#include <RecognitionException.h>

#include "CoolLexer.h"

using namespace antlr4;

using namespace cool;
using namespace std;

void replaceAll( string &s, const string &search, const string &replace ) {
    for( size_t pos = 0; ; pos += replace.length() ) {
        // Locate the substring to replace
        pos = s.find( search, pos );
        if( pos == string::npos )
        	break;
        s.replace(pos, search.length(), replace);
    }
}



class LexerTest {

	static const int noOfTokens = 43;

	string TOKENS[noOfTokens] = {"ERROR", "TYPEID", "OBJECTID", "BOOL_CONST", "INT_CONST", "STR_CONST", "'('", "')'", "':'", "'@'", "';'", "','", "'+'", "'-'", "'*'", "'/'", "'~'", "'<'", "'='", "'{'", "'}'", "'.'", "DARROW", "LE", "ASSIGN", "CLASS", "ELSE", "FI", "IF", "IN", "INHERITS", "LET", "LOOP", "POOL", "THEN", "WHILE", "CASE", "ESAC", "OF", "NEW", "ISVOID", "NOT"};

	static const int VALUED_INDEX_LIMIT = 6;

	static const size_t EOF_TYPEID = -1;

	int findIndex(string str) {

		for (int i = 0; i < noOfTokens; i++) {
			string tok = TOKENS[i];
			if (str == tok)
				return i;
		}
		return -1;

	}

	string escapeSpecialCharacters(string text) {

		replaceAll(text, "\\\\", "\\\\\\\\");
		replaceAll(text, "\n", "\\n");
		replaceAll(text, "\t", "\\t");
		replaceAll(text, "\b", "\\b");
		replaceAll(text, "\f", "\\f");
		replaceAll(text, "\"", "\\\"");
		replaceAll(text, "\r", "\\\\015");
		replaceAll(text, "\\033","\\\\033");
		replaceAll(text, "\\001","\\\\001");
		replaceAll(text, "\\002","\\\\002");
		replaceAll(text, "\\003","\\\\003");
		replaceAll(text, "\\004","\\\\004");
		replaceAll(text, "\\022","\\\\022");
		replaceAll(text, "\\013","\\\\013");
		replaceAll(text, "\\000", "\\\\000");

		return text;
	}
public:
	void printTokenStream(string filename) {
		//create input stream
		ANTLRInputStream inStream;


		// read the from filename
		ifstream file_input;
		file_input.open(filename);

		std::string input_string((std::istreambuf_iterator<char>(file_input)), std::istreambuf_iterator<char>());


		try {
			// cout << "input stream = " << input_string << endl;
			inStream = ANTLRInputStream(input_string);
		} catch (const ifstream::failure& e) {
    		cout << "Exception opening/reading file";
    		exit(1);
  		}

		CoolLexer lexer(&inStream);

		//Call Lexer API for token stream
		CommonTokenStream tokens(&lexer);

		tokens.fill();

		//printing the name of the file
		string name = filename.substr(filename.find_last_of('/') + 1);
		
		cout << "#name \"" << name << "\"" << endl;

		const int BOOL_CONST_INDEX = findIndex("BOOL_CONST");
		const int STR_CONST_INDEX = findIndex("STR_CONST");
		const int ERROR_INDEX = findIndex("ERROR");

		//Print tokens
		

		for(auto t: tokens.getTokens()) {
           
			if(t->getType() != EOF_TYPEID) {
				string output = string("#") + to_string(t->getLine()) + string(" ") + TOKENS[t->getType() - 1];

				if(t->getType() <= VALUED_INDEX_LIMIT) {

					if(t->getType() - 1 == BOOL_CONST_INDEX) {
						string tok_str = t->getText();
						transform(tok_str.begin(), tok_str.end(), tok_str.begin(), ::toupper);
						output += " " + tok_str;
					}

					else if(t->getType() - 1 == STR_CONST_INDEX)
						output += " \"" + escapeSpecialCharacters(t->getText()) + "\"";
					else if(t->getType() - 1 == ERROR_INDEX)
						output += " \"" + escapeSpecialCharacters(t->getText()) + "\"";
					else
						output += " " + t->getText();

				}

				cout << output << endl;
			}
		}
	}
};


int main(int argc, char* argv[]) {

	if(argc < 1) {
		cout << "No files given";
		exit(1);
	}
	LexerTest l;


	for(int i = 1; i < argc; i++) {
		l.printTokenStream(argv[i]);
	}

	return 0;
}