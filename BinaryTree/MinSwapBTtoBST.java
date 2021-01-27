import java.util.Arrays;
import java.util.HashMap;

public class MinSwapBTtoBST {

    void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    int minSwaps(int arr[], int n) {

        int temp[] = Arrays.copyOfRange(arr, 0, n);
        Arrays.sort(temp);
        int result = 0;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] != temp[i]) {
                result++;
                int init = arr[i];
                swap(arr, i, map.get(temp[i]));
                map.put(init, map.get(temp[i]));
                map.put(temp[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        int[] a = { 101, 758, 315, 730, 472, 619, 460, 479 };
        int n = a.length;
        // Output will be 5
        System.out.println(new MinSwapBTtoBST().minSwaps(a, n));
    }
}
