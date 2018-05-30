package samples.basics.statics;

import static java.lang.System.out;

/**
 *  Using other classes with class methods
 */
public class Main {

    public static void main(String[] args){
        Order o1 = new Order();
        out.println(o1.getStatus() == Order.Status.RECEIVED);
        Order o2 = new Order();
        out.println(o1.getOrderNumber() != o2.getOrderNumber());
        out.println( Order.getLastOrderNumber() == 2);  // Static

    }
}
