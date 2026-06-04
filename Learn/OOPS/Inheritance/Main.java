package OOPS.Inheritance;

// Inheritance is making classes and then making sub-classes that can access certain attributes/methods of the parent class.
// Important for code reusability and adding modularity in the codebase.

public class Main {
    public static void main(String[] args) {
        Car c = new Car("Audi", "R8", 4, "manual", 2);
        c.stopEngine();
    }
}

// Access modifiers in Java -> how public/private/protected keywords change the behaviour of attriutes & methods in sub-classes (child classes).