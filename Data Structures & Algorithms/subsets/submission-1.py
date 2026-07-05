class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        path = []
        n = len(nums)

        def dfs(i):
            if i == n:
                res.append(path[:])
                return

            # not choose nums[i]
            dfs(i + 1)
            # choose nums[i]
            path.append(nums[i])
            dfs(i + 1)
            path.pop()

        dfs(0)
        return res
