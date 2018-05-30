package assignment.basics;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 * This program translates from English to Pig latin
 * See,https://en.wikipedia.org/wiki/Pig_Latin
 */
public class PigLatin {

    public static void main(String[] args) {
        new PigLatin().program();
    }

    private final Scanner scan = new Scanner(in);

    private void program() {
        // Only for english
        out.println(toPigLatin("My name is Eric").equals("yMay amenay isway Ericway"));

        // Kill with Ctrl + c or let IntelliJ do it
        while (true) {
            String line = scan.nextLine();
            out.println(toPigLatin(line));
        }
    }

    // Try really hard to use Javas String methods, avoid loops (but possible some needed)
    // Use functional abstraction/decomposition
    private String toPigLatin(String text) {
        // TODO
        return null;
    }




}
