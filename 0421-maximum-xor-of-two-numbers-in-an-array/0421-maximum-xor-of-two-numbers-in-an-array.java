class Solution {
    static class Node {
        Node[] children = new Node[2];
        boolean containsKey(int bit) {
            return children[bit] != null;
        }
        Node get(int bit) {
            return children[bit];
        }
        void put(int bit, Node node) {
            children[bit] = node;
        }
    }
    public int findMaximumXOR(int[] nums) {
        Node root = new Node();
        for (int num : nums) {
            insert(root, num);
        }
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, check(root, num));
        }

        return max;
    }
    private void insert(Node root, int num) {
        Node node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }
    private int check(Node root, int num) {
        Node node = root;
        int xor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int opposite = 1 - bit;
            if (node.containsKey(opposite)) {
                xor |= (1 << i);
                node = node.get(opposite);
            } else {
                node = node.get(bit);
            }
        }
        return xor;
    }
}