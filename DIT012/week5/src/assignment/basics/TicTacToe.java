package assignment.basics;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 *   Array (index) based version of Tic tac toe
 */
public class TicTacToe {

    public static void main(String[] args) {
        new TicTacToe().program();
    }

    Scanner sc = new Scanner(in);

    void program() {

        // Comment out all below if testing
        String[] players = {"olle", "pelle"};
        char[] marks = {'X', 'O'};                       // Olle has X and pelle O
        char[] board = {'-', '-', '-', '-', '-', '-', '-', '-', '-'}; // Logical board
        int winner = -1;

        out.println("Welcome to Tic Tac Toe, board is ...");
        plotBoard(board);

        Random rand = new Random();
        int actual = rand.nextInt(players.length);

        while (!isFull(board)) {
            // -- Input ----------
            int index = getPlayerSelection(players[actual], marks[actual]);

            // --- Process ----------
            if (isEmpty(board, index)) {
                board[index] = marks[actual];
                if (hasWinner(board, marks[actual])) {
                    winner = actual;
                    break;
                }
            }
            // -- Output --------
            plotBoard(board);

            // Book keeping
            actual = (actual + 1) % players.length;
        }

        out.println("Game over!");
        plotBoard(board);
        if (winner >= 0) {
            out.println("Winner is " + players[winner]);
        } else {
            out.println("Draw");
        }
    }

    // Can't place any more marks if true
    boolean isFull(char[] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i] == '-') {
                return false;
            }
        }
        return true;
    }

    boolean hasWinner(char[] board, char mark) {
        return hasUpDiagonal(board, mark) || hasDownDiagonal(board, mark) ||
                hasFullRow(board, mark) || hasFullColumn(board, mark);
    }

    boolean hasFullColumn(char[] board, char mark) {
        for (int i = 0; i < 3; i++) {
            if (board[i] == mark && board[i + 3] == mark && board[i + 6] == mark) {
                return true;
            }
        }
        return false;
    }

    boolean hasUpDiagonal(char[] board, char mark) {
        return board[6] == mark && board[4] == mark && board[2] == mark;
    }

    boolean hasDownDiagonal(char[] board, char mark) {
        return board[0] == mark && board[4] == mark && board[8] == mark;
    }

    boolean hasFullRow(char[] board, char mark) {
        for (int i = 0; i < 3; i++) {
            if (board[i * 3] == mark && board[i * 3 + 1] == mark && board[i * 3 + 2] == mark) {
                return true;
            }
        }
        return false;
    }

    boolean isEmpty(char[] board, int index) {
        return board[index] == '-';
    }

    int getPlayerSelection(String name, char mark) {
        int selection;
        while (true) {
            out.println("Player is " + name + "(" + mark + ")");
            out.print("Select position to put mark > ");
            selection = sc.nextInt();
            if (0 <= selection && selection <= 8) {
                break;
            }
            out.println("Bad choice (0-8 allowed)");
        }
        return  selection;
    }

    void plotBoard(char[] board) {
        for (int i = 0; i < board.length; i++) {
            out.print(board[i] + " ");
            if ((i + 1) % 3 == 0) {
                out.println();
            }
        }
    }
}