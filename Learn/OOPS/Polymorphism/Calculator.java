package OOPS.Polymorphism;

// Polymorphism means having many forms. Ex -> method overloading
// method overloading is an example of static (compile time) polymorphism.

public class Calculator {

    // method overloading demo:
    int add(int a, int b) {
        return a+b;
    }

    int add(int a, int b, int c) {
        return a+b+c;
    }

    long add(long a, long b) {
        return a+b;
    }
    
    double add(int a, double b) {
        return a+b;
    }
}
