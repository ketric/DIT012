/**
 * Created by kenny on 2017-01-01.
 */
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class rehearsal {

    static Scanner sc = new Scanner(in);
    public static void main(String[] args) {
        new rehearsal().program();
    }

    String fname, lname;

    double weight, height;

    int fahrenheit;

    double celcius;

    void program()
    {
        /*
        //1
        out.print ("hej ");
        out.print ("hello ");
        out.println ("tjena ");

        out.println ("hej");
        out.println ("hello");
        out.println ("tjena");


        // Make program print "Hello" + you name here!
        // Example "Hello Sven"
        out.println( "input your firstname: " );
        fname = sc.nextLine();

        out.println ("input your lastname: ");
        lname = sc.nextLine();
        System.out.println ("Hello " + fname +" " + lname + "!");


        //Calculate BMI
        out.println ("enter your weight in kilograms: ");
        weight = sc.nextDouble();

        out.println ("enter your height in meters: (Example: 1,75)");
        height = sc.nextDouble();

        double bmi = weight / (height*height);
        out.println ("Your BMI is " + bmi);

        //Convert Fahrenheit to Celsius

        out.println ("Fahrenheit: ");
        fahrenheit = sc.nextInt();

        celcius = (fahrenheit - 32) * 5 / 9;

        out.println ( fahrenheit + " fahrenheit in celcius is: " + celcius);

        int value = 0;
        while (value < 5) {
            out.println(value);
            value++; // Last in loop
        }
        out.println(value); // Value is ?


        int[] points = { 1, 2, 3, 4, 5 };

        out.println(points);
        String s = Arrays.toString(points);
        out.println(s);

        out.print("Input integer (max 2x10⁹) > ");
        int n = sc.nextInt();
        while (n > 0) {
            out.println(n % 10);
            n = n / 10;
        }


        int[][] m = { { 1,2,3,}, { 4,5,6,}, { 7,8,9,} };
        //[rad][kolumn]
        m[0][2] = 99; // {{ 1,2,99,},{ 4,5,6,},{ 7,8,9,}}
        m[2][1] = m[0][2]; // {{ 1,2,99,},{ 4,5,6,},{ 7,99,9,}}
        //Traversering
        for(int row = 0 ; row < m.length ; row++){
            for( int col = 0 ; col < m[row].length; col++){
                out.print( m[row][col]);
            }
            out.println();
        }
        */
        int a = 1;
        int b = 2;
        out.println(addSquares(a, b));



    }
    int addSquares(int a, int b) {
        return square(a) + square(b);
    }
    int square(int x) {
        return x * x;
    }
}
