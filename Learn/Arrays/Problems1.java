// package Arrays;

public class Problems1 {

    static void findUnsortedElement(int[] arr) {
        // [1, 3, 4, 6, 2, 8, 10] -> 2 is the unsorted.
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                System.out.println(arr[i + 1] + " is the unsorted number.");
                break;
            }
        }
    }

    // [1, 2, 3, 4] -> [2, 1, 4, 3]
    static void swapAlternateElements(int[] arr) {
        int ans[] = new int[arr.length];
        for (int i = 0; i < arr.length - 1; i += 2) {
            int temp = arr[i];
            ans[i] = arr[i + 1];
            ans[i + 1] = temp;
        }

        // problem: if array length is odd then the last element is not copied.
        // fix: copy the last element
        if (arr.length % 2 != 0) {
            ans[arr.length - 1] = ans[arr.length - 1];
        }

        for (int a : ans) {
            System.out.print(a + ", ");
        }
    }

    // given arrays of different lengths, find intersection of them.
    static void arrayIntersection(int[] arr1, int[] arr2) {
        for (int a : arr1) {
            for (int b : arr2) {
                if (a == b) {
                    System.out.print(a + ", ");
                }
            }
        }
    }

    // print alternate extreme elements of array
    // [1, 2, 3, 4, 5, 6] -> [1, 6, 2, 5, 3, 4]
    static void alternateExtremeElements(int[] arr) {
        int ans[] = new int[arr.length];
        int left = 0;
        int right = arr.length - 1;
        for (int i = 0; i < arr.length - 1; i += 2) {
            if (right == left) {
                break;
            }
            ans[i] = arr[left];
            ans[i + 1] = arr[right];
            left++;
            right--;
        }

        // if the array has odd no. of elements then push the mid element to the last
        // since it has no alernate element.
        if (arr.length % 2 != 0) {
            ans[arr.length - 1] = arr[arr.length / 2];
        }

        for (int a : ans) {
            System.out.print(a + ", ");
        }
    }

    public static void main(String[] args) {
        alternateExtremeElements(new int[] { 1, 2, 3, 4, 5, 6, 7 });
    }
}
