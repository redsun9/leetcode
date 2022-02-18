package leetcode.leetcode21xx.leetcode2167;

public class Solution2 {
    public int minimumTime(String s) {
        int n = s.length(), left = 0, ans = n;
        for (int i = 0; i < n; ++i) {
            left = Math.min(left + (s.charAt(i) == '1' ? 2 : 0), i + 1);
            ans = Math.min(ans, left + n - 1 - i);
        }
        return ans;
    }
}
