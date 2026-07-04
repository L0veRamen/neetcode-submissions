class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        if not board or not board[0]:
            return False

        m, n = len(board), len(board[0])
        dirs = [(-1, 0), (1, 0), (0, -1), (0, 1)]

        def dfs(i: int, j: int, k: int) -> bool:
            # mismatch or already visited
            if board[i][j] != word[k]:
                return False
            if k == len(word) - 1:
                return True

            board[i][j] = 2  # mark as visited

            for di, dj in dirs:
                nr = i + di
                nc = j + dj
                if 0 <= nr < m and 0 <= nc < n and dfs(nr, nc, k + 1):
                    return True
            # restore the orginal character(backtrack)
            board[i][j] = word[k]
            return False

        # Try every cell as the starting point
        for i in range(m):
            for j in range(n):
                if dfs(i, j, 0):
                    return True

        return False
