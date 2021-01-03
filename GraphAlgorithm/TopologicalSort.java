import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {

    int V;
    ArrayList<ArrayList<Integer>> graph;

    TopologicalSort(int v){
        V = v;
        graph = new ArrayList<>();
        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }
    }
    
    void addEdge(int u, int v){
        graph.get(u).add(v);
    }

    void dfs(boolean visited[], Stack<Integer> stack, int idx){
        visited[idx] = true;
        for(int i : graph.get(idx)){
            if(!visited[i]){
                dfs(visited, stack, i);
            }
        }
        stack.push(idx);
    }

    void algo(){
        Stack<Integer> stack = new Stack<Integer>();
        boolean visited[] = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                dfs(visited, stack, i);
            }
        }
        System.out.println("Topological Sort");
        while(stack.size() > 0){
            System.out.print(stack.pop()+" ");
        }
        System.out.println();
    }

    public static void main(String args[]){
        TopologicalSort g = new TopologicalSort(6);
        g.addEdge(5, 2); 
        g.addEdge(5, 0); 
        g.addEdge(4, 0); 
        g.addEdge(4, 1); 
        g.addEdge(2, 3); 
        g.addEdge(3, 1); 
        g.algo();
    }
    
}
