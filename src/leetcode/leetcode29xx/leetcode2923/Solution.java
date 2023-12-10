package leetcode.leetcode29xx.leetcode2923;

public class Solution {
    public int findChampion(int[][] grid) {
        int ans = 0, n = grid.length;
        for (int i = 1; i < n; i++) if (grid[ans][i] != 1) ans = i;
        return ans;
    }
}
