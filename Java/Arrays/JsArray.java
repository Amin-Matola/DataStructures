package com.company;

import java.util.Arrays;
import java.util.function.Function;
import javafx.util.Pair;

public class JsArray {
    private static int maxItems;
    private Object[] items      = new Object[maxItems], oldObj;
    public static int length    = maxItems

    void copy(Object[] o, Object[] o2){
        maxItems  = o2.length;
        for(int i = 0; i < o.length; i++){
            o2[i] = o[i];
        }
    }

    void expand(int n){
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
        for(int i = 0; i < o.length; i++){
            push(o[i]);
        }
        return this;
    }

    JsArray sort(){
        Arrays.sort(this.items);
        return this;
    }

    void map(Function f){
        for(int i = 0; i < this.items.length; i++){
            f.apply(this.items[i]);
        }
    }

    Object pop(){

        Object o = items[items.length-1];
        items = Arrays.copyOf(items, items.length - 1);

        return o;

    }

    void show(){
        System.out.println(Arrays.toString(items));
    }

}
