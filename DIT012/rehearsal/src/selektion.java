/**
 * Created by kenny on 2017-01-01.
 */

import java.util.Scanner;
import static java.lang.System.*;

public class selektion {
    static Scanner sc = new Scanner(in);

    public static void main(String[] args) {new selektion().program();
    }

    void program(){
        out.println("input 3 integers (space between)");
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();

        if ( x > y && x > z ) {
            out.println("First number is largest.");
        }
        else if ( y > x && y > z ) {
            out.println("Second number is largest.");
        }
        else if ( z > x && z > y ) {
            out.println("Third number is largest.");
        }
        else {
            out.println("Entered numbers are not distinct.");
        }
    }


}