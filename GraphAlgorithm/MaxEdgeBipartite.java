//Maximum number of edges to be added to a tree so that it stays a Bipartite graph

import java.util.Vector;

public class MaxEdgeBipartite {
  
  public static int V = 5;
  public static int result[] = new int[2];
  public static int getCount(Vector<Integer> graph[]){
    count(graph, 0, -1, true);
    return result[0]*result[1] - V + 1;
  }

  public static void count(Vector<Integer> graph[], int s, int d, boolean dir){
    result[dir == true ? 0 : 1]++;
    for(int i : graph[s]){
      if(i != d){
        count(graph, i, s, !dir);
      }
    }
  }
  public static void main(String args[]){
    Vector<Integer> graph[] = new Vector[V];
    for(int i = 0; i < V; i++){
      graph[i] = new Vector<>();
    }
    graph[0].add(1); 
    graph[0].add(2); 
    graph[1].add(3); 
    graph[2].add(4); 
    System.out.println("Max number of edge that can be added: " + getCount(graph));
  }
}
