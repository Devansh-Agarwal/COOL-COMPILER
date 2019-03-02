-- displaying simple if then else, comparision operator and input output



 class Main
 {

 	num1: Int <-121;
 	num2: Int <- 1221 ;
 	flag: Bool <- true;
 	io : IO <- new IO;
 	main() : Object{
 		{

 		flag <- num1 < num2;
 		if flag
 			then io@IO.out_string("Are Natural loops really Natural\n")
 			else io@IO.out_string("why is AST called AST?\n")
 		fi;	
 		flag <- num1 = num2;
 		if flag
 			then io@IO.out_string("Are Natural loops really Natural\n")
 			else io@IO.out_string("why is AST called AST?\n")
 		fi;
 		io@IO.out_string("Enter an integer to know your lucky color \n");
 		num2<-io@IO.in_int();
 		flag <- num1 <= num2;
		 
 		
 		if flag
 			then io@IO.out_string("Your lucky color is red\n")
 			else io@IO.out_string("Your lucky color is blue\n")
 		fi;



 	}

 	};
 };
