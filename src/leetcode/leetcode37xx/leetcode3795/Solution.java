package leetcode.leetcode37xx.leetcode3795;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minLength(int[] nums, int k) {
        int ans = Integer.MAX_VALUE, n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int l = 0, r = 0, s = 0; r < n; r++) {
            int num = nums[r];
            int prev = map.getOrDefault(num, 0);
            if (prev == 0) s += num;
            map.put(num, prev + 1);

            while (s >= k) {
                ans = Math.min(ans, r - l + 1);
                num = nums[l++];
                prev = map.get(num);
                if (prev == 1) {
                    s -= num;
                    map.remove(num);
                } else {
                    map.put(num, prev - 1);
                }
            }
        }
        return ans != Integer.MAX_VALUE ? ans : -1;
    }
}
