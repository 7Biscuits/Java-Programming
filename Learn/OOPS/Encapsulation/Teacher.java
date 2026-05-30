package OOPS.Encapsulation;

// Implementing Perfect Encapsulation (putting restrictions on data accessibility | hiding data)
public class Teacher {
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

    public int getAge() {
        return age;
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