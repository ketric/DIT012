package lab0.product;

import static java.lang.System.out;

/*
 * Calculating a persons body mass index, BMI
 * See https://en.wikipedia.org/wiki/Body_mass_index
 *
 * bmi = weight / height²     (kg/m²)
 */
import java.util.Scanner;
public class BMI {

    static Scanner sc = new Scanner (System.in);
    public static void main(String[] args) {
        new BMI().program();
    }

    void program() {

        double weight;
        double height;

        System.out.print("enter your weight in kilograms: ");
        weight = sc.nextDouble();

        System.out.print("enter your height in meters: ");
        height = sc.nextDouble();

        double bmi = weight/(height*height);
        System.out.println("BMI = " + bmi);
    }

}
