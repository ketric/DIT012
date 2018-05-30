package samples.slides;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 *  Using inside out strategy to pick one digit at the time from an integer.
 */
public class MaskDigits {

    public static void main(String[] args) {
        new MaskDigits().program();
    }

    void program() {
        Scanner sc = new Scanner(in);
        out.print("Input integer (max 2x10⁹) > ");
        int n = sc.nextInt();
        while (n > 0) {
            out.println(n % 10);
            n = n / 10;
        }
    }

}
