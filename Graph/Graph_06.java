package Graph;
import java.util.*;

//Prim’s algorithm
public class Graph_06 { 
    static class Edge{
        int weight;
        int dest;
        int src;
        public Edge(int src,int dest,int weight){
            this.src=src;
            this.dest=dest;
            this.weight=weight;
        }
    }
    static class Pair implements Comparable<Pair>{
        int v;
        int wt;
        public Pair(int v,int wt){
            this.v=v;
            this.wt=wt; 
        }
        @Override
        public int compareTo(Pair p){
            return this.wt-p.wt;
        }
    }

    //prims algorithm  ~ TC - 0(V+E)
    public static void prims(ArrayList<Edge> graph[]){
        boolean vis[]=new boolean[graph.length];
        int finalCost=0;//Total Minimum cost
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(0, 0));

        while(!pq.isEmpty()){
            Pair cur=pq.remove();
            if(!vis[cur.v]){
                vis[cur.v]=true;
                finalCost+=cur.wt;
                //edges
                for(int i=0;i<graph[cur.v].size();i++){
                    Edge e=graph[cur.v].get(i);
                    pq.add(new Pair(e.dest, e.weight));
                }
            }
        }
        System.out.println("minimum cost of MST = "+finalCost);
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int vertices=4;
        ArrayList<Edge> graph[] =new ArrayList[vertices];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1,10));
        graph[0].add(new Edge(0, 2,15));
        graph[0].add(new Edge(0, 3,30));

        graph[1].add(new Edge(1, 0,10));
        graph[1].add(new Edge(1, 3,40));

        graph[2].add(new Edge(2, 0,15));
        graph[2].add(new Edge(2, 3,50));

        graph[3].add(new Edge(3, 1,40));
        graph[3].add(new Edge(3, 2,50));

        prims(graph);
    }
}
