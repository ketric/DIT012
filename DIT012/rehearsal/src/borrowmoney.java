/**
 * Created by kenny on 2017-01-01.
 */

import java.util.Scanner;
import static java.lang.System.*;

public class borrowmoney {
    static Scanner sc = new Scanner(in);
    public static void main(String[] args) { new borrowmoney().program();

    }
    void program()
    {
        out.println("Please enter an amount: ");
        int amount = sc.nextInt();

        out.println("Enter Time in Years: ");
        int years = sc.nextInt();

        out.println("Enter rate anually (%): (write in decimal form)");
        double rate = sc.nextDouble();

        double interest = (amount * (1 + (rate * years))) - amount;

        out.println("Simple interest is: " + interest);


    }
}
