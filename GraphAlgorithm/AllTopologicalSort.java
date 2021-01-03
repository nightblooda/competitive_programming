import java.util.ArrayList;
import java.util.Stack;

public class AllTopologicalSort {

    int V; 
    ArrayList<ArrayList<Integer>> graph;
    
    AllTopologicalSort(int v){
        V = v;
        graph = new ArrayList<>();
        for(int i = 0; i < v; i++){
            graph.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v){
        graph.get(u).add(v);
    }

    void dfs(Stack<Integer> stack, int indegree[], boolean visited[]){
        boolean flag = false;
        for(int i = 0; i < V; i++){
            if(!visited[i] && indegree[i] == 0){
                stack.push(i);
                visited[i] = true;
                for(int j : graph.get(i)){
                    indegree[j]--;
                }
                dfs(stack, indegree, visited);
                visited[i] = false;
                stack.pop();
                for(int j : graph.get(i)){
                    indegree[j]++;
                }
                flag = true;
            }
        }
        if(!flag){
            stack.forEach(i -> System.out.print(i+" "));
            System.out.println();
        }
    }

    void algo(){
        int indegree[] = new int[V];
        boolean visited[] = new boolean[V];
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < V; i++){
            for(int j : graph.get(i)){
                indegree[j]++;
            }
        }
        dfs(stack, indegree, visited);
    }

    public static void main(String args[]){
        AllTopologicalSort g = new AllTopologicalSort(6);
        g.addEdge(5, 2); 
        g.addEdge(5, 0); 
        g.addEdge(4, 0); 
        g.addEdge(4, 1); 
        g.addEdge(2, 3); 
        g.addEdge(3, 1); 
        g.algo();
    }
    
}
