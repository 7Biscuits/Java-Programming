package OOPS.Encapsulation;

public class Student {
    // Attributes
    public int id;
    public String name;
    public int age;
    public char section;

    // Methods / Behavior
    public void study() {
        System.out.println(name + " is studying.");
    }

    private void sleep() {
        System.out.println(name + " is sleeping.");
    }
    // Constructors -> public ClassName() | They are called whenever the object/instance of the class is created.

    // Default constructor
    public Student() { 
        System.out.println("Student default constructor called.");
    }

    // Parameterized constructor
    public Student(int sid, String name, int age, char section) {
        // note: this.(attribute) -> refers to class attributes; sid, name etc -> parameters passed
        id = sid; // no need to use "this" keyword since the parameter name and the attribute names are different.
        this.name = name;
        this.age = age;
        this.section = section;

        System.out.println("Parameterized constructor called.");
    }

    // Copy Constructor -> When one object/instance of this class wants to copy the set attributes of another object of the same class.
    public Student(Student srcobj) {
        this.id = srcobj.id;
        this.name = srcobj.name;
        this.age = srcobj.age;
        this.section = srcobj.section;

        System.out.println("Copy constructor called.");
    }
}