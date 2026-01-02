package leetcode.leetcode37xx.leetcode3741;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int[] prev = map.get(nums[i]);
            if (prev != null) {
                if (prev[1] != -1) ans = Math.min(ans, i - prev[1]);
                prev[1] = prev[0];
                prev[0] = i;
            } else {
                map.put(nums[i], new int[]{i, -1});
            }
        }
        return ans != Integer.MAX_VALUE ? ans * 2 : -1;
    }
}
