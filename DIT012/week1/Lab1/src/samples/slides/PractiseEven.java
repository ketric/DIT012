package samples.slides;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

;

/**
 * Practice even numbers (for very small children)
 */
public class PractiseEven {

    public static void main(String[] args) {
        new PractiseEven().program();
    }


    void program() {
        Scanner sc = new Scanner(in);
        int correct = 0;
        int total = 0;

        while (true) {              // Using loop-and-a-half
            out.print("Input an even integer (0 to quit) > ");
            int i = sc.nextInt();
            if (i == 0) {
                break;
            } else if (i % 2 == 0) {
                out.println("Ok! That was even.");
                correct++;
            } else {
                out.println("That wasn't an even number.");
            }
            total++;
        }
        out.print("Yot got " + correct + " correct out of " + total);
    }
}
