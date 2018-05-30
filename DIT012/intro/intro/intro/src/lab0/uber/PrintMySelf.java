package lab0.uber;

/*
 * A program that prints it's own code
 *
 * This needs more advanced Java than we have presented so far.
 */
public class PrintMySelf {


    public static void main(String[] args) {
        new PrintMySelf().program();
    }

    private void program() {
        // Make the program print out itself (it's own code)!
        String s = "public class PrintMyself {%3$c%4$cpublic static void main (String[] args) {%3$c%4$c%4$cString s = %2$c%1$s%2$c;%3$c%4$c%4$cSystem.out.printf(s, s, 34, 10, 9);%3$c%4$c}%3$c}";
        System.out.printf(s, s, 34, 10, 9);
    }
}

