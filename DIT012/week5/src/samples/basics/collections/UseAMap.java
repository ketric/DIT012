package samples.basics.collections;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

/**
 * Use a Map
 */
public class UseAMap {


    public static void main(String[] args) {
        new UseAMap().program();
    }

    private void program() {
        Map<Integer, MyClass> map = new HashMap<>();

        map.put(1, new MyClass("Hello"));
        map.put(2, new MyClass("Godbye"));
        map.put(3, new MyClass("Hello"));

        MyClass i1 = map.get(1);
        MyClass i3 = map.get(3);
        out.println( i1 == i3);   // No
        out.println( i1.equals(i3)); // Yes

        // Reverse lookup
        Integer key = null;
        for( Map.Entry<Integer, MyClass> m : map.entrySet()){
            if( m.getValue().equals(new MyClass("Hello"))){
                key = m.getKey();
            }
        }
        out.println(key);

    }

    // Equals and hashCode important!
    class MyClass {
        String data;

        public MyClass(String data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof MyClass)) return false;

            MyClass myClass = (MyClass) o;

            return data != null ? data.equals(myClass.data) : myClass.data == null;

        }

        @Override
        public int hashCode() {
            return data != null ? data.hashCode() : 0;
        }
    }

}
