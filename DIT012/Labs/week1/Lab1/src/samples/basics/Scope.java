package samples.basics;

import static java.lang.System.out;

/**
 * Scope for variables
 */
public class Scope {

    public static void main(String[] args) {
        new Scope().program();
    }


    private void program() {

        {

            int i = 0;
            int j = 4;
            out.println(i == 0 && j == 4);
        }
        // out.println( i + ":"  + j);    // No not in scope

        {

            int i = 2;
            out.println(i == 2);
            // out.println( j );    // No j not in scope

        }

        {

            int i = 3;
            int j = 6;
            out.println(i == 3 && j == 6);

            {
                // int i = 2;    // Already defined in scope
                int k = 9;
                out.println(i == 3 && j == 6 && k == 9);

            }
            // out.println( k ); // No not in scope

        }


    }

}
