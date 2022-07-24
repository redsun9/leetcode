package leetcode.leetcode23xx.leetcode2352;

import java.util.HashMap;

// hash based solution
public class Solution {
    private static final int minVal = 1, maxVal = 100_000, base = maxVal - minVal + 1;
    private static final long p = 92233720368469L;

    public int equalPairs(int[][] grid) {
        int n = grid.length;
        HashMap<Long, Integer> cnt = new HashMap<>();
        for (int[] row : grid) {
            long hash = 0;
            for (int val : row) {
                hash = hash * base + val - minVal;
                if (hash >= p) hash %= p;
            }
            cnt.compute(hash, (k, v) -> v == null ? 1 : v + 1);
        }

        int ans = 0;
        for (int j = 0; j < n; j++) {
            long hash = 0;
            for (int[] row : grid) {
                hash = hash * base + row[j] - minVal;
                if (hash >= p) hash %= p;
            }
            ans += cnt.getOrDefault(hash, 0);
        }
        return ans;
    }
}
