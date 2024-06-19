package Graph;
import java.util.*;

public class Graph_07{
    static class Edge implements Comparable<Edge>{
        int dest,wt;
        Edge(int d,int w){
            this.dest=d;
            this.wt=w;
        }
        public int compareTo(Edge e){
            return this.wt-e.wt;
        }
    }
    
    //Connecting citites with minimum cost(using prim's algorithm) ~ TC - 0(V+E)
    public static int connectingCitites(int cities[][]){
        PriorityQueue<Edge> pq=new PriorityQueue<>();
        boolean vis[]=new boolean[cities.length];
        int cost=0;
        pq.add(new Edge(0, 0));
        while(!pq.isEmpty()){
            Edge cur=pq.remove();
            if(!vis[cur.dest]){
                vis[cur.dest]=true;
                cost+=cur.wt;
                for(int i=0;i<cities[cur.dest].length;i++){
                    if(cities[cur.dest][i]!=0){
                        pq.add(new Edge(i,cities[cur.dest][i]));
                    }
                }
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        int cities[][]={{0,1,2,3,4},{1,0 ,5,0,7},{2,5,0,6,0},{3,0,6,0,0},{4,7,0,0,0}};
        int finalCost=connectingCitites(cities);
        System.out.println("final cost of connecting cities is : "+finalCost);
        
        
    }

} 