class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        n = len(piles)
        l = 0
        r = max(piles)
        while l + 1 < r:
            mid = (l + r) // 2
            if n + sum((p-1) // mid for p in piles) <= h:
                r = mid
            else:
                l = mid
        return l + 1