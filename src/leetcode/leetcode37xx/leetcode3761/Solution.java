package leetcode.leetcode37xx.leetcode3761;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            Integer prev = map.get(nums[i]);
            if (prev != null) ans = Math.min(ans, i - prev);
            long reversed = mirror(nums[i]);
            if (reversed <= Integer.MAX_VALUE) map.put((int) reversed, i);
        }
        return ans != Integer.MAX_VALUE ? ans : -1;
    }

    private static long mirror(int num) {
        long tmp = 0;
        while (num != 0) {
            tmp = tmp * 10 + num % 10;
            num /= 10;
        }
        return tmp;
    }
}
