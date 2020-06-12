package leetcode.leetcode6xx.leetcode689;

public class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        if (n == k * 3) return new int[]{0, k, 2 * k};
        int[] sum = new int[n + 1];
        //prefix sum
        for (int i = 0; i < n; i++) sum[i + 1] = sum[i] + nums[i];
        //now sum[i] = sum of k from i to i+k
        for (int i = 0; i <= n - k; i++) {
            sum[i] = sum[i + k] - sum[i];
        }
        int[] leftMax = new int[n - k + 1];
        int[] leftIndex = new int[n - k + 1];
        leftMax[0] = sum[0];
        leftIndex[0] = 0;
        for (int i = 1; i <= n - k; i++) {
            if (sum[i] > leftMax[i - 1]) {
                leftMax[i] = sum[i];
                leftIndex[i] = i;
            } else {
                leftMax[i] = leftMax[i - 1];
                leftIndex[i] = leftIndex[i - 1];
            }
        }
        int[] rightMax = new int[n - k + 1];
        int[] rightIndex = new int[n - k + 1];
        rightMax[n - k] = sum[n - k];
        rightIndex[n - k] = n - k;
        for (int i = n - k - 1; i >= 0; i--) {
            if (sum[i] >= rightMax[i + 1]) {
                rightMax[i] = sum[i];
                rightIndex[i] = i;
            } else {
                rightMax[i] = rightMax[i + 1];
                rightIndex[i] = rightIndex[i + 1];
            }
        }

        int[] ans = {n, n, n};
        int max = Integer.MIN_VALUE;
        for (int mid = n - 2 * k; mid >= k; mid--) {
            int tmp = sum[mid] + leftMax[mid - k] + rightMax[mid + k];
            if (tmp >= max) {
                ans[0] = leftIndex[mid - k];
                ans[1] = mid;
                ans[2] = rightIndex[mid + k];
                max = tmp;
            }
        }
        return ans;
    }
}
