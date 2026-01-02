package leetcode.leetcode37xx.leetcode3755;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxBalancedSubarray(int[] nums) {
        Map<Key, Integer> map = new HashMap<>();
        map.put(new Key(0, 0), -1);
        int ans = 0;
        for (int i = 0, xor = 0, diff = 0; i < nums.length; i++) {
            xor ^= nums[i];
            diff += 1 - 2 * (nums[i] & 1);
            Integer prev = map.get(new Key(xor, diff));
            if (prev != null) ans = Math.max(ans, i - prev);
            map.putIfAbsent(new Key(xor, diff), i);
        }
        return ans;
    }

    private record Key(int xor, int diff) {
    }
}
