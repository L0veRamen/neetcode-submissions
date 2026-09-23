class Solution:
    def shipWithinDays(self, weights: List[int], days: int) -> int:
        def canShip(capacity:int) -> bool:
            days_needed = 1
            cur_load = 0
            for w in weights:
                if cur_load + w > capacity:
                    days_needed += 1
                    cur_load = w
                else:
                    cur_load += w
            return days_needed <= days

        left = max(weights) - 1
        right = sum(weights)
        while left + 1 < right:
            mid = left + (right - left) // 2
            if canShip(mid):
                right = mid  
            else:
                left = mid

        return left + 1