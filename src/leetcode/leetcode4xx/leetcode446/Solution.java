package leetcode.leetcode4xx.leetcode446;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0, n = nums.length;
        Map<Integer, Integer>[] map = new Map[n];
        for (int i = 0; i < n; i++) {
            long c = nums[i];
            map[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = c - nums[j];
                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) continue;
                int d = (int) diff;
                int c1 = map[i].getOrDefault(d, 0);
                int c2 = map[j].getOrDefault(d, 0);
                ans += c2;
                map[i].put(d, c1 + c2 + 1);
            }
        }
        return ans;
    }
}
