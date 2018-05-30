package Exam2017;


import java.util.Arrays;

public class Sorting {

    public static void main(String[] args){
        int arr[] = {10,9,8,7,8,5,1,2};
        int[] hej = sortThis(arr);

        System.out.println(Arrays.toString(hej));
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