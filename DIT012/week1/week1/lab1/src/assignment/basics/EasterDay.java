package assignment.basics;

import java.util.Scanner;


public class EasterDay {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new EasterDay().program();
    }

    void program() {

        int year;
        boolean done = false;

        while (!done) {
            System.out.println("Enter in a year to find out the day and month of Easter Sunday.");
            year = sc.nextInt();

            if ((year >= 1900) && (year <= 2099)) {


                int a = year % 19;
                int b = year % 4;
                int c = year % 7;
                int s = 19 * a + 24;
                int d = s % 30;
                int t = 2 * b + 4 * c + 6 * d + 5;
                int e = t % 7;
                int x = (22 + d + e);

                if (x <= 31) {
                    System.out.println("Easter in " + year + " is March " + x);
                } else {

                    int y = d + e - 9;

                    if (y == 26) {
                        System.out.println("Easter in " + year + " is April " + y);
                    } else if (y == 25 && a == 16 && d == 28) {
                        System.out.println("Easter in " + year + " is April " + y);
                    } else {
                        System.out.println("Easter in " + year + " is April " + y);
                    }
                }
                done = true;
            } else {
                System.out.println("Enter a valid year between 1900-2099");
                done = false;
            }


        }
    }
}