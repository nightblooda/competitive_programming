import java.util.ArrayList;

//Transpose of a directed graph G is another directed graph on the same set of vertices with all of the edges reversed compared to the orientation of the corresponding edges in G.
public class TransposeGraph {
  
  int V;
  ArrayList<Integer> graph[];
  ArrayList<Integer> transpose[];

  TransposeGraph(int v){
    V = v;
    graph = new ArrayList[V];
    transpose = new ArrayList[V];
    for(int i = 0; i < V; i++){
      graph[i] = new ArrayList<>();
      transpose[i] = new ArrayList<>();
    }
  }

  void addEdge(int u, int v, boolean dir){
    if(dir){
      graph[u].add(v);
    }else{
      transpose[u].add(v);
    }
  }

  void printGraph(boolean dir){
    if(dir){
      System.out.println("Graph representation: ");
      for(int i = 0; i < V; i++){
        System.out.print(i+" => ");
        for(int j : graph[i]){
          System.out.print(j+" ");
        }
        System.out.println();
      }
    }else{
      System.out.println("Transpose of the Graph: ");
      for(int i = 0; i < V; i++){
        System.out.print(i+" => ");
        for(int j : transpose[i]){
          System.out.print(j+" ");
        }
        System.out.println();
      }
    }
  }

  void algo(){
    for(int i = 0; i < V; i++){
      for(int j : graph[i]){
        addEdge(j, i, false);
      }
    }
  }

  public static void main(String args[]){
    TransposeGraph g = new TransposeGraph(5);
    g.addEdge(0, 1, true); 
    g.addEdge(0, 4, true); 
    g.addEdge(0, 3, true); 
    g.addEdge(2, 0, true); 
    g.addEdge(3, 2, true); 
    g.addEdge(4, 1, true); 
    g.addEdge(4, 3, true); 
    
    g.printGraph(true);

    g.algo();

    g.printGraph(false);
  }
}
