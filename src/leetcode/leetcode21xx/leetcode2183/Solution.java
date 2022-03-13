package leetcode.leetcode21xx.leetcode2183;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public long countPairs(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) count.compute(gcd(num, k), (key, v) -> v == null ? 1 : v + 1);
        long ans = 0;
        for (Map.Entry<Integer, Integer> a : count.entrySet()) {
            for (Map.Entry<Integer, Integer> b : count.entrySet()) {
                if ((long) a.getKey() * b.getKey() % k == 0) {
                    if (a.getKey().equals(b.getKey())) ans += a.getValue() * (a.getValue() - 1L);
                    else ans += a.getValue() * (long) b.getValue();
                }
            }
        }
        return ans / 2;
    }

    //greatest common divisor
    private static int gcd(int a, int b) {
        int c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}
