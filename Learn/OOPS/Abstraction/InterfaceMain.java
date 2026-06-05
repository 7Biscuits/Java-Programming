package OOPS.Abstraction;

/* Interfaces -> a blueprint (enforcer) that defines a set of methods a class must implement 
    without providing full implementation details. */

// Modern development use interfaces instead of abstract classes for achieving abstraction.
// A class can implement infinite amout of interfaces.

interface Vehicle {
    void startEngine();

    void speedUp(int s);

    void changeGear(int g);

    void applyBrakes();
}

class Bike implements Vehicle {
    private int gear;
    private int speed;
    private boolean isEngineOn = false;

    public Bike(int gear, int speed) {
        this.gear = gear;
        this.speed = speed;
    }

    @Override
    public void startEngine() {
        this.isEngineOn = true;
        System.out.println("Starting engine");
    }

    @Override
    public void speedUp(int s) {
        if (isEngineOn) {
            speed += s;
            System.out.println("Speeded up");
        } else {
            System.out.println("Start the engine before speeding up.");
        }
    }

    @Override
    public void changeGear(int newGear) {
        if (isEngineOn) {
            gear = newGear;
            System.out.println("Changed gears");
        } else
            System.out.println("Start the engine before changing gears");
    }

    @Override
    public void applyBrakes() {
        speed = 0;
        gear = 0;
        System.out.println("Applying brake");
    }

    public void getStates() {
        String a = isEngineOn ? "On" : "Off";
        System.out.println("Engine: " + a);
        System.out.println("speed: " + speed);
        System.out.println("gear: " + gear);
    }
}

public class InterfaceMain {
    static void interfaceStuff() {
        Bike b = new Bike(1, 10);
        b.startEngine();
        b.changeGear(4);
        b.speedUp(30);
        b.getStates();
        b.applyBrakes();
        b.getStates();

        Vehicle v = new Bike(0, 0);
        v.startEngine();
        // v.getState(); -> won't exist since method of the subclass.
    }

    public static void main(String[] args) {
        interfaceStuff();
    }
}
