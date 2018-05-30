package exercises;

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

        while (round < maxRounds) {

            // -------- Input --------------
            while (true) {
                out.print("Select 1, 2 or 3 (for R, P or S) > ");
                human = sc.nextInt();
                if (1 <= human && human <= 3) {
                    break;
                }
            }
            computer = rand.nextInt(3) + 1;         // Get a random integer 1-3
            out.println("Computer choose: " + computer);

            // ----- Process -----------------
            // There are other ways to compare (but it shouldn't be too long)
            if (human % 3 == (computer + 1) % 3) {  // Computer win (human is one step ahead)
                result = -1;
                total--;
            } else if (human % 3 == (computer + 2) % 3) {  // Human win (human is 2 steps ahead)
                result = 1;
                total++;
            } else {
                result = 0;   // Draw
            }

            // ---------- Output --------------

            if (result == 0) {
                out.println("A draw");
            } else if (result > 0) {
                out.println("You won");
            } else {
                out.println("Computer won");
            }
            out.println("Result " + total);  // Result

            round++;                        // Normally last ("the book keeping")
        }   // <----------------------        End Game loop

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