/**
 * Created by kenny on 2017-01-06.
 */

import java.util.Random;
import java.util.Scanner;
import static java.lang.System.*;

public class RPS {
    static Scanner sc = new Scanner(in);
    Random rand = new Random();
    public static void main(String[] args) {
        new RPS().program();
    }

    int computer;
    int player;
    void program(){

        while (true) {
            out.println("Welcome to Rock | Paper | Scissors");
            out.println("Type 1, 2 or 3 for | R | P | S |");
            player = sc.nextInt();

            computer = rand.nextInt(3) + 1;
            out.println("Computer chooses: " + computer);

            if (player == computer) {
                out.println("Draw");

            }
            else if ( player == 1 && computer == 2) {
                out.println("Computer wins \n");
            }
            else if (player == 1 && computer == 3) {
                out.println("Player Wins \n");
            }
            else if (player == 2 && computer == 3) {
                out.println("Computer Wins \n");
            }
            else if (player == 2 && computer == 1) {
                out.println("Player Wins \n");
            }
            else if (player == 3 && computer == 2) {
                out.println("Player wins \n");
            }
            else if (player == 3 && computer == 1) {
                out.println("Computer wins \n");
            }

            }
        }
    }


