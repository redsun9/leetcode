package leetcode.leetcode3xx.leetcode325;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    /**
     * @param nums: an array
     * @param k:    a target value
     * @return the maximum length of a subarray that sums to k
     */
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int n = nums.length, ans = 0, sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += nums[i - 1];
            ans = Math.max(ans, i - map.getOrDefault(sum - k, i));
            map.putIfAbsent(sum, i);
        }
        return ans;
    }
}
