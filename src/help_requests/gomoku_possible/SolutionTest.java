package help_requests.gomoku_possible;

import basic.utils.IntegerUtils;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static help_requests.gomoku_possible.Solution.isValidPosition;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("DuplicatedCode")
class SolutionTest {
    public static final int n = 3, totalCells = n * n;

    @Test
    void testAll() {
        int[] tmp = new int[n * n];
        for (int i = 0; i < totalCells; i++) tmp[i] = i;
        Set<Integer> positions = new HashSet<>();
        dfs(0, 0, 0, new int[n][n], tmp, positions);

        int binPow = (int) IntegerUtils.binPow(n, totalCells);
        for (int key = 0; key < binPow; key++) assertEquals(positions.contains(key), isValidPosition(decode(key)));
    }

    private static void dfs(int move, int prevRow, int prevCol, int[][] board, int[] tmp, Set<Integer> set) {
        set.add(encode(board));
        if (move >= 2 * n - 1 && isMoveWinning(board, prevRow, prevCol)) return;
        for (int i = move; i < totalCells; i++) {
            swap(tmp, move, i);
            int val = tmp[move], row = val / n, col = val % n;
            board[row][col] = 1 + (move & 1);
            dfs(move + 1, row, col, board, tmp, set);
            board[row][col] = 0;
            swap(tmp, move, i);
        }
    }

    private static boolean isMoveWinning(int[][] board, int i, int j) {
        return isMoveWinningByRow(board, i, j) || isMoveWinningByCol(board, i, j)
                || isMoveWinningByDiag1(board, i, j) || isMoveWinningByDiag2(board, i, j);
    }

    private static boolean isMoveWinningByRow(int[][] board, int i, int j) {
        int val = board[i][j];
        for (int curr : board[i]) if (curr != val) return false;
        return true;
    }

    private static boolean isMoveWinningByCol(int[][] board, int i, int j) {
        int val = board[i][j];
        for (int k = 0; k < n; k++) if (board[k][j] != val) return false;
        return true;
    }

    private static boolean isMoveWinningByDiag1(int[][] board, int i, int j) {
        if (i != j) return false;
        int val = board[i][j];
        for (int k = 0; k < n; k++) if (board[k][k] != val) return false;
        return true;
    }

    private static boolean isMoveWinningByDiag2(int[][] board, int i, int j) {
        if (i + j != n - 1) return false;
        int val = board[i][j];
        for (int i1 = 0, j1 = n - 1; i1 < n; i1++, j1--) if (board[i1][j1] != val) return false;
        return true;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static int encode(int[][] board) {
        int ans = 0;
        for (int[] row : board) for (int a : row) ans = ans * 3 + a;
        return ans;
    }

    private static int[][] decode(int key) {
        int[][] board = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                board[i][j] = key % 3;
                key /= 3;
            }
        }
        return board;
    }
}