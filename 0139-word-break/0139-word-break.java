class Solution {
    // Function to check if the string can be segmented
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;  // Empty string is always "segmented"
        int maxLen = 0;
        // Find the maximum length of words in the dictionary
        for (String word : wordDict) {
            maxLen = Math.max(maxLen, word.length());
        }
        // DP to check if the string can be segmented
        for (int i = 1; i <= n; ++i) {
            for (int j = Math.max(0, i - maxLen); j < i; ++j) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;  // Early termination when we find a valid word
                }
            }
        }
        return dp[n];  // Return if the entire string can be segmented
    }
}
public class Main {
    public static void main(String[] args) {
        Solution obj = new Solution();
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        if (obj.wordBreak(s, wordDict)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}