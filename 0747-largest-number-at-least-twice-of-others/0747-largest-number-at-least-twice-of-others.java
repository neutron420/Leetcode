class Solution {
    public int dominantIndex(int[] nums) {
        int n = nums.length;
        int k= 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[k]) {
                k = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != k && nums[k] < 2 * nums[i]) {
                return -1;
            }
        }
        return k;
    }
}