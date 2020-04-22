package leetcode.leetcode0xx.leetcode79;

public class Solution {
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        int length = chars.length;
        int m = board.length;
        int n = board[0].length;
        if (length > m * n) return false;
        boolean[][] used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (chars[0] == board[i][j]) {
                    used[i][j] = true;
                    if (dfs(board, chars, i, j, m, n, 1, length, used)) return true;
                    used[i][j] = false;
                }
            }
        }
        return false;
    }

    private static boolean dfs(
            char[][] board, char[] word, int i, int j, int m, int n,
            int pos, int length, boolean[][] used
    ) {
        if (pos == length) return true;
        char c = word[pos];
        if (i > 0 && !used[i - 1][j] && board[i - 1][j] == c) {
            used[i - 1][j] = true;
            if (dfs(board, word, i - 1, j, m, n, pos + 1, length, used)) return true;
            used[i - 1][j] = false;
        }
        if (i < m - 1 && !used[i + 1][j] && board[i + 1][j] == c) {
            used[i + 1][j] = true;
            if (dfs(board, word, i + 1, j, m, n, pos + 1, length, used)) return true;
            used[i + 1][j] = false;
        }
        if (j > 0 && !used[i][j - 1] && board[i][j - 1] == c) {
            used[i][j - 1] = true;
            if (dfs(board, word, i, j - 1, m, n, pos + 1, length, used)) return true;
            used[i][j - 1] = false;
        }
        if (j < n - 1 && !used[i][j + 1] && board[i][j + 1] == c) {
            used[i][j + 1] = true;
            if (dfs(board, word, i, j + 1, m, n, pos + 1, length, used)) return true;
            used[i][j + 1] = false;
        }
        return false;
    }
}
