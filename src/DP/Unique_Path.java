package DP;

/**
 * Created by misodumpling on 7/17/17.
 */
public class Unique_Path {

    public static void main(String[] args) {
        Unique_Path u = new Unique_Path();
        System.out.println(u.uniquePaths(3,3));
        System.out.println(u.uniquePaths(0,3));
    }

    // matrix dp problem
    public int uniquePaths(int m, int n) {
         if (m == 0 || n == 0) return 0;
         int[][] dp = new int[m][n];
         for (int i = 0; i < m; i++) {
             dp[i][0] = 1;
         }
         for (int j = 0; j < n; j++) {
             dp[0][j] = 1;
         }
         for (int i = 1; i < m; i++) {
             for (int j = 1; j < n; j++) {
                 dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
             }
         }
         return dp[m - 1][n - 1];
    }
}
