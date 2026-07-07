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
        q = deque([(root, targetSum - root.val)])
        while q:
            node, left_sum = q.popleft()
            if node.left is None and node.right is None and left_sum == 0:
                return True
            if node.left:
                q.append((node.left, left_sum - node.left.val))
            if node.right:
                q.append((node.right, left_sum - node.right.val))
        return False
