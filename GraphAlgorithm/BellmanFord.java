import java.util.Arrays;

public class BellmanFord {

  class Edge {
    int src, dst, weight;
    Edge(){
      src = dst = weight = 0;
    }
  }

  Edge edge[];
  int V, E;

  BellmanFord(int v, int e){
    V = v;
    E = e;
    edge = new Edge[e];
    for(int i = 0; i < e; i++){
      edge[i] = new Edge();
    }
  }

  void algo(int src){
    int dist[] = new int[V];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;
    for(int i = 0; i < V-1; i++){
      for(int j = 0; j < E; j++){
        int s = edge[j].src;
        int d = edge[j].dst;
        int w = edge[j].weight;
        if(dist[s] != Integer.MAX_VALUE && dist[d] > dist[s] + w){
          dist[d] = dist[s] + w;
        }
      }
    }
    for(int i = 0 ; i < E; i++){
      int s = edge[i].src;
      int d = edge[i].dst;
      int w = edge[i].weight;
      if(dist[s] != Integer.MAX_VALUE && dist[d] > dist[s] + w){
        System.out.println("Negative Edge Cycle Exists so Bellman Ford wont work.");
        return;
      }
    }
    printGraph(dist);
  }
  void printGraph(int dist[]){
    for(int i = 0; i < V; i++){
      System.out.println(i+"->"+dist[i]);
    }
  }

  public static void main(String args[]){
    BellmanFord graph = new BellmanFord(5, 8);
    
        // add edge 0-1 (or A-B in above figure) 
        graph.edge[0].src = 0; 
        graph.edge[0].dst = 1; 
        graph.edge[0].weight = -1; 
  
        // add edge 0-2 (or A-C in above figure) 
        graph.edge[1].src = 0; 
        graph.edge[1].dst = 2; 
        graph.edge[1].weight = 4; 
  
        // add edge 1-2 (or B-C in above figure) 
        graph.edge[2].src = 1; 
        graph.edge[2].dst = 2; 
        graph.edge[2].weight = 3; 
  
        // add edge 1-3 (or B-D in above figure) 
        graph.edge[3].src = 1; 
        graph.edge[3].dst = 3; 
        graph.edge[3].weight = 2; 
  
        // add edge 1-4 (or A-E in above figure) 
        graph.edge[4].src = 1; 
        graph.edge[4].dst = 4; 
        graph.edge[4].weight = 2; 
  
        // add edge 3-2 (or D-C in above figure) 
        graph.edge[5].src = 3; 
        graph.edge[5].dst = 2; 
        graph.edge[5].weight = 5; 
  
        // add edge 3-1 (or D-B in above figure) 
        graph.edge[6].src = 3; 
        graph.edge[6].dst = 1; 
        graph.edge[6].weight = 1; 
  
        // add edge 4-3 (or E-D in above figure) 
        graph.edge[7].src = 4; 
        graph.edge[7].dst = 3; 
        graph.edge[7].weight = -3;

        graph.algo(0);
  }
  
}
