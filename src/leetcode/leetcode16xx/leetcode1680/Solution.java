package leetcode.leetcode16xx.leetcode1680;

public class Solution {
    public static final int p = 1_000_000_007;

    public int concatenatedBinary(int n) {
        long ans = 0;
        int lo = 1, hi = 2, shift = 1;
        while (lo <= n) {
            int top = Math.min(n + 1, hi);
            for (int i = lo; i < top; i++) {
                ans = ((ans << shift) | i) % p;
            }
            lo <<= 1;
            hi <<= 1;
            shift++;
        }
        return (int) ans;
    }
}
