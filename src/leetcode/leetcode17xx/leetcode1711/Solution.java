package leetcode.leetcode17xx.leetcode1711;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static final int p = 1_000_000_007;
    public static final int maxSum = 1 << 21;

    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> countMap = new HashMap<>();
        long ans = 0;
        for (int a : deliciousness) {
            int mask;
            if (a == 0) mask = 1;
            else if ((a & (a - 1)) == 0) mask = a;
            else mask = Integer.highestOneBit(a) << 1;

            while (mask <= maxSum) {
                ans += countMap.getOrDefault(mask - a, 0);
                mask <<= 1;
            }
            countMap.compute(a, (k, v) -> v == null ? 1 : v + 1);
        }
        return (int) (ans % p);
    }
}
