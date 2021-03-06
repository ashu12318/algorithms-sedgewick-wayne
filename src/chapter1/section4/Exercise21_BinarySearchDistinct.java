package chapter1.section4;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rene on 18/10/16.
 */
public class Exercise21_BinarySearchDistinct {

    public static void main(String[] args) {

        int[] array = {99, 8, 8, 1, 2, 4, 1, -3};

        Exercise21_BinarySearchDistinct exercise21_binarySearchDistinct = new Exercise21_BinarySearchDistinct(array);

        boolean containsElement1 = exercise21_binarySearchDistinct.contains(4);
        boolean containsElement2 = exercise21_binarySearchDistinct.contains(-3);
        boolean containsElement3 = exercise21_binarySearchDistinct.contains(99);
        boolean containsElement4 = exercise21_binarySearchDistinct.contains(0);

        StdOut.println("Index of element: " + containsElement1 + " Expected: true");
        StdOut.println("Index of element: " + containsElement2 + " Expected: true");
        StdOut.println("Index of element: " + containsElement3 + " Expected: true");
        StdOut.println("Index of element: " + containsElement4 + " Expected: false");
    }

    private int[] a;

    public Exercise21_BinarySearchDistinct(int[] keys) {

        Map<Integer, Boolean> elementsMap = new HashMap<>();

        //Fill map
        for(int i=0; i < keys.length; i++) {
            elementsMap.put(keys[i], true);
        }

        a = new int[elementsMap.size()];
        int arrayIndex = 0;

        for(int key : elementsMap.keySet()) {
            a[arrayIndex] = key;
            arrayIndex++;
        }

        Arrays.sort(a);
    }

    public boolean contains(int key) {
        return rank(key) != -1;
    }

    private int rank(int key) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            if(key < a[middle]){
                high = middle - 1;
            } else if (key > a[middle]){
                low = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;
    }

}
