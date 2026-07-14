class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {    
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        StringBuilder scs = new StringBuilder();
        int i = n, j = m;
        while (i > 0 && j > 0) {

            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                scs.append(str1.charAt(i - 1));
                i--;
                j--;
            }
        
            else if (dp[i - 1][j] > dp[i][j - 1]) {
                scs.append(str1.charAt(i - 1));
                i--;
            }
            // If LCS length came from dp[i][j-1] (or they are equal)
            // It means str2[j-1] was not part of LCS
            // So, include str2[j-1] in SCS and move left in the table
            else {
                scs.append(str2.charAt(j - 1));
                j--;
            }
        }

        // If there are any remaining characters in str1, append them to SCS
        // These characters come from the remaining part of str1 that was not matched
        while (i > 0) {
            scs.append(str1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            scs.append(str2.charAt(j - 1));
            j--;
        }
        return scs.reverse().toString();
    }
}