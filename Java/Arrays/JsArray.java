package arrays.JsArrays

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JsArray {
    private static int maxItems;
    private Object[] items      = new Object[maxItems], oldObj;
    public static int length    = maxItems;

    private void copy(Object[] o, Object[] o2){
        maxItems  = o2.length;
        for(int i = 0; i < o.length; o2[i] = o[i++]);
    }

    private void expand(int n){
        oldObj = new Object[maxItems + n];
        copy(items, oldObj);
        items = new Object[maxItems];
        copy(oldObj, items);

    }

    void push(Object o){
        expand(1);
        for(int i = maxItems; i > 0;){
            i -= 1;
            if( items[i] == null){
                items[i] = o;
                break;
            }
                
        }
    }

    JsArray concat(Object ...o){
        for(int i = 0; i < o.length; push(o[i++]));
        return this;
    }

    JsArray sort(){
        Arrays.sort(this.items);
        return this;
    }

    void map(Function f){
        for(int i = 0; i < this.items.length; f.apply(this.items[i++]));
    }

    Object pop(){

        Object o = items[items.length-1];
        items = Arrays.copyOf(items, items.length - 1);

        return o;

    }
    
    void fill(Object o){
        for (int i = 0; i < maxItems; items[i++] = o);

    }

    @Override
    public String toString() {
        return "JsArray{\n" +
                "\titems = " +
                Arrays.toString(
                        Arrays.stream(items).map((i) -> String.format("\n\t\t\t%s", i)).collect(Collectors.toList()).toArray()
                )+
                "\n\t}";
    }

    protected void show(){
        System.out.println(Arrays.toString(items));
    }

}
