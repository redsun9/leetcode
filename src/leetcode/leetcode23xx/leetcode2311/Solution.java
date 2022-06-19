package leetcode.leetcode23xx.leetcode2311;

public class Solution {
    public int longestSubsequence(String s, int k) {
        int ans = 0, n = s.length(), cur = 0, tmp = 0;
        for (int i = n - 1; i >= 0; i--) {
            int c = s.charAt(i) - '0';
            if (c == 0) ans++;
            else if (ans < 31) {
                tmp = cur | c << ans;
                if (tmp <= k) {
                    cur = tmp;
                    ans++;
                }
            }
        }
        return ans;
    }
}
