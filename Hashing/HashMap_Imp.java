package Hashing;
import java.util.ArrayList;
import java.util.LinkedList;

public class HashMap_Imp{
    static class Hashmap<K,V>{//generics 
        private class Node{
            K key;
            V value;
            public Node(K key,V value){
                this.key=key;
                this.value=value;
            }
        }
        private int size;
        private int N;
        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")
        public Hashmap(){
            this.N=4;
            this.buckets=new LinkedList[N];
            for(int i=0;i<buckets.length;i++){
                buckets[i]=new LinkedList<>();
            }
        }

        //rehash function ~ TC-0(N*lambda) or 0(N)
        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node> oldBucket[]=buckets;
            N=N*2;
            buckets=new LinkedList[N];
            for(int i=0;i<buckets.length;i++){
                buckets[i]=new LinkedList<>();
            }
            for(int i=0;i<oldBucket.length;i++){
                LinkedList<Node> ll=oldBucket[i];
                for(int j=0;j<ll.size();j++){
                    Node nd=ll.remove();
                    put(nd.key,nd.value);
                }
            }
        }

        //Hash Function ~ TC-0(1)
        private int hashFunction(K key){
            return Math.abs(key.hashCode())%N;
        }

        //search function ~ TC-0(lambda) or 0(1)
        private int search(K key,int bi){
            LinkedList<Node> ll=buckets[bi];
            int i;
            for(i=0;i<ll.size();i++){
                Node nd=ll.get(i);
                if(nd.key==key){
                    return i;
                }
            }
            return -1;
        }

        //put function  ~ TC-0(lambda) or 0(1)
        public void put(K key,V value){
            int bi=hashFunction(key);
            //data index (index where the key should exist),if the key doesn't exist then it return -1.
            int di=search(key,bi);
            if(di!=-1){
                Node nd=buckets[bi].get(di);
                nd.value=value;
            }
            else{
                buckets[bi].add(new Node(key, value));
                size++;
            }
            double lambda =(double)size/N;
            if(lambda>2.0){
                rehash();
            }

        }

        //containsKey function ~ TC-0(lambda) or 0(1)
        public boolean containsKey(K key){
            int bi=hashFunction(key);
            int di=search(key, bi);
            return (di!=-1)?true:false;
        }

        //remove function ~ TC-0(lambda) or 0(1)
        public V remove(K key){
            int bi=hashFunction(key);
            int di=search(key, bi);
            if(di!=-1){
                Node nd=buckets[bi].remove(di);
                size--;
                return nd.value;
            }
            else{
                return null;
            }
        }

        //get function ~ TC-0(lambda) or 0(1)
        public V get(K key){
            int bi=hashFunction(key);
            int di=search(key, bi);
            if(di==-1){
                return null;
            }
            else{
                return buckets[bi].get(di).value;
            }
        }

        //keySet function ~ TC-0(N*lambda) or 0(N)
        public ArrayList<K> keySet(){ 
            ArrayList<K> keys=new ArrayList<>();
            for(int i=0;i<buckets.length;i++){
                LinkedList<Node> ll=buckets[i];
                for(Node nd: ll){
                    keys.add(nd.key);
                }
            }
            return keys;
        }

        //isEmpty function ~ TC-0(1)
        public boolean isEmpty(){
            return size==0;
        }
    }
    public static void main(String[] args) {
        Hashmap<String,Integer> map=new Hashmap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        map.put("E", 5);
        System.out.println(map.containsKey("B"));
        System.out.println(map.get("B"));
        System.out.println(map.remove("B"));
        ArrayList<String> list=map.keySet();
        System.out.println();
        for(String key:list){
            System.out.println(key);
        }
        
    }
}
//worst case complexity when hashFunction gives same output every time then time complexity=0(N).
