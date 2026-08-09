package CollectionFramework;

import java.util.HashSet;
import java.util.Objects;

class Student {
    int rollno;
    String name;

    public Student(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }

    // When you pass an object to System.out.println(),
    // Java automatically calls that object's toString() method
    // to obtain a String representation. By overriding toString(),
    // you can customize how the object is displayed.
    @Override
    public String toString() {
        return "Student{" +
                "rollno=" + rollno +
                ", name='" + name + "\'" +
                "}";
    }

    /*
     * If the hashset is of a custom object, the hashCode() and equals() need to be
     * overriden and be customly written.
     */

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true; // if an object is being compared to itself.
        if (this.getClass() != o.getClass() || o == null)
            return false;
        Student student = (Student) o;
        return this.rollno == student.rollno; // rollno must be unique, name can be repeated
    }

    @Override
    public int hashCode() {
        // generate a hashcode based on rollno so that non-unique rollno can't be added
        // into the hashset
        return Objects.hash(rollno);
    }
}

public class SetCustomObject {
    public static void main(String[] args) {
        Student s1 = new Student(1, "name");
        Student s2 = new Student(2, "name");
        Student s3 = new Student(2, "name"); // won't be added due to non-unique rollno

        HashSet<Student> hs = new HashSet<>();
        hs.add(s1);
        hs.add(s2);
        hs.add(s3);

        System.out.println(hs);
    }
}
