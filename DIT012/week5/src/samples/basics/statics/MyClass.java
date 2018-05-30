package samples.basics.statics;

/*
   Instance can use/call static but static not instance
 */
public class MyClass {

    public static int i = 1;
    public int j = 2;


    public static void doIt() {
        // Ok
        i = 5;

        //i = j;   // Bad class use instance
        //j = i;   // Bad, for same reason


        // This is a class method
        // which object should handle this?
        //doOther();         // Bad

        //this.doOther();   // Can't use this, possible no this

        // Ok now we have the object
        new MyClass().j = 5;
        new MyClass().doOther();
    }

    public void doOther() {
        i = 5; // Ok, instance use class

        i = j;
        j = i;

        doIt(); // Ok, instance call class
    }

}
