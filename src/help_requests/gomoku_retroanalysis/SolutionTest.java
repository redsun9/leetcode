package help_requests.gomoku_retroanalysis;

import basic.utils.IntegerUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static help_requests.gomoku_retroanalysis.Solution.possibleMoves;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("DuplicatedCode")
class SolutionTest {
    public static final int n = 3, totalCells = n * n;

    @Test
    void testAll() {
        int[][] board = new int[n][n];
        int[] tmp = new int[n * n];
        Set<Integer> positions = new HashSet<>();
        for (int i = 0; i < totalCells; i++) tmp[i] = i;
        dfs(0, 0, 0, board, tmp, positions);

        int binPow = (int) IntegerUtils.binPow(n, totalCells);
        for (int key = 0; key < binPow; key++) if (!positions.contains(key)) assertNull(possibleMoves(decode(key)));
    }

    private static void dfs(int move, int prevRow, int prevCol, int[][] board, int[] tmp, Set<Integer> set) {
        set.add(encode(board));
        boolean isWin = move >= 2 * n - 1 && isMoveWinning(board, prevRow, prevCol);
        if (isWin) {
            assertTrue(checkWin(board, possibleMoves(board), (move & 1) == 1));
            return;
        }
        assertTrue(checkDraw(board, possibleMoves(board)));
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

    private static boolean checkDraw(int[][] board, int[][] moves) {
        if (moves == null) return false;
        int[][] actualBoard = new int[n][n];
        for (int i = 0; i < moves.length; i++) {
            int[] move = moves[i];
            if (actualBoard[move[0]][move[1]] != 0) return false;
            actualBoard[move[0]][move[1]] = 1 + (i & 1);
        }
        return Arrays.deepEquals(board, actualBoard);
    }

    private static boolean checkWin(int[][] board, int[][] moves, boolean firstWin) {
        if (moves == null) return false;
        if (((moves.length & 1) == 1) != firstWin) return false;

        int[][] actualBoard = new int[n][n];
        int m = moves.length;
        for (int i = 0; i < moves.length - 1; i++) {
            int[] move = moves[i];
            if (actualBoard[move[0]][move[1]] != 0) return false;
            actualBoard[move[0]][move[1]] = 1 + (i & 1);
            if (isMoveWinning(actualBoard, move[0], move[1])) return false;
        }
        int[] lastMove = moves[m - 1];
        if (actualBoard[lastMove[0]][lastMove[1]] != 0) return false;
        actualBoard[lastMove[0]][lastMove[1]] = 1 + ((m + 1) & 1);
        if (!isMoveWinning(actualBoard, lastMove[0], lastMove[1])) return false;
        return Arrays.deepEquals(board, actualBoard);
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