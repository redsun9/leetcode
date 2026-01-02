package leetcode.leetcode37xx.leetcode3753;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public long totalWaviness(long num1, long num2) {
        return totalWaviness(num2) - totalWaviness(num1 - 1);
    }

    public static long totalWaviness(long num) {
        long power = 1;
        while (power * 10 <= num) power *= 10;
        return waveness(0, 0, num, power, true, false, new HashMap<>());
    }

    private static long waveness(int digit1, int digit2, long num, long power, boolean samePrefix, boolean hasNonZeroAlready, Map<Key, Long> cache) {
        long ans = 0;
        if (power == 0) return 0;
        long newPower = power / 10;
        boolean newHasNonZeroAlready = hasNonZeroAlready || digit1 != 0;

        Key key = new Key(digit1, digit2, power, samePrefix, hasNonZeroAlready);
        if (cache.containsKey(key)) return cache.get(key);

        int digit = (int) (num / power % 10);
        for (int digit3 = 0; digit3 <= 9; digit3++) {
            if (samePrefix && digit3 > digit) continue;
            boolean newSamePrefix = samePrefix && digit3 == digit;
            if (newHasNonZeroAlready && (digit1 < digit2 && digit3 < digit2 || digit1 > digit2 && digit3 > digit2)) {
                if (newSamePrefix) ans += (num % power + 1);
                else ans += power;
            }
            ans += waveness(digit2, digit3, num, newPower, newSamePrefix, newHasNonZeroAlready, cache);
        }
        cache.put(key, ans);
        return ans;
    }

    private record Key(int digit1, int digit2, long power, boolean samePrefix, boolean hasNonZeroAlready) {
    }
}
