import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class test {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int m = A.get(0).size();
        boolean visited[][] = new boolean[n][m];
        int x[] = {1, 1, 1, -1, -1, -1, 0, 0};
        int y[] = {1, 0, -1, 1, 0, -1, 1, -1};
        int result = 0;
        Queue<Integer> que = new LinkedList<Integer>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int temp = 0;
                if(!visited[i][j] && A.get(i).get(j) == 1){
                    que.add(i);
                    que.add(j);
                    visited[i][j] = true;
                    System.out.println("HELLO");
                    while(!que.isEmpty()){
                        int xi = que.poll();
                        int yi = que.poll();
                        temp++;
                        System.out.println(xi+" "+yi);
                        for(int k = 0; k < 8; k++){
                            int x_ = xi + x[k];
                            int y_ = yi + y[k];
                            if(!(x_ < 0 || y_ < 0 || x_ >= n || y_ >= m) && !visited[x_][y_] && A.get(x_).get(y_) == 1){
                                que.add(x_);
                                que.add(y_);
                                visited[x_][y_] = true;
                            }
                        }
                    }
                   result = result < temp ? temp : result;

                }
            }
        }
        return result;
    }

    public static void main(String args[]){
      ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
      ArrayList<Integer> ar1 = new ArrayList<Integer>();
      ar1.add(0);
      ar1.add(0);
      ar1.add(1);
      ar1.add(0);
      ar1.add(0);
      ar1.add(0);
      ar1.add(0);
      ar1.add(0);
      ArrayList<Integer> ar2 = new ArrayList<Integer>();
      ar2.add(1);
      ar2.add(1);
      ar2.add(1);
      ar2.add(1);
      ar2.add(1);
      ar2.add(1);
      ar2.add(1);
      ar2.add(0);
      arr.add(ar1);
      arr.add(ar2);
      test t = new test();
      System.out.println(t.solve(arr));
    }
}

