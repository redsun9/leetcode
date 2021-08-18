package leetcode.leetcode6xx.leetcode698;

import java.util.Arrays;

public class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        if (n < k) return false;
        if (k == 1) return true;

        int total = 0;
        for (int num : nums) total += num;
        if (total % k != 0) return false;
        total /= k;

        int max = 0;
        for (int num : nums) max = Math.max(max, num);
        if (max > total) return false;

        Arrays.sort(nums);
        int l = 0, r = n - 1, reduced = 0;
        while (r >= 0 && nums[r] == total) {
            nums[r--] = 0;
            reduced++;
            k--;
        }
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == total) {
                nums[l++] = 0;
                nums[r--] = 0;
                reduced += 2;
                k--;
            } else if (sum < total) l++;
            else r--;
        }
        if (k <= 1) return true;
        if (reduced > 0) Arrays.sort(nums);
        if (nums[reduced] + nums[n - 1] > total) return false;

        boolean[] visited = new boolean[1 << (n - reduced)];
        return dfs(reduced, reduced, n, 0, total, k, (1 << (n - reduced)) - 1, nums, visited);
    }

    private static boolean dfs(int from, int i, int n, int s, int target, int k, int key, int[] nums, boolean[] dp) {
        if (k <= 1) return true;
        if (s == target) return dfs(from, from, n, 0, target, k - 1, key, nums, dp);
        if (dp[key]) return false;
        dp[key] = true;
        int maxNum = target - s;
        while (i < n && nums[i] <= maxNum) {
            if (
                    (key & 1 << (i - from)) != 0 &&
                            dfs(from, i, n, s + nums[i], target, k, key ^ 1 << (i - from), nums, dp))
                return true;
            i++;
        }
        return false;
    }
}
