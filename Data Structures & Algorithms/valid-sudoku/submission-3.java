class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rows = new HashSet[9]; 
        HashSet<Character>[] cols = new HashSet[9]; 
        HashSet<Character>[] boxes = new HashSet[9]; 

        for(int i = 0;i < 9; i++){
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }


        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                int boxIndex = (i / 3) * 3 + (j / 3);
                if (rows[i].contains(c) || cols[j].contains(c) || boxes[boxIndex].contains(c)) { // 重复遇到数字 x
                    return false;
                }
                // 标记行、列、宫包含数字 x
                rows[i].add(c);
                cols[j].add(c);
                boxes[boxIndex].add(c);
            }
        }

        return true;
    }
}
