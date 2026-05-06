class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        # Initialize sets to track seen digits 
        rows = [set() for _ in range(9)]      # 9 sets for 9 rows
        cols = [set() for _ in range(9)]      # 9 sets for 9 columns  
        boxes = [set() for _ in range(9)]     # 9 sets for 9 sub-boxes
        
        # Single pass through the board
        for row in range(9):
            for col in range(9):
                cell = board[row][col]
                
                # Skip empty cells
                if cell == '.':
                    continue
                
                # Calculate which 3x3 box this cell belongs to
                box_index = (row // 3) * 3 + (col // 3)
                
                # Check if digit already exists in row, column, or box
                if (cell in rows[row] or 
                    cell in cols[col] or 
                    cell in boxes[box_index]):
                    return False
                
                # Add digit to respective sets
                rows[row].add(cell)
                cols[col].add(cell)
                boxes[box_index].add(cell)
        
        return True