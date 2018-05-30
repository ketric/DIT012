package samples.basics.collections;

import java.util.ArrayList;
import java.util.List;


import static java.lang.System.out;

/**
 * Basic use of List (ArrayList)
 */

public class UseAList {


    public static void main(String[] args) {
        new UseAList().program();
    }

    public void program() {
        /*

            ArrayList is an implementation of the List interface (a contract).
            ArrayList implements List (all methods in List are found in ArrayList)
            It's possible to have a variable of an interface type
            ArrayList is type compatible with List (guaranteed to have same operations)
            We prefer variables of interface type (because then we can change the implementation
            without changing the rest of the program (not applicable here, but in general)
         */
        List<Integer> l = new ArrayList<>();  // List is a supplied class from library (API) "util" see import

        out.println(l.isEmpty());
        l.add(100);   // Put last in list
        l.add(200);
        l.add(300);
        out.println(l);                 // List has nice toString method, easy to print out
        out.println(l.size() == 3);
        out.println(l.get(2));   // Can't use [ ]. Use get() (0-indexed)
        out.println(l.indexOf(300) == 2);

        l.set(0, 500);  // Will overwrite
        out.println(!l.contains(100));
        out.println(l);

        for (Integer i : l) {   // Use short for-loop. NOTE Can't remove using this loop ...
            out.print(i);     // See RemoveFromCollection sample
        }


        l.add(1, 400);  // Values moved to right, then inserted at 1
        out.println(l);
        // Index 50 doesn't exist, exception!
        //l.add(50, 555);

        l.remove(1);      // Remove using index, see also RemoveFromCollection sample
        out.println(l);

        List<Integer> l2 = l.subList(1, 3);
        out.println(l2);

        l.clear();
        out.println(l.isEmpty());

    }

}
