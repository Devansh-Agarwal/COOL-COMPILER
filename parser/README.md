# Cool Parser Using Antlr 4.5
> Group 9, Devansh Agarwal( ES16BTECH11009), Sidhartha Mohla(ES16BTECH11020)

CoolParser.g4 contains the language specification for the Cool language and AST is generated for the given program.
The grammar rules are:
		program ::= [[class; ]] +
		class ::= class TYPE [inherits TYPE] { [[feature; ]] ∗ }
		feature ::= ID( [ formal [[, formal]] ∗ ] ) : TYPE { expr }
		|
		ID : TYPE [ <- expr ]
		formal ::= ID : TYPE
		expr ::= ID <- expr
		| expr[@TYPE].ID( [ expr [[, expr]] ∗ ] )
		| ID( [ expr [[, expr]] ∗ ] )
		| if expr then expr else expr fi
		| while expr loop expr pool
		| { [[expr; ]] + }
		| let ID : TYPE [ <- expr ] [[, ID : TYPE [ <- expr ]]] ∗ in expr
		| case expr of [[ID : TYPE => expr; ]] + esac
		| new TYPE
		| isvoid expr
		| expr + expr
		| expr − expr
		| expr ∗ expr
		| expr / expr
		|  ̃expr
		| expr < expr
		| expr <= expr
		| expr = expr
		| not expr
		| (expr)
		| ID
		| integer
		| string
		| true
		| false

# Precedence rules
All precedence rules are defined by the grammar so are handled by default.

# Lists
We handle lists by defining a new rule to serve as an interface between the single items and the rule requiring the list.
It's like:
	E := F+ 
is written as
	E := F_list
	F_list := F+
By separating the list like this it makes the flow easier.
We are using these lists
	class_list: All classes.
	feature_list: All functions and variable declarations.
	formal_list: All parameters of a function
	case_list: All case blocks.
	expr_block: Block of expression containing more expressions.
	expr_comma_expr: Expression followed by more comma separated expressions.
	let_stmt: Handles the multiple let statements since many of them can be daisy chained together. We use a for loop to iterate through the attributes. 


# Handling '?' (To be or not to be)
Since defining variables inside the ? rule it throws a NullPointer Exception when their value is accessed we cant use if else or ternary operator (?:). So we have to define separate rules one with the rule and other without it.

For example for the subrule 
	feature : = ID : TYPE [<- expr] 
we thus define the rules
	feature := ID : TYPE |  ID : TYPE <- expr

We pass an empty item to the same constructor in the case where the rule is not applicable.

# Checking the Correctness
There are 4 correct programs and 4 wrong programs that are used to check the correctness of the parser.
Stack Machine interpreter is one for the correct programs, it is sufficiently large enough to check all the grammar rules, whichever rules are missed are covered by the rest of the files
