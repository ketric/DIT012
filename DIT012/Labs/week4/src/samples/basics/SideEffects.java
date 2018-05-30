package samples;

import static java.lang.System.out;

/*
 * The program template
 */
public class SideEffects {

    public static void main(String[] args) {
        new SideEffects().program();
    }

    void program() {
        Calculator c = new Calculator();
        out.println(c.m(0) - c.m(0));  // Intuitively 0, but ....

    }


    class Calculator {
        int i;
        int m(int i){
            int result = this.i + i;
            this.i++;                 // ... side effect in method! (avoid)
            return result;
        }

    }

}
