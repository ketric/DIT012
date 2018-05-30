/**
 * Created by kenny on 2017-01-10.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class reverseString {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        new reverseString().program();
    }
    void program() {
        System.out.print("input String: ");
        String s = sc.nextLine();
        reverseThisString(s);
    }
    static void reverseThisString(String mening) {
        String preResult = "";
        String[] arrayStr = mening.split(" ");
        for (int i = arrayStr.length - 1; i > -1; i --) {
            preResult += arrayStr[i] + " ";
        }
        String result = preResult.substring(0, preResult.length() -1);
        System.out.println(result);
    }
}