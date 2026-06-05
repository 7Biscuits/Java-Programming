package OOPS.Polymorphism;

class Shape {
    public void draw() {
        System.out.println("Drawing a generic shape...");
    }
}

class Circle extends Shape {
    @Override // cosmetic annotation -> not required to be written but forces compiler to verify if the parent class has method of the same name.
    public void draw() { // this draw method overrides the draw method of the parent class.
        System.out.println("Drawing a Circle");
    }
    
    int radius = 5;
    public void getRadius() {
        System.out.println(radius);
    }
}

public class Main {
    public static void main(String[] args) {
        // Upcasting [runtime polymorphism]
        Circle c = new Circle();
        Shape s = new Circle(); // since Cicle is a subclass of a Shape.
        // note: s.getRadius() won't exist since it's a method of the subclass.
        s.draw(); // Drawing a Circle
        doDrawing(c); // Drawing a Circle -> Circle method was upcasted.
        doDrawing(new Shape()); // Drawing a generic shape...

        // Downcasting -> not used much and risky to use
        Circle circle = new Circle();
        doDrawing2(circle);
    }

    static void doDrawing(Shape s) {
        s.draw();
    }

    static void doDrawing2(Shape s) {
        Circle c = (Circle) s; // downcasting
        c.draw();
    }
}