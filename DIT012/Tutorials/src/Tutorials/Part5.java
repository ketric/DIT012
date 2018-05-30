package Tutorials;
import java.util.Scanner;

public class Part5 {

    static Scanner sc = new Scanner(System.in);

    public static void main (String[] args){

        inputTest();
    }
    public static void inputTest(){
        String message = sc.nextLine();
        System.out.println(Hello(message));
    }
    public static String Hello(String message){
        if (message.equals("Hi")){
            return "Hello";
        }
        else {
            return "Goodbye";
        }
    }
}
