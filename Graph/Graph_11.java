package Graph;
import java.util.*;

//Tarjan's Algorithm (Articulation Point)
public class Graph_11 {
    static class Edge{
        int src,dest,wt;
        Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    public static void tarjanAP(ArrayList<Edge> graph[],int V){
        boolean vis[]=new boolean[V];
        //to avoid outputing same Articular point multiple times
        boolean AP[]=new boolean[V];
        int dt[]=new int[V];
        int low[]=new int[V];
        int time=0;

        for(int i=0;i<V;i++){
            if(!vis[i]){
                tarjanAPUtil(graph,i,-1,dt,low,time,vis,AP);
            }
        }

        //printing Articular point
        int j=1;
        for(int i=0;i<V;i++){
            if(AP[i]){
                System.out.println("AP"+j+" is "+i);
                j++;
            }
        }
    }
    public static void tarjanAPUtil(ArrayList<Edge> graph[],int cur,int par,int dt[],int low[],int time,boolean vis[],boolean AP[]){
        vis[cur]=true;
        dt[cur]=low[cur]=++time;
        //children= total unvisited neighbour 
        int children=0;
        for(int i=0;i<graph[cur].size();i++){
            Edge e=graph[cur].get(i);
            // if neighbour is parent
            if(e.dest==par){
                continue;
            }
            //if neighbour is visited
            else if(vis[e.dest]){
                low[cur]=Math.min(low[cur],dt[e.dest]);
            }
            // neighbour is un-visited
            else{
                tarjanAPUtil(graph,e.dest,cur,dt,low,time,vis,AP);
                low[cur]=Math.min(low[cur],low[e.dest]);
                children++;
                //Articular point condition-1 {if cur node is not starting node and discoveryTime of cur node is less or equal to lowTime of neighbour}
                if(par!=-1 && dt[cur]<=low[e.dest]){
                    AP[cur]=true;
                }
            }
        }
        //Articular point condition-2 {if cur node is starting node and has atleast 2 children(disconnected neighbour)}
        if(par==-1 && children>1){
            AP[cur]=true;
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        int V=5;
        ArrayList<Edge> graph[]=new ArrayList[V];
        
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }
        
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[0].add(new Edge(0, 3, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 1, 1));

        graph[3].add(new Edge(3, 0, 1));
        graph[3].add(new Edge(3, 4, 1));

        graph[4].add(new Edge(4, 3, 1));

        tarjanAP(graph, V);
        
    }    
}
