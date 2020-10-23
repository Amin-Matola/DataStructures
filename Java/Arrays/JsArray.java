package dsa;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.util.*;

public class BigOh {

    public static void main(String[] args){
        BigOh test = new BigOh();
        //test.proofIt(2);
        List m = new ArrayList(), b = new ArrayList();
        LinkedList l = new LinkedList();

        Vector<String> v = new Vector<String>();
        
        v.addElement("Amin");
        v.addElement("Matola");
        m.add(9);
        m.add(null);
        m.add(8);


        print(101);
        for (Object o: v) print(o);

        //System.out.println(Arrays.toString(b.toArray()));
    }
    public static void print(@NotNull Object o){
        System.out.println(o);
    }

    void proofIt(Integer n) {

        for(int i = 0; i < n; i = i + 1){
            //System.out.println(i);
            for( int j = i; j < n; j += 1 ){
                System.out.println(j);
            }
        }
    }
}

