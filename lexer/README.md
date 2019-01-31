# COOL Compiler #

#Lexical Analyzer#

CoolLexer.g4 has lexical rules written for COOL language, an lexical analyzer is created using antlr ver4 in cpp

#Design#

The lexical analyzer follows the maximum matching rule while matching the tokens and if two sizes are the same
the rule which is written above is matched.
There are 3 subparts in which CoolLexer.g4 is divided:
From top to bottom
-> Tokens : Contains a list of Tokens
-> Members: Contains methods to process strings and to match errors.
for error handling: void reportError(string errorString); void notMatched();
for processing strings: void processString();
->Lexer Rules: Lexical rules for strings, keywords, comments

#Comments#

Single line comments are handle by putting '\n' at the end of the lexer rule.
In multiline comment for making sure that all the opening tags and closing tag are properly matched 
two modes are used, one for 1st comment and the other one of subsequent comment.#

#Strings#
Stings cannot contain single /, ", EOF and unescaped newline.
String without these characters are matched and passed to void processString().
Which take cares of the max string size (1024 characters) and the no null character in a string
 
#Test Cases#
test1.cl demnostrates error of unslashed new line
test2.cl demonstrates max string length error
test3.cl EOF inside comment error
test4.cl null character in string
test5.cl # character not defined in cool & unmatched comments bracket
test6.cl standard lamda cal code from example library big enough code and runs properly
