package leetcode.leetcode17xx.leetcode1759;

public class Solution {
    private static final int p = 1_000_000_007;

    public int countHomogenous(String s) {
        int n = s.length();
        long ans = 0;
        int l = 0, r = 0;
        char c = s.charAt(0);
        while (true) {
            while (r < n && s.charAt(r) == c) r++;
            ans += ((long) (r - l + 1)) * (r - l) / 2;
            if (r == n) return (int) (ans % p);
            c = s.charAt(r);
            l = r;
        }
    }
}
