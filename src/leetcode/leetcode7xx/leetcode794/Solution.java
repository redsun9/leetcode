package leetcode.leetcode7xx.leetcode794;

@SuppressWarnings("ConditionCoveredByFurtherCondition")
public class Solution {
    public boolean validTicTacToe(String[] board) {
        int numXY = 0, rowX = 0, rowY = 0, colX = 0, colY = 0;
        boolean diagX = false, diagY = false;
        for (int i = 0; i < 3; i++) {
            String row = board[i];
            for (int j = 0; j < 3; j++) {
                char c = row.charAt(j);
                if (c == 'X') numXY++;
                else if (c == 'O') numXY--;
            }
            if (row.charAt(0) == 'X' && row.charAt(1) == 'X' && row.charAt(2) == 'X') rowX++;
            if (row.charAt(0) == 'O' && row.charAt(1) == 'O' && row.charAt(2) == 'O') rowY++;
            if (board[0].charAt(i) == 'X' && board[1].charAt(i) == 'X' && board[2].charAt(i) == 'X') colX++;
            if (board[0].charAt(i) == 'O' && board[1].charAt(i) == 'O' && board[2].charAt(i) == 'O') colY++;
        }
        if (board[0].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(2) == 'X') diagX = true;
        if (board[0].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(2) == 'O') diagY = true;
        if (board[0].charAt(2) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(0) == 'X') diagX = true;
        if (board[0].charAt(2) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(0) == 'O') diagY = true;

        boolean winX = rowX != 0 || colX != 0 || diagX;
        boolean winY = rowY != 0 || colY != 0 || diagY;
        return numXY >= 0 && numXY <= 1 && rowX <= 1 && rowY <= 1 && colX <= 1 && colY <= 1 &&
                (!winX || !winY) && (!winX || numXY == 1) && (!winY || numXY == 0);
    }
}
