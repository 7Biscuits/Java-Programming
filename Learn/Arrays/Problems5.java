public class Problems5 {
    /*
     * kadane's algorithm - Given an integer array nums, find the subarray with the
     * largest sum, and return its sum.
     * Input: arr = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
     */
    static int maximumSubarray(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i=0; i<arr.length; i++) {
            sum += arr[i];
            if (sum > maxSum) maxSum = sum;
            if (sum < 0) sum = 0;
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int max = maximumSubarray(new int[] {-2,1,-3,4,-1,2,1,-5,4});
        System.out.println(max);
    }
}
