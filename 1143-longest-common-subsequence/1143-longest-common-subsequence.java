
class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(n - 1, m - 1, text1, text2, dp);
    }
    private int solve(int i, int j, String s, String t, int[][] dp) {
        // Base Case
        if (i < 0 || j < 0) {
            return 0;
        }
        // Already Computed
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        // Characters Match
        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = 1 + solve(i - 1, j - 1, s, t, dp);
        }
        // Characters Don't Match
        return dp[i][j] = Math.max(
                solve(i - 1, j, s, t, dp),
                solve(i, j - 1, s, t, dp)
        );
    }
}