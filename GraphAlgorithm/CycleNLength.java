public class CycleNLength {

    public static int count = 0;

    static void dfs(int idx, int graph[][], boolean visited[], int n, int start, int v){
        visited[idx] = true;
        if(n == 0){
            visited[idx] = false;
            if(graph[idx][start] == 1){
                count++;
                return;
            }else{
                return;
            }
        }
        for(int i = 0; i < v; i++){
            if(graph[idx][i] == 1 && !visited[i]){
                dfs(i, graph, visited, n-1, start, v);
            }
        }
        visited[idx] = false;
    }

    static void algo(int graph[][], int v, int n){
        boolean visited[] = new boolean[v];
        for(int i = 0; i < v-(n-1); i++){
            dfs(i, graph, visited, n-1, i, v);
            visited[i] = true;
        }
    }

    public static void main(String args[]){
        int graph[][] = {{0, 1, 0, 1, 0}, 
                        {1, 0, 1, 0, 1}, 
                        {0, 1, 0, 1, 0}, 
                        {1, 0, 1, 0, 1}, 
                        {0, 1, 0, 1, 0}}; 
        int n = 4;
        int v = 5;
        algo(graph, v, n);
        System.out.println("Cycles of length "+n+": " + count/2);
    }
    
}
