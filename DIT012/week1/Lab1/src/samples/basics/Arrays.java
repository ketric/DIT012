package samples.basics;

import java.util.Scanner;

import static java.lang.System.*;

/**
 * Basic use of Arrays. Using indexes
 */
public class Arrays {

    public static void main(String[] args) {
        new Arrays().program();
    }

    void program() {
        int i = 1;           // Declare and initialize
        int[] numbers = {1, 2, 3};

        numbers[0] = 4; // Index 0,1,2
        numbers[1] = numbers[2];

        out.println(numbers[2]);

        numbers[0]++;
        out.println(numbers[0]);

        out.println(numbers[i]);
        out.println(numbers[i - 1]);  // After i
        out.println(numbers[i + 1]);  // Before i

        out.println(numbers[numbers[1]-1]);   // Oops! Possible but avoid

    }
}
