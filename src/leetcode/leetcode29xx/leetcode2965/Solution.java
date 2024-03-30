package leetcode.leetcode29xx.leetcode2965;

public class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        long n = grid.length;

        long e1 = n * n * (n * n + 1) / 2;
        long e2 = n * n * (n * n + 1) * (2 * n * n + 1) / 6;

        long s1 = 0, s2 = 0;
        for (int[] row : grid) {
            for (int a : row) {
                s1 += a;
                s2 += (long) a * a;
            }
        }

        long a = ((s2 - e2) / (s1 - e1) + (s1 - e1)) / 2;
        long b = ((s2 - e2) / (s1 - e1) - (s1 - e1)) / 2;
        return new int[]{(int) a, (int) b};
    }
}
