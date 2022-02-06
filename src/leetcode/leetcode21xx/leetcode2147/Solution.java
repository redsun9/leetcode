package leetcode.leetcode21xx.leetcode2147;

public class Solution {
    private static final int mod = 1_000_000_007;

    public int numberOfWays(String corridor) {
        int k = 0, n = corridor.length();
        for (int i = 0; i < n; i++) {
            if (corridor.charAt(i) == 'S') k++;
        }
        if (k == 0 || (k & 1) != 0) return 0;
        long ans = 1;
        for (int i = 0, seat = 0, prev = -1; i < n; i++) {
            if (corridor.charAt(i) == 'S') {
                if (seat != 0 && (seat & 1) == 0) {
                    ans = ans * (i - prev);
                    if (ans >= mod) ans %= mod;
                }
                seat++;
                prev = i;
            }
        }
        return (int) ans;
    }
}
