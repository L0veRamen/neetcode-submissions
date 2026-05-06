class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        total_profit = 0
        
        # Compare each day with the previous day
        for i in range(1, len(prices)):
            # If price increased, we could have bought yesterday and sold today
            if prices[i] > prices[i-1]:
                total_profit += prices[i] - prices[i-1]
        
        return total_profit