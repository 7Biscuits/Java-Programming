package OOPS.Encapsulation;
import java.util.Scanner;


public class Main {

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

    static void student() {
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

    static void teacher() {
        Teacher T = new Teacher(134, "Frank", 41, new String[]{"Math", "Physics", "Chemistry"});
        System.out.println(T.getId(isAuthenticated));
        System.out.println(T.getName());
        T.setName("Henry");
        System.out.println(T.getName());
    }
    
    public static void main(String[] args) {
        authenticate();
        teacher();
    }
}
