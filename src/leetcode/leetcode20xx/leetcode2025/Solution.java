package leetcode.leetcode20xx.leetcode2025;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int waysToPartition(int[] nums, int k) {
        int n = nums.length;
        Map<Long, Integer> right = new HashMap<>();
        long totalSum = nums[0];
        for (int i = 1; i < n; i++) {
            right.compute(totalSum, (key, v) -> v == null ? 1 : v + 1);
            totalSum += nums[i];
        }

        int ans = (totalSum & 1L) == 1 ? 0 : right.getOrDefault(totalSum / 2, 0);

        Map<Long, Integer> left = new HashMap<>();
        long leftSum = 0;
        for (int num : nums) {
            long newTotal = totalSum - num + k;
            if ((newTotal & 1L) == 0) {
                newTotal /= 2;
                int tmpVal = right.getOrDefault(totalSum - newTotal, 0) +
                        left.getOrDefault(newTotal, 0);
                ans = Math.max(ans, tmpVal);
            }
            leftSum += num;
            right.computeIfPresent(leftSum, (key, v) -> v - 1);
            left.compute(leftSum, (key, v) -> v == null ? 1 : v + 1);
        }
        return ans;
    }
}
