package DP;

/**
 * Created by misodumpling on 7/17/17.
 */
public class Palindrome_Partition_II {

    public static void main(String[] args) {
        Palindrome_Partition_II p = new Palindrome_Partition_II();
        System.out.print(p.minCut("aabbbc"));
    }

    public int minCut(String s) {
        if (s == null || s.length() == 0) return 0;
        boolean[][] isPalindrome = getIsPalindrome(s);
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;

        for (int i = 0; i <= s.length(); i++) {
            dp[i] = i;
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i - 1]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[s.length()] - 1;
    }

    public boolean[][] getIsPalindrome(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }

        for (int i = 0; i < s.length() - 1; i++) {
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }

        for (int len = 2; len < s.length(); len++) {
            for (int start = 0; start + len < s.length(); start++) {
                isPalindrome[start][start + len] = isPalindrome[start + 1][start + len - 1] && (s.charAt(start) == s.charAt(start + len));
            }
        }
        return isPalindrome;
    }
}
