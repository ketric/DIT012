package samples.slides;

import java.util.Arrays;

import static java.lang.System.out;

/**
 * Move all elements one index to left
 */
public class MoveOneLeft {

    public static void main(String[] args) {
        new MoveOneLeft().program();
    }

    void program() {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};   // Declare and initialize
        int first = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i-1] = arr[i];
        }
        arr[arr.length-1] = first;
        out.println(Arrays.toString(arr));
    }
}
