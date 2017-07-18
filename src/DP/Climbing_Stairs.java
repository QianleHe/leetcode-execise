package DP;

/**
 * Created by misodumpling on 7/17/17.
 */
public class Climbing_Stairs {

    public static void main(String[] args) {
        Climbing_Stairs c = new Climbing_Stairs();
        System.out.println(c.climbStairs(3));
    }

    public int climbStairs(int n) {
        if (n == 0) return 1;
        if (n < 3) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
