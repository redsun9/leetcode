package leetcode.leetcode20xx.leetcode2033;

import java.util.Arrays;

public class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        if (m == 1 && n == 1) return 0;
        int[] arr = new int[m * n];
        int pos = 0;
        for (int[] row : grid) for (int i : row) arr[pos++] = i;
        Arrays.sort(arr);
        int mid = arr[pos / 2];
        int ans = 0;
        for (int a : arr) {
            if ((mid - a) % x != 0) return -1;
            ans += Math.abs(mid - a) / x;
        }
        return ans;

    }
}
