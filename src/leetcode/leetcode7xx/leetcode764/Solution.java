package leetcode.leetcode7xx.leetcode764;

public class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        if (mines.length == 0) return (n + 1) / 2;
        boolean[][] field = new boolean[n][n];
        for (int[] mine : mines) {
            field[mine[0]][mine[1]] = true;
        }
        int[][] ans = new int[n][n];
        //from left to right
        for (int i = 0; i < n; i++) {
            boolean[] row = field[i];
            int[] min = ans[i];
            int tmp = 0;
            for (int j = 0; j < n; j++) {
                if (row[j]) tmp = 0;
                else tmp++;
                min[j] = tmp;
            }
        }
        //from right to left
        for (int i = 0; i < n; i++) {
            boolean[] row = field[i];
            int[] max = ans[i];
            int tmp = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (row[j]) tmp = 0;
                else tmp++;
                max[j] = Math.min(max[j], tmp);
            }
        }
        for (int j = 0; j < n; j++) {
            int tmp = 0;
            for (int i = 0; i < n; i++) {
                if (field[i][j]) tmp = 0;
                else tmp++;
                ans[i][j] = Math.min(ans[i][j], tmp);
            }
        }
        for (int j = 0; j < n; j++) {
            int tmp = 0;
            for (int i = n - 1; i >= 0; i--) {
                if (field[i][j]) tmp = 0;
                else tmp++;
                ans[i][j] = Math.min(ans[i][j], tmp);
            }
        }

        int res = 0;
        for (int[] a : ans) for (int b : a) res = Math.max(res, b);
        return res;
    }
}
