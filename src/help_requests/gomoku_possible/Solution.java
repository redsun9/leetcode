package help_requests.gomoku_possible;

@SuppressWarnings("RedundantIfStatement")
public class Solution {
    private static final int n = 3;

    public static boolean isValidPosition(int[][] board) {
        int[] countTotal = new int[2];
        for (int[] row : board) for (int val : row) if (val != 0) countTotal[val - 1] += 1;
        if (countTotal[0] != countTotal[1] && countTotal[0] != countTotal[1] + 1) return false;

        int[] totalWins = new int[2];
        for (int p = 0; p < 2; p++) {
            for (int i = 0; i < n; i++) {
                if (checkWin(i, 0, 0, 1, p, board)) totalWins[p]++;
                if (checkWin(0, i, 1, 0, p, board)) totalWins[p]++;
            }
            if (checkWin(0, 0, 1, 1, p, board)) totalWins[p]++;
            if (checkWin(n - 1, 0, -1, 1, p, board)) totalWins[p]++;
        }

        if (totalWins[0] != 0 && totalWins[1] != 0) return false;
        if (totalWins[0] != 0 && countTotal[0] != countTotal[1] + 1) return false;
        if (totalWins[1] != 0 && countTotal[0] != countTotal[1]) return false;
        return true;
    }

    private static boolean checkWin(int i0, int j0, int di, int dj, int p, int[][] board) {
        for (int k = 0, i = i0, j = j0; k < n; k++, i += di, j += dj) if (board[i][j] != p + 1) return false;
        return true;
    }
}
