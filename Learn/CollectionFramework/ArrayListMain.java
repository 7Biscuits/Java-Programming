package CollectionFramework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class ArrayListMain {

    static void one() {
        // An arraylist dynamically allocates memory to cater new elements being added.
        ArrayList<Integer> list = new ArrayList<>();
        list.ensureCapacity(10);
        // Convert an array into an arraylist
        Integer[] arr = { 2, 3, 9 };
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(arr));

        // add elements
        for (int i = 0; i < 11; i++) {
            list.add(i);
        }
        System.out.println(list);

        // remove elements by index
        list.remove(0);

        // remove common elements of 2 arraylists:
        list.removeAll(list2);
        System.out.println(list);

        // Iterating over an arraylist
        // using a forloop (fails for datastructures like linkedlists)
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // creating an iterator object
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // change an element and fetch it
        list.set(list.size() - 1, 100);
        System.out.println(list.get(list.size() - 1));

        // get the index of a specific element
        System.out.println(list.indexOf(5)); // returns -1 if element is not present.
    }

    static void two() {
        ArrayList<Integer> list = new ArrayList<>();
        // use a method to append random numbers between 0-99
        generateRandomList(list);
        System.out.println(list);

        // sorting
        Collections.sort(list); // sorts the list in ascending order
        System.out.println(list);

        Collections.sort(list, Collections.reverseOrder()); // sorts the list in descending order
        System.out.println(list);

        // note: this just creates a new reference to the list, not a clone of the list.
        ArrayList<Integer> newList = list; // newList is just a reference to the arraylist.
        newList.clear(); // clears out the list
        System.out.println(list); // output: []

        // to create a clone:
        generateRandomList(list);
        // ArrayList<Integer> newList2 = (ArrayList<Integer>) list.clone(); // outdated
        ArrayList<Integer> newList2 = new ArrayList<>(list); // modern and better way to clone
        System.out.println("List: " + list);
        list.clear(); // list = []
        System.out.println("New list 2: " + newList2); // holds the values of list.
    }

    static void generateRandomList(ArrayList<Integer> list) {
        list.clear();
        // append random numbers between 0-99
        Random r = new Random();
        for (int i=0; i<11; i++) {
            list.add(r.nextInt(100));
        }
    }

    public static void main(String[] args) {
        one();
    }
}
