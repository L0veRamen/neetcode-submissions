class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        # memo[i][0] -> hold = False, memo[i][1] -> hold = True
        memo = [[None, None] for _ in range(n)]

        def dfs(i: int, hold: bool) -> int:
            if i < 0:
                return -float('inf') if hold else 0
            
            # Python treats False as 0 and True as 1 for indexing
            hold_idx = 1 if hold else 0
            
            if memo[i][hold_idx]:
                return memo[i][hold_idx]

            if hold:
                res = max(dfs(i - 1, True), dfs(i - 1, False) - prices[i])
            else:
                res = max(dfs(i - 1, False), dfs(i - 1, True) + prices[i])

            memo[i][hold_idx] = res
            return res

        return dfs(n - 1, False)