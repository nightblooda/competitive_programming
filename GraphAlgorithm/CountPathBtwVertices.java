import java.util.LinkedList;

// works for both directed as well as undirected
public class CountPathBtwVertices {

  int V;
  LinkedList<Integer> graph[];

  CountPathBtwVertices(int v) {
    V = v;
    graph = new LinkedList[V];
    for (int i = 0; i < V; i++) {
      graph[i] = new LinkedList<>();
    }
  }

  void addEdge(int u, int v) {
    graph[u].add(v);
    graph[v].add(u);
  }

  int count(int s, int d, int result, boolean visited[]) {
    if (s == d) {
      result++;
    } else {
      for (int i : graph[s]) {
        if (!visited[i]) {
          visited[i] = true;
          result = count(i, d, result, visited);
          visited[i] = false;
        }
      }
    }
    return result;
  }

  void algo(int s, int d) {
    int result = 0;
    boolean visited[] = new boolean[V];
    visited[s] = true;
    System.out.println("Number of path from " + s + " to " + d + " => " + count(s, d, result, visited));
  }

  public static void main(String args[]) {
    CountPathBtwVertices g = new CountPathBtwVertices(5);
    g.addEdge(0, 1);
    g.addEdge(2, 0);
    g.addEdge(0, 3);
    g.addEdge(1, 3);
    g.addEdge(2, 3);
    g.addEdge(1, 4);
    g.addEdge(4, 2);
    g.algo(0, 3);
  }

}
