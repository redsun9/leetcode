package leetcode.leetcode3xx.leetcode368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0) return Collections.emptyList();
        if (n == 1) return Collections.singletonList(nums[0]);
        Arrays.sort(nums);
        int ansLength = 1;
        int ansStart = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) max = Math.max(max, dp[j]);
            }
            max++;
            dp[i] = max;
            if (ansLength < max) {
                ansLength = max;
                ansStart = i;
            }
        }
        List<Integer> ansList = new ArrayList<>(ansLength);
        for (int i = ansStart, val = nums[ansStart]; ansLength > 0; i--) {
            if (val % nums[i] == 0 && dp[i] == ansLength) {
                ansList.add(nums[i]);
                ansLength--;
                val = nums[i];
            }
        }
        return ansList;
    }
}
