# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def lowestCommonAncestor(self, root: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode:
        x = root.val
        if p.val > x and q.val > x: # right sub tree 
            return self.lowestCommonAncestor(root.right, p, q)
        if p.val < x and q.val < x: # left sub tree
            return self.lowestCommonAncestor(root.left, p, q)
        return root
        