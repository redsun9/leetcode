package leetcode.leetcode24xx.leetcode2461;

import java.util.HashMap;

@SuppressWarnings("DataFlowIssue")
public class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long max = 0, cur = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0, j = -k + 1; i < n; i++, j++) {
            cur += nums[i];
            map.compute(nums[i], (key, val) -> val == null ? 1 : val + 1);
            if (j >= 0) {
                if (map.size() == k && cur > max) max = cur;
                cur -= nums[j];
                map.compute(nums[j], (key, val) -> val == 1 ? null : val - 1);
            }
        }
        return max;
    }
}
