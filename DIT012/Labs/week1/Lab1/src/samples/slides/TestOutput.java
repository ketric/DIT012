package samples.slides;


import static java.lang.System.*;
/**
 * Testing some output (not explained what happens here)
 */
public class TestOutput {

    public static void main(String[] args) {
        new TestOutput().program();  // Must be same as program name (Template)
    }

    void program() {
        out.println( 1 + 2);
        out.println( "1" + 2);
        out.println( "1 + 2");
        out.println( '1' + 2 );
        out.println( '1' + "2");
    }


}
