package leetcode.leetcode20xx.leetcode2022;

public class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int total = m * n;
        if (total != original.length) return new int[0][0];
        int[][] ans = new int[m][n];
        for (int i = 0, pos = 0; i < m; i++) {
            int[] arr = ans[i];
            for (int j = 0; j < n; j++, pos++) {
                arr[j] = original[pos];
            }
        }
        return ans;
    }
}
