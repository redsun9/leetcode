package leetcode.leetcode14xx.leetcode1463;

import java.util.Arrays;

public class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] prev = new int[n][n];
        int[][] curr = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(prev[i], -1);
        }
        prev[0][n - 1] = grid[0][0] + grid[0][n - 1];
        for (int i = 1; i < m; i++) {
            for (int p1 = 0; p1 < n; p1++) {
                for (int p2 = p1; p2 < n; p2++) {
                    int max = -1;
                    for (int d1 = -1; d1 <= 1; d1++) {
                        for (int d2 = -1; d2 <= 1; d2++) {
                            int p11 = p1 + d1;
                            int p21 = p2 + d2;
                            if (p11 >= 0 && p21 < n && p11 <= p21) max = Math.max(max, prev[p11][p21]);
                        }
                    }
                    if (max >= 0) max += grid[i][p1] + grid[i][p2] - (p1 == p2 ? grid[i][p1] : 0);
                    curr[p1][p2] = max;
                }
            }
            int[][] tmp = prev;
            prev = curr;
            curr = tmp;
        }
        int ans = 0;
        for (int p1 = 0; p1 < n; p1++) {
            for (int p2 = p1; p2 < n; p2++) {
                ans = Math.max(ans, prev[p1][p2]);
            }
        }
        return ans;
    }
}
