import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Created by kenny on 2017-01-10.
 */
public class matrix {
    static Scanner sc = new Scanner(in);
    public static void main(String[] args) {
        new matrix().program();
    }

    void program(){
        int[] arr = {1,0,1,2,2,0,1,3,0};


    }
    //METHODS
    int maxSquare(int[][] matr) {
        int sum = 0;
        for (int r = 0; r < matr.length - 1; r++) {
            for (int c = 0; c < matr[r].length - 1; c++) {
                int tmp = matr[r][c] + matr[r][c + 1] + matr[r + 1][c] + matr[r + 1][c + 1];
                if (tmp > sum) {
                    sum = tmp;
                }
            }
        }
        return sum;
    }

}
