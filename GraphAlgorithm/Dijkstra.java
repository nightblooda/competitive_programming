import java.util.Arrays;

public class Dijkstra {
  int V;
  Dijkstra(int v){
    this.V = v;
  }
  int minKey(boolean visited[], int dist[]){
    int idx = -1;
    int temp = Integer.MAX_VALUE;
    for(int i = 0; i < V; i++){
      if(!visited[i] && temp > dist[i]){
        temp = dist[i];
        idx = i;
      }
    }
    return idx;
  }
  void dijkstra(int graph[][], int src){
    int dist[] = new int[V];
    boolean visited[] = new boolean[V];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;
    for(int i = 0; i < V-1; i++){
      int min = minKey(visited, dist);
      visited[min] = true;
      for(int j = 0; j < V; j++){
        if(!visited[j] && graph[i][j] != 0 && dist[i] != Integer.MAX_VALUE && dist[j] > dist[i] + graph[i][j]){
          dist[j] = dist[i] + graph[i][j];
        }
      }
    }
    printGraph(dist);
  }
  void printGraph(int dist[]){
    for(int i = 0; i < V; i++){
      System.out.println(i+"->"+dist[i]);
    }
  }

  public static void main(String args[]){
    Dijkstra g = new Dijkstra(9);
    int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
    { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
    { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
    { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
    { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
    { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
    { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
    { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
    { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
    g.dijkstra(graph, 0); 
  }
}
