/**
 * Created by kenny on 2017-01-10.
 */
import static java.lang.System.in;
import static java.lang.System.out;

public class sumofdigits {
    public static void main(String[] args) {
        System.out.print(sumOfDigits(321));
    }

    public static int sumOfDigits(int n) {
        String digits = new Integer(n).toString();
        int sum = 0;
        for (char c: digits.toCharArray())
            sum += c - '0';
        return sum;
    }

}
