/**
 * Created by kenny on 2017-01-09.
 */

import static java.lang.System.out;
public class arraymethods {
    public static void main(String[] args) {
        new arraymethods().program();
    }

    void program() {
        int bucky[] =  {1,2,3,4,5};
        change(bucky);

        for(int y: bucky){
            out.println(y);
        }
    }

    public static void change(int x[]){
        for(int counter = 0; counter < x.length; counter++){
            //ADDS 1 TO EVERY ELEMENT IN THE ARRAY
            x[counter]+=1;
        }
    }
}
