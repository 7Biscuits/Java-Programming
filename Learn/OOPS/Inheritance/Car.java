package OOPS.Inheritance;

public class Car extends Vehicle {

    protected String transmissionType;
    protected int noOfDoors;

    public Car(String name, String model, int noOfTyres, String transmissionType, int noOfDoors) {
        super(name, model, noOfTyres);
        // super keyword is used to refer to the immediate parent (the class it extends) class object
        this.transmissionType = transmissionType;
        this.noOfDoors = noOfDoors;
        super.startEngine();
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

}
