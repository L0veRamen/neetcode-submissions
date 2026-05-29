/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int res = 0;
    private void dfs(TreeNode node, int depth){
        if(node == null) return;
        depth++;
        res = Math.max(depth, res);
        dfs(node.left,depth);
        dfs(node.right, depth);
    }
    public int maxDepth(TreeNode root) {
        dfs(root, 0);
        return res;        

    }
}
