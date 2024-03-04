package Graph;
import java.util.*;

public class Graph_01 {
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

    //Breadth first search ~ TC-0(Vertices+Edges)
    public static void bfs(ArrayList<Edge> graph[]){
        Queue<Integer> q=new LinkedList<>();
        boolean vis[]=new boolean[graph.length];
        q.add(0);

        while(!q.isEmpty()){
            int cur=q.remove();
            if(!vis[cur]){
                System.out.print(cur+" ");
                vis[cur]=true;
                for(int i=0;i<graph[cur].size();i++){
                    Edge e=graph[cur].get(i);
                    q.add(e.dest);
                }
            }
        }
        System.out.println();        
    }
    
    public static boolean visitedDFS[];
    //Depth first search ~ TC-0(Vertices+Edges)
    public static void dfs(ArrayList<Edge> graph[],int src){
        System.out.print(src+" ");
        visitedDFS[src]=true;
        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            if(!visitedDFS[e.dest]){
                dfs(graph, e.dest);
            }
        }
    }
    //Find if there exist a path from point src to point dest in the graph.(dfs approach)
    public static boolean hasPath(ArrayList<Edge> graph[],boolean vis[],int src,int dest){
        if(src==dest){
            return true;
        }
        vis[src]=true;
        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            if(!vis[e.dest] && hasPath(graph, vis,e.dest, dest)){
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        //Creating a Graph
        int vertices=7;
        ArrayList<Edge> graph[]=new ArrayList[vertices];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        // //bi-directed and connected graph.
        graph[0].add(new Edge(0,1,1));
        graph[0].add(new Edge(0,2,1));
        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,3,1));
        graph[2].add(new Edge(2,0,1));
        graph[2].add(new Edge(2,4,1));
        graph[3].add(new Edge(3,1,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));
        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));
        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[5].add(new Edge(5,6,1));
        graph[6].add(new Edge(6,5,1));
        //find x's neighbours
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the vertex integer value within range which is "+(vertices-1)+" : ");
        int x=sc.nextInt(vertices);
        System.out.print(x+" neighbours = ");
        for(int i=0;i<graph[x].size();i++){
            Edge e=graph[x].get(i);
            System.out.print(e.dest+" ");
        }
        System.out.println();
        System.out.print("bfs = ");
        bfs(graph);
        visitedDFS=new boolean[vertices];
        System.out.print("dfs = ");
        dfs(graph, 0);
        System.out.println();
        System.out.println("does path exist :"+hasPath(graph, new boolean[vertices],0, 6));
       
    }

}