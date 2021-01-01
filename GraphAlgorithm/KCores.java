import java.util.ArrayList;

//K-cores of graph are connected components that are left after removing vertices of degree less than k
public class KCores {

  int V;
  int K;
  ArrayList<ArrayList<Integer>> graph;

  KCores(int v, int k){
    V = v;
    K = k;
    graph = new ArrayList<ArrayList<Integer>>();
    for(int i = 0; i < v; i++){
      graph.add(new ArrayList<Integer>());
    }
  }

  void addEdge(int u, int v){
    graph.get(u).add(v);
    graph.get(v).add(u);
  }

  boolean dfs(int start, boolean visited[], int degree[]){
    visited[start] = true;
    for(int itr : graph.get(start)){
      if(degree[start] < K){
        degree[itr]--;
      }
      if(!visited[itr]){
        if(dfs(itr, visited, degree)){
          degree[start]--;
        }
      }
    }
    return degree[start] < K;
  }

  void algo(){
    int degree[] = new int[V];
    for(int i = 0; i < V; i++){
      degree[i] = graph.get(i).size();
    }
    boolean visited[] = new boolean[V];
    dfs(0, visited, degree);
    for(int i = 0; i < V; i++){
      if(!visited[i]){
        dfs(i, visited, degree);
      }
    }

    for(int i = 0; i < V; i++){
      if(degree[i] >= K){
        System.out.print(i+"=>");
        for(int j : graph.get(i)){
          if(degree[j] >= K)
            System.out.print(j+" ");
        }
        System.out.println();
      }
    }
  }

  public static void main(String args[]){
    KCores g1 = new KCores(9, 3);
    g1.addEdge(0, 1); 
        g1.addEdge(0, 2); 
        g1.addEdge(1, 2); 
        g1.addEdge(1, 5); 
        g1.addEdge(2, 3); 
        g1.addEdge(2, 4); 
        g1.addEdge(2, 5); 
        g1.addEdge(2, 6); 
        g1.addEdge(3, 4); 
        g1.addEdge(3, 6); 
        g1.addEdge(3, 7); 
        g1.addEdge(4, 6); 
        g1.addEdge(4, 7); 
        g1.addEdge(5, 6); 
        g1.addEdge(5, 8); 
        g1.addEdge(6, 7); 
        g1.addEdge(6, 8);
        g1.algo();
  }
  
}