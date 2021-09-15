package leetcode.leetcode2xx.leetcode202;

import java.util.HashSet;

public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> cache = new HashSet<>();
        while (n != 1 && cache.add(n)) n = sum(n);
        return n == 1;
    }

    private static int sum(int n) {
        int ans = 0;
        while (n != 0) {
            ans += (n % 10) * (n % 10);
            n /= 10;
        }
        return ans;
    }
}
