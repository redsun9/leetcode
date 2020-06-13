package leetcode.leetcode13xx.leetcode1392;

public class Solution {
    private static final long mod = Integer.MAX_VALUE; //it's prime
    private static final long pow = 31;

    public String longestPrefix(String s) {
        int ans = 0;
        long l = 0, r = 0, power = 1;
        for (int i = 0, j = s.length() - 1; j > 0; i++, j--) {
            l = (l * pow + s.charAt(i)) % mod;
            r = (r + power * s.charAt(j)) % mod;
            power = power * pow % mod;
            if (l == r) ans = i + 1;
        }
        return s.substring(0, ans);
    }
}
