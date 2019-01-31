ANTLR_JAR = /usr/local/lib/antlr-4.7.1-complete.jar

%: all

all:
	c++ cool/*.cpp -I ${ANTLR4CPP}/run/usr/local/include/antlr4-runtime -std=c++11 -L ${ANTLR4CPP}/run/usr/local/lib -lantlr4-runtime -o lexer

clean:
	rm -rf lexer