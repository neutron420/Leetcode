class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= amount; j++) {
                int take = 0;
                if (coins[i] <= j)
                    take = dp[i][j - coins[i]];
                int skip = dp[i + 1][j];
                dp[i][j] = take + skip;
            }
        }
        return dp[0][amount];
    }
}