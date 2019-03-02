-- displaying input output, aritmetic and integer complement 

 class Main
 {

 	num1: Int <-121;
 	num2: Int <- 1221 ;
 	io : IO <- new IO;
 	main() : Object{
 		{

 			io@IO.out_string("Enter an integer  \n");
	 		num1<-io@IO.in_int();
	 		
	 		io@IO.out_string("Enter an integer \n");
 			num2<-io@IO.in_int();
 			io@IO.out_string("Calculating num1 + num2 / 5 * 89 + 7 \n");
 			num1 <- num1 + num2 / 5 * 89 + 7;
 			io@IO.out_int(num1);
 			io@IO.out_string("\n");
 			io@IO.out_string("Calculating integer complement of num2 \n");
 			num2<- ~ num2;
 			io@IO.out_int(num2);
 			io@IO.out_string("\n");
 		


 	}

 	};
 };
