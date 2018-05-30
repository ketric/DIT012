package Tutorials;
import java.util.ArrayList;
import java.util.Scanner;

public class usingArrayLists {

    public static ArrayList<Integer> array = new ArrayList<Integer>();
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args){

        System.out.println("Enter a bunch of numbers, 1-100, 0 to stop.");
        int input = sc.nextInt();

        while(input != 0){

            if((input >= 1) && (input <= 100)){
                array.add(input);
            }
            else{
                System.out.println("Number must be 1-100");
            }
            input = sc.nextInt();
        }

        for(int i = 1; i <= 10; i++ ){

            int firstNum = ((i-1)*10)+1;
            int secondNum = (i *10);
            int count = 0;
            System.out.print(firstNum+ " - " + secondNum + " |");

            for(int number : array){
                if((number >= firstNum) && (number <= secondNum)){
                    count++;
                }
            }
            for(int x = 0; x < count; x++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
