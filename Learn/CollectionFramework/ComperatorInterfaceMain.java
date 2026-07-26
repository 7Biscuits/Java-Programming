package CollectionFramework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

// this code discusses how to use comparator interface to define sorting order of a collection of custom objects.
// comparator interface doesn't require the object's class to be modified.
// there are 3 ways to define a comparator. 1st is writing a class, 2nd is a shorthand method,
// and 3rd is using lambda expression

class Student {
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

// writing a class that implements comparator interface.
// this improves reusability
class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o2.age == o1.age)
            return o1.name.compareTo(o2.name);
        return o1.age - o2.age;
    }
}

class CGPAComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        if (o2.cgpa == o1.cgpa)
            return o1.name.compareTo(o2.name);
        return Double.compare(o2.cgpa, o1.cgpa);
    }
}

public class ComperatorInterfaceMain {

    static void shortHandMethod() {
        Student s1 = new Student(1, "Aman", 19, 9.7f);
        Student s2 = new Student(2, "Ben", 20, 9.1f);
        Student s3 = new Student(3, "Chris", 19, 8.4f);

        ArrayList<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);

        // shorthand method
        Collections.sort(students, new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                return o1.age - o2.age;
            }

        });

        System.out.println(students);
    }

    static void useComparatorObject() {
        Student s1 = new Student(1, "Ben", 19, 9.1f);
        Student s2 = new Student(2, "Aman", 20, 9.1f);
        Student s3 = new Student(3, "Chris", 19, 8.4f);

        ArrayList<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);

        Collections.sort(students, new AgeComparator());
        System.out.println(students);
        Collections.sort(students, new CGPAComparator());
        System.out.println(students);
    }

    static void lamdaExpressionMethod() {
        Student s1 = new Student(1, "Aman", 19, 9.7f);
        Student s2 = new Student(2, "Ben", 20, 9.1f);
        Student s3 = new Student(3, "Chris", 19, 8.4f);

        ArrayList<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);

        Collections.sort(students, (o1, o2) -> o1.age - o2.age);
        System.out.println(students);
    }

    public static void main(String[] args) {
        shortHandMethod();
        useComparatorObject();
        lamdaExpressionMethod();

        // sort an array in descending order using comparator in Arrays.sort() method
        Integer[] arr = {5, 6, 1, 9, 2, 0, 4};
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1); // descending order
            }
        });

        for (int a : arr) {
            System.out.println(a);
        }
    }
}
