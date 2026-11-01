class Solution:
    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        DIRS = [(0, 1), (1, 0), (0, -1), (-1, 0)]  # 右下左上
        res = []
        m = len(matrix)
        n = len(matrix[0])
        i = 0
        j = 0
        di = 0
        for _ in range(m * n):
            res.append(matrix[i][j])
            matrix[i][j] = "#"
            x = i + DIRS[di][0]
            y = j + DIRS[di][1]
            # (x,y) 出界或者已经访问过
            if x < 0 or y < 0 or x >= m or y >= n or matrix[x][y] == "#":
                di = (di + 1) % 4  # 右转90°
            i += DIRS[di][0]
            j += DIRS[di][1]
        return res