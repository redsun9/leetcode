package leetcode.leetcode25xx.leetcode2547;

import java.util.HashMap;

public class Solution {
    public int minCost(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int min = k + dp[i];
            int cntNonDuplicate = 1;
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(nums[i], 1);
            for (int j = i - 1, len = 2; j >= 0; j--, len++) {
                int tmp = map.compute(nums[j], (key, value) -> value == null ? 1 : value + 1);
                if (tmp == 1) cntNonDuplicate++;
                else if (tmp == 2) cntNonDuplicate--;
                min = Math.min(min, k + len - cntNonDuplicate + dp[j]);
            }
            dp[i + 1] = min;
        }
        return dp[n];
    }
}
