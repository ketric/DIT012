package samples.slides;

import java.util.Scanner;

import static java.lang.System.*;;

/*
 * Calculating simple interest
 */
public class SimpleInterest {


    public static void main(String[] args) {
        new SimpleInterest().program();
    }

    void program() {
        Scanner sc = new Scanner(in);

        // --- Input -----
        out.print("Please enter an amount > ");
        double amount = sc.nextDouble();
        out.print("Enter time in years > ");
        int time = sc.nextInt();
        out.print("Enter rate annually > ");
        double rate = sc.nextDouble();

        // --- Process ------
        // *Simple* interest
        double interest = (amount * rate * time) / 100;

        // --- Output ----------
        out.println("Simple interest is : " + interest);
    }

}
