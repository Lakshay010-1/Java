package Hashing;
import java.util.*;

public class set_01 {
  
    //count distinct elements
    public static int countDistinct(int nums[]){
        HashSet<Integer> set=new HashSet<>();
        for(int i:nums){
            set.add(i);
        }
        return set.size();
    }

    //union of 2 arrays
    public static ArrayList<Integer> union2Arr(int[] arr1,int[] arr2){
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            set.add(arr1[i]);
        }
        for(int i=0;i<arr2.length;i++){
            set.add(arr2[i]);
        }
        ArrayList<Integer> arr= new ArrayList<>();
        for(int i:set){
            arr.add(i);
        }
        return arr;
    }

    //intersection of 2 arrays
    public static ArrayList<Integer> intersection2Arr(int arr1[],int arr2[]){
        HashSet<Integer> set1=new HashSet<>();        
        for(int i=0;i<arr1.length;i++){
            set1.add(arr1[i]);
        }        
        ArrayList<Integer> arr=new ArrayList<>();
        for(int i:arr2){
            if(set1.contains(i)){
                arr.add(i);
            }
        }
        return arr;
    }
    

    public static void main(String[] args) {
        int arr1[]={1,3,2,1,3,2,2,3,1};
        System.out.println("total distinct elements = "+countDistinct(arr1));
        int arr2[]={2,4,5,4,5};

        ArrayList<Integer> union=union2Arr(arr1, arr2);
        System.out.print("union = ");
        System.out.println(union);
       ArrayList<Integer> intersection=intersection2Arr(arr1, arr2);
        System.out.print("intersection = ");
        System.out.println(intersection);

        System.out.println();
        //HashSet
        System.out.println("HashSet");
        HashSet<Integer> hs=new HashSet<>();
        hs.add(8);
        hs.add(4);
        hs.add(3);
        hs.add(2);
        hs.add(5);        
        System.out.println(hs);
        System.out.println();

        //LinkedHashSet
        System.out.println("LinkedHashSet");
        LinkedHashSet<Integer> lhs=new LinkedHashSet<>();
        lhs.add(7);
        lhs.add(2);
        lhs.add(9);
        lhs.add(4);
        lhs.add(1);
        System.out.println(lhs);
        System.out.println();

        //TreeSet
        System.out.println("TreeSet");
        TreeSet<Integer> ts=new TreeSet<>();
        ts.add(1);
        ts.add(7);
        ts.add(3);
        ts.add(9);
        ts.add(5);
        System.out.println(ts);
        // //contains ~ TC-0(1)
        // System.out.println(hs.contains(3));
        // System.out.println(hs.contains(8));
        // //remove ~ TC-0(1)
        // System.out.println(hs.remove(4));        
        // System.out.println("isEmpty = "+hs.isEmpty());

        // //Iteration
        // //Approach-1.using Iterator
        // Iterator<Integer> it=hs.iterator();
        // while(it.hasNext()){
        //     System.out.println(it.next());
        // }
        // System.out.println();
        // //Approach-2.using for each loop
        // for(int num:hs){
        //     System.out.println(num);
        // }
    }
    
}
