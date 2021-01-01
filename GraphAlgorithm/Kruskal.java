import java.util.Arrays;

public class Kruskal {

  class Edge implements Comparable<Edge>{
    int src, dst, weight;
    @Override
    public int compareTo(Kruskal.Edge o) {
      return this.weight - o.weight;
    }
  }

  class Subset {
    int parent, rank;
  }

  int V, E;
  Edge edge[];

  Kruskal(int v, int e){
    V = v;
    E = e;
    edge = new Edge[e];
    for(int i = 0; i < e; i++){
      edge[i] = new Edge();
    }
  }

  int find(int x, Subset subset[]){
    if(subset[x].parent != x){
      subset[x].parent = find(subset[x].parent, subset);
    }
    return subset[x].parent;
  }

  void union(int x, int y, Subset subset[]){
    int xroot = find(x, subset);
    int yroot = find(y, subset);
    if(subset[xroot].rank > subset[yroot].rank){
      subset[yroot].parent = xroot;
    }else if(subset[xroot].rank < subset[yroot].rank){
      subset[xroot].parent = yroot;
    }else{
      subset[xroot].parent = yroot;
      subset[yroot].rank++;
    }
  }

  void algo(){
    Edge result[] = new Edge[V];
    Subset subset[] = new Subset[V];
    for(int i = 0; i < V; i++){
      result[i] = new Edge();
    }
    for(int i = 0; i < V; i++){
      subset[i] = new Subset();
      subset[i].parent = i;
      subset[i].rank = 0;
    }
    int k = 0;
    int e = 0;
    Arrays.sort(edge);
    while(e < V-1 && k < E){
      // Edge temp = new Edge();
      Edge temp = edge[k++];
      int xroot = find(temp.src, subset);
      int yroot = find(temp.dst, subset);
      if(xroot != yroot){
        union(xroot, yroot, subset);
        result[e++] = temp;
      }
    }
    for(int i = 0; i < V-1; i++){
      System.out.println(result[i].src+" "+result[i].dst+"=>"+result[i].weight);
    }
  }

  public static void main(String args[]){
    Kruskal graph = new Kruskal(4, 5);
    graph.edge[0].src = 0;
    graph.edge[0].dst = 1;
    graph.edge[0].weight = 10;
    // add edge 0-2
    graph.edge[1].src = 0;
    graph.edge[1].dst = 2;
    graph.edge[1].weight = 6;
    // add edge 0-3
    graph.edge[2].src = 0;
    graph.edge[2].dst = 3;
    graph.edge[2].weight = 5;
    // add edge 1-3
    graph.edge[3].src = 1;
    graph.edge[3].dst = 3;
    graph.edge[3].weight = 15;
    // add edge 2-3
    graph.edge[4].src = 2;
    graph.edge[4].dst = 3;
    graph.edge[4].weight = 4;

    graph.algo();
  }
}