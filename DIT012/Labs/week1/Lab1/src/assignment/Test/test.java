
package assignment.Test;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class test {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        new test().program();
    }

    void program() {
        int choose;
        int dice;
        int roll = 1;         // Player commands
        int next = 2;
        int leave = 3;
        int pointsToWin = 20;  // Points to win

        String[] names = {"0lle", "Pelle", "Fia"};  // Olle = 0, Pelle = 1, Fia = 2
        int[] points = {0, 0, 0};       // To record points for players (Olle is first/leftmost)
        int player = 0;                 // Index for actual player
        int total;                      // Running total for this round
        boolean aborted = false;        // Game aborted by player
        boolean done = false;           // Game over
        Random rand = new Random();


        System.out.println("Welcome to PIG!");
        System.out.println("Commands are: roll = 1, next = 2, quit = 3");




        if (aborted) {
            System.out.println("Aborted");
        } else {
            System.out.println("Overall Score: " + names[0] + "=" + points[0] + "," + names[1] + "=" + points[1] +
                    "," + names[2] + "=" + points[2]);
            System.out.println("Game over! Winner is player " + names[player]);
        }
    }
}


