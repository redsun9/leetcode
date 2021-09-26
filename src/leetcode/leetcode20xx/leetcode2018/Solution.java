package leetcode.leetcode20xx.leetcode2018;

public class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int k = word.length();

        for (char[] chars : board) {
            int j1 = 0, j2 = k - 1;
            while (j2 < n) {
                while (j2 < n && chars[j1] == '#') {
                    j1++;
                    j2++;
                }
                if (j2 == n) continue;
                int k1 = 0;
                while (k1 < k && (chars[j1] == ' ' || chars[j1] == word.charAt(k1))) {
                    j1++;
                    j2++;
                    k1++;
                }
                if (k1 == k && (j1 == n || chars[j1] == '#')) return true;
                while (j2 < n && chars[j1] != '#') {
                    j1++;
                    j2++;
                }

            }
        }
        for (int j = 0; j < n; j++) {
            int i1 = 0, i2 = k - 1;
            while (i2 < m) {
                while (i2 < m && board[i1][j] == '#') {
                    i1++;
                    i2++;
                }
                if (i2 == m) continue;
                int k1 = 0;
                while (k1 < k && (board[i1][j] == ' ' || board[i1][j] == word.charAt(k1))) {
                    i1++;
                    i2++;
                    k1++;
                }
                if (k1 == k && (i1 == m || board[i1][j] == '#')) return true;
                while (i2 < m && board[i1][j] != '#') {
                    i1++;
                    i2++;
                }
            }
        }

        for (char[] chars : board) {
            int j1 = n - 1, j2 = n - k;
            while (j2 >= 0) {
                while (j2 >= 0 && chars[j1] == '#') {
                    j1--;
                    j2--;
                }
                if (j2 < 0) continue;
                int k1 = 0;
                while (k1 < k && (chars[j1] == ' ' || chars[j1] == word.charAt(k1))) {
                    j1--;
                    j2--;
                    k1++;
                }
                if (k1 == k && (j1 < 0 || chars[j1] == '#')) return true;
                while (j2 >= 0 && chars[j1] != '#') {
                    j1--;
                    j2--;
                }

            }
        }
        for (int j = 0; j < n; j++) {
            int i1 = m - 1, i2 = m - k;
            while (i2 >= 0) {
                while (i2 >= 0 && board[i1][j] == '#') {
                    i1--;
                    i2--;
                }
                if (i2 < 0) continue;
                int k1 = 0;
                while (k1 < k && (board[i1][j] == ' ' || board[i1][j] == word.charAt(k1))) {
                    i1--;
                    i2--;
                    k1++;
                }
                if (k1 == k && (i1 < 0 || board[i1][j] == '#')) return true;
                while (i2 >= 0 && board[i1][j] != '#') {
                    i1--;
                    i2--;
                }
            }
        }

        return false;
    }
}
