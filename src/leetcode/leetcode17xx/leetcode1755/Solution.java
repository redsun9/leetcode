package leetcode.leetcode17xx.leetcode1755;

import java.util.Arrays;

public class Solution {
    private static int[] createAllSums(int[] nums) {
        int n = nums.length;
        int len = 1 << n;
        int[] ans = new int[len];
        for (int mask = 0; mask < len; mask++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) sum += nums[i];
            }
            ans[mask] = sum;
        }
        Arrays.sort(ans);
        return ans;
    }

    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        int[] first = Arrays.copyOfRange(nums, 0, n / 2);
        int[] second = Arrays.copyOfRange(nums, n / 2, n);
        int[] arr1 = createAllSums(first);
        int[] arr2 = createAllSums(second);
        int p1 = 0, p2 = arr2.length - 1, n1 = arr1.length;
        int ans = Math.abs(goal);
        while (ans != 0 && p1 < n1 && p2 >= 0) {
            int testSum = arr1[p1] + arr2[p2];
            ans = Math.min(ans, Math.abs(goal - testSum));
            if (testSum > goal) p2--;
            else p1++;
        }
        return ans;
    }
}
