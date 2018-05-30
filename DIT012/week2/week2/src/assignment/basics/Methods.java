package assignment.basics;

import java.util.Scanner;
import static java.lang.System.*;

/*
 * Exercising methods with primitive types
 */
public class Methods {

    public static void main(String[] args) {
        new Methods().program();
    }
    static Scanner sc = new Scanner(System.in);

    void program() {
        // Testing the methods.
        // All output should print "true" (comment/uncomment as needed)
        out.println(sign(-100) == -1);
        out.println(sign(0) == 0);
        out.println(sign(14) == 1);

        out.println(fac(0)== 1);
        out.println(fac(1)== 1);
        out.println(fac(2)== 2);
        out.println(fac(3)== 6);

        out.println(gcd(24, 8) == 8);
        out.println(gcd(7, 2) == 1);

    }

    // ------------- Write your methods below this line --------------------
    public static int sign(int x) {
        int a = 1;
        int b = 0;
        int c = -1;

        if (x > 1)
        {return a;}
        else if (x == 0)
        {return b;}
        else {return c;}
    }
    public static int fac(int y) {

        if (y <= 1)
            return 1;
        else
            return y * fac(y-1);
    }
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }

}


