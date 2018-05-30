/**
 * Created by kenny on 2017-01-06.
 */

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class command {
    static Scanner sc = new Scanner(in);
    public static void main(String[] args) {
        new command().program();
    }

    void program(){
        boolean done = false;
        String cmd;
        while (!done) {
            out.print("Enter command > ");
            cmd = sc.nextLine();
            switch (cmd) {
                case "roll":
                    out.println("roll selected");
                    break;
                case "move":
                    out.println("move selected");
                    break;
                case "bye":
                    done = true;
                    break;
                default:
                    out.println("Not Legit Command");
            }
        }

        out.println("Program finished");
    }

}
