# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        res = 0

        # 返回 node 子树的最大链长
        def dfs(node: Optional[TreeNode]) -> int:
            if node is None:
                return -1  # 对于叶子来说，链长就是 -1+1=0
            l_len = dfs(node.left) + 1  # 左子树最大链长+1
            r_len = dfs(node.right) + 1  # 右子树最大链长+1
            nonlocal res
            res = max(res, l_len + r_len)  # 两条链拼成路径
            return max(l_len, r_len)  # 当前子树最大链长

        dfs(root)
        return res

