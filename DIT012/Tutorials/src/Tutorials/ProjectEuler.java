package Tutorials;

public class ProjectEuler {

    public static void main(String[] args){

        int i = 0;
        int count = 0;

        while(i < 1000){

            if((i % 3) == 0) {
                count++;
            }
            else if ((i % 5) == 0) {
                count++;
            }
            i++;
        }
        i = 1;
        int total = 0;
        //Keep the track of the array slot we are in.

        while( i < 1000){
            if((i % 3) ==0){
                total += i;
            }
            else if ((i % 5) == 0) {
                total += i;
            }
            i++;
        }
        System.out.println(total);
    }
}
