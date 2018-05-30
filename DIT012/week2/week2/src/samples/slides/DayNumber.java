package samples.slides;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
     This is an example of functional decomposition

 */
public class DayNumber {

    public static void main(String[] arg) {
        new DayNumber().program();
    }

    void program() {
        // Testing
        /*out.println(isLeapYear(2016));
        out.println(!isLeapYear(2015));
        out.println(getDaysInMonth(4) == 31);
        out.println(getDaysInMonth2(2) == 28);
        out.println(getDaysInMonth3(2, true) == 29);
        out.println(getDaysInMonth3(2, true) == 29);
        out.println(sumMonthTo(3) == 90);
        */
        // -- In ----------------
        Scanner sc = new Scanner(in);

        out.print("Input a year >");
        int year = sc.nextInt();
        out.print("Input a month number >");
        int month = sc.nextInt();
        out.print("Input a day number >");
        int day = sc.nextInt();

        // --- Process ---------
        int numberOfDay = getNumberOfDay(year, month, day); // NOTE: 1 <= month <= 12

        // ---- Out ----
        printResult(year, month, day, numberOfDay);

    }

    int getNumberOfDay(int year, int month, int day) {
        // Sum all days to moth before and add day number
        int n = sumMonthTo(month - 1) + day;
        if (month > 2 && isLeapYear(year)) {
            n++;
        }
        return n;
    }

    int sumMonthTo(int monthNumber) {
        int sum = 0;
        for (int i = 0; i < monthNumber; i++) {
            sum = sum + getDaysInMonth(i);
        }
        return sum;
    }

    int getDaysInMonth(int monthNumber) {
        // NOTE:  0 <= monthNumber <= 11
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return daysInMonth[monthNumber];
    }

    // Alt
    int getDaysInMonth2(int monthNumber) {
        boolean has31Days = monthNumber == 0 || monthNumber == 2 || monthNumber == 4 ||
                monthNumber == 6 || monthNumber == 7 || monthNumber == 9 || monthNumber == 11;
        if (monthNumber == 2) {
            return 28;
        } else if (has31Days) {
            return 31;
        } else {
            return 30;
        }
    }

    // Alt
    int getDaysInMonth3(int monthNumber, boolean isLeapYear) {
        if (monthNumber == 2) {
            if (isLeapYear) {
                return 29;
            } else {
                return 28;
            }
        } else if (monthNumber <= 6 && monthNumber % 2 == 0 ||
                monthNumber >= 7 && monthNumber % 2 != 0) {
            return 31;
        } else {
            return 30;
        }

    }


    boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }


    void printResult(int year, int month, int day, int numberOfDay) {
        out.println("Day number for " + day + "/" + month + " in " + year + " is: " + numberOfDay);
        if (isLeapYear(year)) {
            out.println(year + " is a leap year");
        } else {
            out.println(year + " is not a leap year");
        }
    }


}
