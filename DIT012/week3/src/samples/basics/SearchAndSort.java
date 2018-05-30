package samples.basics;


import java.util.Arrays;

import static java.lang.System.out;

/*
 * Search and Sort
 *
 */
public class SearchAndSort {

    public static void main(String[] args) {
        new SearchAndSort().program();
    }

    void program() {
        int[] a = {1, 2, 3, 4, 5, 7, 17, 19};

        out.println(binarySearch(a, 7));
        out.println(binarySearch(a, 6));

        int[] a2 = {5, 4, 2, 1, 7};
        sort(a2);
        out.println(Arrays.toString(a2));
    }

    // Searching
    int binarySearch(int[] a, int b) {
        if (a.length == 0) {
            return -1;
        }
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int middle = (low + high) / 2;
            if (b > a[middle]) {
                low = middle + 1;
            } else if (b < a[middle]) {
                high = middle - 1;
            } else { // The element has been found
                return middle;
            }
        }
        return -1;
    }


    // Bubble sort
    void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                //out.println(j + ":" + (j+1));
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                //out.println(Arrays.toString(arr));
            }
        }
    }

    // Bubble sort again (original array NOT lost)
    int[] sort2(int[] arr) {
        int[] a = new int[arr.length];         // Make a copy
        for (int i = 0; i < a.length; i++) {
            a[i] = arr[i];
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return a;   // return the copy
    }

}
