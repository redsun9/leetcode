package leetcode.leetcode18xx.leetcode1814;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static final int p = 1_000_000_007;

    private static int reverse(int num) {
        int ans = 0;
        while (num != 0) {
            ans = ans * 10 + num % 10;
            num /= 10;
        }
        return ans;
    }

    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.compute(num - reverse(num), (k, v) -> v == null ? 1 : v + 1);
        }
        long ans = 0;
        for (Integer value : map.values()) {
            ans += value * (value - 1L) / 2;
        }
        return (int) (ans % p);
    }
}
