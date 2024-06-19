package PriorityQueue_Heaps;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueue_02 {
    static class Block implements Comparable<Block>{
        int value,idx;

        Block(int value,int i){
            this.value=value;
            this.idx=i;
        }

        public int compareTo(Block b){
            return b.value-this.value;
        }
    }

    // Function to return the minimum time taken to fill the array
    public static int minTime(int arr[],int n, int k){
                 
        // Stores visited slots
        Queue<Integer> q = new LinkedList<>();
 
        // Checks if a slot is visited or not
        boolean vis[] = new boolean[n + 1];
        int time = 0;
 
        // Insert all filled slots
        for (int i = 0; i < k; i++) { 
            q.add(arr[i]);
            vis[arr[i]] = true;
        }
 
        // Iterate until queue is not empty
        while (q.size() > 0) {
            for (int i = 0; i < q.size(); i++) {
                // Front index
                int curr = q.poll();
 
                // If previous slot is present and not visited
                if (curr - 1 >= 1 && !vis[curr - 1]) {
                    vis[curr - 1] = true;
                    q.add(curr - 1);
                } 
                // If next slot is present and not visited
                if (curr + 1 <= n && !vis[curr + 1]) {
                    vis[curr + 1] = true;
                    q.add(curr + 1);
                }
            }
            time++;
        } 
        return time-1;
    }

    public static void main(String[] args) {

        //Sliding Window maximum
        int arr[]={1,3,-1,-3,5,3,6,7};
        int k=3;
        int ans[]=new int[arr.length-k+1];
        PriorityQueue<Block> pq4=new PriorityQueue<>();

        for(int i=0;i<k;i++){
            pq4.add(new Block(arr[i], i));
        }
        ans[0]=pq4.peek().value;

        for(int i=k;i<arr.length;i++){
            while(!pq4.isEmpty() && pq4.peek().idx<=(i-k)){
                pq4.remove();
            }
            pq4.add(new Block(arr[i], i));
            ans[i-k+1]=pq4.peek().value;
        }     
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
        System.out.println();

        //Minimum time required to fill given N slots
        int arr2[]={2,6};
        int n=6,k2=2;
        System.out.println("Minimum time taken = "+minTime(arr2, n, k2));



    }    
}
