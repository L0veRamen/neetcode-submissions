class Solution:
    def mySqrt(self, x: int) -> int:
        left = -1
        right = x+1
        res = 0

        while left + 1 < right:
            mid = left + (right - left) // 2
            if mid * mid > x:
                right = mid
            elif mid * mid < x:
                left = mid
                res = mid
            else:
                return mid
        return res