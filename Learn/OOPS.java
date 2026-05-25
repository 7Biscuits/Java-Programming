public class OOPS {

    static void studentOOPS() {
        Student A = new Student(); // calls the default constructor.
        // set attributes line by line for default constr. Default attributes = null
        A.id = 1234;
        A.name = "Sam";
        A.age = 17;
        A.section = 'C';
        A.study();

        Student B = new Student(9876, "Peter", 18, 'B'); // send attributes and parameters.
        B.study();

        Student C = new Student(B); // copies B's set attributes to C
        C.study();
    }
    
    public static void main(String[] args) {
        studentOOPS();
    }
}


class Student {
    // Attributes
    public int id;
    public String name;
    public int age;
    public char section;

    // Methods / Behavior
    public void study() {
        System.out.println(name + " is studying.");
    }

    // Constructors -> public ClassName() | They are called whenever the object/instance of the class is created.

    // Default constructor
    public Student() { 
        System.out.println("Student default constructor called.");
    }

    // Parameterized constructor
    public Student(int sid, String name, int age, char section) {
        // note: this.(attribute) -> refers to class attributes; sid, name etc -> parameters passed
        this.id = sid;
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
