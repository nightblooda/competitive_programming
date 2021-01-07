import java.util.ArrayList;

// Eulerian path is a path in graph that visits every edge exactly once. Eulerian Circuit is an Eulerian Path which starts and ends on the same vertex
public class Eulerian {
    
    int V;
    ArrayList<ArrayList<Integer>> graph;

    Eulerian(int v){
        V = v;
        graph = new ArrayList<>();
        for(int i = 0; i < V; i++){
            graph.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v){
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    void dfsUtil(int s, boolean visited[]){
        visited[s] = true;
        for(int i : graph.get(s)){
            if(!visited[i]){
                dfsUtil(i, visited);
            }
        }
    }

    boolean isConnected(int degree[]){
        int v = -1;
        for(int i = 0; i < V; i++){
            if(degree[i] > 0){
                v = i;
                break;
            }
        }
        if(v == -1){
            return true;
        }
        boolean visited[] = new boolean[V];
        dfsUtil(v, visited);
        for(int i = 0; i < V; i++){
            if(degree[i] > 0 && !visited[i]){
                return false;
            }
        }
        return true;
    }

    void algo(){
        int degree[] = new int[V];
        int odd = 0;
        for(int i = 0; i < V; i++){
            degree[i] = graph.get(i).size();
            if(degree[i]%2 != 0){
                odd++;
            }
        }
        if(isConnected(degree)){
            if(odd == 2){
                System.out.println("Graph is Eulerian Path");
                return;
            }else if(odd == 0){
                System.out.println("Graph is Eulerian Cycle");
                return;
            }
        }
        System.out.println("Graph is neither Eulerian Path nor Eulerian Cycle");
        return;
    }

    public static void main(String args[]){

        Eulerian g1 = new Eulerian(5); 
        g1.addEdge(1, 0); 
        g1.addEdge(0, 2); 
        g1.addEdge(2, 1); 
        g1.addEdge(0, 3); 
        g1.addEdge(3, 4); 
        g1.algo(); 
  
        Eulerian g2 = new Eulerian(5); 
        g2.addEdge(1, 0); 
        g2.addEdge(0, 2); 
        g2.addEdge(2, 1); 
        g2.addEdge(0, 3); 
        g2.addEdge(3, 4); 
        g2.addEdge(4, 0); 
        g2.algo(); 
  
        Eulerian g3 = new Eulerian(5); 
        g3.addEdge(1, 0); 
        g3.addEdge(0, 2); 
        g3.addEdge(2, 1); 
        g3.addEdge(0, 3); 
        g3.addEdge(3, 4); 
        g3.addEdge(1, 3); 
        g3.algo(); 
  
        Eulerian g4 = new Eulerian(3); 
        g4.addEdge(0, 1); 
        g4.addEdge(1, 2); 
        g4.addEdge(2, 0); 
        g4.algo(); 

        Eulerian g5 = new Eulerian(3);
        g5.algo();
    }
}
