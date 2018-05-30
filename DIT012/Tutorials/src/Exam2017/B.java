package Exam2017;

/**
 * Created by kenny on 2017-04-12.
 */
public class B {
    int i;
    A a;
    public B(int i, A a){
        this.i=i;
        this.a=a;
    }
    public B copy(){
        return new B(i,a);
    }
}
