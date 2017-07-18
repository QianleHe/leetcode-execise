package DP;

/**
 * Created by misodumpling on 7/17/17.
 */
public class House_Robber_II {

    public static void main(String[] args) {
        House_Robber_II h = new House_Robber_II();
        int[] arr = new int[]{3,6,4};
        System.out.print(h.houseRobber2(arr));
    }

    public int houseRobber2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
        // if stole first one
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length - 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        int res = dp[nums.length - 2];
        dp = new int[nums.length];
        // if not stole the first one
        dp[0] = 0;
        dp[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        res = Math.max(dp[nums.length - 1], res);
        return res;
    }
}
