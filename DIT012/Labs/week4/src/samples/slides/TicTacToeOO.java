package samples.slides;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 *  TicTacToe using a class for the board.
 *
 *
 */
public class TicTacToeOO {

    public static void main(String[] args) {
        new TicTacToeOO().program();
    }

    final Random rand = new Random();

    void program() {
        // NOTE: Must create the objects (the world)
        Player p1 = new Player("olle", 'X');
        Player p2 = new Player("pelle", 'O');
        Player winner = null;

        TicTacToeBoard board = new TicTacToeBoard();

        out.println("Welcome to Tic Tac Toe, board is ...");
        plotBoard(board);
        Player actual = p1;   // Bad, jus for now

        while (!board.isFull()) {
            // -- Input ----------
            int index = getPlayerSelection(actual);

            // --- Process ----------
            if (board.isEmpty(index)) {
                board.positions[index] = actual.mark;
                if (board.hasWinner(actual.mark)) {
                    winner = actual;
                    break;
                }
            }
            // -- Output --------
            plotBoard(board);

            // Book keeping
            if (actual == p1) {
                actual = p2;
            } else {
                actual = p1;
            }
        }

        out.println("Game over!");
        plotBoard(board);
        if (winner == p2) {
            out.println("Winner is " + p2.name);
        } else if (winner == p1) {
            out.println("Winner is " + p1.name);
        } else {
            out.println("Draw");
        }
    }

    // --- Input/output is outside class
    int getPlayerSelection(Player player) {
        out.println("Player is " + player.name + "(" + player.mark + ")");
        Scanner sc = new Scanner(in);
        out.print("Select position to put mark > ");
        return sc.nextInt();
    }

    void plotBoard(TicTacToeBoard b) {
        for (int i = 0; i < b.positions.length; i++) {
            out.print(b.positions[i] + " ");
            if ((i + 1) % 3 == 0) {
                out.println();
            }
        }
    }

    // ------- Classes ----------------

    class Player {
        final String name;
        final char mark;

        public Player(String name, char mark) {
            this.name = name;
            this.mark = mark;
        }
    }

    class TicTacToeBoard {

        final char[] positions = {'-', '-', '-', '-', '-', '-', '-', '-', '-'}; // Logical positions

        // Instance methods below
        // Can't place any more marks if true
        boolean isFull() {
            for (int i = 0; i < positions.length; i++) {
                if (positions[i] == '-') {
                    return false;
                }
            }
            return true;
        }

        boolean hasWinner(char mark) {
            return hasUpDiagonal(mark) || hasDownDiagonal(mark)
                    || hasFullRow(mark) || hasFullColumn(mark);
        }

        boolean hasFullColumn(char mark) {
            for (int i = 0; i < 3; i++) {
                if (positions[i] == mark && positions[i + 3] == mark
                        && positions[i + 6] == mark) {
                    return true;
                }
            }
            return false;
        }

        boolean hasUpDiagonal(char mark) {
            return positions[6] == mark && positions[4] == mark
                    && positions[2] == mark;
        }

        boolean hasDownDiagonal(char mark) {
            return positions[0] == mark && positions[4] == mark
                    && positions[8] == mark;
        }

        boolean hasFullRow(char mark) {
            for (int i = 0; i < 3; i++) {
                if (positions[i * 3] == mark && positions[i * 3 + 1] == mark
                        && positions[i * 3 + 2] == mark) {
                    return true;
                }
            }
            return false;
        }

        // Is position "index" empty
        boolean isEmpty(int index) {
            return positions[index] == '-';
        }

    }
}