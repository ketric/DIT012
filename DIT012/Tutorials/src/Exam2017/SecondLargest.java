package Exam2017;

import java.util.Arrays;
public class SecondLargest {

    public static void main(String[] args){
        int arr[] = {5,4,8,1,8};
        int[] hej = sortThis(arr);
        int secBiggset = secondLargest(hej);

        System.out.println(Arrays.toString(hej));
        System.out.println(secBiggset);

    }

    public static int secondLargest(int[] arr){
        int[] sorted = sortThis(arr);
        int biggest = sorted[sorted.length-1];
        int secBiggest = biggest;
        int i = arr.length-1;
        while (secBiggest == biggest) {
            secBiggest = arr[i];
            System.out.println("choose second biggest as " + arr[i]);
            i--;
        }
        System.out.println("loop breaks. The final choice for secBiggest is: " + secBiggest);
        return secBiggest;
    }
    public static int[] sortThis(int[] arr) {
        int len = arr.length;
        for (int x = len - 1; x > 0; x --) {
            for (int y = 0; y < x; y ++) {
                if(arr[y] > arr[y+1]){
                    int tmp = arr[y];
                    arr[y] = arr[y+1];
                    arr[y+1] = tmp;
                }
            }
        }
        return arr;
    }

}
