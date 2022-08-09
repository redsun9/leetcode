package leetcode.leetcode23xx.leetcode2364;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.compute(nums[i] - i, (k, v) -> v == null ? 1 : v + 1);
        long ans = n * (n - 1L);
        for (Integer cnt : map.values()) ans -= cnt * (cnt - 1L);
        return ans / 2;
    }
}
