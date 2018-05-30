package samples.slides;

import java.util.Scanner;

import static java.lang.System.*;

/**
 * Biggest of three ints (note out put last, save results)
 */
public class BiggestOf3 {


    public static void main(String[] args) {
        new BiggestOf3().program();
    }

    void program() {
        Scanner sc = new Scanner(in);
        out.print("Input 3 integer (space between) > ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int max = a;
        if( b > max ){
            max = b;
        }
        if( c > max){
            max = c;
        }

        // Possible but above much better
        /*if( a > b ){
            if( a > c){
                max = a;
            }else {
                max = c;
            }
        }else {
            if( b > c){
                max = b;
            }else {
                max = c;
            }
        }*/


        out.println("Biggest was "  + max);
    }





}
