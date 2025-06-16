package ch15.sec02.exam03;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();

        long startTime;
        long endTime;

        startTime = System.nanoTime();
        for(int i =0; i<1000; i++){
            list1.add(String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.printf("%-17s %8d ns \n", "ArrayList 걸린 시간: ", (endTime - startTime));

        startTime = System.nanoTime();
        for(int i =0; i<1000; i++){
            list2.add(String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.printf("%-17s %8d ns \n", "ArrayList 걸린 시간: ", (endTime - startTime));
    }
}
