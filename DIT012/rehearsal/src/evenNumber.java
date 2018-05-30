/**
 * Created by kenny on 2017-01-01.
 */

import java.util.Scanner;

import static java.lang.System.*;

public class evenNumber {
    static Scanner sc = new Scanner(in);

    public static void main(String[] args) {
        new evenNumber().program();
    }

    int x;
    int attempts;
    int correct = 0;
    int wrong = 0;

    void program() {

        while (attempts < 3){
            attempts++;

            out.println("Type an integer");
            x = sc.nextInt();

            if ( x % 2 == 0){
                out.println("Even integer");
                correct++;
            } else{
                out.println("Odd Integer");
                wrong++;
            }
        }
        out.println("amount of even Integers: " + correct);
        out.println("amount of odd integers: " + wrong);

    }
}