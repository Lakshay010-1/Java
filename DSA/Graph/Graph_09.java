package Graph;
import java.util.*;

//Kosaraju's Algorithm
public class Graph_09 {
    static class Edge{
        int src,dest,wt;
        Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }

    //Kosaraju Algorithm ~ TC-0(Vertices+Edges)
    public static void kosaraju(ArrayList<Edge> graph[],int V){

        //Step.1-get nodes in stack in topological sort Order.
        Stack<Integer> s=new Stack<>();
        boolean vis[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){                
                topSort(graph,i,vis,s);
            }
        }

        //Step.2-transpose the graph. ~ TC -0(Vertices+Edges)
        @SuppressWarnings("unchecked")
        ArrayList<Edge> transpose[]=new ArrayList[V];
        for(int i=0;i<V;i++){
            vis[i]=false;
            transpose[i]=new ArrayList<>();
        }
        for(int i=0;i<V;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e=graph[i].get(j);
                //reverse Edge.
                transpose[e.dest].add(new Edge(e.dest,e.src,e.wt));
            }
        }

        //Step.3-perform dfs on nodes according to stack order on transpose graph.
        int count=1;
        while(!s.isEmpty()){
            int cur=s.pop();
            if(!vis[cur]){
                System.out.print("SCC"+count+" -> ");
                dfs(transpose,cur,vis);
                System.out.println();
                count++;
            }
        }
    }

    //Topological Sort ~ TC -0(Vertices+Edges)
    public static void topSort(ArrayList<Edge> graph[],int cur,boolean vis[],Stack<Integer> s){
        vis[cur]=true;
        for(int i=0;i<graph[cur].size();i++){
            Edge e=graph[cur].get(i);
            if(!vis[e.dest]){
                topSort(graph, e.dest, vis, s);
            }
        }
        s.push(cur);
    }

    //DFS ~ TC -0(Vertices+Edges)
    public static void dfs(ArrayList<Edge> graph[],int cur,boolean vis[]){
        vis[cur]=true;
        System.out.print(cur+" ");
        for(int i=0;i<graph[cur].size();i++){
            Edge e=graph[cur].get(i);
            if(!vis[e.dest]){
                dfs(graph,e.dest,vis);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int V=7;
        ArrayList<Edge> graph[]=new ArrayList[V];
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,2,1));
        graph[1].add(new Edge(1,0,1));
        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,5,1));
        graph[3].add(new Edge(3,3,1));
        graph[4].add(new Edge(4,6,1));
        graph[5].add(new Edge(5,4,1));
        graph[6].add(new Edge(6,5,1));

        kosaraju(graph,V);
        
    }
}
