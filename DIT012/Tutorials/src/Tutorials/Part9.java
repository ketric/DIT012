package Tutorials;

public class Part9 {

    public static void main(String[] args){

        int arrInt[] = new int[5];

        arrInt[0] = 1;

        int i = 1;

        while(i <= 4){
            arrInt[i] = i+1;
            i++;
        }
        System.out.println(arrInt[0] + " " + arrInt[1] + " " + arrInt[2] +" "+ arrInt[3] +" "+ arrInt[4]);
    }

}
