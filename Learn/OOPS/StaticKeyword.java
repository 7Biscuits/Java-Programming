package OOPS;

/* 
static means the member belongs to the class itself, not to individual objects of that class.

static schoolName = "sbs bgn" -> schoolName will be same for all the instances (objects)
and sub classes of the class.
*/


class Student {
    static String schoolName;
    String name;
    static void study() {
        System.out.println("A Student has to study.");
    }
}

class HeadBoy extends Student {
    String name;
    String designation = "HeadBoy";
}

public class StaticKeyword {
    public static void main(String[] args) {
        Student.schoolName = "Sbs Bgn";
        Student.study();

        Student s1 = new Student();
        s1.name = "Raghav";
        System.out.println(s1.schoolName); // Sbs Bgn

        Student s2 = new Student();
        s2.name = "Harsh";
        System.out.println(s2.schoolName); // Sbs Bgn

        HeadBoy s3 = new HeadBoy();
        s3.name = "Rudransh";
        System.out.println(s3.schoolName); // Sbs Bgn
        System.out.println(s3.designation);
        s3.study();
    }
}
