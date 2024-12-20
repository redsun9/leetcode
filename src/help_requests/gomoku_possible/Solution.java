package help_requests.gomoku_possible;

@SuppressWarnings("RedundantIfStatement")
public class Solution {
    private static final int n = 3;

    public static boolean isValidPosition(int[][] board) {
        int[] countTotal = new int[2];
        for (int[] row : board) for (int val : row) if (val != 0) countTotal[val - 1] += 1;
        if (countTotal[0] != countTotal[1] && countTotal[0] != countTotal[1] + 1) return false;

        boolean[] haveWin = new boolean[2];
        for (int p = 0; p < 2; p++) {
            for (int i = 0; i < n; i++) {
                haveWin[p] |= checkWin(i, 0, 0, 1, p, board);
                haveWin[p] |= checkWin(0, i, 1, 0, p, board);
            }
            haveWin[p] |= checkWin(0, 0, 1, 1, p, board);
            haveWin[p] |= checkWin(n - 1, 0, -1, 1, p, board);
        }

        if (haveWin[0] && haveWin[1]) return false;
        if (haveWin[0] && countTotal[0] != countTotal[1] + 1) return false;
        if (haveWin[1] && countTotal[0] != countTotal[1]) return false;
        return true;
    }

    private static boolean checkWin(int i0, int j0, int di, int dj, int p, int[][] board) {
        for (int k = 0, i = i0, j = j0; k < n; k++, i += di, j += dj) if (board[i][j] != p + 1) return false;
        return true;
    }
}
