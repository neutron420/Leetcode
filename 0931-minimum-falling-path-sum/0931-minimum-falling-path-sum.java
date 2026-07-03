class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = dp[i - 1][j];
                int ld = Integer.MAX_VALUE;
                if (j > 0)
                    ld = dp[i - 1][j - 1];
                int rd = Integer.MAX_VALUE;
                if (j < m - 1)
                    rd = dp[i - 1][j + 1];
                dp[i][j] = matrix[i][j] +
                        Math.min(up, Math.min(ld, rd));
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            ans = Math.min(ans, dp[n - 1][j]);
        }
        return ans;
    }
}