package samples.slides;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.*;

/**
 * The most boring game ever invented. Guess a number n, 1 <= n <= 100.
 */
public class NumberGuess {

    public static void main(String[] args) {
        new NumberGuess().program();
    }

    void program() {

        int guess;
        boolean done = false;
        int nGuesses = 0;
        int theNumber = 87;  // "Hard coded", same at every execution (just for now)

        Scanner sc = new Scanner(in);
        Random rand = new Random();
        out.println("Welcome to Number Guess");

        theNumber = rand.nextInt(100) + 1;
        while (!done) {
            out.print("Guess a number [1-100] > ");
            guess = sc.nextInt();
            nGuesses++;

            if (guess == theNumber) {
                done = true;
            } else if (guess < theNumber) {
                out.println("To small ");
            } else {
                out.println("To big ");
            }
        }
        out.println("Correct! Number of guesses needed " + nGuesses);
    }
}
