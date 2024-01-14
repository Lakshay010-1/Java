package Arraylist;

import java.util.ArrayList;
import java.util.Collections;

public class arrayList_01 {
    public static void main(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        
        //add operation --~ 0(1)
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        //adding element at a particular index --~ 0(n)
        list.add(0,0);

        //get operation --~ 0(1)
        System.out.println("element = "+list.get(2));

        //remove operation --~ 0(n)
        list.remove(5);

        //set operation --~ 0(n)
        list.set(3,4);

        //contains operation --~ 0(n)
        System.out.println(list.contains(4));

        //size function of the arrayList
        System.out.println("size = "+list.size());

        //printing ArrayList
        System.out.println(list);

        //printing the arraylist using iteration
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();

        //ascending-order sort
        Collections.sort(list);
        System.out.println(list);
        //descending-order sort
        Collections.sort(list,Collections.reverseOrder());
        System.out.println(list);
    }  
}
