-- inheritance cycle is formed A0->A1->A2->A3->A4->A0

class Main {
    main() : Int {
        0
    };
};

class A0 inherits A4{

};

class A1 inherits A0{

};

class A2 inherits A1{

};

class A3 inherits A2{

};

class A4 inherits A3{

};

class A5 inherits A0{

};

class A6 inherits A0{

};

class A7 inherits A0{

};
