package Graph;
import java.util.*;

public class Graph_02 {
    static class Edge{
        int weight;
        int dest;
        int src;
        public Edge(int src,int dest){
            this.src=src;
            this.dest=dest;
            this.weight=1;
        }
        public Edge(int src,int dest,int weight){
            this.src=src;
            this.dest=dest;
            this.weight=weight;
        }
    }

    //detect cycle in a directed graph ~ TC-0(Vertices+Edges)
    public static boolean detectCycle(ArrayList<Edge> graph[]){
        boolean vis[]=new boolean[graph.length];
        boolean stack[]=new boolean[graph.length];

        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(detectCycleUtil(graph,i,vis,stack)){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean detectCycleUtil(ArrayList<Edge> graph[],int cur,boolean vis[],boolean stack[]){
        vis[cur]=true;
        stack[cur]=true;
        for(int i=0;i<graph[cur].size();i++){
            Edge e=graph[cur].get(i);
            //cycle condition where in recursion call stack e's(e.dest) is already true;
            if(stack[e.dest]){
                return true;
            }
            if(!vis[e.dest]){
                if(detectCycleUtil(graph, e.dest, vis, stack)){
                    return true;
                }
            }
        }
        stack[cur]=false;
        return false;
    }
    
    //print all path from source to destination vertex ~ TC-0(Vertices^Vertices);
    public static void allPath(ArrayList<Edge> graph[],int cur,int dest,String path){
        if(cur==dest){
            System.out.println(path+cur);
            return ;
        }
        for(int i=0;i<graph[cur].size();i++){
            Edge e=graph[cur].get(i);
            allPath(graph, e.dest, dest, path+cur+" ");
        }


    }

    //check whether the given graph is bi-partite or not; ~ TC- 0(Vertices+Edges){Modified BFS}
    public static boolean isBipartite(ArrayList<Edge> graph[]){
        int col[]=new int[graph.length];
        Queue<Integer> q=new LinkedList<>();
        //Colour: -1 represents no colour,0 represents colour1,1 represents colour2
        //intialising no colour to all vertices
        for(int i=0;i<col.length;i++){
            col[i]=-1;
        }
        for(int i=0;i<graph.length;i++){
            //if vertex is uncoloured(unvisited)
            if(col[i]==-1){
                if(!isBipartiteUtil(graph,i,col,q)){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isBipartiteUtil(ArrayList<Edge> graph[],int src,int col[],Queue<Integer> q){
        //source colour = c1;
        col[src]=0;
        q.add(src);
        while(!q.isEmpty()){
            int cur=q.remove();
            for(int i=0;i<graph[cur].size();i++){
                Edge e=graph[cur].get(i);
                //if neighbour is uncoloured/unvisited
                if(col[e.dest]==-1){
                    col[e.dest]=col[cur]==0?1:0;
                    q.add(e.dest);
                }
                //& if neighbour's colour is same as it parent
                else if(col[e.dest]==col[cur]){
                    return false;
                }
            }
        }
        return true;
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
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 3));

        boolean cycle=detectCycle(graph);
        System.out.println("Cycle exists :"+cycle);
        allPath(graph, 0, 3, "");
        System.out.println("isBipartite : "+isBipartite(graph));

        
    }

}
