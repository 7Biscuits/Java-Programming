import java.lang.Math;

public class BasicMaths {

    static void digitsOfNum() {
        int num = 53127;
        while (num != 0) {
            int digit = num%10;
            System.out.println(digit);
            num = num/10; // int/int = int (floating point gets truncated)
        }
    }
    
    static void countDigits() {
        int num = 53127;
        int count = 0;
        while (num != 0) {
            num /= 10; // num = num/10
            count++;
        }
        System.out.println(count);
    }

    static void sumOfDigits() {
        int num = 53127;
        int sum = 0;
        while (num != 0) {
            sum += num%10;
            num /= 10;
        }
        System.out.println(sum);
    }

    static void reverseNumber() {
        int num = 53127;
        int revNum = 0;
        while (num != 0) {
            int digit = num%10;
            revNum = revNum*10+digit;
            num /= 10;
        }
        System.out.println(revNum);
    }

    static void palindromeNumber() {
        int num = 1321;
        int revNum = 0;
        int tempNum = num;
        while (tempNum != 0) {
            revNum = (revNum*10)+(tempNum%10);
            tempNum /= 10;
        }
        System.out.println(revNum);
        if (revNum == num)
            System.out.println("The given number is a palindrome.");
        else
            System.out.println("The given number is not a palindrome.");
    }

    static void primeNumber() {
        int num = 11;
        if (num <= 1) {
            System.out.println(num + " is not a prime number.");
            return;
        }

        boolean isPrime = true;
        for (int i=2; i<num; i++) { // i*i < num for better time complexity
            if (num%i == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime)
            System.out.println(num + " is a prime number.");
        else
            System.out.println(num + " is not a prime number.");
    }

    static int gcd(int a, int b) { // gcd = hcf
        // formula: gcd(a, b) = gcd(b, a%b)
        while (b != 0) {
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }

    static void lcm(int a, int b) {
        // formula: lcm*gcd = a*b -> lcm = a*b/gcd
        System.out.println((a*b)/gcd(a, b));
    }

    static void armstrongNumber(int num) {
        int noOfDigits = 0;
        int temp1 = num;
        while (temp1 != 0) {
            noOfDigits++;
            temp1 /= 10;
        }
        int temp2 = num;
        int cubicSum = 0;
        while (temp2 != 0) {
            cubicSum += Math.powExact(temp2%10, noOfDigits);
            temp2 /= 10;
        }
        if (cubicSum == num)
            System.out.println(num + " is an armstrong number.");
        else
            System.out.println(num + " is not an armstrong number.");
    }

    static void perfectNumber(int num) {
        int sum = 0;
        for (int i=1; i<num; i++) {
            if (num%i == 0)
                sum += i;
        }
        if (sum == num)
            System.out.println(num + " is a perfect number.");
        else
            System.out.println(num + " is not a perfect number.");
    }

    static boolean isPrime(int num) {
        if (num <= 1)
            return false;

        for (int i=2; i<num; i++) {
            if (num%i == 0)
                return false;
        }
        return true;
    }

    static void nPrimeNumbers() {
        int n = 10;
        for (int i=2; i<n; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        nPrimeNumbers();
    }
}
