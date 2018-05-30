package samples.basics;

import java.util.Scanner;

import static java.lang.System.*;

/**
 * Loop and a half
 */
public class LoopAndAHalf {

    public static void main(String[] args) {
        new LoopAndAHalf().program();
    }


    void program()
    {
        Scanner scan = new Scanner(in);

        boolean done = false;
        // Alt 1
        while (!done)
        {
            out.print("Input positive int > ");
            int i = scan.nextInt();
            if (i > 0) {
                done = true;  // Will exit loop next round
            }
        }
        out.print("Loop ended");

        // Alt 2
        while (true)
        {
            out.print("Input positive int > ");
            int i = scan.nextInt();
            if (i > 0) {
                break;    // Jump directly out of enclosing loop
            }
        }
        out.print("Loop ended");
    }
}
