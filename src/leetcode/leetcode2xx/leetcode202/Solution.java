package leetcode.leetcode2xx.leetcode202;

import java.util.HashSet;

public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> cache = new HashSet<>();
        while (!cache.contains(n) && n != 1) {
            cache.add(n);
            int next = 0;
            while (n != 0) {
                next += (n % 10) * (n % 10);
                n /= 10;
            }
            n = next;
        }
        return n == 1;
    }
}
