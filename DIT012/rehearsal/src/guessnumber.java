/**
 * Created by kenny on 2017-01-06.
 */
import java.util.Random;
import java.util.Scanner;
import static java.lang.System.*;

public class guessnumber {
    static Scanner sc = new Scanner(in);
    Random rand = new Random();
    public static void main(String[] args) {
        new guessnumber().program();

    }

    void program(){
        boolean win = false;
        int tries = 0;
        int guess;
        int numofGuesses = rand.nextInt(100);

        while (win == false){
            out.println("Guess a number between 1-100");
            guess = sc.nextInt();
            tries++;

            if (guess == numofGuesses) {
                out.println("Correct!");
                out.println ("Tries to get correct answer: "+ tries);
                win = true;
            }
            else if (guess < numofGuesses){
                out.println("your guess is too low");
            }
            else if (guess > numofGuesses){
                out.println("your guess is too high");
            }

        }


    }
}
