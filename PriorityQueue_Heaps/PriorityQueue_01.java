package PriorityQueue_Heaps;
import java.util.PriorityQueue;
import java.util.Arrays;

public class PriorityQueue_01 {
    public static int[] kthLargest(int k, int[] arr, int n) {
        // code here
        if(k<=0){
            return new int[]{};
        }
        int ans[]=new int[n];
        
        for(int i=0;i<k-1;i++){
            ans[i]=-1;
        }
        for(int i=k-1;i<n;i++){
            Arrays.sort(arr,0,i+1);
            ans[i]=arr[k-i-1];
        }
        return ans;
    }
    static class Coordinates implements Comparable<Coordinates>{
        int idx,distance,x,y;

        Coordinates(int x,int y,int dis,int i){
            this.x=x;
            this.y=y;
            this.idx=i;
            this.distance=dis;
        }

        @Override
        public int compareTo(Coordinates c){
            return this.distance-c.distance;
        }
    }

    static class Row implements Comparable<Row>{
        int soldr,idx;
        Row(int soldier,int i){
            this.soldr=soldier;
            this.idx=i;
        }
        @Override
        public int compareTo(Row r){
            if(this.soldr==r.soldr){
                return this.idx-r.idx;
            }
            return this.soldr-r.soldr;
        }
    }

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

    public static void main(String[] args) {

        //Nearest coordinate close to coordinate(0,0);
        PriorityQueue<Coordinates> pq=new PriorityQueue<>();
        int points[][]={{3,3},{5,-1},{-2,4}};
        int k=2;
        for(int i=0;i<points.length;i++){
            int dis=(int)(Math.sqrt((points[i][0]*points[i][0])+(points[i][1]*points[i][1])));
            pq.add(new Coordinates(points[i][0],points[i][1],dis, i));
        }
        for(int i=0;i<k;i++){
            System.out.println("C"+pq.remove().idx);
        }

        //connect n ropes at minimum cost
        PriorityQueue<Integer> pq2=new PriorityQueue<>();
        int ropes[]={4,3,2,6};
        for(int i=0;i<ropes.length;i++){
            pq2.add(ropes[i]);
        }
        int cost=0;
        while (pq2.size()>1) {
            int minn=pq2.remove();
            int minn2=pq2.remove();
            cost+=minn+minn2;
            pq2.add(minn+minn2);
        }
        System.out.println("Cost = "+ cost);

        //weakest soldier row in the n*m  matrix;
        PriorityQueue<Row> pq3 =new PriorityQueue<>();
        int soldier[][]={{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
        for(int i=0;i<soldier.length;i++){
            int count=0;
            for(int j=0;j<soldier[i].length;j++){
                count+=soldier[i][j]==1?1:0;
            }
            pq3.add(new Row(count, i));
        }
        for(int i=0;i<k;i++){
            System.out.println("row"+pq3.remove().idx);
        }

        //Sliding Window maximum
        int arr[]={1,3,-1,-3,5,3,6,7};
        k=3;
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


    }
}
