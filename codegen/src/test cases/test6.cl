-- checking recursion, nested if, self type

class Main
 {

 	num1: Int ;
 	io : IO <- new IO;
 	obj : Fib <- new Fib;
 	main() : Object{
	{
		io@IO.out_string("Fibonacii  element 5 is \n");

		io@IO.out_int(obj@Fib.f(5));
 	}

 	};
 };

 class Fib
 {
 	f(i : Int) : Int{
 			if i = 0 then 0
 			else
 			 	if i  = 1 then 1 
 			 	else self@Fib.f(i-1) + self@Fib.f(i-2)
 			fi fi 	
 	};
 };