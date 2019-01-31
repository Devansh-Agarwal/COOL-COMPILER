class Main {
	main():IO {
		new IO.out_string("Hello world!\n")
		
		new IO.out_string("Hello   
			world!\n") -- error
		new IO.out_string("Hello \
			world!\n") -- no errror
		new IO.out_string("He\ll\o \" awesome \" world!\n") -- no error
		new IO.out_string("He\llo \" \"
		 world!\n") -- error


	};
};

