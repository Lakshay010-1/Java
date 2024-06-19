package Graph;
import java.util.ArrayList;
import java.util.Collections;

//Disjoint set Data Structure AND Kruskal's Algorithm
public class Graph_08 {
    static class Edge implements Comparable<Edge>{
        int src,dest,wt;

        public Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }

        @Override
        public int compareTo(Edge e){
            return this.wt- e.wt;
        }
    }
    static int n;
    static int par[];
    static int rank[];
    
    public static void init(int V){
        n=V;
        par=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            par[i]=i;
        }
    }

    //find operation of union-find algorithm ~ TC-0(4k)=0(1) //k is some constant
    public static int find(int x){
        if(par[x]==x){
            return x;
        }
        return par[x]=find(par[x]);
    }

    //union operation of union-find algorithm ~ TC-0(4k)=0(1) //k is some constant
    public static void union(int a,int b){
        int parA=find(a);
        int parB=find(b);
        if(rank[parA]==rank[parB]){
            par[parB]=parA;
            rank[parA]++;
        }
        else if(rank[parA]>rank[parB]){
            par[parB]=parA;
        }
        else{
            par[parA]=parB;
        }
    }
    public static void createMap(ArrayList<Edge> edges){
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    //kruskal's Algorithm ~ TC -0(V)+0(E.logE)
    public static int kruskalMST(ArrayList<Edge> edges,int V){
        init(V);
        Collections.sort(edges);//0(E.logE)
        int minCost=0,edgeCount=0;
        for(int i=0;edgeCount<V-1;i++){//0(V)
            Edge e=edges.get(i);
            int parA=find(e.src);
            int parB=find(e.dest);
            if(parA!=parB){
                union(e.src,e.dest);
                minCost+=e.wt;
                edgeCount++;
            }
        }
        return minCost;
    }
    public static void main(String[] args) {
        int V=4;
        ArrayList<Edge> edges=new ArrayList<>();
        createMap(edges);
        System.out.println("minimum total cost/weight of MST is : "+kruskalMST(edges, V));
        
    }    
}
