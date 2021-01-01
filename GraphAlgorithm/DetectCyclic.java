import java.util.LinkedList;

public class DetectCyclic {

    int V;
    LinkedList<LinkedList<Integer>> graph;

    DetectCyclic(int v){
        V = v;
        graph = new LinkedList<>();
        for(int i = 0; i < v; i++){
            graph.add(new LinkedList<>());
        }
    }

    void addEdge(int u, int v){
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    boolean dfs(int idx, boolean visited[], int parent){
        visited[idx] = true;
        for(int i : graph.get(idx)){
            if(!visited[i]){
                if(dfs(i, visited, idx)){
                    return true;
                }
            }else{
                if(parent != i){
                    return true;
                }
            }
        }
        return false;
    }

    boolean algo(){
        boolean visited[] = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                if(dfs(i, visited, -1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String args[]){
        DetectCyclic dc = new DetectCyclic(5);
        dc.addEdge(1, 0); 
        dc.addEdge(0, 2); 
        dc.addEdge(2, 1); 
        dc.addEdge(0, 3); 
        dc.addEdge(3, 4); 
        System.out.println("Is the graph cyclic: "+dc.algo());
    }
    
}
