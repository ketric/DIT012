package assignments.uber;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static java.lang.Math.*;

/**
 *  The Hex Map
 */
public class HexMap {

    private Hex[] map;
    final Random rand = new Random();


    public Hex[] randomWalkHexes(float x, float y, float outer, int n) {
        Set<Hex> s = new HashSet<>();  // Used to avoid duplicates
        map = new Hex[n];
        map[0] = new Hex(x, y, outer);
        s.add(map[0]);
        int i = 1;
        while (i < n) {
            float[] dir = getRandomDirection(outer);
            Hex h = (Hex) s.toArray()[rand.nextInt(s.size())];
            float xn = h.x + dir[0];
            float yn = h.y + dir[1];
            h = new Hex(xn, yn, outer);
            if (isValidDistance(x, y, xn, yn, (n / 2) * outer)
                    && isInsideBorders(xn, yn)
                    && !s.contains(h)) {
                map[i] = new Hex(xn, yn, outer);
                s.add(map[i]);
                i++;
            }
        }
        return map;
    }

    private float[] getRandomDirection(float outer) {
        float inner = Hex.COS30 * outer;
        float dx = 0;
        float dy = 0;
        switch (rand.nextInt(6)) {
            case 0:
                dx = inner;
                dy = 1.5f * outer;
                break;
            case 1:
                dx = 2f * inner;
                dy = 0;
                break;
            case 2:
                dx = inner;
                dy = -1.5f * outer;
                break;
            case 3:
                dx = -inner;
                dy = -1.5f * outer;

                break;
            case 4:
                dx = -2 * inner;
                dy = 0;
                break;
            case 5:
                dx = inner;
                dy = 1.5f * outer;
                break;
        }
        return new float[]{dx, dy};
    }

    private boolean isValidDistance(float x1, float y1, float x2, float y2, float distance) {
        return sqrt(pow(x1 - x2, 2) + pow(y1 - y2, 2)) < distance;
    }

    private boolean isInsideBorders(float x, float y) {
        return 50 < x && x < 350 && 50 < y && y < 350;
    }

    // Testing
    private boolean hasDuplicates(Hex[] hexes) {
        Set<Hex> s = new HashSet<>();
        s.addAll(Arrays.asList(hexes));
        return hexes.length != s.size();
    }


}
