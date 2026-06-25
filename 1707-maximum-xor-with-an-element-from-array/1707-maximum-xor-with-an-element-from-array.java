import java.util.*;
class Solution {
    static class Node {
        Node[] children = new Node[2];
    }
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int n = queries.length;
        int[][] q = new int[n][3];
        for (int i = 0; i < n; i++) {
            q[i][0] = queries[i][0];
            q[i][1] = queries[i][1];
            q[i][2] = i;
        }
        Arrays.sort(q, (a, b) -> Integer.compare(a[1], b[1]));
        Node root = new Node();
        int[] ans = new int[n];
        int idx = 0;
        for (int[] query : q) {
            while (idx < nums.length && nums[idx] <= query[1]) {
                insert(root, nums[idx]);
                idx++;
            }
            if (idx == 0) {
                ans[query[2]] = -1;
            } else {
                ans[query[2]] = getMax(root, query[0]);
            }
        }
        return ans;
    }
    private void insert(Node root, int num) {
        Node curr = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (curr.children[bit] == null) {
                curr.children[bit] = new Node();
            }
            curr = curr.children[bit];
        }
    }
    private int getMax(Node root, int num) {
        Node curr = root;
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int opposite = 1 - bit;
            if (curr.children[opposite] != null) {
                ans |= (1 << i);
                curr = curr.children[opposite];
            } else {
                curr = curr.children[bit];
            }
        }
        return ans;
    }
}