import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int randInt = rand.nextInt(100);
        boolean flag = true;
        System.out.println(randInt);
        int tries = 0;

        System.out.println("Welcome to number guessing game");
        while (flag) {
            System.out.println("Enter a number between 0-99");
            int num = sc.nextInt();
            tries++;
            if (num > randInt) {
                System.out.println("enter a smaller number");
            } else if (num < randInt) {
                System.out.println("enter a larger number");
            } else {
                System.out.println("Found the number!");
                System.out.println("Random number was: " + randInt);
                System.out.println("No. of tries taken: " + tries);
                sc.close();
                flag = false;
            }
        }
    }
}