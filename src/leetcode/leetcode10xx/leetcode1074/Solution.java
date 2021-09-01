package leetcode.leetcode10xx.leetcode1074;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        for (int[] row : matrix) {
            for (int i = 1; i < n; i++) {
                row[i] += row[i - 1];
            }
        }

        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        for (int j1 = 0; j1 < n; j1++) {
            for (int j2 = j1; j2 < n; j2++) {
                count.clear();
                count.put(0, 1);
                int sum = 0;
                for (int[] row : matrix) {
                    sum += row[j2] - (j1 > 0 ? row[j1 - 1] : 0);
                    ans += count.getOrDefault(sum - target, 0);
                    count.compute(sum, (k, v) -> v == null ? 1 : v + 1);
                }
            }
        }
        return ans;

    }
}
