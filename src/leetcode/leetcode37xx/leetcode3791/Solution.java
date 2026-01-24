package leetcode.leetcode37xx.leetcode3791;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public long countBalanced(long low, long high) {
        return countBalanced(high) - countBalanced(low - 1);
    }

    private static long countBalanced(long n) {
        List<Integer> digits = digits(n);
        return countBalanced(digits.size() - 1, digits, 0, true, new HashMap<>());
    }

    private static long countBalanced(int digitIdx, List<Integer> digits, int curr, boolean same, Map<Key, Long> cache) {
        if (digitIdx == -1) return curr == 0 ? 1 : 0;
        Key key = new Key(digitIdx, curr, same);
        if (cache.containsKey(key)) return cache.get(key);

        int curDigit = digits.get(digitIdx);
        int coef = (digitIdx & 1) == 0 ? 1 : -1;

        long ans = 0;
        for (int i = 0; i < 10; i++) {
            if (same && curDigit < i) continue;
            ans += countBalanced(digitIdx - 1, digits, curr + i * coef, same && curDigit == i, cache);
        }
        cache.put(key, ans);
        return ans;
    }

    private static List<Integer> digits(long n) {
        List<Integer> list = new ArrayList<>();
        do {
            list.add((int) (n % 10));
            n /= 10;
        } while (n != 0);
        return list;
    }

    private record Key(int digitIdx, int curr, boolean same) {
    }
}
