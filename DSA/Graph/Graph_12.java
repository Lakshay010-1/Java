package Graph;
import java.util.*;

//Tarjan's Algorithm(Strongly Connected Components)
public class Graph_12 {
    static class Edge{
        int src,dest,wt;
        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    //tarjan algorithm ~ TC - 0(V+E)
    public static ArrayList<ArrayList<Integer>> tarjanSSC(ArrayList<Edge> graph[],int V){
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        int low[]=new int[V];
        int dt[]=new int[V];
        int time[]={0};
        boolean inStack[]=new boolean[V];
        Stack<Integer> s=new Stack<>();
        Arrays.fill(dt,-1);

        for(int i=0;i<V;i++){
            //traverse un-visited vertex
            if(dt[i]==-1){
                tarjanSSCutil(graph, i, low, dt, s, inStack, time, res);
            }
        }
        
        //sort 2d arraylist in ascending order
        Collections.sort(res,(a,b) -> a.get(0)-b.get(0));
        return res;
    }
    public static void tarjanSSCutil(ArrayList<Edge> graph[],int cur,int low[],int dt[],Stack<Integer> s,
                                    boolean inStack[],int time[],ArrayList<ArrayList<Integer>> res){
      low[cur]=dt[cur]=++time[0];
      inStack[cur]=true;
      s.push(cur);
      
      for(Edge e:graph[cur]){
        if(dt[e.dest]==-1){
            tarjanSSCutil(graph, e.dest, low, dt, s, inStack, time, res);
            low[cur]=Math.min(low[cur],low[e.dest]);
        }
        else if(inStack[e.dest]){
            low[cur]=Math.min(low[cur],dt[e.dest]);
        }
      }

      //head of the SCC
      if(dt[cur]==low[cur]){
        ArrayList<Integer> list=new ArrayList<>();
        for(int node=s.pop();;node=s.pop()){
            inStack[node]=false;
            list.add(node);
            if(node==cur){
                break;
            }
        }
        //sort the arraylist in ascending order
        Collections.sort(list);
        res.add(list);        
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
        ArrayList<ArrayList<Integer>> res=tarjanSSC(graph, V);
        System.out.println(res);        
    }    
}
