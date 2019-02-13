--prints the fibonacci series till a particular index
class Main inherits IO{
	main(): Object {{
		out_string("Enter the index till which you want to print fibonacci series");
		let index :Int <- in_int() in
		let i: Int <- 1 in
		let first: Int <- 0 in
		let second: Int <- 1 in 
		let next: Int <- 0 in
		if index <= 0 then -- checking for wrong input 
			out_string("Invalid Input\n")
		else
		{
			out_string("Fibonacci series:\n");
			(while i <= index loop{
				if i <=1 then
					next <- i
				else{
					 next <- first + second; -- implementing f(n) = f(n-1) + f(n-2)
      				 first <- second;
				     second <- next;
				}
				fi;	
				i <- i +1;	
				out_int(next);
				out_string(" ");
			}pool);
			out_string("\n");

		} fi;
		}};
	};		
