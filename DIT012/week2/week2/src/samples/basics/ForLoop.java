package samples.basics;

import java.util.Arrays;

import static java.lang.System.out;

/**
 * Travers an array (access all variables, left to right or right to left)
 */
public class ForLoop {

    public static void main(String[] args) {
        new ForLoop().program();
    }

    void program() {

        for (int i = 0; i < 10; i++) {  // Basic for loop, going up
            out.print(i);
        }
        for (int i = 9; i >= 0; i--) {  // Basic for loop, going down
            out.print(i);
        }
        for (int i = 0; i < 10; i = i + 2) {  // Basic for loop, step
            out.print(i);
        }
    }
}
