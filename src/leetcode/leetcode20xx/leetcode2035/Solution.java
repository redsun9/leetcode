package leetcode.leetcode20xx.leetcode2035;

import java.util.Arrays;

public class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        if (n == 2) return Math.abs(nums[1] - nums[0]);
        int[][] lists1 = generate(Arrays.copyOfRange(nums, 0, n / 2));
        int[][] lists2 = generate(Arrays.copyOfRange(nums, n / 2, n));
        int ans = Integer.MAX_VALUE;
        for (int d = 0; d <= n / 2; d++) {
            int[] arr1 = lists1[d], arr2 = lists2[d];
            int k = arr1.length;
            int i1 = 0, i2 = 0;
            while (i1 < k && i2 < k) {
                int diff = arr1[i1] - arr2[i2];
                ans = Math.min(ans, Math.abs(diff));
                if (diff <= 0) i1++;
                if (diff >= 0) i2++;
            }
        }
        return ans;
    }

    private static int[][] generate(int[] nums) {
        int n = nums.length;
        int ansSize = 1 << n;

        int total = 0;
        for (int num : nums) total += num;

        for (int i = 0; i < n; i++) nums[i] <<= 1;
        int[] sums = new int[ansSize];
        sums[0] -= total;
        for (int i = 0, maxTo = 1; i < n; i++, maxTo <<= 1) {
            int num = nums[i];
            for (int from = 0, to = maxTo; from < maxTo; from++, to++) sums[to] = sums[from] + num;
        }

        int[][] ans = new int[n + 1][];
        int[] pos = new int[n + 1];
        for (int i = 0, binomial = 1; i <= n; i++) {
            ans[i] = new int[binomial];
            binomial = binomial * (n - i) / (i + 1);
        }
        for (int key = 0; key < ansSize; key++) {
            int bits = Integer.bitCount(key);
            ans[bits][pos[bits]++] = sums[key];
        }
        for (int[] arr : ans) Arrays.sort(arr);
        return ans;
    }
}
