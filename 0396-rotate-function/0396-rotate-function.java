class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;

        long sum = 0;
        long f = 0;

        // Calculate total sum and F(0)
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += (long) i * nums[i];
        }

        long max = f;

        // Calculate F(1), F(2), ..., F(n-1)
        for (int i = n - 1; i > 0; i--) {
            f = f + sum - (long) n * nums[i];
            max = Math.max(max, f);
        }

        return (int) max;
    }
}