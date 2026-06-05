package OOPS.Abstraction;

// abstract class is a class whose instance/object can't be created. It can only be derived to form subclasses.
abstract class Bird {
    protected String name;

    protected void displayName() { // can contain defined methods aswell
        System.out.println(this.name);
    }

    abstract void fly();

    abstract void eat();
    /*
     * abstract methods do not specify a body. their body is defined by the derived
     * class (subclass).
     */
}

class Sparrow extends Bird {

    public Sparrow() {
        super.name = "Sparrow";
    }

    @Override // since method exists in the parent class.
    void fly() {
        System.out.println(name + " is flying.");
    }

    @Override
    void eat() {
        System.out.println(name + " is eating.");
    }
}


public class AbstractMain {
    static void abstractStuff() {
        // Bird b = new Bird(); Can't be done since Bird is abstract.
        Sparrow s = new Sparrow();
        s.fly();
        s.displayName(); // Sparrow
        Bird b = new Sparrow();
        b.fly(); // Sparrow is flying
    }

    public static void main(String[] args) {
        abstractStuff();
    }
}
