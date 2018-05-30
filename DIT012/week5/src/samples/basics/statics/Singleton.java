package samples.basics.statics;

import static java.lang.System.*;
/**
 * Using a static variable and a static method
 * to create a class with only one object
 *
 * To use this;
 *
 * Singleton s = Singleton.getInstance();
 * s.sayHello("Fia");
 *
 */
public class Singleton {
    private static Singleton instance;

    private Singleton(){}  // Private can't use outside class

    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton(); // The only object
        }
        return instance;
    }

    public void sayHello(String name){
        out.println("Hello " + name);
    }
}
