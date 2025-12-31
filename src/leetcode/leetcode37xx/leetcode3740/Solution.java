package leetcode.leetcode37xx.leetcode3740;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, Integer[]> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            Integer[] prev = map.get(nums[i]);
            if (prev == null) {
                map.put(nums[i], new Integer[]{i, null});
            } else if (prev[1] == null) {
                prev[1] = prev[0];
                prev[0] = i;
            } else {
                ans = Math.min(ans, i - prev[1]);
                prev[1] = prev[0];
                prev[0] = i;
            }
        }
        return ans != Integer.MAX_VALUE ? 2 * ans : -1;
    }
}
