import java.util.LinkedList;

public class DetectCyclicDirected {
    
    int V;
    LinkedList<LinkedList<Integer>> graph;
    
    DetectCyclicDirected(int v){
        V = v;
        graph = new LinkedList<>();
        for(int i = 0; i < V; i++){
            graph.add(new LinkedList<>());
        }
    }

    void addEdge(int u, int v){
        graph.get(u).add(v);
    }

    boolean dfs(int idx, boolean visited[], boolean track[]){
        if(track[idx]){
            return true;
        }
        if(visited[idx]){
            return false;
        }
        visited[idx] = true;
        track[idx] = true;
        for(int i : graph.get(idx)){
            if(dfs(i, visited, track)){
                return true;
            }
        }
        track[idx] = false;
        return false;
    }

    boolean algo(){
        boolean visited[] = new boolean[V];
        boolean track[] = new boolean[V];

        for(int i = 0; i < V; i++){
            if(dfs(i, visited, track)){
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]){
        DetectCyclicDirected dcd = new DetectCyclicDirected(4);
        dcd.addEdge(0, 1); 
        dcd.addEdge(0, 2); 
        dcd.addEdge(1, 2); 
        dcd.addEdge(2, 0); 
        dcd.addEdge(2, 3); 
        dcd.addEdge(3, 3);
        System.out.println("Is the graph connected: "+ dcd.algo()); 
    }
}
