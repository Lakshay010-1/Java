package Graph;
import java.util.PriorityQueue;
import java.util.ArrayList;

//Dijkstra's Algorithm
public class Graph_04 {
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
        int ver;
        int pathDis;
        public Pair(int v,int pd){
            this.ver=v;
            this.pathDis=pd;
        }

        @Override
        public int compareTo(Pair p){
            //pathDis based sorting for Pair
            return this.pathDis-p.pathDis;
        }

    }

    //dijkstra Algorithm {used to find the shortest path form source to all vertices in "weighted Graph"} 
    //~ TC-0(Vertices+Edges.log(Vertices)) Or TC-0(Vertices^2)
    public static void dijkstra(ArrayList<Edge> graph[],int src){
        int dis[]=new int[graph.length];
        boolean vis[]=new boolean[graph.length];

        //initialising distance; dis[src]=0;else dis[i]=Integer.MAX_VALUE
        for(int i=0;i<dis.length;i++){
            if(i!=src){
                dis[i]=Integer.MAX_VALUE;
            }
        }
        
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        //add source Pair in the PriQueue
        pq.add(new Pair(src, dis[src]));

        while(!pq.isEmpty()){
            Pair cur=pq.remove();
            //if cur is unvisited
            if(!vis[cur.ver]){
                vis[cur.ver]=true;
                //traversing through neighbour
                for(int i=0;i<graph[cur.ver].size();i++){
                    Edge e=graph[cur.ver].get(i);
                    int u=e.src,v=e.dest;
                    int wt=e.weight;
                    //if new Path distance is lesser than before
                    if(dis[v]>dis[u]+wt){
                        //update the distance
                        dis[v]=dis[u]+wt;
                        //also add in the PriQueue
                        pq.add(new Pair(v, dis[v]));
                    }
                }
            }
        }
        
        //Print distance 
        for(int i=0;i<dis.length;i++){
            System.out.println("Distance from src to "+i+" = "+dis[i]+" ; ");
        }

    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        //Creating a Graph
        int vertices=4;
        ArrayList<Edge> graph[]=new ArrayList[vertices];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        //directed and connected graph.
        graph[0].add(new Edge(0, 2,4));
        graph[0].add(new Edge(0, 1,3));
        graph[1].add(new Edge(1, 3,6));
        graph[2].add(new Edge(2, 3,5));

        dijkstra(graph, 0);

        
    }
    
}
