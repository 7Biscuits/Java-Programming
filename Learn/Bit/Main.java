// package Bit;

// integer takes 4 bytes of memory; 1 byte = 8 bits; 4*8 = 32 bits of memory is taken by int.
// 5 = 00000000 00000000 00000000 00000101

public class Main {
    /*
     * logical operators for bits:
     * bitwise AND: n & m
     * bitwise OR : n | m
     * bitwise XOR: n ^ m; bit is 1 if the corresponding bits are different:
     * 1100 ^ 1010 = 0110
     * bitwise NOT: ~n: flips each bit: ~(1001) = 0110
     */

    static void checkEvenOdd(int n) {
        /*
         * logic: n & 1 gives the right most bit of the number (if bit = 0 then 0 & 1
         * gives 0; 1 & 1 gives 1).
         * An even integer's right most bit will always be 0 and odd integer's will be
         * 1.
         * example:
         * 2 = 0000 0010
         * 3 = 0000 0011
         */

        int rightMostBit = n & 1;
        if (rightMostBit == 0)
            System.out.println(n + " is even");
        else
            System.out.println(n + " is odd");
    }

    /*
     * note: the leftmost bit is called the sign bit
     * if leftmost bit is 1 then integer is negative
     * if leftmost bit is 0 then integer is postive
     * 1001 -> negative integer; 0110 -> positive integer
     */
    static void leftShift(int n) {
        /*
         * <<
         * shifts each bit to the left.
         * leftmost bit is lost.
         * 0 is added as the rightmost bit.
         * << (10011) = lost->1(00110)<-added = 00110
         * an integer is multiplied by 2.
         */

        // writing a program to multiply an integer by 2, 10 times.
        for (int i = 1; i < 11; i++) {
            n = n << 1; // leftshift by 1 bit; same as n *= 2
            System.out.println(n);
        }
        /*
         * note: if we keep leftshifting and the leftmost bit (sign bit) becomes 1 then
         * we start getting negative integers.
         * if we lose all the bits by shifting then we get 0. (integer overflow)
         */

        // same logic follows rightshift except it shifts the bits to right and
        // rightmost bit is lost.
        // number is divided by 2.
    }

    // note: the "1" bit in binary is called "set bit"

    // this function checks if a number is a power of two i.e 2^n using a bruteforce
    // method.
    /*
     * logic: if a number is power of 2, it will have only one set-bit/"1" in its
     * binary form.
     * 2^0: 1 in binary = 0000 0001
     * 2^1: 2 in binary = 0000 0010
     * 2^2: 4 in binary = 0000 0100
     * 
     * So, if we count the no. of set bits in a number we can find out if it can be
     * a power of 2.
     */

    static void checkPowerOf2Bruteforce(int n) {
        int m = n;
        int count = 0;
        int pow = -1;
        while (n != 0) {
            if ((n & 1) != 0) {
                count++;
            }
            pow++;
            n = n >> 1;
        }

        if (count == 1) {
            System.out.println(m + " is a power of 2.");
            System.out.println(m + " = 2^" + pow);
        }
    }

    /*
     * non-bruteforce method to check if n is a power of 2.
     * let n = 8.
     * 8 = 0000 1000
     * (n-1): 7 = 0000 0111
     * 8 & 7: 1000 & 0111 = 0000 0000
     * hence, if n & (n-1) = 0 then n is power of 2
     */
    static void checkPowerOf2(int n) {
        if ((n & (n - 1)) == 0) {
            System.out.println(n + " is a power of 2.");
        }
    }

    /*
     * Logic:
     * Swapping a and b i.e a will be = b and b will be equal to a.
     * Property of XOR: n ^ n = 0 | n ^ 0 = n
     * let a = 2, b = 3
     * a = a^b = 2^3
     * b = a^b = (2^3)^3 = 2^(3^3) = 2
     * a = a^b = (2^3)^2 = 3^(2^2) = 3
     * 
     * a and b are swapped.
     */
    static void swapTwoNumberUsingXOR(int a, int b) {
        System.out.println(a + ", " + b);
        // swap logic
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + ", " + b);
    }

    // question: find unique element from a list where all other elements appear
    // twice.
    // bruteforce method, O(n^2)
    static void findUniqueElementBruteforce() {
        int[] arr = { 1, 2, 3, 6, 3, 2, 1 };
        for (int i = 0; i < arr.length; i++) {
            int target = arr[i];
            int count = 0;
            for (int j = 0; j < arr.length; j++) {
                if (target == arr[j]) {
                    count++;
                }
            }
            if (count == 1) {
                System.out.println(target + " is the unique element.");
                break;
            }
        }
    }

    /* problem: all elements appear twice except one, find the number that appears only once
     * logic:
     * 1^2^3^6^3^2^1 = (1^1)^(2^2)^(3^3)^6 = 6. Since n^n = 0
     * time complexity: O(n)
     */
    static void findUniqueElement() {
        int[] arr = { 1, 2, 3, 6, 3, 2, 1 };

        int unique = arr[0];
        for (int i = 1; i < arr.length; i++) {
            unique = unique ^ arr[i];
        }
        System.out.println(unique + " is the unique element.");
    }

    /*
     * logic: n & (n-1) removes last set bit.
     * example: n = 7
     * 7 = 0111; n-1 = 6 = 0110
     * last set bit in 7: 011[1]
     * 7 & 6 = 0111 & 0110 = 0110
     * the last set bit was removed.
     */
    static void removeLastSetBit(int n) {
        int m = n & (n - 1); // remove the last setbit
        System.out.println(m);
    }

    /*
     * note: steps to find a negative of the number
     * use the bitwise NOT (~) operator on the number.
     * perform a binary addition of 1 on the flipped number (i.e add 1 to its binary form)
     * example: n = 9 = 0000 1001
     * ~n = 1111 0110
     * ~n+1:
     *   1111 0110
     * + 0000 0001
     * = 1111 0111 = -9
     */
    static void findNegativeOfNumber(int n) {
        int m = ~n;
        m += 1;
        System.out.println(m);
    }

    public static void main(String[] args) {
        // checkPowerOf2Bruteforce(8);
        // checkPowerOf2(8);
        // swapTwoNumberUsingXOR(2, 3);
        // findUniqueElement();
        // removeLastSetBit(10);
        findNegativeOfNumber(9);
    }
}
