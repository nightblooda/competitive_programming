import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// If the graph is bipertite then there will be no odd length cycle.
public class Bipertite {
    
    static boolean algo(int graph[][], int s, int v){
        Queue<Integer> que = new LinkedList<Integer>();
        que.add(s);
        int color[] = new int[v];
        Arrays.fill(color, -1);
        color[s] = 0;
        while(!que.isEmpty()){
            int temp = que.poll();
            // if(graph[temp][temp] == 1){
                
            // }
            for(int i = 0; i < v; i++){
                if(graph[temp][i] == 1){
                    if(color[i] == -1){
                        que.add(i);
                        color[i] = 1-color[temp];
                    }else if(color[i] == color[temp]){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String args[]){
        int G[][] = {{0, 1, 0, 1}, 
                     {1, 0, 1, 0}, 
                     {0, 1, 0, 1}, 
                     {1, 0, 1, 0}}; 
        System.out.println("Is the graph bipertite: "+algo(G, 0, 4));
    }
}
