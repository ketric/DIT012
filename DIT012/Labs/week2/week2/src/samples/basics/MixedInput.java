package samples.basics;

import java.util.Scanner;

import static java.lang.System.*;

/*
 *   If reading int's and strings mixed we have to read away the \n
 */
public class MixedInput {

    public static void main(String[] args) {
        new MixedInput().program();
    }

    void program() {
        Scanner sc = new Scanner(in);

        int i = sc.nextInt(); // Possible char's left and in particular the \n (the new line char)

        sc.nextLine();  // Will read  \n  ...

        String s = sc.nextLine();  // .. so we don't read it here.

        out.println(s);

        int[] k = { 1,2,3,4,5};
        out.println(k);
    }
}
