package samples.slides;

import java.util.Arrays;

import static java.lang.System.out;

/**
 * Using array as objects (explicit instantiate)
 */
public class MergeArrays {

    public static void main(String[] args) {
        new MergeArrays().program();
    }

    void program() {
        int[] i1 = {5, 4, 2, 1, 7};
        int[] i2 = {8, 3, 8};


        int[] r1 = merge(i1, i2);
        out.println(Arrays.toString(r1));

        int[] r2 = merge2(i1, i2);
        out.println(Arrays.toString(r2));

        int[] test1 = new int[i1.length + i2.length];
        int index;
        for (index = 0; index < test1.length; index++)
            System.out.print(test1[1] + " ");
    }

    // Merge two arrays
    int[] merge(int[] a, int[] b) {
        Arrays.sort(a);   // Java built in sorting
        Arrays.sort(b);

        int[] result = new int[a.length + b.length];  // <--------------------- HERE!!
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                result[k] = a[i];
                i++;
            } else {
                result[k] = b[j];
                j++;
            }
            k++;
        }

        // If b shorter
        while (i < a.length) {
            result[k] = a[i];
            i++;
            k++;
        }

        // If a shorter
        while (j < b.length) {
            result[k] = b[j];
            j++;
            k++;
        }
        return result;
    }

    int[] merge2(int[] a, int[] b) {
        int[] r = concat(a, b);
        Arrays.sort(r);
        return r;
    }

    int[] concat(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int k = 0;
        for (int i = 0; i < a.length; i++) {
            result[k] = a[i];
            k++;
        }
        for (int i = 0; i < b.length; i++) {
            result[k] = b[i];
            k++;
        }
        return result;
    }
}
