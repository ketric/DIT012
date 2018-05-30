package lab0;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;
/**
 * Created by kenny on 2016-11-27.
 */
public class Testing {
    public static void main(String[] args) {
        new Testing().program();
    }

    void program() {
        int i = 4;
// If expression true ...
        if (i % 2 == 0) {
            System.out.println("i is 4"); // .. do this
        } else {
            System.out.println("i is not 4");
        }
// … else continue here

        int j = 3;
        int k = 10;
        if (j == 3) { // if expression true ...
            System.out.println("j is 3"); //... do this...
        } else if (k <= 20) { // ... else if this true ...
            System.out.println("k <= 20"); // ... do this ...
        } else if (j >= 3) {
            System.out.println("J >= 3");
        } else {
            System.out.println("j != 3 and k > 20"); // ...do this
        }


        //Input 3 integer (space between) > 3 5 1
        //Biggest was 5




        int value = 0;
        while (value < 3) {
            System.out.println(value);
            value++; // Last in loop
        }
        System.out.println(value); // Value is ?


        int x;
        Scanner sc= new Scanner(in);

        // Input
        System.out.print("Enter digit: ");
        x = sc.nextInt();     // Read an int ... (when running, write input in window below + Enter)
        if((x%2)==0){
            System.out.print(+x+ " Is Even ");
        }
        // even
        else {
            System.out.print(+x+ " Is Odd ");
        }
        // odd




    }

    }