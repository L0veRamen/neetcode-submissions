class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        res = 0
        min_price = prices[0]
        for i, x in enumerate(prices):
            res = max(res, x - min_price)
            min_price = min(x, min_price)
        return res