class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) 
        return res;

        res.addAll(inorderTraversal(root.left));
        res.add(root.val);                       
        res.addAll(inorderTraversal(root.right));

        return res;
    }
}