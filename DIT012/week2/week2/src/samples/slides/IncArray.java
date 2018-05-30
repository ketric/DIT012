package samples.slides;

import java.util.Arrays;

import static java.lang.System.out;

/**
 * Method with an arrays
 */
public class IncArray {

    public static void main(String[] args) {
        new IncArray().program();
    }

    void program() {
        int[] arr = {2, 5, 0, -1, 5, 6};

        incArr(arr);
        incArr(arr);
        String s = Arrays.toString(arr);
        out.println(s);  // [4, 7, 2, 1, 7, 8]

        s = Arrays.toString(incArr(incArr(arr)));
        out.println(s);  //  [6, 9, 4, 3, 9, 10]
    }


    // --------- Array as return value (original changed) ---------------------
    int[] incArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i]++;
        }
        return arr;
    }





}


