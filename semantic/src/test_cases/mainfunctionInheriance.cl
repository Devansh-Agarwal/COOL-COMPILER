-- if Main class inherits from some class and that class has main method defined
-- then that method should return the same type
Class A {

	a : String;
	main() : String {
		{
			a <- "VisualStudio";
		}
	};
};
 
class Main inherits A {
	b: Int;
	main() : Object {
		{
			b <-666;
		}
};
};