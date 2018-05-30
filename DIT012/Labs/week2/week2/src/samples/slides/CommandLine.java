package samples.slides;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Basic command line menu
 */
public class CommandLine {

    public static void main(String[] args) {
        new CommandLine().program();
    }

    void program() {

        boolean done = false;
        Scanner sc = new Scanner(in);

        while (!done) {     // Command loop
            out.print("Enter command > ");  // Prompt user
            String cmd = sc.nextLine();      // Loop and a half
            switch (cmd) {
                case "roll":
                    out.println("roll selected");  // Act on command
                    break;
                case "move":
                    out.println("move selected");
                    break;
                case "bye":
                    done = true;   // Leave loop
                    break;
                default:
                    out.println("?");     // Bad command
            }
        }  // <--------------------- end command line

        out.println("Program finished");
    }
}
