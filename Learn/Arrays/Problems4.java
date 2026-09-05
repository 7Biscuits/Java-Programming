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
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
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

    // remove duplicate elements from a sorted array. -> bruteforce
    // [1, 2, 2, 2, 3, 3, 4] -> [1, 2, 3, 4, _, _]
    static int removeDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            if (!list.contains(n)) {
                list.add(n);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < list.size())
                nums[i] = list.get(i);
            else
                nums[i] = 0;
        }
        return list.size();
    }

    // remove duplicate elements using a HashMap.
    static int removeDuplicates2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for (int i = 0; i < keys.size(); i++) {
            nums[i] = keys.get(i);
        }
        return keys.size();
    }

    // remove duplicate elements using two-pointer method.
    static int removeDuplicates3(int[] nums) {
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                nums[i + 1] = nums[j];
                i++;
            } else {
                j++;
            }
        }
        return i + 1;
    }

    // find the first repeating number
    // [1, 2, 3, 4, 3, 5] -> 3 since it repeats
    // time complexity -> O(n^2)
    static int firstRepeatingNumber(int[] arr) {
        int num = arr[0];
        for (int n : arr) {
            int tempCount = 0;
            for (int a : arr) {
                if (a == n)
                    tempCount++;
            }
            if (tempCount > 1) {
                num = n;
            } else {
                num = -1;
            }
        }
        return num;
    }

    // using hashmap -> O(n)
    static int firstRepeatingNumber2(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    // [1, 7, 3, 6, 5, 6] -> index 3 is the pivot point since sum of left of 3rd
    // index = sum of right.
    static int pivotIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int sumL = 0;
            int sumR = 0;
            for (int j = 0; j < nums.length; j++) {
                if (j < i) {
                    sumL += nums[j];
                } else if (j > i) {
                    sumR += nums[j];
                }
            }
            if (sumR == sumL) {
                return i;
            }
        }
        return -1;
    }

    // [1, 4, 4, 5, 2, 2] -> missing number: 3 & 6, since range is [0, 6].
    static List<Integer> missingNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i+1);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 4, 4, 5, 2, 2 };
        for (int n : missingNumber(arr)) {
            System.out.println(n);
        }
    }
}