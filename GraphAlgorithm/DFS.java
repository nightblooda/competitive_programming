import java.util.LinkedList;

public class DFS {
  
  int V;
  LinkedList<Integer> graph[];
  DFS(int v) {
    this.V = v;
    graph = new LinkedList[v];
    for(int i = 0; i < v; i++){
      graph[i] = new LinkedList<>();
    }
  }
  void addEdge(int u, int v){
    graph[u].add(v);
  }
  void dfs(int root){
    boolean visited[] = new boolean[V];
    dfsUtil(root, visited);
  }
  void dfsUtil(int root, boolean visited[]){
    visited[root] = true;
    System.out.print(root);
    for(int i : graph[root]){
      if(!visited[i]){
        System.out.print("->");
        dfsUtil(i, visited);
      }
    }
  }
  public static void main(String args[]){
    DFS g = new DFS(4);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);
    g.dfs(2);
  }
}
