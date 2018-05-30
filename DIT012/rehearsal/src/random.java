import static java.lang.System.out;
import java.util.Arrays;
/**
 * Created by kenny on 2017-01-06.
 */
public class random {
    public static void main(String[] args) {
        new random().program();
    }

    void program() {


        int[] arr1 = {7, 1, 0, 4, -2};
        int[] arr2 = {5, 4, 3, 2, 1};
        int[] arr = {2, 5, 0, -1, 5, 6};

        int minIndex = findMin(arr1);
        out.println( arr1[minIndex] );
        out.println(findIndex(arr2, 4));

        incArr(arr);
        incArr(arr);
        String s = Arrays.toString(arr);
        out.println(s);  // [4, 7, 2, 1, 7, 8]

        s = Arrays.toString(incArr(incArr(arr)));
        out.println(s);  //  [6, 9, 4, 3, 9, 10]


    }

    // ---------- METHODS -------------------------
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
    // --------- Array as return value (original changed) ---------------------
    int[] incArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i]++;
        }
        return arr;
    }





}
