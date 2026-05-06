class Solution:
    def climbStairs(self, n: int) -> int:
        memo = [0] * (n + 1)

        def dfs(i: int) -> int:
            if i <= 1:  # base case
                return 1
            if memo[i] != 0:  # already computed
                return memo[i]
            memo[i] = dfs(i - 1) + dfs(i - 2)  # store result
            return memo[i]

        return dfs(n)


