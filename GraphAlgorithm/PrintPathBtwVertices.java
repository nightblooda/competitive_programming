import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class PrintPathBtwVertices {

  int V;
  ArrayList<Integer> graph[];

  PrintPathBtwVertices(int v){
    V = v;
    graph = new ArrayList[v];

    for(int i = 0; i < V; i++){
      graph[i] = new ArrayList<>();
    }
  }

  boolean notVisited(int s, ArrayList<Integer> temp){
    for(int i = 0; i < temp.size(); i++){
      if(s == temp.get(i)){
        return false;
      }
    }
    return true;
  }

  void print(ArrayList<Integer> temp){
    for(int i = 0; i < temp.size(); i++){
      System.out.print(temp.get(i)+" ");
    }
    System.out.println();
  }

  void findPath(int s, int d){

    Queue<ArrayList<Integer>> que = new LinkedList<>();
    ArrayList<Integer> first = new ArrayList<>();
    first.add(s);
    que.add(first);
    while(!que.isEmpty()){
      ArrayList<Integer> temp = que.poll();
      int last = temp.get(temp.size()-1);
      if(last == d){
        print(temp);
      }
      for(int i : graph[last]){
        if(notVisited(i, temp)){
          ArrayList<Integer> second = new ArrayList<>(temp);
          second.add(i);
          que.add(second);
        }
      }
    }
  }

  public static void main(String args[]){
    PrintPathBtwVertices pp = new PrintPathBtwVertices(4);
    pp.graph[0].add(3);
    pp.graph[0].add(1);
    pp.graph[0].add(2);
    pp.graph[1].add(3);
    pp.graph[2].add(0);
    pp.graph[2].add(1);
    pp.findPath(2, 3);
  }
  
}
