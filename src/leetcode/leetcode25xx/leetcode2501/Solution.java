package leetcode.leetcode25xx.leetcode2501;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static final int MAX_TO_SQR = 46340;
    public static final int MAX_TO_SQRT = 2147395600;

    public int longestSquareStreak(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) map.put(num, false);
        int ans = 0;
        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
            if (entry.setValue(true)) continue;
            int tmp = 1;
            int lo = sqrt(entry.getKey());
            while (lo != -1 && map.computeIfPresent(lo, (k, v) -> true) != null) {
                tmp++;
                lo = sqrt(lo);
            }
            int hi = sqr(entry.getKey());
            while (hi != -1 && map.computeIfPresent(hi, (k, v) -> true) != null) {
                tmp++;
                hi = sqr(hi);
            }
            ans = Math.max(ans, tmp);
        }
        return ans < 2 ? -1 : ans;
    }

    private static int sqr(int a) {
        if (a > MAX_TO_SQR) return -1;
        return a * a;
    }

    private static int sqrt(int a) {
        if (a > MAX_TO_SQRT) return -1;
        int ans = (int) Math.round(Math.sqrt(a));
        if (ans * ans != a) return -1;
        return ans;
    }
}
