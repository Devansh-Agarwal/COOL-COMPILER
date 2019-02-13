-- Attribuites cannot be initialised with non conforming types 
-- aaaa doesn't gives error as it inherits from B


class B inherits Supeer {
    b : Int;
};

class Supeer {
    a : Int;
};

class C inherits B {
    c : Int;
};
    



class Main {

    aa : B <- new B;
    aaa : B <- new Supeer;
    aaaa: B <- new C;
    main() : Int {
        0
    };
};