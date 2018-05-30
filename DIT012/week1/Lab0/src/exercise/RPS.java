package exercise;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.*;    // To be able to use the in and out

/**
 * The Rock, Paper, Scissors game
 * See https://en.wikipedia.org/wiki/Rock-paper-scissors
 *
 * Exercising: Inside-out programming
 */
public class RPS {

    public static void main(String[] args) {
        new RPS().program();
    }


    /*  NOTE:

         -----------  Beats -------------
         |                              |
         V                              |
        Rock (1) --> Scissors (2) --> Paper (3)


     */
    void program() {

        int maxRounds = 5;
        int human;          // Outcome for player
        int computer;       // Outcome for computer
        int result;         // Result for this round
        int round = 0;      // Number of rounds
        int total = 0;      // Final result after all rounds

        Random rand = new Random();
        Scanner sc = new Scanner(in);
        out.println("Welcome to Rock, Paper and Scissors");

        // We'll start writing code here

        out.println("Game over! ");
        if (total == 0) {
            out.println("Draw");
        } else if (total > 0) {
            out.println("Human won.");
        } else {
            out.println("Computer won.");
        }
    }
}
