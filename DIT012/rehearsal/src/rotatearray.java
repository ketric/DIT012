/**
 * Created by kenny on 2017-01-06.
 */
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;


public class rotatearray {
    static Scanner sc = new Scanner(in);
    public static void main(String[] args) {
        new rotatearray().program();
    }

    void program(){

        int a [] = {1,2,3,4,5,6,7,8,9};
        int temp ;

        for(int i = 0; i < a.length -1; i++){
            temp = a[i];
            a[i] = a[i+1];
            a[i+1] = temp;
        }
        for(int p : a) {
            out.print(p);
        }


    }

}

