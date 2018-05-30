package assignments.product;

import java.util.Random;
import java.util.Scanner;

import static java.lang.System.*;
import static java.lang.Math.*;

/*
 * Simplified text based (i.e. non graphical) version of the Dice Wars game
 * For a full graphical version, see http://www.gamedesign.jp/flash/dice/dice.html (or other)
 *
 * Some rule simplification
 * - No limit of dices in a country
 * - Distribution of earned dices may be "somewhat" random.
 * - Game over when a player lost all countries
 * - Player with most countries wins (or dices? or a combination? You find a measure)
 *
 *  Plan and Process: Compare Tic Tac Toe from exercises
 */
public class DiceWars {

    public static void main(String[] args) {
        new DiceWars().program();
    }

    Scanner sc = new Scanner(in);
    Random rand = new Random();

    void program() {


        // The players of the game (mostly referenced by index)
        String[] players = {"pelle", "fia", "lisa"};
        // A map with nine countries, named by their index (0-8)
        // Leading 1:s because can't have leading 0 (just skip the ones when processing)
        // 114 says: The country 0 has border to countries 1 and 4.
        // Number of countries is a multiple of players, they all get the same numbers of countries
        int[] map = {114, 1024, 115, 146, 101357, 12487, 137, 14568, 157};
        // This is the owners of the countries. Country 0 is owned by player pelle (players[0])
        int[] owners = {0, 1, 2, 1, 2, 0, 0, 1, 2};
        // This is the number of dices for a country. Country 1 has 3 dices.
        int[] dices = {2, 3, 2, 3, 1, 3, 1, 1, 3};
        boolean isPlaying = true;


        // Test area

        //out.println(countOwnedBy(0, owners));


        out.println("Welcome to Dice Wars \"lite!\"");
        out.println();
        int attacker = rand.nextInt(players.length);
        String loser = "a";
        // In ---------------------


        // ****** Write out code here  ******
        // You should use functional decomposition i.e. find a top level
        // method. Then, which methods should be used by the top level method?
        // Then, which methods should be used by methods used by top level etc.
        // Draw a sketch on paper!


        while (isPlaying) {                             // plays the game while true, becomes false when game is over
            plotMap(map, owners, dices, players);
            while (playerAction(players[attacker])) {   // if true, turn starts. when false, turn ends
                int from = getCountry(players[attacker], "from");       // Value: 0, 1 or 2
                int to = getCountry(players[attacker], "to");           // Value: 0, 1 or 2
                if (checkOwnerAndDices(from, to, attacker, owners, dices) && hasBorder(from, to, map)) {    //if move is allowed
                    int attackerResult = diceToss(from, dices);
                    int defenderResult = diceToss(to, dices);
                    out.println(players[attacker] + " rolled " + attackerResult + ", " + players[owners[to]] + " rolled " + defenderResult);
                    if (attackerResult > defenderResult) {
                        doAttack(from, to, owners, dices);
                        for(int i = 0; i < owners.length; i++){
                            for( int j = 0; j < players.length; j++){
                                if(countOwnedBy(j, owners) == 0){
                                    isPlaying = false;
                                    loser = players[j];
                                    break;
                                }
                            }
                        }
                    }
                    dices[from] = 1;
                    plotMap(map, owners, dices, players);

                }


            }
            int nCountries = countOwnedBy(attacker, owners);
            distributeDices(attacker, nCountries, dices, owners);
            attacker = (attacker + 1) % players.length;

        }
        out.println("Game over");
        out.println("Loser is " + loser);
    }


    // ---- Write your methods below this -----------------------------------
    boolean playerAction(String name) {
        boolean temp = true;
        boolean stop = true;
        out.print("(" + name + ")" + "Action (a/n) > ");
        while (stop) {
            String action = sc.nextLine();
            switch (action) {
                case "a":
                    temp = true;
                    stop = false;
                    break;
                case "n":
                    temp = false;
                    stop = false;
                    break;
                default:
                    continue;
            }
        }
        return temp;

    }


    int getCountry(String name, String msg) {
        out.print("(" + name + ") Select " + msg + " > ");
        return sc.nextInt();
    }

    // Start with this one! It will say "yes" if two countries have a border
    boolean hasBorder(int from, int to, int[] map) {
        int temp;
        temp = map[from];
        while (temp > 1) {
            if (temp % 10 == to) {
                return true;
            } else {
                temp = temp / 10;
            }
        }
        return false;
    }

    void doAttack(int from, int to, int[] owners, int[] dices) {
        owners[to] = owners[from];
        dices[to] = dices[from] - 1;
    }

    int diceToss(int country, int[] dices) {
        int diceSum = 0;
        for (int i = 0; i < dices[country]; i++) {
            diceSum = diceSum + rand.nextInt(6) + 1;
            //out.println(diceSum);
        }
        return diceSum;


    }

    boolean checkOwnerAndDices(int from, int to, int attacker, int[] owners, int[] dices) {
        if (owners[from] == attacker && owners[to] != attacker && dices[from] > 1) {
            return true;
        } else {
            return false;
        }
    }


    int countOwnedBy(int attacker, int[] owners) {
        int temp = 0;
        for (int x = 0; x < owners.length; x++) {
            if (owners[x] == attacker) {
                temp++;
            }
        }
        return temp;
    }

    void distributeDices(int attacker, int nCountries, int[] dices, int[] owners) {
        int availableDices = nCountries;
        while (availableDices > 0) {
            int land = rand.nextInt(owners.length);
            if (attacker == owners[land]) {
                dices[land]++;
                availableDices--;
            }
        }
    }


    // ----  Nothing to do for you below this line  -----

    // Plot map (as a graph) using ASCII chars
    void plotMap(int[] map, int[] owners, int[] dices, String[] players) {
        int n = (int) sqrt(map.length);
        for (int row = 0; row < 2 * n - 1; row += 2) {
            // One row with horizontal connections
            for (int col = 0; col < n; col++) {
                int i = 3 * row / 2 + col;
                out.print(players[owners[i]] + ":" + dices[i]);
                if (hasBorder(i, i + 1, map)) {
                    out.print("--");
                } else {
                    out.print("  ");
                }
            }
            out.println();
            // Another row with vertical connections
            for (int col = 0; col < n; col++) {
                int i = 3 * row / 2 + col;
                if (hasBorder(i, i + n, map)
                        && hasBorder(i, i + n - 1, map)
                        && hasBorder(i, i + n + 1, map)) {
                    out.print("  / | \\ ");
                } else if (hasBorder(i, i + n, map)
                        && hasBorder(i, i + n - 1, map)) {
                    out.print("/  |     ");
                } else if (hasBorder(i, i + n, map)
                        && hasBorder(i, i + n + 1, map)) {
                    out.print("   | \\  ");
                } else if (hasBorder(i, i + n - 1, map)) {
                    out.print(" /      ");
                } else if (hasBorder(i, i + n + 1, map)) {
                    out.print("     \\  ");
                } else if (hasBorder(i, i + n, map)) {
                    out.print("   |    ");
                } else {
                    out.print("         ");
                }
            }
            out.println();
        }
        out.println("-----------------------------------------");
    }
}
