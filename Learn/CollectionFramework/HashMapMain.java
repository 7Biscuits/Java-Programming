package CollectionFramework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;;

// HashMap -> key, value pairs. (key, value)

public class HashMapMain {

    static void printActions() {
        System.out.println("""
                    1. View students
                    2. Add student
                    3. Update student's name
                    4. Delete student
                    0. Quit
                """);
    }

    static void viewStudents(Map<Integer, String> hm) {
        if (hm.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Map.Entry<Integer, String> entry : hm.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    static void addStudent(int rollno, String name, Map<Integer, String> hm) {
        if (hm.putIfAbsent(rollno, name) == null) {
            System.out.println("Student added");
        } else {
            System.out.println("Student with rollno " + rollno + " already exists.");
        }
    }

    static void updateName(int rollno, String name, Map<Integer, String> hm) {
        if (hm.replace(rollno, name) != null)
            System.out.println("Student updated");
        else
            System.out.println("Student with rollno doesn't exist");
    }

    static void deleteStudent(int rollno, Map<Integer, String> hm) {
        if (hm.remove(rollno) != null) {
            System.out.println("Student deleted.");
        } else {
            System.out.println("Student not found.");
        }
    }

    public static void main(String[] args) {
        Map<Integer, String> hm = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            printActions();
            int action = sc.nextInt();
            switch (action) {
                case 1:
                    viewStudents(hm);
                    break;
                case 2:
                    System.out.print("Enter roll number: ");
                    int rollno = sc.nextInt();

                    sc.nextLine(); // consume newline

                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    addStudent(rollno, name, hm);
                    break;
                case 3:
                    System.out.print("Enter roll number: ");
                    int _rollno = sc.nextInt();

                    sc.nextLine(); // consume newline

                    System.out.print("Enter name: ");
                    String _name = sc.nextLine();

                    updateName(_rollno, _name, hm);
                    break;
                case 4:
                    System.out.println("Enter roll number: ");
                    deleteStudent(sc.nextInt(), hm);
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid Option");
                    break;
            }
        }
        sc.close();
    }
}
