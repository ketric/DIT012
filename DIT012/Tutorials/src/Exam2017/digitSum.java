package Exam2017;


public class digitSum {

    public static void main(String[] args){
        System.out.println(digitSum(333));
    }

    public static int digitSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            n = n / 10;
        }
        return sum;
    }

}
