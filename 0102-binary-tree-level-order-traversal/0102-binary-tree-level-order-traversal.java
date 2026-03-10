/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size() != 0){
            int count = queue.size();
            List<Integer> list = new LinkedList<>();
            for(int i = 0; i < count; i++){
                TreeNode node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                list.add(node.val);
            }
            result.add(list);
        }
        return result;
    }
}