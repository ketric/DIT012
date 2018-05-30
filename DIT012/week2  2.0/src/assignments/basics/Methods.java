package assignments.basics;

import static java.lang.System.*;

/*
 * Exercising methods with primitive types
 */
public class Methods {

    public static void main(String[] args) {
        new Methods().program();
    }


    void program() {
        // Testing the methods.
        // All output should print "true" (comment/uncomment as needed)
        out.println(sign(-100) == -1);
        out.println(sign(0) == 0);
        out.println(sign(14) == 1);

        out.println(factorial(0)== 1);
        out.println(factorial(1)== 1);
        out.println(factorial(2)== 2);
        out.println(factorial(3)== 6);

        out.println(gcd(24, 8) == 8);
        out.println(gcd(7, 2) == 1);
        out.println(gcd(2322, 654) == 6);
    }

    // ------------- Write your methods below this line --------------------

    //method a)
    int sign(int n) {
        if (n > 0) {
            return 1;

        } else if (n == 0) {
            return 0;

        } else {
            return (-1);
        }
    }

    int factorial(int n) {
        int temp;
        temp = 1;
        while (n > 1) {
            temp = temp * n;
            n--;

        }
        return temp;
    }

    int gcd(int n, int m) {
        int temp;
        while (n % m != 0) {
            temp = n % m;
            n = m;
            m = temp;
        }
        return m;
    }


    // sign, factorial and gcd

}
