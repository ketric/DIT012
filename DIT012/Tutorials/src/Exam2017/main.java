package Exam2017;

/**
 * Created by kenny on 2017-04-12.
 */
public class main {
    public static void main(String[] args) {


    A a = new A(9);
    B b1 = new B(9, a);
    B b2 = b1.copy();

    b2.a.i =37;
    System.out.println(b1.a.i);
}
}
