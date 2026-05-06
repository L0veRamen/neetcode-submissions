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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(key > root.val){
            root.right = deleteNode(root.right, key);
        }else if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else{
             // found the node to delete -> 3 cases:

            // case 1: No left child -> promote right child
            if(root.left == null) return root.right;

            // case 2: No right child -> promote left child
            if(root.right == null) return root.left;

            // Case 3: Two children
            // Find in-order successor: smallest node in right subtree
            TreeNode successor = findMin(root.right);

            //Overwrite current node's value with successor's value
            root.val = successor.val;

            //Delete the successor from the right subtree
            // (successor has no left child, so this is a simple deletion)
            root.right = deleteNode(root.right, successor.val);
        }
        return root;
    }

    private TreeNode findMin(TreeNode node){
        while(node.left != null){
            node = node.left;
        }
        return node;
    }
}