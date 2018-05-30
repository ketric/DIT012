package samples.basics;

import static java.lang.System.*;

/**
 * The if statement
 */
public class IfStatement {

    public static void main(String[] args) {
        new IfStatement().program();
    }


    void program() {
        int i = 2;
        int j = 5;
        int k = 20;

        // If statement (NOTE: "{" on same line!)
        if (i == 2) {                       // if expression true ...
            out.println("i is 2");    // .. do this. Continue after }
        }  // <----------------------------- NOTE: No ';' here

        // If-else statement
        if (j > 3) {                        // if expression true ...
            out.println("j > 3");    //... do this...
        } else {                            // ... else ...
            out.println("j <= 3");   // ... do this. Continue after }
        }

        // If-else if-else statement (elsif-ladder)
        if (j == 3) {                       // if expression true ...
            out.println("j is 3");    //... do this...
        } else if (k <= 20) {               // ... else if this expression true ...
            out.println("k <= 20");   // ... do this ...
        } else {                            // ... else ...
            out.println("j != 3 and k > 20");   // ...do this (NOTE: Only one of is executed)
        }

        int num = 5;
        // Dangling else (we always use { } to avoid this!
        if (num > 0)
            if (num < 10)
                out.println("aaa");
        else
            out.println("bbb");  // Which if does else belong to??!


    }

}
