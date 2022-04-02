package leetcode.leetcode22xx.leetcode2222;

public class Solution {
    public long numberOfWays(String s) {
        int n = s.length(), c0 = 0, c1 = 0;
        long ans = 0, c01 = 0, c10 = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                ans += c01;
                c10 += c1;
                c0++;
            } else {
                ans += c10;
                c01 += c0;
                c1++;
            }
        }
        return ans;
    }
}
