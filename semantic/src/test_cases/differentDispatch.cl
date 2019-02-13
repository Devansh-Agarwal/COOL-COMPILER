-- Different types of dispatches are shown
class A1 {
	foo (a : Int) : String {
		if a = 1 then "1" else
		if a = 2 then "2" else
		if a = 3 then "3" else
		if a = 4 then "4" else
		if a = 5 then "5" else
		if a = 6 then "6" else
		if a = 7 then "7" else
		if a = 7 then "8" else
		"9"
		fi fi fi fi fi fi fi fi 
	};
};

class A2 inherits A1 {
	foo (a : Int) : String {
			"0"
	};
};

class Main inherits A2{
	a : String ;
	i : Int <- 5;
	foo (a : Int) : String {
	"0"
	};
	main() : Object {
		{
			a <- foo(i);	-- foo in main
			new IO.out_string(a);	

			a <- new A1.foo(i);
			new IO.out_string(a);	-- foo in A1 (dispatch)

			a <- (new A2)@A2.foo(i);
			new IO.out_string(a);	-- foo in A1 called through A2
		}
	};
};