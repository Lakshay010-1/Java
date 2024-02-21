package Hashing;
import java.util.*;

public class map_01{

    //subArray sum equal to k ~ TC-0(n)
    public static int subArraySumK(int nums[],int k){
        int count=0,sum=0;
        //(sum,count)
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0, 1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                count+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count; 
    }
    
    //largest subarray with 0 sum ~ TC-0(n)
    public static int largestSubarray(int nums[]){
        HashMap<Integer,Integer> map=new HashMap<>();
        int maxLen=0,sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(map.containsKey(sum)){
                maxLen=Math.max(maxLen,i-map.get(sum));
            }
            else{
            map.put(sum, i);
            }
        }
        return maxLen;
    }

    //find itineary from tickets
    public static void itineary(HashMap<String,String> tickets){
        String startPoint=getStartPoint(tickets);
        while(tickets.get(startPoint)!=null){
            System.out.print(startPoint+"->");
            startPoint=tickets.get(startPoint);
        }
        System.out.println(startPoint);
        
    }
    private static String getStartPoint(HashMap<String,String> tickets){
        HashMap<String,String> revMap=new HashMap<>();
        for(Map.Entry<String,String> entry:tickets.entrySet()){
            revMap.put(entry.getValue(), entry.getKey());
        }
        for(String start:tickets.keySet()){
            if(!revMap.containsKey(start)){
                return start;
            }
        }
        return null;
    }

    //Majority Element
    public static void majorityEle(int arr[]){
        int div=arr.length/3;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue()>div){
                System.out.print(entry.getKey()+" ");
            }
        }
        System.out.println();       
    }

    //Valid Anagram
    public static boolean validAnagram(String s,String t){
        if(s.length()!=t.length()){
            return false;
        }
        HashMap<Character,Integer> fre=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char sChar=s.charAt(i);
            char tChar=t.charAt(i);
            fre.put(sChar, fre.getOrDefault(sChar, 0)+1);
            fre.put(tChar, fre.getOrDefault(tChar, 0)-1);
        }
        for(Map.Entry<Character,Integer> map: fre.entrySet()){
            if(map.getValue()!=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]){

        int arr[]={1,3,2,5,1,3,1,5,1};
        System.out.print("Majority Element = ");
        majorityEle(arr);
        int arr2[]={1,2};
        System.out.print("Majority Element = ");
        majorityEle(arr2);

        String s="race";
        String t="caree";
        System.out.println("isAnagram = "+validAnagram(s, t));
        System.out.println();

        HashMap<String,String> ticket=new HashMap<>();
        ticket.put("A","B");
        ticket.put("B","C");
        ticket.put("C","D");
        ticket.put("D","E");
        System.out.print("itineary = ");
        itineary(ticket);

        int subArr[]={15,-2,2,-8,1,7,10,23};
        System.out.println("maxLen = "+largestSubarray(subArr));

        int subArrK[]={10,2,-2,-20,10};
        System.out.println("total count of subarray sum equal to k is "+subArraySumK(subArrK,-10));

        ////HashMap
        System.out.println("HashMap");
        //Create - TC~0(1)
        HashMap<String,Integer> hash_map=new HashMap<>();

        //Insert - TC~0(1)
        hash_map.put("Earth",1);
        hash_map.put("Moon",2);
        hash_map.put("Sun",3);
        hash_map.put("Venus",4);
        hash_map.put("Saturn",5);
        hash_map.put("Jupiter",6);
        System.out.println(hash_map);
        System.out.println();

        ////LinkedHashMap
        System.out.println("LinkedHashMap");
        //Create - TC~0(1)
        LinkedHashMap<String,Integer> linked_hashmap=new LinkedHashMap<>();
        //Insert - TC~0(1)
        linked_hashmap.put("Earth",1);
        linked_hashmap.put("Moon",2);
        linked_hashmap.put("Sun",3);
        linked_hashmap.put("Venus",4);
        linked_hashmap.put("Saturn",5);
        linked_hashmap.put("Jupiter",6);
        System.out.println(linked_hashmap);
        System.out.println();


        ////TreeMap
        System.out.println("TreeMap");
        //Create - TC~0(1)
        TreeMap<String,Integer> tree_map=new TreeMap<>();
        //Insert - TC~0(1)
        tree_map.put("Earth",1);
        tree_map.put("Moon",2);
        tree_map.put("Sun",3);
        tree_map.put("Venus",4);
        tree_map.put("Saturn",5);
        tree_map.put("Jupiter",6);
        System.out.println(tree_map);
        System.out.println();


        // //get - TC~0(1)
        // System.out.println("Earth value = "+hash_map.get("Earth"));
        // System.out.println("Uranus value = "+hash_map.get("Uranus"));
        // System.out.println();

        // //containsKey - TC~0(1)
        // System.out.println("containsKey earth = "+hash_map.containsKey("Earth"));
        // System.out.println("containsKey uranus = "+hash_map.containsKey("Uranus"));        
        // //containsValue - TC~0(1)
        // System.out.println("containsValue 11 = "+hash_map.containsValue(11));
        // System.out.println("containsValue 2 = "+hash_map.containsValue(2));
        // System.out.println();

        // //remove - TC~0(1)
        // System.out.println("remove moon = "+hash_map.remove("Moon"));System.out.println();

        // //size
        // System.out.println("size ="+hash_map.size());System.out.println();

        // //clear
        // hash_map.clear();

        // //isEmpty
        // System.out.println("isEmpty ="+hash_map.isEmpty());System.out.println();

        // //Iteration
        // //Approach-1. Iterate through a hashmap entrySet using iterator
        // System.out.println("Approach 1 -Iterating through a hashmap using iterator");
        // System.out.println("(i).entrySet");
        // Iterator<Map.Entry<String,Integer>> it=hash_map.entrySet().iterator();
        // while(it.hasNext()){
        //     Map.Entry<String,Integer> entry=it.next();
        //     System.out.println("K-"+entry.getKey()+" ,V-"+entry.getValue());
        // }
        // System.out.println();
        // System.out.println("(ii).keySet");
        // Iterator<String> it2=hash_map.keySet().iterator();
        // while(it2.hasNext()){
        //     String key=it2.next();
        //     System.out.println("k->"+key+", V->"+hash_map.get(key));
        // }

        // //Approach-2. for-each loop
        // System.out.println("Approach 2. -for-each loop");
        // System.out.println("(i).entrySet");
        // Set<Map.Entry<String,Integer>> entryset=hash_map.entrySet();
        // for(Map.Entry<String,Integer> entry:entryset){
        //     System.out.println("K-"+entry.getKey()+" ,V-"+entry.getValue());
        // }        
        // /*
        // for(Map.Entry<String,Integer> entryyset:map.entrySet()){
        //     System.out.println(entryyset.getKey()+","+entryyset.getValue());
        // }
        //  */
        // System.out.println("(ii).keySet");
        // Set<String> set1=hash_map.keySet();
        // for(String k: set1){
        //     System.out.println("Key= "+k+", Value= "+hash_map.get(k));
        // }

        // //Approach-3. Iterate through a HashMap using lamda expressions
        // System.out.println("Approach-3. Iterating through a HashMap using lamda expressions");
        // hash_map.forEach((k,v)->System.out.println("key-"+k+" ,value-"+v));

        // //Approach-4. Iterate through a HashMap using Stream API
        // System.out.println("Approach-4. Iterating through a HashMap using Stream API");
        // hash_map.entrySet().stream().forEach(entry->System.out.println("key-"+entry.getKey()+" ,value-"+entry.getValue()));
    }
}