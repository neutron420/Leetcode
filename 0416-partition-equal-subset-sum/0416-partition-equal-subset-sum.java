class Solution {
    private boolean subsetSumUtil(int ind, int target, int[] arr, int[][] dp) {
        // Base case: target sum reached
        if (target == 0)
            return true;
        // Base case: first element check
        if (ind == 0)
            return arr[0] == target;
        // If already computed, return stored result
        if (dp[ind][target] != -1)
            return dp[ind][target] == 1;
        // Choice 1: exclude current element
        boolean notTaken = subsetSumUtil(ind - 1, target, arr, dp);
        // Choice 2: include current element if possible
        boolean taken = false;
        if (arr[ind] <= target)
            taken = subsetSumUtil(ind - 1, target - arr[ind], arr, dp);
        // Store result in dp table
        dp[ind][target] = (notTaken || taken) ? 1 : 0;
        return notTaken || taken;
    }
    public boolean canPartition(int[] arr) {
        // Find array size
        int n = arr.length;
        // Calculate total sum
        int totSum = 0;
        for (int num : arr)
            totSum += num;
        // If sum is odd, partition not possible
        if (totSum % 2 == 1)
            return false;
        // Target sum for each subset
        int k = totSum / 2;
        int[][] dp = new int[n][k + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return subsetSumUtil(n - 1, k, arr, dp);
    }
}