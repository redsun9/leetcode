package leetcode.leetcode19xx.leetcode1959;

public class Solution {
    public int minSpaceWastedKResizing(int[] nums, int k) {
        int n = nums.length;

        int[][] h = new int[n][n];
        for (int i = 0; i < n; i++) h[i][i] = nums[i];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                h[i][j] = Math.max(h[i][j - 1], nums[j]);
            }
        }
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++) s[i + 1] = s[i] + nums[i];

        int[] prev = new int[n + 1], next = new int[n + 1], tmp;
        for (int i = 0; i < n; i++) prev[i + 1] = (i + 1) * h[0][i] - s[i + 1];
        while (k-- > 0) {
            for (int i = 0; i < n; i++) {
                int min = prev[i + 1];
                for (int j = 1; j <= i; j++) min = Math.min(min, prev[j] + h[j][i] * (i - j + 1) - s[i + 1] + s[j]);
                next[i + 1] = min;
            }
            tmp = prev;
            prev = next;
            next = tmp;
        }
        return prev[n];
    }
}
