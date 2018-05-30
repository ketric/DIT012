package assignment.product;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;


public class Pig {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        new Pig().program();
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
        int total;                  // Running total for this round
        boolean aborted = false;        // Game aborted by player
        boolean done = false;           // Game over
        Random rand = new Random();


        System.out.println("Welcome to PIG!");
        System.out.println("Commands are: roll = 1, next = 2, quit = 3");


        while(!done && !aborted){
            System.out.println("Overall score is: " + names[0] + "=" + points[0] + "," + names[1] + "=" + points[1] +
                    "," + names[2] + "=" + points[2]);
            total = 0;
            while(true) {
                System.out.println("Current Player is: " + names [player]);
                choose = sc.nextInt();

                boolean nextRound = false;

                if (choose == roll){
                    dice = rand.nextInt(6)+1;   //dice ger random tal mellan 1 och 6
                    total = total + dice;

                    if (dice == 1) {
                        System.out.println("You got " + dice + " and lost all your points, next player");
                        total = 0;
                        nextRound = true;
                    } else {
                        System.out.println("You got " + dice + " totalscore for this round is: " + total);
                    }

                    }else if (choose == next){
                    nextRound = true;
                    }else if (choose == leave){
                    aborted = true;
                    break;
                }
                if (points[player] + total >= pointsToWin){
                    done = true;
                }
                if (nextRound || done){
                    points[player] = points[player] + total;
                    if (!done) {
                        player = (player + 1) % 3;
                    }
                    break;
                }

            }
        }

        if (aborted) {
            System.out.println("Aborted");
        } else {
            System.out.println("Overall Score: " + names[0] + "=" + points[0] + "," + names[1] + "=" + points[1] +
                    "," + names[2] + "=" + points[2]);
            System.out.println("Game over! Winner is player " + names[player]);
        }
    }
}



