package samples.basics;

import static java.lang.System.*;
/**
 * The switch statement
 */
public class SwitchStatement {

    public static void main(String[] args) {
        new SwitchStatement().program();
    }


    void program() {
        int i = 5;
        int k = 20;

        // Switch statement
        switch (k) {                                    // Compare k with ...
            case 10:                                    // ... 10. If equal ...
                out.println("k is exactly 10");  // .. do this. Else compare with ...
                break;
            case 20:                                    // ...20. And so on.
                out.println("k is exactly 20");
                break;                                  // Must have "break" at all "case". Else following case executed
            case 30:
                out.println("k is exactly 30");
                break;
            /*case i :                            // NO! Constant expression
                 out.println("k equal to i");
                break;*/
            default:                                    // If no match do this
                out.println("k is ? (no match)");
        }  // <-----------------------------------------  NOTE: No ';' here


    }

}
