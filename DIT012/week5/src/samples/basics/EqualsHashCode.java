package samples.basics;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

/**
 * Equals by value (and hashCode)
 */
public class EqualsHashCode {

    public static void main(String[] args) {
        new EqualsHashCode().program();
    }

    private void program() {
        List<A> as = new ArrayList<>();

        as.add(new A(1, 1));
        out.println(as.indexOf(new A(1, 1)) < 0 );   // No found, equality by reference
        out.println( ! as.contains(new A(1, 1)));    // No found, equality by reference


        List<B> bs = new ArrayList<>();
        bs.add(new B(1, 1));
        out.println(bs.indexOf(new B(1, 1)) == 0);   // Found, equality by value
        out.println(bs.contains(new B(1, 1)));       // Found, equality by value
    }


    // Class has NO equals and hashCode
    public class A {
        private int x;
        private int y;

        public A(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // Class has own equals and hashCode
    public class B {
        private int x;
        private int y;

        public B(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // NOTE: We decide what we mean by equal, below is one option
        @Override
        public boolean equals(Object o) {
            if (this == o) {      // If same object of course true
                return true;
            }
            // If null or
            // If not same class (i.e. not have same class object) false
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            // Cast Object to B
            B b = (B) o;  // We know o is of type be because o has same class-object as this
            return (x == b.x) && (y == b.y); // Finally compare by value
        }

        // Must have this if equals overridden (generate an integer value
        // used by some collections, i.e. Map)
        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

}
