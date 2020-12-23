import java.util.ArrayList;
import java.util.Arrays;

public class TransitiveClouser {
  
  int V, E;
  ArrayList<ArrayList<Integer>> graph;
  
  TransitiveClouser(int v){
    V = v;
    graph = new ArrayList<ArrayList<Integer>>();
    for(int i = 0; i < V; i++){
      graph.add(new ArrayList<Integer>());
    }
  }

  void addEdge(int u, int v){
    graph.get(u).add(v);
  }

  void dfs(int tc[][], int u, int v){
    tc[u][v] = 1;
    for(int i : graph.get(v)){
      if(tc[u][i] != 1){
        dfs(tc, u, i);
      }
    }
  }
  void algo(){
    int tc[][] = new int[V][V];
    for(int i = 0; i < V; i++){
      dfs(tc, i, i);
    }
    for(int i = 0; i < V; i++){
      System.out.println(Arrays.toString(tc[i]));
    }
  }

  public static void main(String args[]){
    TransitiveClouser g = new TransitiveClouser(4);
    g.addEdge(0, 1); 
    g.addEdge(0, 2); 
    g.addEdge(1, 2); 
    g.addEdge(2, 0); 
    g.addEdge(2, 3); 
    g.addEdge(3, 3);
    
    g.algo();
  }
}
