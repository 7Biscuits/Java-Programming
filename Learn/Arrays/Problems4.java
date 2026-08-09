import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problems4 {

    // problem: find two integers in the array that add up to the target and return
    // their indices.
    // bruteforce approach -> O(n^2) time complexity
    static int[] twoSum(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] { -1, -1 };
    }

    // optimal approach -> use hashmap for O(n) time complexity.
    static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int n = target - nums[i];
            if (map.containsKey(n) && map.get(n) != i) {
                return new int[] { map.get(n), i };
            }
        }
        return new int[] { -1, -1 };
    }

    // 3Sum bruteforce
    static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i=0; i<nums.length-2; i++) {
            for (int j=i+1; j<nums.length-1; j++) {
                for (int k=j+1; k<nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> elems = new ArrayList<>();
                        elems.add(nums[i]);
                        elems.add(nums[j]);
                        elems.add(nums[k]);
                        Collections.sort(elems);
                        if (!list.contains(elems)) {
                            list.add(elems);
                        }
                    }
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        arr = twoSum2(arr, 8);
        for (int n : arr) {
            System.out.print(n + ", ");
        }
    }
}