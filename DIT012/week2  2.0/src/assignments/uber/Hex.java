package assignments.uber;

import static java.lang.Math.abs;

/**
 *  This is a single hexagon. The map is build up by these
 */
public class Hex {

    final static float COS30 = 0.866025f;
    final float x;
    final float y;
    final float outerRadius; // The corner
    final float innerRadius; // The sides
    int countryId;  // Which country this hex belongs to, NOT USED

    public Hex(float x, float y, float outerRadius) {
        this.x = x;
        this.y = y;
        this.outerRadius = outerRadius;
        this.innerRadius = COS30 * outerRadius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Hex hex = (Hex) o;
        return abs(x - hex.x) < 1 && abs(y - hex.y) < 1;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Hex{" +
                "x=" + x +
                ", y=" + y +
                ", countryId=" + countryId +
                '}';
    }
}

