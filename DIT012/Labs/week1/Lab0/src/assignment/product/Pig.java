package assignment.product;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * The Pig game, see http://en.wikipedia.org/wiki/Pig_%28dice_game%29
 *
 * Structure:
 * - Structure should be; Input -> Process -> Output.
 * - Don't mix logic and input/output. Save values for later output.
 *
 * Process:
 * - Use the "inside-out" approach. Start with a single roll, use In -> Process -> Out
 * - Add an if and put the above in correct place.
 * - Do the "next" command
 * - Add a loop surrounding
 * - Add quit option.
 *
 */
public class Pig {

    public static void main(String[] args) {
        new Pig().program();
    }

    void program() {

        int roll = 1;         // Player commands
        int next = 2;
        int quit = 3;
        int nPlayers = 3;    // There are 3 players (hard coded).
        int winPoints = 20;  // Points to win

        String[] names = {"0lle", "Pelle", "Fia"};
        int[] points = {0, 0, 0};       // To record points for players (Olle is first/leftmost)
        int actual = 0;                 // Index for actual player
        int total = 0;                  // Running total for this round
        boolean aborted = false;        // Game aborted by player
        boolean done = false;           // Game over

        Random rand = new Random();
        Scanner scan = new Scanner(in);

        out.println("Welcome to PIG!");
        out.println("Commands are: roll = 1, next = 2, quit = 3");
        out.println(names[0] + "=" + points[0] + "," + names[1] + "=" + points[1] +
                "," + names[2] + "=" + points[2]);


        // Start writing code here


        if (aborted) {
            out.println("Aborted");
        } else {
            out.println(names[0] + "=" + points[0] + "," + names[1] + "=" + points[1] +
                    "," + names[2] + "=" + points[2]);
            out.println("Game over! Winner is player " + names[actual]);
        }
    }
}


