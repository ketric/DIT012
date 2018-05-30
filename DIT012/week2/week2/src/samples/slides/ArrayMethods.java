package samples.slides;

import java.util.Arrays;

import static java.lang.System.*;

/**
 * Method with an arrays
 */
public class ArrayMethods {

    public static void main(String[] args) {
        new ArrayMethods().program();
    }

    void program() {
        int[] arr1 = {7, 1, 0, 4, -2};   // Declare and initialize
        int[] arr2 = {5, 4, 3, 2, 1};

        out.println(findMin(arr1));
        out.println(findIndex(arr1, 4));

    }

    // ---------- Returning primitive types -------------------------
    int findMin(int[] arr) {
        int minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    int findIndex(int[] arr, int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }



}


