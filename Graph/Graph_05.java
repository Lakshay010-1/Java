package Graph;
import java.util.ArrayList;

//Bellman–Ford Algorithm
public class Graph_05 { 
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
    
    //Bellman-ford Algorithm (DP optimisation) {used to find the shortest path form source to all vertices in "positive AND negative weighted Graph"} 
    //~ TC-0(Vertices*Edges)
    public static void bellmanFord(ArrayList<Edge> graph[],int src){
        int V=graph.length;
        int dis[]=new int[V];
        //distance intialisation
        for(int i=0;i<dis.length;i++){
            if(i!=src){
                dis[i]=Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<V-1;i++){
            //Edges
            for(int j=0;j<V;j++){
                for(int k=0;k<graph[j].size();k++){
                    Edge e=graph[j].get(k);
                    if(dis[e.src] != Integer.MAX_VALUE && dis[e.src]+e.weight<dis[e.dest]){
                        //Relaxation
                        dis[e.dest]=dis[e.src]+e.weight;
                    }
                }
            }
        }
        //printing distance
        for(int i=0;i<dis.length;i++){
            System.out.print(dis[i]+" ");
        }
        System.out.println();
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int vertices=5;
        ArrayList<Edge> graph[]=new ArrayList[vertices];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        //directed and connected graph.
        graph[0].add(new Edge(0, 1,2));
        graph[0].add(new Edge(0, 2,4));
        graph[1].add(new Edge(1, 2,-4));
        graph[2].add(new Edge(2, 3,2));
        graph[3].add(new Edge(3, 4,4));
        graph[4].add(new Edge(4, 1,-1));
        bellmanFord(graph, 0);
    }
}
