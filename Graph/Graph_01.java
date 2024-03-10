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
        boolean vis[]=new boolean[graph.length];
        //traversing through every vertex to check if they are visited or not;
        //(this is to overcome the limitation of disconnected graph)
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                bfsUtil(graph,vis,i);
            }
        }
    }
    private static void bfsUtil(ArrayList<Edge> graph[],boolean vis[],int src){
        Queue<Integer> q=new LinkedList<>();

        q.add(src);
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
    }
    
    //Depth first search ~ TC-0(Vertices+Edges)
    public static void dfs(ArrayList<Edge> graph[]){
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                dfsUtil(graph, vis, i);
            }
        }

    }
    private static void dfsUtil(ArrayList<Edge> graph[],boolean vis[],int src){
        System.out.print(src+" ");
        vis[src]=true;
        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            if(!vis[e.dest]){
                dfsUtil(graph,vis,e.dest);
            }
        }
    }
    
    //Find if there exist a path from point src to point dest in the graph.(dfs approach) ~ TC-0(Vertices+Edges)
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

    //detect cycle in an undirected graph(dfs approach) ~ TC-0(Vertices+Edges)
    public static boolean detectCycle(ArrayList<Edge> graph[]){
        boolean vis[]=new boolean[graph.length];
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                if(detectCycleUtil(graph,vis,i,-1)){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean detectCycleUtil(ArrayList<Edge> graph[],boolean vis[],int cur,int par){
        vis[cur]=true;
        for(int i=0;i<graph[cur].size();i++){
            Edge e=graph[cur].get(i);
            //case-1.neighbour is un-visited
             if(!vis[e.dest] ){
                if(detectCycleUtil(graph, vis, e.dest, cur)){
                    return true;
                }
            }   
            //case-2.neighbour is visited but it's not the parent that means it a cycle
             else if(vis[e.dest] && e.dest!=par){
                return true;
            }
            //case-3.neighbour is visited but it's the parent that doesn't specifies anything
            //so in this case "continue";
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        //Creating a Graph
        int vertices=9;
        ArrayList<Edge> graph[]=new ArrayList[vertices];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        // //bi-directed and dis-connected graph.
        graph[0].add(new Edge(0,3,1));
        graph[0].add(new Edge(0,1,1));
        graph[1].add(new Edge(1,0,1));
        graph[1].add(new Edge(1,2,1));
        graph[2].add(new Edge(2,4,1));
        graph[2].add(new Edge(2,1,1));
        graph[3].add(new Edge(3,0,1));
        graph[3].add(new Edge(3,4,1));
        graph[3].add(new Edge(3,5,1));
        graph[4].add(new Edge(4,2,1));
        graph[4].add(new Edge(4,3,1));
        graph[4].add(new Edge(4,5,1));
        graph[5].add(new Edge(5,3,1));
        graph[5].add(new Edge(5,4,1));
        graph[6].add(new Edge(6,6,1));
        graph[7].add(new Edge(7,8,1));
        graph[8].add(new Edge(8,7,1));

        //find x's neighbours
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the vertex integer value within range or equal to "+(vertices-1)+" : ");
        int x=sc.nextInt(vertices);
        System.out.print(x+" neighbours = ");
        for(int i=0;i<graph[x].size();i++){
            Edge e=graph[x].get(i);
            System.out.print(e.dest+" ");
        }

        //breadth first search
        System.out.println();
        System.out.print("bfs = ");
        bfs(graph);
        
        //depth first search
        System.out.println();
        System.out.print("dfs = ");
        dfs(graph);

        //Question-> Does path exist from src point to dest point
        System.out.println();
        System.out.print("does path exist :");
       System.out.println( hasPath(graph, new boolean[vertices],0, 6));

       //Find cycle
       System.out.println("cycle exists :"+detectCycle(graph));
       
    }

}