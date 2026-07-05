package CollectionFramework;

import java.util.HashSet;
import java.util.Set;

/*
- Set contains only unique elements. Elemens can't be repeated in a set.
- Each element that is added has a hashcode that decides where the element will be stored in the 
datastructure. Set doesn't retain the order of addition of elements to the datastruct.
- Methods like add, remove etc is same as list methods.

addAll() -> union; retainAll() -> intersection; removeAll() -> difference;
containsAll() -> subset;
*/

public class SetMain {
    static void hashSetFunc() {
        Set<Integer> st1 = new HashSet<>();
        for (int i=10; i<60; i+=10) {
            st1.add(i);
        }
        Set<Integer> st2 = new HashSet<>();
        st2.add(10);
        st2.add(20);
        st1.hashCode(); // returns the hashcode for st1

        st1.containsAll(st2); // true, since 10, 20 is present in s1.
        st2.containsAll(st1); // false, since 30, 40, 50 is not present in s2. 

        // intersection of sets
        st1.retainAll(st2); // 10, 20 since only those elements are common in both
    }
    public static void main(String[] args) {
        hashSetFunc();
    }
}

/*
HashSet working: For every element added in a hashset, a hashcode is generated.
A unique element generates a unque hashcode. The hashcode decides which box in the 
datastructure the element is gonna be stored in. If you try to add the same element
more than once, it generates the same hashcode and checks if that hashcode already has between
generated. If yes the the element won't be added.

HashSet -> Order in which elements are added is not preserved.
LinkedHashSet -> Order of elemenets is preserved.
TreeHashSet -> Automatically sorts the elements added.
*/