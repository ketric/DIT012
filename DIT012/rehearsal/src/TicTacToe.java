import java.util.Random;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class TicTacToe {

    public static void main(String[] args) {
        new TicTacToe().program();
    }

    Scanner sc = new Scanner(in);

    void program() {

        // Comment out all below if testing
        String[] players = {"Olle", "Pelle"};
        char[] marks = {'X', 'O'};                       // Olle has X and pelle O
        char[] board = {'-', '-', '-', '-', '-', '-', '-', '-', '-'}; // Logical board

        out.println("Welcome to Tic Tac Toe, board is ...");
        plotBoard(board);

        Random rand = new Random();
        int actual = rand.nextInt(players.length);

        // --BOOLEANS--
        boolean done = false;


        // Start coding here
        while (!done) {
            System.out.println("Current player: " + players[actual] + ". Mark type is: " + marks[actual]);

            System.out.println(" Choose a position to put down a mark: ");
            int position = sc.nextInt();

            board[position] = marks[actual];
            if(draw(board)){
                plotBoard(board);
                System.out.print("Draw, friendship has won!");
                break;
            }
            else if (gameIsOver(board)) {
                plotBoard(board);
                System.out.print("Game over! The Winner is " + players[actual]);
                break;
            }else{
                plotBoard(board);
                actual = (actual + 1) % 2;
                done = false;
            }

        }
    }

    // -------- Method below this ----------------------------

    public static boolean gameIsOver(char[] board) {
        boolean bool;

        if (board[0] == board[3] && board[3] == board[6] && board[0] != '-')      {bool = true;}
        else if (board[2] == board[5] && board[5] == board[8] && board[2] != '-') {bool = true;}
        else if (board[1] == board[4] && board[4] == board[7] && board[1] != '-') {bool = true;}

        else if (board[0] == board[1] && board[1] == board[2] && board[0] != '-') {bool = true;}
        else if (board[3] == board[4] && board[4] == board[5] && board[3] != '-') {bool = true;}
        else if (board[6] == board[7] && board[7] == board[8] && board[6] != '-') {bool = true;}

        else if (board[0] == board[4] && board[4] == board[8] && board[0] != '-') {bool = true;}
        else if (board[2] == board[4] && board[4] == board[6] && board[2] != '-') {bool = true;}

        else                                                                      {bool = false;}
        return bool;
    }
    public static boolean draw(char[] board){
        int sumX = 0;
        int sumO = 0;
        int i;
        for (i = 0; i < 9; i++) {
            if (board[i] == 'X') {sumX = sumX + 1;}
            else                 {sumX = sumX + 0;}
        }
        for (i = 0; i < 9 ; i++) {
            if (board[i] == 'O') {sumO = sumO + 1;}
            else                 {sumO = sumO + 0;}
        }
        if ((sumO == sumX - 1 || sumX == sumO - 1) && sumX + sumO== 9) {return true;}
        else                                                           {return false;}
    }

    // ---- Nothing to do below this ----------------------

    void plotBoard(char[] board) {
        for (int i = 0; i < board.length; i++) {
            out.print(board[i] + " ");
            if ((i + 1) % 3 == 0) {
                out.println();
            }
        }
    }
}