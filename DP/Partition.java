public class Partition {

    static boolean findPartition(int arr[], int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        boolean part[][] = new boolean[sum / 2 + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            part[0][i] = true;
        }
        for (int i = 0; i <= sum / 2; i++) {
            part[i][0] = false;
        }
        for (int i = 1; i <= sum / 2; i++) {
            for (int j = 1; j <= n; j++) {
                part[i][j] = part[i][j - 1];
                if (i >= arr[j - 1]) {
                    part[i][j] = part[i][j] || part[i - arr[j - 1]][j - 1];
                }
            }
        }
        return part[sum / 2][n];
    }

    public static void main(String[] args) {
        int arr[] = { 3, 1, 1, 2, 2, 1 };
        int n = arr.length;
        if (findPartition(arr, n) == true)
            System.out.println("Can be divided into two subsets of equal sum");
        else
            System.out.println("Can not be divided into two subsets of equal sum");
    }

}
