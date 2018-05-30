package Tutorials;

/**
 * Created by kenny on 2017-04-10.
 */
public class Part10 {

    int tNumber = 0;
    String sNumber = "";

    public Part10(int numberSequence){
        tNumber = numberSequence;
    }
    public Part10(String numberSequence){
        sNumber = numberSequence;

    }

    public void returnInvertedOrderByMath(){
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;

        i1 = (tNumber % 10);
        i2 = (tNumber % 100) / 10;     //will round up to a value of integer.
        i3 = (tNumber % 1000) / 100;
        i4 = (tNumber % 10000) / 1000;
        i5 = (tNumber % 100000) / 10000;

        System.out.println(i1 + "\n" + i2 + "\n" + i3 + "\n" + i4 + "\n" + i5);

    }

    public void returnInvertedOrderByString(){

        char part1;
        char part2;
        char part3;
        char part4;
        char part5;

        part1 = sNumber.charAt(4);
        part2 = sNumber.charAt(3);
        part3 = sNumber.charAt(2);
        part4 = sNumber.charAt(1);
        part5 = sNumber.charAt(0);

        System.out.println(part1 + "\n" + part2 + "\n" + part3 + "\n" + part4 + "\n" + part5);
    }
}
