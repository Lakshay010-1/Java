package Graph;
import java.util.*;

//Topological Sort
public class Graph_03 {
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

    //topological sorting (dependency){ is used only for DAG(Directed Acyclic Graph),
      //it is used to get linear order of vertices such that every directed edge u->v,the vertex 'u' comes before 'v' in the order.}
      
    //topological Sort (using DFS) ~ TC-0(Vertices+Edges)
    public static void topSort(ArrayList<Edge> graph[]){
        boolean vis[]=new boolean[graph.length];
        Stack<Integer> s=new Stack<>();
        //traversing through every vertex;
        for(int i=0;i<graph.length;i++){
            if(!vis[i]){
                topSortUtil(graph,i,vis,s);
            }
        }
        while(!s.isEmpty()){
            System.out.print(s.pop()+" ");
        }
        System.out.println();
    }
    private static void topSortUtil(ArrayList<Edge> graph[],int src,boolean vis[],Stack<Integer> s){
        vis[src]=true;
        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            //if neighbour is un-visited
            if(!vis[e.dest]){
                topSortUtil(graph, e.dest, vis, s);
            }
        }
        //push in stack
        s.push(src);
    }
  
    //topological sort (using BFS) ~ TC-0(Vertices*Edges)
    public static void KahnSort(ArrayList<Edge> graph[]){
        int inDe[]=new int[graph.length];
        //calculate incoming edges
        calInDe(graph, inDe);
        Queue<Integer> q=new LinkedList<>();
        
        //add nodes which have 0 incoming edges
        for(int i=0;i<inDe.length;i++){
            if(inDe[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int cur=q.remove();
            System.out.print(cur+" ");
            //traversing neighbours
            for(int i=0;i<graph[cur].size();i++){
                Edge e=graph[cur].get(i);
                //decrement neighbour incoming edges count
                inDe[e.dest]--;
                //if indegree is 0 add neighbour in the queue
                if(inDe[e.dest]==0){
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }
    private static void calInDe(ArrayList<Edge> graph[],int inDe[]){
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e=graph[i].get(j);
                inDe[e.dest]++;
            }
        }
    }


    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        //Creating a Graph
        int vertices=6;
        ArrayList<Edge> graph[]=new ArrayList[vertices];
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        // //bi-directed and dis-connected graph.
       
        graph[2].add(new Edge(2,3,1));
        graph[3].add(new Edge(3,1,1));
        graph[4].add(new Edge(4,0,1));
        graph[4].add(new Edge(4,1,1));
        graph[5].add(new Edge(5,0,1));
        graph[5].add(new Edge(5,2,1));
        
        System.out.print("topological sort using dfs :");
        topSort(graph);
        System.out.print("topological sort using bfs :");
        KahnSort(graph);

    }
    
}
