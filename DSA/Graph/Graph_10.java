package Graph;
import java.util.*;

//Tarjan's Algorithm (Bridges)
public class Graph_10 {
    static class Edge{
        int src,dest,wt;
        Edge(int s,int d,int w){
            this.src=s;
            this.wt=w;
            this.dest=d;
        }
    }

    //tarjan's Algorithm to find the bridge in the graph(DFS) ~ TC - 0(V+E) ,SC - 0(V)
    public static ArrayList<ArrayList<Integer>> tarjanBridge(ArrayList<Edge> graph[],int V){
        boolean vis[]=new boolean[V];
        int dt[]=new int[V];
        int low[]=new int[V];
        int time=0;
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();

        for(int i=0;i<V;i++){
            if(!vis[i]){
                tarjanBridgeUtil(graph, i, -1, vis, dt, low, time,result);
            }
        }
        return result;
    }
    public static void tarjanBridgeUtil(ArrayList<Edge> graph[],int cur,int par,boolean vis[],int dt[],int low[],int time,ArrayList<ArrayList<Integer>> result){
        vis[cur]=true;
        dt[cur]=low[cur]=++time;

        for(int i=0;i<graph[cur].size();i++){
            Edge e=graph[cur].get(i);
            //if neighbour is parent ,then ignore
            if(e.dest==par){
                continue;
            }
            //if neighbour is unvisited, then perform (1)dfs,then (2)compare low[u]=Min( low[u] with low[v] ), then (3)check bridge condition 
            else if(!vis[e.dest]){
                tarjanBridgeUtil(graph, e.dest, e.src, vis, dt, low, time,result);
                low[e.src]=Math.min(low[e.src],low[e.dest]);
                if(dt[e.src]<low[e.dest]){
                    ArrayList<Integer> list=new ArrayList<>();
                    list.add(e.src);
                    list.add(e.dest);
                    result.add(list);                    
                }
            }
            //if neighbour is visited, then compare low[u]=Min(low[u],dt[v])
            else{
                low[e.src]=Math.min(low[e.src],dt[e.dest]);
            }
        }

    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge> graph[]=new ArrayList[V];
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,1)); 
        graph[0].add(new Edge(0,2,1));
        graph[0].add(new Edge(0,3,1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 1, 1));

        graph[3].add(new Edge(3, 0, 1));
        graph[3].add(new Edge(3, 4, 1));
        
        graph[4].add(new Edge(4, 3, 1));
        ArrayList<ArrayList<Integer>> result=tarjanBridge(graph, V);
        for(int i=0;i<result.size();i++){
            System.out.println(result.get(i));
        }
        
    }
}
