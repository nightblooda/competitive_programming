import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    public static void main(String args[]) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String one[] = br.readLine().split(" ");
            String two = br.readLine();
            int n = Integer.parseInt(one[0]);
            int m = Integer.parseInt(one[1]);
            int ref = 0;
            HashSet<Integer> set = new HashSet<>();
            set.add(ref);
            for (int i = 0; i < m; i++) {
                String input[] = br.readLine().split(" ");
                int start = Integer.parseInt(input[0]);
                int end = Integer.parseInt(input[1]);
                for (int j = 0; j < start; j++) {
                    if (two.charAt(j) == '-') {
                        set.add(ref - 1);
                    } else if (two.charAt(j) == '+') {
                        set.add(ref + 1);
                    }
                }
                for (int j = end + 1; j < n; j++) {
                    if (two.charAt(j) == '-') {
                        set.add(ref - 1);
                    } else if (two.charAt(j) == '+') {
                        set.add(ref + 1);
                    }
                }
            }
            System.out.println(set.size());
        }
    }
}
