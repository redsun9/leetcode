package leetcode.leetcode23xx.leetcode2319;

public class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            int[] row = grid[i];
            for (int j = 0; j < n; j++) {
                if ((i == j || i + j == n - 1) ^ (row[j] != 0)) return false;
            }
        }
        return true;
    }
}
