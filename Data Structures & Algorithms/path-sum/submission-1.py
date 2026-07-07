# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def hasPathSum(self, root: Optional[TreeNode], targetSum: int) -> bool:
        if root is None:
            return False
        left_sum = targetSum - root.val
        if root.left is None and root.right is None and left_sum == 0:
            return True
        return self.hasPathSum(root.left, left_sum) or self.hasPathSum(root.right, left_sum)
