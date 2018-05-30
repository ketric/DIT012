import static java.lang.System.out;

/**
 * Created by kenny on 2017-01-08.
 */
public class halfsquare {

    public static void main(String[] args) {
        new halfsquare().program();
    }


    void program() {


        // Plot a half square. May only use for-loops, out.print("X") and out.println()
        for (int i = 10; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                out.print("X");
            }
            out.println();
        }


    }
}
