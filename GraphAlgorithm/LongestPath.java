import java.util.Vector;

public class LongestPath {

    class Pair {
        int y;
        int w;

        Pair(int y, int w) {
            this.y = y;
            this.w = w;
        }
    }

    int V;
    int length = Integer.MIN_VALUE;
    Vector<Pair> graph[];

    LongestPath(int v) {
        this.V = v;
        graph = new Vector[V + 1];
        for (int i = 0; i <= V; i++) {
            graph[i] = new Vector();
        }
    }

    void dfs(boolean visited[], int idx, int cur) {
        visited[idx] = true;
        int prev = 0;
        for (int i = 0; i < graph[idx].size(); i++) {
            Pair temp = graph[idx].get(i);
            if (!visited[temp.y]) {
                prev = temp.w + cur;
                dfs(visited, temp.y, prev);
            }
            length = Math.max(length, prev);
            prev = 0;
        }
        visited[idx] = false;
    }

    void algo() {
        for (int i = 1; i <= V; i++) {
            boolean visited[] = new boolean[V + 1];
            dfs(visited, i, 0);
        }
    }

    public static void main(String args[]) {
        LongestPath g = new LongestPath(6);
        g.graph[1].add(g.new Pair(2, 3));
        g.graph[2].add(g.new Pair(1, 3));
        g.graph[2].add(g.new Pair(3, 4));
        g.graph[3].add(g.new Pair(2, 4));
        g.graph[2].add(g.new Pair(6, 2));
        g.graph[6].add(g.new Pair(2, 2));
        g.graph[4].add(g.new Pair(6, 6));
        g.graph[6].add(g.new Pair(4, 6));
        g.graph[5].add(g.new Pair(6, 5));
        g.graph[6].add(g.new Pair(5, 5));
        g.algo();
        System.out.println("Result is : " + g.length);
    }

}
