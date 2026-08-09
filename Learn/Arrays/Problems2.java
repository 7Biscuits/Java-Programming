import java.util.HashMap;
import java.util.Map;

public class Problems2 {

    // method to reverse an array, [1, 2, 3, 4, 5] -> [5, 4, 3, 2, 1]
    static void reverseArray(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        for (int a : arr) {
            System.out.print(a + ", ");
        }
    }

    // method to shift an element by 1 position. [1, 2, 3, 4] -> [4, 1, 2, 3]
    static void shiftElement(int[] arr) {
        int n = arr.length;
        int temp = arr[n-1];
        for (int i = n-1; i >= 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;

        for (int a : arr) {
            System.out.print(a + ", ");
        }
    }

    // [1, 2, 2, 2, 2, 3, 3, 5, 5, 5] -> mode = 2 | frequency = 4
    static void getMode(int[] arr) {
        int mode = -1;
        int count = -1;
        for (int i=0; i<arr.length; i++) {
            int tempCount = 0;
            int elem = arr[i];
            for (int j=0; j<arr.length; j++) {
                if (elem == arr[j]) {
                    tempCount++;
                }
            }
            if (tempCount > count) {
                count = tempCount;
                mode = elem;
            }
        }
        System.out.println("mode of array: " + mode + " | frequency: " + count);
    }

    // more efficient way to achieve same result in less time complexity. 
    static void getModeUsingHashmap(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0)+1);
            /* getOrDefault method:
            if key exists -> returns the stored value
            if key does not exist -> return the fallback/default value.
            here, if n is present in the map then return increment the stored value by 1
            if n is not present then add it in the map and the value will be default value +1 -> 0 + 1.
            */ 
        }

        int maxFrequency = -1;
        int mode = -1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                mode = entry.getKey();
            }
        }
        System.out.println("mode of array: " + mode + " | frequency: " + maxFrequency);
    }

    static void getFrequency(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int num : arr) {
            hm.put(num, hm.getOrDefault(num, 0)+1);
        }

        int maxFrequency = Integer.MIN_VALUE;
        int minFrequency = Integer.MAX_VALUE;
        int maxKey = -1;
        int minKey = -1;
        for (int a : hm.keySet()) { // another way to traverse through a HashMap.
            if (hm.get(a) > maxFrequency) {
                maxFrequency = hm.get(a);
                maxKey = a;
            }
            if (hm.get(a) < minFrequency) {
                minFrequency = hm.get(a);
                minKey = a;
            }
        }

        System.out.println("Max frequency: " + maxFrequency + " | Key: " + maxKey);
        System.out.println("Min frequency: " + minFrequency + " | Key: " + minKey);
    }
    public static void main(String[] args) {
        getFrequency(new int[] {1, 2, 3, 2, 2, 3, 5, 5, 5, 5, 2, 2});
    }
}
