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

  void bfs(boolean visited[], int parent[], Queue<Integer> que){
    int s = que.poll();
    for(int i : graph.get(s)){
      if(!visited[i]){
        visited[i] = true;
        parent[i] = s;
        que.add(i);
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

    Queue<Integer> s_que = new LinkedList<Integer>();
    Queue<Integer> e_que = new LinkedList<Integer>();

    s_visited[s] = true;
    e_visited[d] = true;

    s_que.add(s);
    e_que.add(d);

    while(!s_que.isEmpty() && !e_que.isEmpty()){
      bfs(s_visited, s_parent, s_que);
      bfs(e_visited, e_parent, e_que);

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
        System.out.println();
        return;
      }

    }
    System.out.println("No path between "+s+" "+d);

    

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
