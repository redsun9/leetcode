package leetcode.leetcode37xx.leetcode3712;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            if (entry.getValue() % k == 0) ans += entry.getValue() * entry.getKey();
        }
        return ans;
    }
}
