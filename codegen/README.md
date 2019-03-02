# Cool Code Generation in LLVM IR Using ANTLR v4.5 
> Group 9, Devansh Agarwal( ES16BTECH11009), Sidhartha Mohla(ES16BTECH11020)

A Cool program gets converted into it's LLVM IR representation then it can be further used using lli.
It is assumed that there is no let, case, SELF_TYPE and dynamic dispatch.
We have used Godbolt.org(Compiler Explorer) for studying the LLVM IR generated for various c++ programs.
On Godbolt the specification used is x86-64 Clang 7.0.0 and -S-emit-llvm 
# Design of the Code Generator 
All the code has been written in Codegen.java with a few lines added in ScopeTable.java and Semantic.java .


#Approach
We first used godbolt to determine what kind of instructions are generated for different types of calls.
For classes we decided to make the functions global and class parameters as a type which allows us to pass pointer this to the functions defined.

So whenever a class is created a type is defined emitting the IR as:
%class.NAME = type { <ArgTypesList> }
	and subsequently a constructor is definded using constructorConstructor function which constructs the constructor.
Here we first define a constructor by printing:
	define %class.NAME* @MainConsrtuctorMain( %class.NAME* %this ) {
and subsequently generating code for default as well as user defined types.
To access the ith attribute in class we use getelementptr:
	%className = getelementptr inbounds %className* %this_copy, i32 0, i32 i 
Also printType() is used along with a HashTable containing mapping of built in types to get the type to print in IR with pointers(For example i32 is Int in COOL and some user class A becomes %class.A\*) since mostly we handle instances of objects by pointer.
We have to evaluate the expr used to initialize the attributes so we call visitExpr to print the code for the same.
We have a Logger class to keep track of last register used while evaluating the sub expr so that it can be stored in the super expr or for new register etc. It also logs the last basic block used which can be useful for phi nodes used in if to simplify value allocation etc.

catchString() was used to capture the strings before printing was started for other attributes since the constant strings were made global and the register value substituted whenever the value of the string was required.
The trickiest part was to handle static dispatch since it had the largest no. of sub expr as well as a chance of runtime error (dispatch being called when the object used to call wasnt initialized). Runtime errors were handled by creating "escape blocks" which would exit the program if branched to.
Other helper functions were also defined inside Codegen.java


# Test Cases
6 Test Cases are made to test various things like static Dispatach, loops, recursion, inbuilt cool classes(Object, IO, Int, String, Bool) and other stuff.
#Tools/References Used
1. Cool Manual
2. LLVM Language Reference Manual
3. Godbolt.org
4. lli: LLVM Interpreter
