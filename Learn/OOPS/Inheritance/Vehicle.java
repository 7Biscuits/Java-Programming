package OOPS.Inheritance;

public class Vehicle {
    protected String name;
    protected String model;
    protected int noOfTyres;
    // Protected keywords acts like a private keyword except it allows derived classes to access the attributes and methods.

    public Vehicle(String name, String model, int noOfTyres) {
        this.name = name;
        this.model = model;
        this.noOfTyres = noOfTyres;
    }

    public void startEngine() {
        System.out.printf("Engine starting for %s - %s", name, model);
        System.out.println();
    }

    public void stopEngine() {
        System.out.printf("Engine stopping for %s - %s", name, model);
        System.out.println();
    }

    public String getName() {
        return this.name;
    }

    public String getModel() {
        return this.model;
    }

    // Methods to update name & model
    public void setName(String name) {
        this.name = name;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
