package assignments.basics;

import java.util.Arrays;

import static java.lang.System.*;

/**
 * Exercising methods with array parameters (using only integer arrays)
 */
public class MethodsWithArrays {

    public static void main(String[] args) {
        new MethodsWithArrays().program();
    }


    void program() {
        int[] arr = {1, 4, 3, 8, 4, 9, 2, -1};
        out.println(Arrays.toString(arr));  // Use Arrays.toString() to get a nice print out
        // Testing the methods.
        // All output should print "true" (uncomment as needed)
        out.println(sumArray(arr) == 30);
        out.println(maxIndex(arr) == 5);
        out.println(countN(arr, 4) == 2);
    }

    // ------------- Write methods below this line --------------------
    int sumArray(int[] arr){
        int sum;
        sum = 0;
        for(int i = 0 ; i <= arr.length-1; i++){
            sum = sum + arr[i];
        }return sum;
    }
    int maxIndex(int[] arr){
        int biggest;
        biggest = 0;
        for(int i = 0 ; i <= arr.length-1; i++){
            if(arr[i] > arr[biggest]){
                biggest = i;
            }
        }return biggest;

    }int countN(int[] arr, int n){
        int temp;
        temp = 0;
        for(int i = 0 ; i <= arr.length-1; i++){
            if(arr[i] == n){
                temp++;
            }
        }return temp;
    }

    // sumArray, maxIndex and countN

}
