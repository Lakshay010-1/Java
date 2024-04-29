package Graph;

//Floyd_Warshall's Algorithm ~ TC-0(V^3) and SC-0(V^2)
public class Graph_13 { 

    public static int[][] floyd(int graph[][]){
        int V=graph.length;
        int dist[][]=new int[V][V];
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                dist[i][j]=graph[i][j];
            }
        }
        for(int k=0;k<V;k++){
            for(int i=0;i<V;i++){
                for(int j=0;j<V;j++){
                    if(dist[i][k]==Integer.MAX_VALUE || dist[k][j]==Integer.MAX_VALUE){
                        continue;
                    }
                    dist[i][j]=Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }

        return dist;
    }
  
    public static void main(String[] args) {
        int inf=Integer.MAX_VALUE;
        //adjacency matrix
        int graph[][]={
            {0,2,4,inf,inf},
            {inf,0,-4,inf,inf},
            {inf,inf,0,2,inf},
            {inf,inf,inf,0,4},
            {inf,-1,inf,inf,0}
        };        

        int dist[][]=floyd(graph);
        int V=dist.length;
        //print distance
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(dist[i][j]==inf){
                    System.out.print("inf ");
                    continue;
                }
                System.out.print(dist[i][j]+" ");
            }
            System.out.println();
        }

        //negative cycle condition
        for(int i=0;i<V;i++){
            if(dist[i][i]<0){
                System.out.println("this graph contains negative cycle.");                
            }
        }
        
    }    
}
