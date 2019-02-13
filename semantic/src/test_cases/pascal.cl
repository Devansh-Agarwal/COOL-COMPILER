class Main inherits IO{
	main(): Object {{
	out_string("Enter number of rows of the pascals triangle you want to print");
	let rows: Int <- in_int() in
	let i: Int <- 0 in
	let j: Int <- 0 in
	let coef: Int <- 1 in
	let space: Int <- 1 in
	if rows <= 0 then
			out_string("Invalid Input\n")
	else{
		(while i< rows loop{
			
			(while space <= rows-i loop{
				out_string(" ");
			}
			pool);
			space <- 1;	

			(while j<= i loop{
				if j = 0 then
					coef <- 1
				else{
					if i = 0 then
						coef <- 1
					else{
						coef = coef *(i-j +1)/j;
					}
					fi;	

				}
				fi;
				out_int(coef);
				j <- j + 1;
				}pool);
				j <- 0;
				i <- i +1;
				out_string("\n");
			}
		 pool);

	} fi;
}};
};