import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
public class BidirectionalSearch {
  
  int V;
  ArrayList<ArrayList<Integer>> graph;
  BidirectionalSearch(int v){
    V = v;
    graph = new ArrayList<ArrayList<Integer>>();
    for(int i = 0; i < V; i++){
      graph.add(new ArrayList<Integer>());
    }
  }

  void addEdge(int u, int v){
    graph.get(u).add(v);
    graph.get(v).add(u);
  }

  void bfs(boolean visited[], int parent[], int s){
    Queue<Integer> que = new LinkedList<Integer>();
    que.add(s);
    visited[s] = true;
    while(!que.isEmpty()){
      int temp = que.poll();
      for(int i : graph.get(temp)){
        if(!visited[i]){
          visited[i] = true;
          parent[i] = temp;
          que.add(i);
        }
      }
    }
  }

  void join(ArrayList<Integer> path, int intersection, int parent[], int s){
    while(intersection != s){
      path.add(parent[intersection]);
      intersection = parent[intersection];
    }
  }
  void algo(int s, int d){
    boolean s_visited[] = new boolean[V];
    boolean e_visited[] = new boolean[V];

    int s_parent[] = new int[V];
    int e_parent[] = new int[V];

    s_parent[s] = -1;
    e_parent[d] = -1;

    bfs(s_visited, s_parent, s);
    bfs(e_visited, e_parent, d);

    int intersection = -1;
    
    for(int i = 0; i < V; i++){
      if(s_visited[i] && e_visited[i]){
        intersection = i;
        break;
      }
    }

    ArrayList<Integer> path = new ArrayList<Integer>();
    if(intersection != -1){
      path.add(intersection);
      join(path, intersection, s_parent, s);
      Collections.reverse(path);
      join(path, intersection, e_parent, d);
      System.out.println("Path between "+s+" "+d+":");
      for(int i = 0; i < path.size(); i++){
        System.out.print(path.get(i)+" ");
      }
    }else{
      System.out.println("No path exist between "+s+" "+d);
    }
  }

  public static void main(String args[]){
    BidirectionalSearch bs = new BidirectionalSearch(15);
    bs.addEdge(0, 4);
    bs.addEdge(1, 4);
    bs.addEdge(2, 5);
    bs.addEdge(3, 5);
    bs.addEdge(4, 6);
    bs.addEdge(5, 6);
    bs.addEdge(6, 7);
    bs.addEdge(7, 8);
    bs.addEdge(8, 9);
    bs.addEdge(8, 10);
    bs.addEdge(9, 11);
    bs.addEdge(9, 12);
    bs.addEdge(10, 13);
    bs.addEdge(10, 14);
    bs.algo(0, 14);
  }
}
