import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int half = n / 2;
        int total = 0;
        for (int x : nums)
            total += x;
        List<List<Integer>> left = new ArrayList<>();
        List<List<Integer>> right = new ArrayList<>();
        for (int i = 0; i <= half; i++) {
            left.add(new ArrayList<>());
            right.add(new ArrayList<>());
        }

        // Generate subset sums
        for (int mask = 0; mask < (1 << half); mask++) {
            int leftSum = 0;
            int rightSum = 0;
            int count = 0;

            for (int j = 0; j < half; j++) {

                if ((mask & (1 << j)) != 0) {
                    leftSum += nums[j];
                    rightSum += nums[j + half];
                    count++;
                }
            }
            left.get(count).add(leftSum);
            right.get(count).add(rightSum);
        }
        // Sort all right lists
        for (int i = 0; i <= half; i++)
            Collections.sort(right.get(i));
        int ans = Integer.MAX_VALUE;
        for (int leftCount = 0; leftCount <= half; leftCount++) {
            List<Integer> leftList = left.get(leftCount);
            List<Integer> rightList = right.get(half - leftCount);

            for (int lSum : leftList) {
                int target = total / 2 - lSum;
                int idx = Collections.binarySearch(rightList, target);

                if (idx < 0)
                    idx = -idx - 1;

                if (idx < rightList.size()) {
                    int chosen = lSum + rightList.get(idx);
                    ans = Math.min(ans, Math.abs(total - 2 * chosen));
                }

                if (idx > 0) {
                    int chosen = lSum + rightList.get(idx - 1);
                    ans = Math.min(ans, Math.abs(total - 2 * chosen));
                }
            }
        }
        return ans;
    }
}