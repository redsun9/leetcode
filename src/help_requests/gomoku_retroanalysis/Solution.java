package help_requests.gomoku_retroanalysis;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    private static final int n = 3;

    public static int[][] possibleMoves(int[][] board) {
        //total crosses - totalNaughts between 0 and 1
        int[] countTotal = new int[2];
        for (int[] row : board) for (int val : row) if (val != 0) countTotal[val - 1] += 1;
        if (countTotal[0] != countTotal[1] && countTotal[0] != countTotal[1] + 1) return null;

        int[][][] winsByCell = new int[2][n][n];
        int[] totalWins = new int[2];

        for (int p = 0; p < 2; p++) {
            for (int i = 0; i < n; i++) {
                if (checkWin(i, 0, 0, 1, p, board)) {
                    inc(i, 0, 0, 1, p, winsByCell);
                    totalWins[p]++;
                }
                if (checkWin(0, i, 1, 0, p, board)) {
                    inc(0, i, 1, 0, p, winsByCell);
                    totalWins[p]++;
                }
            }
            if (checkWin(0, 0, 1, 1, p, board)) {
                inc(0, 0, 1, 1, p, winsByCell);
                totalWins[p]++;
            }
            if (checkWin(n - 1, 0, -1, 1, p, board)) {
                inc(n - 1, 0, -1, 1, p, winsByCell);
                totalWins[p]++;
            }
        }


        if (totalWins[0] != 0 && totalWins[1] != 0) return null;
        if (totalWins[0] != 0 && countTotal[0] != countTotal[1] + 1) return null;
        if (totalWins[1] != 0 && countTotal[0] != countTotal[1]) return null;

        int lastCellI = -1, lastCellJ = -1, lastCellWins = 0;
        for (int p = 0; p < 2; p++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (winsByCell[p][i][j] != 0) {
                        if (lastCellWins < winsByCell[p][i][j]) {
                            lastCellI = i;
                            lastCellJ = j;
                            lastCellWins = winsByCell[p][i][j];
                        }
                    }
                }
            }
        }

        int totalMoves = countTotal[0] + countTotal[1];
        int[][] ans = new int[totalMoves][2];

        for (int p = 0; p < 2; p++) {
            for (int i = 0, pos = p; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == lastCellI && j == lastCellJ) continue;
                    if (board[i][j] == p + 1) {
                        ans[pos][0] = i;
                        ans[pos][1] = j;
                        pos += 2;
                    }
                }
            }
        }
        if (lastCellWins != 0) {
            ans[totalMoves - 1][0] = lastCellI;
            ans[totalMoves - 1][1] = lastCellJ;
        }
        return ans;
    }

    private static boolean checkWin(int i0, int j0, int di, int dj, int p, int[][] board) {
        for (int k = 0, i = i0, j = j0; k < n; k++, i += di, j += dj) if (board[i][j] != p + 1) return false;
        return true;
    }

    private static void inc(int i0, int j0, int di, int dj, int p, int[][][] winsByCell) {
        for (int k = 0, i = i0, j = j0; k < n; k++, i += di, j += dj) winsByCell[p][i][j]++;
    }
}
