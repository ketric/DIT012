/**
 * Created by kenny on 2017-01-09.
 */

import java.util.Arrays;

import static java.lang.System.out;

public class sumarray {
    public static void main(String[] args) {
        new sumarray().program();
    }


    void program() {
        int bucky[] = {1,2,3,4,5};  //0,1,2,3,4 positions
        out.println("1,2,3,4,5");
        int sum = 0;

        for (int counter = 0; counter <bucky.length; counter++){
            sum += bucky[counter];
        }
        out.println("the sum of these numbers are: " +sum);
    }

}
