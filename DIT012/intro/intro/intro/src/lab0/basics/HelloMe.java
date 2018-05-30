package lab0.basics;

/*
 * A program that prints my name
 */
public class HelloMe {


    public static void main(String[] args) {
        new HelloMe().program();
    }

    private void program() {
        // Make program print "Hello" + you name here!
        // Example "Hello Sven"

        String myName = "kenny";
        System.out.println ("Hello " + myName + "!");
    }
}
