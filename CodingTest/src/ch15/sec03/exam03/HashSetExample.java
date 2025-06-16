package ch15.sec03.exam03;

import java.util.*;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();

        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
            if(element.equals("A")){
                iterator.remove();
            }
        }
        System.out.println();
        set.remove("B");
        for(String element : set){
            System.out.println(element);
        }
    }
}
