package leetcode.leetcode18xx.leetcode1888;

public class Solution {
    public int minFlips(String s) {
        int n = s.length();
        if (n <= 1) return 0;
        int s010 = 0;
        for (int i = 0; i < n; i++) s010 += Math.abs((i & 1) - (s.charAt(i) - '0'));
        int ans = Math.min(s010, n - s010);
        if (n % 2 == 0) return ans;
        int cur010 = 0;
        for (int i = 0; i < n - 1; i++) {
            cur010 += Math.abs((i & 1) - (s.charAt(i) - '0'));
            int merged = (s010 - cur010) + (i + 1 - cur010);
            ans = Math.min(ans, Math.min(merged, n - merged));
        }
        return ans;
    }
}
