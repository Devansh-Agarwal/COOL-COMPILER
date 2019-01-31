ANTLR_JAR = /usr/local/lib/antlr-4.7.1-complete.jar
ANTLR = java -jar $(ANTLR_JAR)
ANTLR_OUT_DIR = ../cpp
PACKAGE = cool
ANTLR_FLAGS = -no-listener -visitor -package $(PACKAGE) -Dlanguage=Cpp
LEXER = CoolLexer
PARSER = Cool

%: all

all:
	$(ANTLR) $(ANTLR_FLAGS) -o $(ANTLR_OUT_DIR)/$(PACKAGE)/ $(LEXER).g4

clean:
	rm -rf ../cpp/$(PACKAGE)/$(PARSER)*.cpp
	rm -rf ../cpp/$(PACKAGE)/$(PARSER)*.h
	rm -rf ../cpp/$(PACKAGE)/$(PARSER)*.interp
	rm -rf ../cpp/$(PACKAGE)/*.tokens
