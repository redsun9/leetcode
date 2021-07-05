package leetcode.leetcode10xx.leetcode1051;

import java.util.Arrays;

// sort
// O(N*logN)

public class Solution {
    public int heightChecker(int[] heights) {
        int n = heights.length;
        int[] sorted = Arrays.copyOf(heights, n);
        Arrays.sort(sorted);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (sorted[i] != heights[i]) ans++;
        }
        return ans;
    }
}
