package leetcode.leetcode10xx.leetcode1051;

// Count
// O(M+N) - m - max height, n - heights.length

public class Solution2 {
    public static final int MAX_HEIGHT = 100;

    public int heightChecker(int[] heights) {
        int n = heights.length;
        int[] count = new int[MAX_HEIGHT + 1];
        for (int height : heights) {
            count[height]++;
        }
        int ans = 0, i1 = 0, i2 = 1, left;
        while (i1 < n) {
            left = count[i2];
            while (left-- > 0) if (heights[i1++] != i2) ans++;
            i2++;
        }
        return ans;
    }
}
