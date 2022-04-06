package leetcode.leetcode16xx.leetcode1691;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static final int[][] r = {{0, 1, 2}, {1, 2, 0}, {2, 0, 1}};

    public int maxHeight(int[][] cuboids) {
        int n = cuboids.length, m = n * 3;

        int[][] rotatedCuboids = new int[m][4];
        for (int i = 0, idx1 = 0; i < n; i++) {
            for (int r1 = 0; r1 < 3; r1++, idx1++) {
                int a1 = Math.min(cuboids[i][r[r1][0]], cuboids[i][r[r1][1]]);
                int b1 = Math.max(cuboids[i][r[r1][0]], cuboids[i][r[r1][1]]);
                int c1 = cuboids[i][r[r1][2]];
                rotatedCuboids[idx1][0] = idx1;
                rotatedCuboids[idx1][1] = a1;
                rotatedCuboids[idx1][2] = b1;
                rotatedCuboids[idx1][3] = c1;
            }
        }

        Arrays.sort(rotatedCuboids, Comparator.comparingInt((int[] x) -> x[1])
                .thenComparingInt(x -> x[2]).thenComparingInt(x -> x[3]));

        int[] dp = new int[m];
        for (int i = 0; i < m; i++) {
            int[] u = rotatedCuboids[i];
            int tmp = 0;
            for (int j = 0; j < i; j++) {
                int[] v = rotatedCuboids[j];
                if (u[0] / 3 == v[0] / 3) continue;
                if (u[1] >= v[1] && u[2] >= v[2] && u[3] >= v[3]) tmp = Math.max(tmp, dp[j]);
            }
            dp[i] = tmp + u[3];
        }
        int ans = 0;
        for (int a : dp) ans = Math.max(ans, a);
        return ans;
    }
}
