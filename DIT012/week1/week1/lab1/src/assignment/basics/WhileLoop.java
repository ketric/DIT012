package assignment.basics;


/*
 *   Exercising while-loop
 */
public class WhileLoop {

    public static void main(String[] args) {
        new WhileLoop().program();
    }


    void program() {

        /*A
        int i = -20;
        while ( i < 4 ){
            System.out.println( i );
            i++;
        }
        */

        /*B
        int i = 10;
        while ( i > -11 ){
            System.out.println( i );
            i = i -1;
        }
        */

        /*C
        int i = 5;
        while ( i < 105){
            System.out.println( i s);
            i = i +5;
        }
        */

        /*D
        double i = 0.0;
        while ( i < 9.3){
            System.out.println( i );
            i = i + 0.3;
        }
        */

        /*E
        int a = 1;      //Numerator
        int b = 2;      //Denominator
        while ( b < 512 ){
            System.out.println(a+ "/" + b);
            b = b*2;
            }
            */

        //F 3,1415926536
            double x = 3.0;
            double sum1 = 1 / 3.0;
            while ( x < 196 ){
                x = x + 4;
                sum1 = sum1 + (1/x);
            }
            double y = 5;
            double sum2 = 1 / 5.0;
            while ( y < 196){
                y = y + 4;
                sum2 = sum2 + (1/y);
            }
            double sum3 = 4*(1-sum1 + sum2);
            System.out.println(sum3);





        }
    }

