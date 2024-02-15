package PriorityQueue_Heaps;
import java.util.ArrayList;

public class Heaps_01{

    static class Heap{
        ArrayList<Integer> arr=new ArrayList<>();

        //MinHeap        
        //add method of Priority Queue. ~ TC-0(logn)
        public void add(int key){
            //add at last index
            arr.add(key);
            int childIdx=arr.size()-1;
            int parIdx=(childIdx-1)/2;
            while(arr.get(childIdx)<arr.get(parIdx)){
                //swap
                int temp=arr.get(childIdx);
                arr.set(childIdx,arr.get(parIdx));
                arr.set(parIdx, temp);
                childIdx=parIdx;
                parIdx=(childIdx-1)/2;
            }
        }
        
        //peek method of PQ ~ TC-0(1)
        public int peek(){
            return arr.get(0);
        }

        //remove method of PQ ~ TC-0(logn)
        public int remove(){
            if(isEmpty()){
                return Integer.MIN_VALUE;
            }
            int temp=arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            arr.remove(arr.size()-1);
            minHeapify(0);
            return temp;

        }
        //heapify~TC-0(logn);
        private void minHeapify(int idx){
            int minIdx=idx;
            int leftChIdx=(2*idx)+1;
            int rightChIdx=(2*idx)+2;

            if(leftChIdx<arr.size() && arr.get(minIdx)>arr.get(leftChIdx)){
                minIdx=leftChIdx;
            }

            if(rightChIdx<arr.size() && arr.get(minIdx)>arr.get(rightChIdx)){
                minIdx=rightChIdx;
            }

            if(idx!=minIdx){
                int temp=arr.get(idx);
                arr.set(idx,arr.get(minIdx));
                arr.set(minIdx,temp);
                minHeapify(minIdx);                
            }

        }
        public void maxHeapify(int idx,int size){
            int leftChIdx=2*idx+1;
            int rightChIdx=2*idx+2;
            int maxIdx=idx;
            if(leftChIdx<size && arr.get(leftChIdx)>arr.get(maxIdx)){
                maxIdx=leftChIdx;
            }
            if(rightChIdx<size && arr.get(rightChIdx)>arr.get(maxIdx)){
                maxIdx=rightChIdx;
            }
            if(maxIdx!=idx){
                int temp=arr.get(maxIdx);
                arr.set(maxIdx,arr.get(idx));
                arr.set(idx,temp);
                maxHeapify( maxIdx, size);
            }
        }

        //heapSort ~ TC-0(n*logn)
        public void heapSort(){
            int n=arr.size();
            //step-1 construct a max heap
            for(int i=n/2;i>=0;i--){
                maxHeapify(i,n);
            }

            //step-2 push at end 
            for(int i=n-1;i>0;i--){
                int temp=arr.get(0);
                arr.set(0,arr.get(i));
                arr.set(i,temp);

                maxHeapify(0, i);
            }
        }

        public boolean isEmpty(){
            return arr.size()==0;
        }        

        public void print(){
            System.out.println(arr);
        }
    }
    public static void main(String args[]){
        Heap pq=new Heap();
        pq.add(2);
        pq.add(3);
        pq.add(4);
        pq.add(5);
        pq.add(10);
        pq.add(6);
        pq.print();
        System.out.println("removed element = "+pq.remove());
        pq.print();
        pq.heapSort();
        System.out.print("Heap Sort =");
        pq.print();


    }
}