class Solution {
    public int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int ind1 = 1; ind1 <= n; ind1++) {
            for (int ind2 = 1; ind2 <= m; ind2++) {

                if (s1.charAt(ind1 - 1) == s2.charAt(ind2 - 1)) {
                    dp[ind1][ind2] = 1 + dp[ind1 - 1][ind2 - 1];
                }
                // If they don't match
                else {
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2],  dp[ind1][ind2 - 1]);
                }
            }
        }
        return dp[n][m];
    }
    public int longestPalindromeSubsequence(String s) {
        String t = new StringBuilder(s).reverse().toString();
        return lcs(s, t);
    }
    public int minInsertions(String s) {
        int n = s.length();
        int k = longestPalindromeSubsequence(s);

        // Return answer
        return n - k;
    }
}

