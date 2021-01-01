import java.util.LinkedList;
import java.util.Queue;

public class BFS {

  int V;
  LinkedList<Integer> graph[];
  BFS(int v) {
    this.V = v;
    graph = new LinkedList[v];
    for(int i = 0; i < v; i++){
      graph[i] = new LinkedList<>();
    }
  }
  void addEdge(int u, int v){
    graph[u].add(v);
  }
  void bfs(int root){
    boolean visited[] = new boolean[V];
    Queue<Integer> que = new LinkedList<>();
    que.add(root);
    visited[root] = true;
    while(!que.isEmpty()){
      int temp = que.poll();
      System.out.print(temp);
      for(int i : graph[temp]){
        if(!visited[i]){
          que.add(i);
          visited[i] = true;
        }
      }
      if(!que.isEmpty()){
        System.out.print("->");
      }
    }
  }
  public static void main(String args[]){
    BFS g = new BFS(4);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);
    g.bfs(2);
  }
}