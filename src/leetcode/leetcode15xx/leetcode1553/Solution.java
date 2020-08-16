package leetcode.leetcode15xx.leetcode1553;

import java.util.HashMap;

public class Solution {
    HashMap<Integer, Integer> cache = new HashMap<>();

    public int minDays(int n) {
        if (n <= 1) return n;
        if (!cache.containsKey(n)) {
            cache.put(n, 1 + Math.min(n % 2 + minDays(n / 2), n % 3 + minDays(n / 3)));
        }
        return cache.get(n);
    }
}
