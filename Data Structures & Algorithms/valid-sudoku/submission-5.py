class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row_visited = set()
        col_visited = set()
        sub_box_visited = set()

        for i, row in enumerate(board):
            for j, x in enumerate(row):
                if x == ".":
                    continue
                if (
                    (i, x) in row_visited
                    or (j, x) in col_visited
                    or (i // 3, j // 3, x) in sub_box_visited
                ):
                    return False
                row_visited.add((i, x))
                col_visited.add((j, x))
                sub_box_visited.add((i // 3, j // 3, x))
        return True
