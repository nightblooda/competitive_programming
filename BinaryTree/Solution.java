import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Solution {
    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out); 
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            String input[] = br.readLine().split(" ");
            int a[] = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = Integer.parseInt(input[i]);
            }
            boolean m[] = new boolean[n];
            boolean v[] = new boolean[n];
            boolean f[] = new boolean[n];
            for(int i = 1; i < n-1; i++){
                if(a[i-1] < a[i] && a[i] > a[i+1]){
                    m[i] = true;
                }
                if(a[i-1] > a[i] && a[i] < a[i+1]){
                    v[i] = true;
                }
                f[i] = v[i] || m[i];
            }
            int count = 0;
            int h = 0;
            for(int i = 1; i < n-1; i++){
                if(f[i]){
                    count++;
                }
                if(i < n-3){
                    if((f[i] && f[i+1]) && (f[i+2]) && h < 3){
                        h = 3;
                    }
                }else if(i < n-2){
                    if((f[i] && f[i+1]) && h < 2){
                        h = 2;
                    }
                }else if(i < n-1 && h < 1){
                    if(f[i]){
                        h = 1;
                    }
                }
            }
            out.println(count-h);
            out.flush();
        }
    }
}
