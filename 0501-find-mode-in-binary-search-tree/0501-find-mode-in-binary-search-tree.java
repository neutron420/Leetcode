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
 	private Map<Integer, Integer> map;
 	private int max = Integer.MIN_VALUE;
 	public int[] findMode(TreeNode root) {
 		if(root == null) return new int[]{};
 		this.map = new HashMap<>();
 		dfs(root);
 		int count = 0;
 		for(int i : map.values()){
 			if(i == max) count++;
 		}
 		int[] res = new int[count];
 		int i = 0;
 		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
 			if(entry.getValue() == max)
 				res[i++] = entry.getKey();
 		}
 		return res;
 	}
 	private void dfs(TreeNode node){
 		if(node == null) return;
 		Integer count = map.containsKey(node.val) ? map.get(node.val): 0;
 		map.put(node.val, count + 1);
 		this.max = Math.max(max, count + 1);
 		dfs(node.left);
 		dfs(node.right);
 	}
 }