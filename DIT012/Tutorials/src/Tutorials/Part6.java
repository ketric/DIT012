package Tutorials;
import java.util.Scanner;

public class Part6 {

    static Scanner sc = new Scanner(System.in);

    public static void main (String[] args){

        countNumber();
        compareUnequalString();

    }
    public static void countNumber(){
        int i = 0;

        while(i <= 5){
            System.out.println(i);
            i++;
        }
    }
    public static void compareUnequalString(){
        String x = "Brandon";
        String y = "Ryan";

        if(!x.equals(y)){
            System.out.println("X does not equal Y.");

            if(2 != 5){
                System.out.println("2 does not equal 5");
            }
        }
    }
}
