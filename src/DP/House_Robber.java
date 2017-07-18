package DP;

/**
 * Created by misodumpling on 7/17/17.
 */
public class House_Robber {

    public static void main(String[] args) {
        House_Robber h = new House_Robber();
        int[] arr = new int[]{1,8,3};
        System.out.println(h.houseRobber(arr));
    }

    public long houseRobber(int[] A) {
        if (A == null || A.length == 0) return 0;
        if (A.length == 1) return A[0];
        if (A.length == 2) return Math.max(A[0], A[1]);

        long[] dp = new long[A.length];
        dp[0] = A[0];
        dp[1] = Math.max(A[0], A[1]);
        for (int i = 2; i < A.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + A[i]);
        }

        return dp[A.length - 1];
    }
}
