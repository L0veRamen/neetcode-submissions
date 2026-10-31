class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        n = len(matrix[0])
        for i in range(n):
            for j in range(i):
                matrix[i][j], matrix[j][i] =  matrix[j][i], matrix[i][j]
        
        for row in matrix:
            left, right = 0, len(row) - 1
            while left < right:
                row[left], row[right] = row[right], row[left]
                left += 1
                right -= 1