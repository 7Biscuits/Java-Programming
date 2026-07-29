import java.util.Scanner;

public class ArraysBasic {

    static void traverseArray(int[] arr) {
        for (int e : arr) {
            System.out.print(e+" ");
        }
    }

    static void p1() {
        int[] arr = new int[5];
        for (int i=0; i<5; i++) {
            arr[i] = i+10;
        }
        
        for (int elem : arr) { // for each loop
            System.out.println(elem);
        }

        for (int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    static void userInputArray() {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        System.out.println(arr.length);
        for (int i=0; i<arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        int mulOfArr = 1;
        for (int elem : arr) {
            mulOfArr *= elem;
        }
        System.out.println(mulOfArr);
    }

    static void findMaxElem() {
        int[] arr = {1, 3, 2, 7, 3, 6, -21, 21};
        int max = arr[0];
        for (int i=0; i<arr.length; i++) {
            if (arr[i]>max) max = arr[i];
        }
        System.out.println(max);
    }

    // 2D Arrays

    static void array2D() {
        int[][] arr = { // jagged 2d array
            {1, 2}, {3, 4, 5}, {6}, {7,8, 9, 10}
        };
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void traverseJaggedArray2D(int[][] arr) {
        for (int i=0; i<arr.length; i++) {
            for (int j=0; j<arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void jaggedArray2D() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of Rows: ");
        int row = sc.nextInt();
        int[][] arr = new int[row][]; // arr[0] = new int[2]; arr[1] = new int[3]; arr[2] = new int[5];
        for (int i=0; i<arr.length; i++) {
            System.out.println("Enter the no. of elements for Row " + i + " :");
            int n = sc.nextInt();
            arr[i] = new int[n];
            System.out.println("Enter the elements for Row " + i);
            for (int j=0; j<n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();
        traverseJaggedArray2D(arr);
    }

    static void reverseArray1D() {
        int[] arr = {1, 2, 3, 4, 5};
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        traverseArray(arr);
    }

    static void transposeMatrix() {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transpose = new int[cols][rows]; // no. of rows and columns interchange in transpose.
        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        traverseJaggedArray2D(transpose);
    }

    public static void main(String[] args) {
        transposeMatrix();
    }
}
