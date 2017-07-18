package DP;

/**
 * Created by misodumpling on 7/17/17.
 */
public class Unique_Path_II {
    public static void main(String[] args) {
        Unique_Path_II u = new Unique_Path_II();
        int[][] m = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(u.uniquePathsWithObstacles(m));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        // init
        boolean isStone = false;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] != 1 && !isStone) {
                dp[i][0] = 1;
            }
            if (obstacleGrid[i][0] == 1) {
                isStone = true;
            }
        }
        isStone = false;
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] != 1 && !isStone) {
                dp[0][j] = 1;
            }
            if (obstacleGrid[0][j] == 1) {
                isStone = true;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}

