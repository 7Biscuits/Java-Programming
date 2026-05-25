import java.util.Scanner;

public class PatternPrinting {

    static void p1() { // Sum of n natural numbers
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for (int i=1; i<=n; i++) {
            sum += i;
        }
        System.out.println(sum);
        sc.close();
    }

    static void p2() { // generate table of x number
        System.out.println("Enter the number to generate table: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n*i));
        }
        sc.close();
    }

    static void p3() { // Input an integer and count how many digits it has.
        Scanner sc = new Scanner(System.in);
        int myInt = sc.nextInt();
        int noOfDigits = 0;
        String nStr = String.valueOf(myInt);
        System.out.println(nStr);
        for (char a : nStr.toCharArray()) {
            noOfDigits++;
        }
        System.out.println(noOfDigits);
        sc.close();
    }

    static void p4() { // rectangular star pattern

        int height = 4;
        int width = 5;

        for (int i = 0; i<height; i++) {
            for (int j = 0; j<width; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void p5() { // hollow rectangle
        int height = 4;
        int width = 5;
        for (int i = 1; i<=height; i++) {
            for (int j = 1; j<=width; j++) {
                if (i == 1 || j == 1 || i == height || j == width) 
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    static void p6() { // half pyramid
        int n = 4;
        for (int i=0; i<n; i++) {
            for (int j=0; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void p7() { // inverted half pyramid
        int n = 6;
        for (int i=n; i>=1; i--) {
            for (int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void p8() { // 180 deg rotated inverted half pyramid
        int n = 4;
        for (int i=1; i<=n; i++) {
            for (int j=n; j>i; j--) {
                System.out.print(" ");
            }
            for (int k=1; k<=i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void p9() { // pyramid with numbers
        int n = 5;
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void p10() { // inverted half pyramid with numbers
        int n = 5;
        for (int i=n; i>=1; i--) {
            for (int j=1; j<=i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static void p11() { // Floyd's Triangle
        int n = 5;
        int number = 1;
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                System.out.print(number+" ");
                number++;
            }
            System.out.println();
        }
    }

    static void p12() { // 0-1 Triangle
        int a = 0, b = 0, n = 5;
        for (int i=1; i<=n; i++) {
            if (a == 1) a--;
            else a++;
            b=a;
            for (int j=1; j<=i; j++) {
                System.out.print(b+" ");
                if (b==1) b--;
                else b++;
            }
            System.out.println();
        }
    }

    static void p13() { // hollow right-angled triangle
        int height = 10;
        for (int i=1; i<=height; i++) {
            for (int j=1; j<=i; j++) {
                if (i==j || j==1 || i==height)
                    System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();
        }
    }

    static void p14() { // rhombus pattern
        int n=5;
        for (int i=1; i<=n; i++) {
            // blank spaces
            for (int j=n; j>=i; j--) {
                System.out.print(" ");
            }
            // stars
            for (int k=1; k<=n; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void p15() {
        int n = 4; // height
        for (int i=1; i<=n; i++) {
            // blank spaces
            for (int j=n; j>=i; j--) {
                System.out.print(" ");
            }
            // 1st number pyramid
            for (int j=1; j<=i; j++) {
                System.out.print(i);
            }
            // 2nd number pyramid
            for (int j=2; j<=i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    static void p16() { // Isosceles triangle
        int n = 5; // height
        for (int i=1; i<=n; i++) {
            for (int j=n; j>=i; j--) {
                System.out.print("  ");
            }
            for (int j=1; j<=i; j++) {
                System.out.print("* ");
            }
            for (int j=2; j<=i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void p17() { // Isosceles triangle
        int n = 5;
        for (int i=1; i<=n; i++) {
            for (int j=n; j>=i; j--) {
                System.out.print("  ");
            }
            for (int j=1; j<=2*i-1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void p18() { // 180 deg inverted isosceles triangle
        int n = 5;
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                System.out.print("  ");
            }
            for (int j=n; j>i; j--) {
                System.out.print("* ");
            }
            for (int j=1; j<n-i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void hollowRect() {
        int n = 4; // height
        int m = 6; // width
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (i == 1 || i == n || j == 1 || j == m)
                    System.out.print("* ");
                else 
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    static void hollowIsoscelesTriangle() {
        int n = 5; // height
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n-i; j++) {
                System.out.print("  ");
            }
            for (int j=1; j<=i; j++) {
                if (i==n || j==1)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            for (int j=2; j<=i; j++) {
                if (i==j || i==n)
                    System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();
        }
    }

    static void invertedIsoscelesTriangle() {
        int n = 7;
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                System.out.print("  ");
            }
            for (int j=n; j>=2*i-1; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        invertedIsoscelesTriangle();
    }
}

