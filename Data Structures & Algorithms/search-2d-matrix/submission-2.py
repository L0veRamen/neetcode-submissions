class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        m = len(matrix)
        n = len(matrix[0])
        l = -1
        r = m * n
        while l + 1 < r:
            mid = (l + r) // 2
            x = matrix[mid // n][mid % n]
            if x == target:
                return True
            elif x < target:
                l = mid
            else:
                r = mid
        return False