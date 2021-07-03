package leetcode.leetcode17xx.leetcode1726;

import java.util.HashMap;

public class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                count.compute(nums[i] * nums[j], (k, v) -> v == null ? 1 : v + 1);
            }
        }
        int ans = 0;
        for (Integer value : count.values()) ans += value * (value - 1);
        return ans * 4;
    }
}
