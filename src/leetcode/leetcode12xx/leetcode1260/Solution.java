package leetcode.leetcode12xx.leetcode1260;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        k = k % (m * n);
        List<List<Integer>> ans = new ArrayList<>(m);
        for (int i1 = 0, i2 = (m * n - k) / n % m, j2 = (m * n - k) % n; i1 < m; i1++) {
            List<Integer> list = new ArrayList<>(n);
            for (int j1 = 0; j1 < n; j1++) {
                list.add(grid[i2][j2++]);
                if (j2 == n) {
                    j2 = 0;
                    i2++;
                    if (i2 == m) i2 = 0;
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
