public class Problem3 {

    // [0, 1, 0, 1, 1, 0, 1] -> [0, 0, 0, 1, 1, 1, 1]
    static int[] sortZeroesAndOnes(int[] arr) {
        int zeroes = 0;
        for (int num : arr) {
            if (num == 0)
                zeroes++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (i < zeroes) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }
        return arr;
    }

    // [0, 1, 0, 1, 1, 0, 1] -> [0, 0, 0, 1, 1, 1, 1]
    static int[] sortZeroesAndOnes2(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[left] == 1 && arr[right] == 0) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
            if (arr[left] == 0)
                left++;
            if (arr[right] == 1)
                right--;
            if (left > right)
                break;
        }
        return arr;
    }

    /*
     * Problem: [3, 4, 1, 0, 5] -> missing number = 2 since it's not in range [0, 5]
     * where 5 is number of elements.
     * [3, 4, 1, 0, 5] -> add all the elements -> 3+4+1+0+5 = 13
     * (no. of elements) -> n = 5
     * sum of elements between [0, n]: 1+2+3+4+5 = 15
     * missing number = 15-13 = 2
     */
    static int missingNumber(int[] nums) {
        int sum = 0;
        for (int i = 0; i <= nums.length; i++) {
            sum += i;
        }
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
        }
        return sum;
    }

    /*
     * Using XOR to solve this problem
     * a number xor with itself is 0 -> n ^ n = 0
     * so we can perform XOR operation between the range elements and the elements
     * of the array.
     */
    static int missingNumber2(int[] nums) {
        int xor = 0;
        // find the xor for the range
        for (int i = 0; i <= nums.length; i++) {
            xor ^= i;
        }

        // now perform XOR with the elements of the array
        for (int n : nums) {
            xor ^= n;
        }

        return xor; // xor is the missing number
    }

    // [1, 1, 2, 3, 4, 5, 4, 5, 3]
    static int findUniqueElement(int[] arr) {
        int unique = arr[0];
        for (int i = 1; i < arr.length; i++) {
            unique ^= arr[i];
        }
        return unique;
    }

    // [0, 1, 1, 2, 1, 2, 2, 1, 0, 0, 1] -> [0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2]
    // static int[] sortZeroesOnesTwos(int[] nums) {
    // int left = 0;
    // int right = nums.length - 1;
    // for (int i = 0; i < nums.length; i++) {
    // if ((nums[left] == 1 || nums[left] == 2) && nums[right] == 0) {
    // int temp = nums[left];
    // nums[left] = nums[right];
    // nums[right] = temp;
    // left++;
    // right--;
    // }
    // }
    // return nums;
    // }

    public static void main(String[] args) {
        int n = findUniqueElement(new int[] { 1, 1, 2, 3, 4, 5, 4, 5, 3 });
        System.out.println(n);
    }
}
