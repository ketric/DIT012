import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created by kenny on 2017-01-10.
 */
public class clump {
    static Scanner sc = new Scanner(in);
    public static void main(String[] args) {
        new clump().program();
    }

    void program(){
    int clump[] = {1,2,2,3,4,5,5};
        int x = nClump(clump);
        System.out.println(x);

    }

    int nClump(int arr[]) {
        int n = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                n++;
            }
        }
        return n;
    }

}