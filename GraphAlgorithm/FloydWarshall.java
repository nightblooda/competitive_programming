public class FloydWarshall {

  final static int INF = 9999;
  int V;

  FloydWarshall(int v){
    V = v;
  }

  void algo(int graph[][]){
    for(int k = 0; k < V; k++){
      for(int i = 0; i < V; i++){
        for(int j = 0; j < V; j++){
          if(graph[i][j] > graph[i][k] + graph[k][j]){
            graph[i][j] = graph[i][k] + graph[k][j];
          }
        }
      }
    }
    printGraph(graph);
  }
  
  void printGraph(int graph[][]){
    for(int i = 0; i < V; i++){
      for(int j = 0; j < V; j++){
        if(graph[i][j] == INF){
          System.out.print("INF ");
        }else{
          System.out.print(graph[i][j]+" ");
        }
      }
      System.out.println();
    }
  }

  public static void main(String args[]){
    int graph[][] = { {0,   5,  INF, 10}, 
                          {INF, 0,   3, INF}, 
                          {INF, INF, 0,   1}, 
                          {INF, INF, INF, 0} 
                        }; 
    FloydWarshall g = new FloydWarshall(4);
    g.algo(graph);                    
  }
  
}
