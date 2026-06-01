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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while(cur != null){
            if(cur.left == null){
                res.add(cur.val);
                cur = cur.right;
            }else{
                TreeNode pred = cur.left;
                while(pred.right != null && pred.right != cur){
                    pred = pred.right;
                }
                if(pred.right == null){
                    res.add(cur.val);
                    pred.right = cur;
                    cur = cur.left;
                }else{
                    pred.right = null;
                    cur = cur.right;
                }
            }
        }
        return res;
    }
}