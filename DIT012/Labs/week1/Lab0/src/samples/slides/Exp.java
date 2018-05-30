package samples.slides;

import java.util.Scanner;

import static java.lang.System.*;

/**
 * Created by hajo on 4/11/16.
 */
public class Exp {


    public static void main(String[] args) {
        new Exp().program();
    }

    // exp(x) = 1 + x/1! + x²/2! + x³/3! + ...
    private void program() {

        Scanner sc = new Scanner(in);
        out.print("Input x > ");
        double x = sc.nextDouble();

        int n = 0;
        int denom = 1;
        double nom = x;
        double exp = 1;
        while (n < 10) {
            denom = denom * (n + 1);
            out.println( n + " Denom: " + denom);
            nom = nom * x;
            out.println( n + " Nom: "+ nom);
            exp = exp + nom / denom;
            n++;
        }
        out.print("Exp(x) = " + exp);

    }

}
