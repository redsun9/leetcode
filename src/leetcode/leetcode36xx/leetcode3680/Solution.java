package leetcode.leetcode36xx.leetcode3680;

import java.util.Arrays;

public class Solution {
    public int[][] generateSchedule(int n) {
        int total = n * (n - 1);
        int[][] ans = new int[total][2];
        boolean[][] used = new boolean[n][n];
        int[] left = new int[n];
        Arrays.fill(left, 2 * n - 2);

        for (int k = 0, prev1 = -1, prev2 = -1; k < total; k++) {
            int u = -1, v = -1, max = 0;
            for (int i = 0; i < n; i++) {
                if (i == prev1 || i == prev2) continue;
                for (int j = 0; j < n; j++) {
                    if (i == j || j == prev1 || j == prev2 || used[i][j] && used[j][i]) continue;
                    int tmp = left[i] + left[j];
                    if (tmp > max) {
                        u = i;
                        v = j;
                        max = tmp;
                    }
                }
            }
            if (max == 0) return new int[0][];
            if (!used[u][v]) {
                used[u][v] = true;
                ans[k] = new int[]{u, v};
            } else {
                used[v][u] = true;
                ans[k] = new int[]{v, u};
            }
            left[u]--;
            left[v]--;
            prev1 = u;
            prev2 = v;
        }
        return ans;
    }
}
