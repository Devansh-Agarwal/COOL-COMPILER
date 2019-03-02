-- Testing Static Dispatch 

 class Main
 {

 	num1: Int <-121;
 	num2: Int <- 1221 ;
 	io : IO <- new IO;
 	obj : MultiClass <- new MultiClass;
 	main() : Object{
	{
		io@IO.out_string("Static Dispatch in action\n");
		io@IO.out_int(obj@MultiClass.func(num1));
 	}

 	};
 };
class MultiClass inherits IO
{
	func(a: Int):Int
	{
		{
			a <- a + 42;	
		}
	
	};

};
