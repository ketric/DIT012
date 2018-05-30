package samples.basics;

import java.util.Arrays;
import java.util.function.Function;

import static java.lang.System.out;

/*
 *  Using method references
 */
public class MethodReference {

    public static void main(String[] args) {
        new MethodReference().program();
    }

    void program() {
        double[] d = {1.0, 2.0, 3.0};
        Accumulator a = new Accumulator(d.length);

        a.accumulate(d, this::square);   // Instance method reference
        out.println(Arrays.toString(a.getData()));

        a.accumulate(d, Math::exp);       // Class method reference
        out.println(Arrays.toString(a.getData()));

    }

    double square(double d) {
        return d * d;
    }

    class Accumulator {
        final double[] data;

        Accumulator(int size) {
            data = new double[size];
        }

        // Param func is a method with Double arg and Double return type
        void accumulate(double[] indata, Function<Double, Double> func) {
            for (int i = 0; i < data.length; i++) {
                data[i] = func.apply(indata[i]);
            }
        }

        double[] getData() {
            return data;
        }


    }
}
