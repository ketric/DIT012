package samples.basics.statics;

/**
 *  Using an static variables and method
 *
 *  NOTE: This is *very* rarely needed!
 */
public class Order {

    /*
        Usage:
        Order o = new Order....

        if( o.getStatus() == Order.Status.ACCEPTED){
               ...
        }

     */

    public enum Status {
        RECEIVED,
        ACCEPTED,
        DECLINED,
        PROCESSING,
        SHIPPED,
        CANCELLED
    }

    private static int orderNumberCounter;  // Class variable
    private final int orderNumber;  // Instance variable
    private Status status;

    public Order() {       // Constructor
        this.orderNumber = orderNumberCounter;
        this.status = Status.RECEIVED;
        orderNumberCounter++;
    }

    public static int getLastOrderNumber() {  // Class method
        return orderNumberCounter;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }


}
