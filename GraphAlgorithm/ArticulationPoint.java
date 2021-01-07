import java.util.ArrayList;
import java.util.Arrays;

public class ArticulationPoint {

    int V;
    ArrayList<ArrayList<Integer>> graph;
    int time;
    
    ArticulationPoint(int v){
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

    void apUtil(int parent[], boolean visited[], int low[], int dis[], boolean ap[], int idx){
        visited[idx] = true;
        low[idx] = dis[idx] = ++time;
        int children = 0;
        for(int i : graph.get(idx)){
            if(!visited[i]){
                children++;
                parent[i] = idx;
                apUtil(parent, visited, low, dis, ap, i);
                low[idx] = Math.min(low[idx], low[i]);
                if(parent[idx] == -1 && children > 1){
                    ap[idx] = true;
                }
                if(parent[idx] != -1 && low[i] >= dis[idx]){
                    ap[idx] = true;
                }
            }else if(parent[idx] != i){
                low[idx] = Math.min(low[idx], dis[i]);
            }
        }
    }

    void algo(){
        int parent[] = new int[V];
        boolean visited[] = new boolean[V];
        int low[] = new int[V];
        int dis[] = new int[V];
        boolean ap[] = new boolean[V];

        Arrays.fill(parent, -1);

        for(int i = 0; i < V; i++){
            if(!visited[i]){
                apUtil(parent, visited, low, dis, ap, i);
            }
        }
        System.out.println("Articulation Points of the graph: ");
        for(int i = 0; i < V; i++){
            if(ap[i]){
                System.out.print(i+" ");
            }
        }
    }

    public static void main(String args[]){

        System.out.println("Articulation points in first graph "); 
        ArticulationPoint g1 = new ArticulationPoint(5); 
        g1.addEdge(1, 0); 
        g1.addEdge(0, 2); 
        g1.addEdge(2, 1); 
        g1.addEdge(0, 3); 
        g1.addEdge(3, 4); 
        g1.algo(); 
        System.out.println(); 
  
        System.out.println("Articulation points in Second graph"); 
        ArticulationPoint g2 = new ArticulationPoint(4); 
        g2.addEdge(0, 1); 
        g2.addEdge(1, 2); 
        g2.addEdge(2, 3); 
        g2.algo(); 
        System.out.println(); 
  
        System.out.println("Articulation points in Third graph "); 
        ArticulationPoint g3 = new ArticulationPoint(7); 
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
