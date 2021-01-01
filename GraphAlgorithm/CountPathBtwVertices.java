import java.util.LinkedList;

public class CountPathBtwVertices {

  int V;
  LinkedList<Integer> graph[];

  CountPathBtwVertices(int v){
    V = v;
    graph = new LinkedList[V];
    for(int i = 0; i < V; i++){
      graph[i] = new LinkedList<>();
    }
  }

  void addEdge(int u, int v){
    graph[u].add(v);
  }

  int count(int s, int d, int result){
    if(s == d){
      result++;
    }else{
      for(int i : graph[s]){
        result = count(i, d, result);
      }
    }
    return result;
  }

  void algo(int s, int d){
    int result = 0;
    System.out.println("Number of path from "+s+" to "+d+" => "+ count(s, d, result));
  }

  public static void main(String args[]){
    CountPathBtwVertices g = new CountPathBtwVertices(5);
    g.addEdge(0, 1); 
    g.addEdge(0, 2); 
    g.addEdge(0, 3); 
    g.addEdge(1, 3); 
    g.addEdge(2, 3); 
    g.addEdge(1, 4); 
    g.addEdge(2, 4); 
    g.algo(0, 3);
  }
  
}
