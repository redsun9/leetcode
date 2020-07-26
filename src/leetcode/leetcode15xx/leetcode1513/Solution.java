package leetcode.leetcode15xx.leetcode1513;

public class Solution {
    public static final int mod = 1_000_000_007;

    public int numSub(String s) {
        int n = s.length();
        long cur = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') cur++;
            else {
                ans += cur * (cur + 1) / 2;
                cur = 0;
            }
        }
        ans += cur * (cur + 1) / 2;
        return (int) (ans % mod);
    }
}
