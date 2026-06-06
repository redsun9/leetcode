package leetcode.leetcode32xx.leetcode3257;

import java.util.Arrays;

import static java.lang.Integer.MIN_VALUE;

public class Solution {
    public long maximumValueSum(int[][] board) {
        int n = board[0].length;
        int[][] prevMax = {{MIN_VALUE, 0}, {MIN_VALUE, 1}, {MIN_VALUE, 2}, {MIN_VALUE, 3}};
        long[] prev2wo = new long[n];
        Arrays.fill(prev2wo, MIN_VALUE);
        long ans = Long.MIN_VALUE;

        for (int[] row : board) {
            for (int i = 0; i < n; i++) ans = Math.max(ans, row[i] + prev2wo[i]);
            int[][] curMax3 = max3(row);
            for (int i = 0; i < n; i++) prev2wo[i] = Math.max(prev2wo[i], prev2wo(prevMax, curMax3, i));
            for (int i = 0; i < 3; i++) updateMax3(prevMax, curMax3[i]);
        }
        return ans;
    }

    private static int[][] max3(int[] nums) {
        int[][] ans = {{MIN_VALUE, 0}, {MIN_VALUE, 1}, {MIN_VALUE, 2}, {MIN_VALUE, 0}};
        for (int i = 0; i < nums.length; i++) {
            ans[3] = new int[]{nums[i], i};
            int j = 2;
            while (j >= 0 && ans[j][0] < ans[j + 1][0]) {
                int[] tmp = ans[j + 1];
                ans[j + 1] = ans[j];
                ans[j--] = tmp;
            }
        }
        return ans;
    }

    private static long prev2wo(int[][] prevMax, int[][] curMax, int index) {
        long ans = MIN_VALUE;
        for (int[] max1 : prevMax) {
            if (max1[1] == index || max1[0] == MIN_VALUE) continue;
            for (int[] max2 : curMax) {
                if (max2[1] == index || max2[1] == max1[1] || max2[0] == MIN_VALUE) continue;
                ans = Math.max(ans, (long) max1[0] + max2[0]);
            }
        }
        return ans;
    }

    private static void updateMax3(int[][] prevMax, int[] newMax) {
        for (int i = 0; i < 3; i++) {
            if (prevMax[i][1] == newMax[1]) {
                prevMax[i][0] = Math.max(prevMax[i][0], newMax[0]);

                int j = i - 1;
                while (j >= 0 && prevMax[j][0] < prevMax[j + 1][0]) {
                    int[] tmp = prevMax[j + 1];
                    prevMax[j + 1] = prevMax[j];
                    prevMax[j--] = tmp;
                }
                return;
            }
        }
        prevMax[3] = newMax;
        int j = 2;
        while (j >= 0 && prevMax[j][0] < prevMax[j + 1][0]) {
            int[] tmp = prevMax[j + 1];
            prevMax[j + 1] = prevMax[j];
            prevMax[j--] = tmp;
        }
    }
}
