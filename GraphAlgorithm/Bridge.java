import java.util.ArrayList;
import java.util.Arrays;

public class Bridge {
    
    int V;
    ArrayList<ArrayList<Integer>> graph;
    int time;
    Bridge(int v){
        V = v;
        time = 0;
        graph = new ArrayList<>();
        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v){
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    void brideUtil(int parent[], int low[], int dis[], boolean visited[], int idx){
        visited[idx] = true;
        low[idx] = dis[idx] = ++time;
        for(int i : graph.get(idx)){
            if(!visited[i]){
                parent[i] = idx;
                brideUtil(parent, low, dis, visited, i);
                low[idx] = Math.min(low[i], low[idx]);
                if(low[i] > dis[idx]){
                    System.out.println(i+" "+idx);
                }
            }else if(parent[idx] != i){
                low[idx] = Math.min(low[idx], dis[i]);
            }
        }
    }

    void algo(){
        int parent[] = new int[V];
        int low[] = new int[V];
        int dis[] = new int[V];
        boolean visited[] = new boolean[V];

        Arrays.fill(parent, -1);

        for(int i = 0; i < V; i++){
            if(!visited[i]){
                brideUtil(parent, low, dis, visited, i);
            }
        }
        
    }

    public static void main(String args[]){
        System.out.println("Bridges in first graph "); 
        Bridge g1 = new Bridge(5); 
        g1.addEdge(1, 0); 
        g1.addEdge(0, 2); 
        g1.addEdge(2, 1); 
        g1.addEdge(0, 3); 
        g1.addEdge(3, 4); 
        g1.algo(); 
        System.out.println(); 
  
        System.out.println("Bridges in Second graph"); 
        Bridge g2 = new Bridge(4); 
        g2.addEdge(0, 1); 
        g2.addEdge(1, 2); 
        g2.addEdge(2, 3); 
        g2.algo(); 
        System.out.println(); 
  
        System.out.println("Bridges in Third graph "); 
        Bridge g3 = new Bridge(7); 
        g3.addEdge(0, 1); 
        g3.addEdge(1, 2); 
        g3.addEdge(2, 0); 
        g3.addEdge(1, 3); 
        g3.addEdge(1, 4); 
        g3.addEdge(1, 6); 
        g3.addEdge(3, 5); 
        g3.addEdge(4, 5); 
        g3.algo(); 
    }
}
