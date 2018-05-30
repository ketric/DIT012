package assignment.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * The application main model class
 *
 */
public class Memory {

    private final Random rand = new Random();
    private final List<Player> players;
    private final Board board;
    private Player actual = null;
    private List<Card> selected;

    public enum State {     // Game state
       // TODO
    }

    public Memory(Board board, List<Player> players) {
        this.board = board;
        this.players = players;
        actual = players.get(rand.nextInt(players.size()));
    }


    // TODO Methods here


    // -------- Getters for GUI ----------
    // TODO Need more???

    public Player getActual() {
        return actual;
    }

}

