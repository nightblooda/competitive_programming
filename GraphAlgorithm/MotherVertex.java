import java.util.ArrayList;

// A vertex from which we can reach to all the vertices, such a vertex is called Mother vertex.
public class MotherVertex {

  int V, E;
  ArrayList<ArrayList<Integer>> graph;
  
  MotherVertex(int v, int e){
    V = v;
    E = e;
    graph = new ArrayList<ArrayList<Integer>>();
    for(int i = 0; i < V; i++){
      graph.add(new ArrayList<Integer>());
    }
  }

  void addEdge(int u, int v){
    graph.get(u).add(v);
  }

  void dfs(boolean visited[], int s){
    visited[s] = true;
    for(int i : graph.get(s)){
      if(!visited[i]){
        dfs(visited, i);
      }
    }
  }

  void algo(){
    boolean visited[] = new boolean[V];
    int v = -1;
    for(int i = 0; i < V; i++){
      if(!visited[i]){
        dfs(visited, i);
        v = i;
      }
    }
    boolean check[] = new boolean[V];
    if(v == -1){
      System.out.println("No mother vertex exist for this graph.");
      return;
    }
    dfs(check, v);
    for(int i = 0; i < V; i++){
      if(!check[i]){
        System.out.println("No mother vertex exist for this graph.");
        return;
      }
    }
    System.out.println("Mother vertex is : "+v);
    return;
  }

  public static void main(String args[]){
    MotherVertex mv = new MotherVertex(7, 8);
    mv.addEdge(0, 1); 
    mv.addEdge(0, 2); 
    mv.addEdge(1, 3); 
    mv.addEdge(4, 1); 
    mv.addEdge(6, 4); 
    mv.addEdge(5, 6); 
    mv.addEdge(5, 2); 
    mv.addEdge(6, 0);
    mv.algo();
  }

}