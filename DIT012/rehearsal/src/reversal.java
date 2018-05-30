/**
 * Created by kenny on 2017-01-10.
 */
import java.util.Scanner;
public class reversal {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new reversal().program();
    }

    void program(){
        System.out.print("input: ");
        int n = sc.nextInt();
        boolean bool = whatever(n);
        System.out.println(bool);
        System.out.println();
        program();
    }
        //METHODS
    boolean whatever (int num){
        String s = String.valueOf(num);
        String s1 = "";
        for(int i = s.length()-1; i > -1; i--) {
            s1 += Character.toString(s.charAt(i));
        }
        return s1.equals(s);
    }
}
