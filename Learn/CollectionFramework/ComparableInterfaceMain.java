package CollectionFramework;

// this code discusses how to define ways of sorting collections of custom objects.

import java.util.ArrayList;
import java.util.Collections;

class Student implements Comparable<Student> {
    int id;
    String name;
    int age;
    float cgpa;

    public Student(int id, String name, int age, float cgpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.cgpa = cgpa;
    }

    // this method compares the current object with the specified object to
    // determine their order for sorting.
    // returns negative int, zero, positive int if the current object is less than,
    // equal to, more than the specified object.
    // this is a custom compareTo method for sorting students on the basis of their
    // age in descending order.
    @Override
    public int compareTo(Student s) {
        // if the age is same, define their order according to their name in
        // lexographically order.
        if (this.age == s.age) {
            // since this.name is a String object, compareTo method is already defined for
            // it
            return this.name.compareTo(s.name);
        }
        return s.age - this.age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name=" + name +
                ", age=" + age +
                ", cgpa=" + cgpa +
                "\'" +
                "}";
    }
}

public class ComparableInterfaceMain {
    public static void main(String[] args) {
        Student s1 = new Student(1, "Aman", 19, 9.7f);
        Student s2 = new Student(2, "Ben", 20, 9.1f);
        Student s3 = new Student(3, "Chris", 19, 8.4f);

        ArrayList<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);

        // sort students on the basis of their age
        Collections.sort(students);
        System.out.println(students);
    }
}
