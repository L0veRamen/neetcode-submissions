class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        res = 0
        min_price = prices[0]
        for p in prices:
            res = max(res, p - min_price)
            min_price = min(min_price, p)
        return res


        