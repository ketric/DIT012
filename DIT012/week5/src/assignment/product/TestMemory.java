package assignment.product;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

/**
 * Tests for memory
 */
public class TestMemory {

    public static void main(String[] args) {
        new TestMemory().test();
    }

    // Simple board to run test on.
    String[] cardNames = {
            "A", "D", "C", "B",
            "F", "A", "G", "F",
            "H", "B", "H", "E",
            "E", "C", "G", "D"
    };
    List<Card> cs;
    Board b;

    private void init() {
        cs = new ArrayList<>();
        for (int i = 0; i < cardNames.length; i++) {
            cs.add(new Card(cardNames[i]));
        }
        b = new Board(cs);
    }

    private void test() {
        testHasNonMatchingPair();
        testHasMatchingPair();
    }

    private void testHasNonMatchingPair() {
       // TODO
    }

    private void testHasMatchingPair() {
       // TODO
    }

    // TODO possibly more tests


}
