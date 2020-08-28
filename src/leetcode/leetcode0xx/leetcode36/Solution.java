package leetcode.leetcode0xx.leetcode36;


/*
[
    ["5","3",".",  ".","7",".",  ".",".","."],
    ["6",".",".",  "1","9","5",  ".",".","."],
    [".","9","8",  ".",".",".",  ".","6","."],

    ["8",".",".",  ".","6",".",  ".",".","3"],
    ["4",".",".",  "8",".","3",  ".",".","1"],
    ["7",".",".",  ".","2",".",  ".",".","6"],

    [".","6",".",  ".",".",".",  "2","8","."],
    [".",".",".",  "4","1","9",  ".",".","5"],
    [".",".",".",  ".","8",".",  ".","7","9"]
]
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9) return false;
        for (char[] chars : board) {
            if (chars == null || chars.length != 9) return false;
        }
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] squares = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] >= '1' && board[i][j] <= '9') {
                    int a = board[i][j] - '1';
                    boolean[] square = squares[3 * (i / 3) + (j / 3)];
                    if (rows[i][a] || cols[j][a] || square[a]) return false;
                    rows[i][a] = true;
                    cols[j][a] = true;
                    square[a] = true;
                } else if (board[i][j] != '.') return false;
            }
        }
        return true;
    }
}
