-- testing all the functions of string 

class Main
 {

 	num1: Int ;
 	io : IO <- new IO;
 	str: String <- "Compiler vs Interpreter";
 	temp : String ;
 	main() : Object{
	{
		io@IO.out_string("String Concat\n");
		temp <-str@String.concat("; what do you think?\n");
		io@IO.out_string(temp);
		io@IO.out_string("String length\n");
		num1 <-temp@String.length();
		io@IO.out_int(num1);
 	}

 	};
 };