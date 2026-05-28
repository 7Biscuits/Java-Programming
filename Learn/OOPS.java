import java.util.Scanner;

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

// Implementing Perfect Encapsulation (putting restrictions on data accessibility | hiding data)
class Teacher {
    private int id; // can only access private attributes within this class. Can't access externally or via a derived class.
    private String name;
    private int age;
    private String[] subjects;

    public Teacher(int id, String name, int age, String[] subjects) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Adding an authentication/security layer for getter & setter methods.
    public int getId(boolean isAuthenticated) {
        if (isAuthenticated)
            return id;
        else {
            System.out.println("User is not authenticated");
            return 0;
        }
    }

    public void setId(boolean isAuthenticated, int id) {
        if (isAuthenticated)
            this.id = id;
        else
            System.out.println("User is not authenticated.");
    }
}

public class OOPS {

    static String username = "user1234";
    static int password = 1234;
    static boolean isAuthenticated = false;

    static void authenticate() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username");
        String _username = sc.nextLine();
        System.out.println("Enter password");
        int _password = sc.nextInt();
        sc.close();

        if (_username.equalsIgnoreCase(username) && (_password == password)) {
            isAuthenticated = true;
            System.out.println("Authentication successful");
        }
        else
            System.out.println("Authentication failed.");
    }

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

    static void teacherOOPS() {
        Teacher T = new Teacher(134, "Frank", 41, new String[]{"Math", "Physics", "Chemistry"});
        System.out.println(T.getId(isAuthenticated));
        System.out.println(T.getName());
        T.setName("Henry");
        System.out.println(T.getName());
    }
    
    public static void main(String[] args) {
        authenticate();
        teacherOOPS();
    }
}
