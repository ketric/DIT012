package samples.basics;

import static java.lang.System.*;

/**
 * The eternal Hello world program
 */
public class HelloWorld {


    public static void main(String[] args) {
        new HelloWorld().program();
    }

    void program(){
        out.println("Hello world");
        out.print("Hello space");


    }
}
