package leetcode.leetcode16xx.leetcode1671;

import java.util.Arrays;

public class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] leftLIS = new int[n];
        int[] dp = new int[n + 1];
        int maxLength = 0;
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            int v = nums[i];
            int lo = 0, hi = maxLength;
            while (lo != hi) {
                int mid = lo + (hi - lo) / 2;
                if (dp[mid] < v) lo = mid + 1;
                else hi = mid;
            }
            leftLIS[i] = lo + 1;
            dp[leftLIS[i] - 1] = v;
            if (lo == maxLength) maxLength++;
        }

        int[] rightLIS = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        maxLength = 0;
        Arrays.fill(rightLIS, Integer.MAX_VALUE);
        for (int i = n - 1; i >= 0; i--) {
            int v = nums[i];
            int lo = 0, hi = maxLength;
            while (lo != hi) {
                int mid = lo + (hi - lo) / 2;
                if (dp[mid] < v) lo = mid + 1;
                else hi = mid;
            }
            rightLIS[i] = lo + 1;
            dp[rightLIS[i] - 1] = v;
            if (lo == maxLength) maxLength++;
        }

        int max = 0;
        for (int i = 1; i < n - 1; i++) {
            if (leftLIS[i] >= 2 && rightLIS[i] >= 2) {
                max = Math.max(max, leftLIS[i] + rightLIS[i]);
            }
        }
        return n - max + 1;


    }
}
