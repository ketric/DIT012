package samples.basics;

import java.util.Arrays;
import java.util.Random;

import static java.lang.System.out;

/**
 * Fisher-Yates permutation algorithm (shuffle)
 */
public class FisherYates {


    public static void main(String[] args) {
        new FisherYates().program();
    }

    final static Random rand = new Random();

    void program() {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        shuffle(numbers);
        out.println(Arrays.toString(numbers));
    }

    // Will only work for int[]
    void shuffle(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            int j = rand.nextInt(i+1);
            int ii = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = ii;
            out.println("Swap " + i + ":" + j + "-->" + Arrays.toString(numbers));
        }
    }

}

