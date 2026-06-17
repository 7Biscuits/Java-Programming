package CollectionFramework;

import java.util.PriorityQueue;

/*
- PriorityQueue is a type of queue that gives priority to integers with less value.
- default behaviour: low integer -> high priority
- passing [ (a,b) -> b-a ] lambda expression in PriorityQueue reverses the default behaviour.
- or pass Collections.reverseOrder() instead of the lamda exp
*/

public class PriorityQueueMain {

    static void tryPriorityQueue() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(40);
        pq.offer(20);
        pq.offer(50);
        pq.offer(10);
        pq.offer(30);

        while (!pq.isEmpty()) {
            System.out.println(pq.poll()); // prints 10, 20, 30, 40, 50
        } // smallest int is given first priority and goes out before larger intergers
    }

    // sort in ascending order
    static void sortRandomArray(int[] arr) {
        System.out.println("Ascending order sort");
        int[] sortedArr = new int[arr.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            pq.offer(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            sortedArr[i] = pq.poll();
        }

        for (int elem : sortedArr) {
            System.out.println(elem);
        }
    }

    // sort in descending order
    static void reverseSortRandomArray(int[] arr) {
        System.out.println("Descending order sort");
        int[] rSortedArr = new int[arr.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // lambda exp

        for (int i = 0; i < arr.length; i++) {
            pq.offer(arr[i]);
        }

        for (int i = 0; i < arr.length; i++) {
            rSortedArr[i] = pq.poll();
        }

        for (int elem : rSortedArr) {
            System.out.println(elem);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 20, 31, 11, 9, 50, 78, 69 };
        sortRandomArray(arr);
        reverseSortRandomArray(arr);
    }
}
