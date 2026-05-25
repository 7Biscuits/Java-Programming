public class StringLearn {
    
    static void p() {
        String str1 = "Hello"; // String literal; Stores "Hello" in String pool (a part of heap memory)
        String str2 = new String("Hello"); // Makes a new object and stores it in heap memory only.

        if (str1.equals(str2)) {
            System.out.println("they are both equal");
        }
    }

    static void traverseString() {
        String str = "Hello, World";
        char[] arr = str.toCharArray();
        for (char chr : arr) {
            System.out.print(chr);
        }
    }

    static void reverseString() { // 2 pointer method
        String str = "Hello";
        char[] chr = str.toCharArray();
        int start = 0;
        int end = chr.length - 1;
        while (start < end) {
            char temp = chr[start];
            chr[start] = chr[end];
            chr[end] = temp;
            start++; end--;
        }
        System.out.println(new String(chr));
    }

    static void revString() { // easy method
        String str = "Hello";
        char[] chr = str.toCharArray();
        String revStr = "";
        for (int i=chr.length-1; i>=0; i--) {
            revStr += chr[i];
        }
        System.out.println(revStr);
    }

    static void checkPalindrome() {
        // palindrome -> racecar, civic, radar
        String str = "Hello";
        String revStr = "";
        char[] chr = str.toCharArray();
        for (int i=chr.length-1; i>=0; i--) {
            revStr += chr[i];
        }
        if (str.equalsIgnoreCase(revStr))
            System.out.println("The string is a palindrome.");
        else
            System.out.println("The string is not a palindrome.");
    }

    public static void main(String[] args) {
        checkPalindrome();
    }
}
