# Cool Semantic Analyser Using ANTLR v4.5 
> Group 9, Devansh Agarwal( ES16BTECH11009), Sidhartha Mohla(ES16BTECH11020)

# Design of the semantic Analyser 
## Number of Passes
Three full passes are made over the AST. Use of each pass:
1st Pass : Adding the nodes in the inheritance graph
2nd Pass : Adding the edges between the nodes in the inheritance graph
3rd Pass : Adding the type annotions and checking the related semantic error  

## Making the inheritance Graph
We 1st iterate through  entire list of classes while checking for the validity of the name of the class and the name of the class from which inherits and add the the class as a node(integer equivalent) to the graph
For built in classes mapping is :
0 ->Object
1 ->IO
2-> Int
3-> String
4-> Bool
After  all the nodes have been added to the graph the edges(inheritance relationship) between them are constructed.	


## Detecting the Cylces in Inheritance Graph
It is done by using a non recursive DFS that is DFS with a stack. Basically back edges are found in the graph.
Back edges are edges which point to one of its ancestors.
BFS is not used as in directed graphs for checking the back edges it requires more memory.

## Name and scope checking.
This is accomplished by adding the current attributes to a new entry in scope map created when entering a method, a let or a case, with the variable name as key for fast lookup. We also check for duplicates whenever we add a new variable and print an error when a attribute with same name is encountered. Whenever a previously defined variable is required we search the scope table and provide an error message when it is not found. We do this in dispatch to check whether the dispatch is valid or not, in assignment whether the variable exists or not etc.

## Type checking
Similarly we have a classList which contains all the types possible, so we can quickly refer it and check whether the type being used is defined or not. Also, we check for validity of types when we recurse expressions so that the expression type being returned is valid. If we encounter an error we assign the "Object" type since all classes are derived from it.
Most of the type checking is thus done at expression level, where the type is recursively found out and checked for inconsistencies with respect to type rules defined in Section 12 of the cool manual.

##Testing
There are 10 wrong test cases and 5 working test cases.
The test cases are named properly so it can easily be inferred what 
they are ment for