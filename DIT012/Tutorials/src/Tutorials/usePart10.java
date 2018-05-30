package Tutorials;
import java.util.Scanner;
public class usePart10 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){

        System.out.print("Welcome to the digit extractor! Please enter 5 digits\n");
        String input = sc.nextLine();

        System.out.println("Mathematically:");
        Part10 demath = new Part10(Integer.parseInt(input));
        demath.returnInvertedOrderByMath();

        System.out.println("Using Strings/ Conceptually:");
        Part10 deconceptual = new Part10(input);
        deconceptual.returnInvertedOrderByString();

    }
}
