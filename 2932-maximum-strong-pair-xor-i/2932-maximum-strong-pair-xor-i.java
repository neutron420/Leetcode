
import java.util.Arrays;
class Solution {
    public int maximumStrongPairXor(int[] nums) {
        Arrays.sort(nums);
        int max_xor = 0;
        int n = nums.length;
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                if((nums[j] -  nums[i]) <= nums[i]) {
                    max_xor = Math.max(max_xor, (nums[i] ^ nums[j]));
                }else{
                    break;
                }
            }
        }
        return max_xor;
    }
}