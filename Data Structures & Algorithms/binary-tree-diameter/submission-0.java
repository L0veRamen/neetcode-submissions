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
    private int res;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    // 返回 node 子树的最大链长
    private int dfs(TreeNode node) {
        if (node == null) {
            return -1; // 对于叶子来说，链长就是 -1+1=0
        }
        int lLen = dfs(node.left) + 1; // 左子树最大链长+1
        int rLen = dfs(node.right) + 1; // 右子树最大链长+1
        res = Math.max(res, lLen + rLen); // 两条链拼成路径
        return Math.max(lLen, rLen); // 当前子树最大链长
    }
}
