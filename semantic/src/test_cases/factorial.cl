-- this program is to find the factorial of an non-negative integer
class Main inherits IO {

	-- this method finds the factorial using recursion 
	factorial(number:Int) :Int{ 
	if number =0 then 1 else number * factorial(number -1) fi
	};

	main(): Object{{
		out_string("Enter a non-negative integer ");
		let num: Int <- in_int() in 
		if num < 0 then
			out_string("Invalid Input\n")
		else{
			out_string("The factorial of ").out_int(num);
			out_string(" is ").out_int(factorial(num));-- factorial method dispatched
			out_string("\n");
		}
	fi;
	}};
};