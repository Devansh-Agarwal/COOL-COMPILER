(*
-------------------------------------------------------------------
class StackNode is used in making nodes of the stack
-------------------------------------------------------------------
*)
class StackNode inherits Object{
	next : StackNode;
	value : String;
	init(fun :String): Object{
		 value <- fun
	};
	attach(funny : StackNode): Object{
	next <- funny
	};
	returnnext(): StackNode{next};
	returnvalue(): String{value};
};

(*
-------------------------------------------------------------------
main function just used for calling the StackCommands
-------------------------------------------------------------------
*)
class Main inherits Object{

	main() : Object {{
		(new StackCommands).stacker();
	}};
	
	
};

(*
-------------------------------------------------------------------
Contains the main while loop and the push and pop commands used in a 
generic stack.
-------------------------------------------------------------------
*)
class StackCommands inherits IO{
	a2iobj : A2I;
	looper : Bool;
	input : String;
	size: Int;
	temp: String;
	top : String;
	head: StackNode;
	t: StackNode;
	stacker(): Object{
	{
		a2iobj <- new A2I;
		looper <- true;
		size <- 0;
		out_string("Commands available\n1.<int>\n2.+\n3.s\n4.e\n5.d\n6.x\n(meaning given in assignment)\n");
		while looper loop
		{
			out_string(">");
			input <- in_string();
			if input = "x" then 
			{out_string("Program is exiting \n"); looper <- false;}
			else
			if input = "d" then 
			(new Display).displayStack(head)
			else
			if input = "e" then
			{
				temp <- pop();
				if temp = "+" then
					if size < 2 then 
					{
						out_string("Not Enough elements in stack, program ending\n");
						abort();
					} 
					else
					{
						top <-pop();
						temp <- pop();
						push(a2iobj.i2a(a2iobj.a2i(top)+a2iobj.a2i(temp)));
					}fi
				else
				if temp = "s" then
				{ 
					top <- pop(); 
					temp<- pop(); 
					push(top); 
					push(temp);
				}
				else
				push(temp)
				fi fi;}
				else push(input)
				fi
				fi
				fi;
 			} 
			pool;
		}
	};

(*
-------------------------------------------------------------------
push function creates a new StackNode object, initialises it and 
pushes on the stack 
-------------------------------------------------------------------
*)
	push(element:String) : Object{{

		t <- new StackNode ;
		size <- size + 1;
		t.init(element);
		if size  = 1 then head <- t else
		{
		 t.attach(head);
		 head<-t ;
		} 
		fi;
	}};
	(*
-------------------------------------------------------------------
pop function removes the top element of the stack 
-------------------------------------------------------------------
*)
	pop() : String{{
		temp <- head.returnvalue();
		size <- size -1;
		head<- head.returnnext();
		temp;

	}};

};

(*
-------------------------------------------------------------------
Display class contains a displayStack function which prints the stack
elements by going through each node and printing the value in each 
node
-------------------------------------------------------------------
*)

class Display inherits IO{
	
	t : StackNode;
	displayStack(heady : StackNode) : Object{{
		t <- heady;
		out_string("Stack:\n");
		while not isvoid t
		loop
		{
			out_string(t.returnvalue());
			t <- t.returnnext();
			out_string("\n");
		}pool;

	}};
};

(*
-------------------------------------------------------------------
A2I class below
-------------------------------------------------------------------
*)

class A2I {

     c2i(char : String) : Int {
	if char = "0" then 0 else
	if char = "1" then 1 else
	if char = "2" then 2 else
        if char = "3" then 3 else
        if char = "4" then 4 else
        if char = "5" then 5 else
        if char = "6" then 6 else
        if char = "7" then 7 else
        if char = "8" then 8 else
        if char = "9" then 9 else
        { abort(); 0; }  -- the 0 is needed to satisfy the typchecker
        fi fi fi fi fi fi fi fi fi fi
     };

(*
   i2c is the inverse of c2i.
*)
     i2c(i : Int) : String {
	if i = 0 then "0" else
	if i = 1 then "1" else
	if i = 2 then "2" else
	if i = 3 then "3" else
	if i = 4 then "4" else
	if i = 5 then "5" else
	if i = 6 then "6" else
	if i = 7 then "7" else
	if i = 8 then "8" else
	if i = 9 then "9" else
	{ abort(); ""; }  -- the "" is needed to satisfy the typchecker
        fi fi fi fi fi fi fi fi fi fi
     };

(*
   a2i converts an ASCII string into an integer.  The empty string
is converted to 0.  Signed and unsigned strings are handled.  The
method aborts if the string does not represent an integer.  Very
long strings of digits produce strange answers because of arithmetic 
overflow.
*)
     a2i(s : String) : Int {
        if s.length() = 0 then 0 else
	if s.substr(0,1) = "-" then ~a2i_aux(s.substr(1,s.length()-1)) else
        if s.substr(0,1) = "+" then a2i_aux(s.substr(1,s.length()-1)) else
           a2i_aux(s)
        fi fi fi
     };

(*
  a2i_aux converts the usigned portion of the string.  As a programming
example, this method is written iteratively.
*)
     a2i_aux(s : String) : Int {
	(let int : Int <- 0 in	
           {	
               (let j : Int <- s.length() in
	          (let i : Int <- 0 in
		    while i < j loop
			{
			    int <- int * 10 + c2i(s.substr(i,1));
			    i <- i + 1;
			}
		    pool
		  )
	       );
              int;
	    }
        )
     };

(*
    i2a converts an integer to a string.  Positive and negative 
numbers are handled correctly.  
*)
    i2a(i : Int) : String {
	if i = 0 then "0" else 
        if 0 < i then i2a_aux(i) else
          "-".concat(i2a_aux(i * ~1)) 
        fi fi
    };
	
(*
    i2a_aux is an example using recursion.
*)		
    i2a_aux(i : Int) : String {
        if i = 0 then "" else 
	    (let next : Int <- i / 10 in
		i2a_aux(next).concat(i2c(i - next * 10))
	    )
        fi
    };

};