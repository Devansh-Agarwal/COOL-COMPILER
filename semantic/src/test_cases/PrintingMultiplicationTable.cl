-- Prints the table of natural number till 10
class Main inherits IO{
	main(): Object {{
		out_string("Prints the table of natural number till 10 \n");
		out_string("Enter the number till which you want to calculate Sum ");
		let n: Int <- in_int() in
		let i :Int <- 1 in
		if n <= 0 then -- checking for invalid input
			out_string("Invalid Input\n")
		else{
			(while i <= 10 loop{ -- loop to find the table
				out_int(i * n);
				out_string("\n");
				i<- i + 1;
				}pool);
				} fi;
		}};
	};
