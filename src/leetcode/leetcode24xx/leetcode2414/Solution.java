package leetcode.leetcode24xx.leetcode2414;

public class Solution {
    public int longestContinuousSubstring(String s) {
        int ans = 0, n = s.length();
        char prev = 0, curr;
        for (int i = 0, len = 0; i < n; i++) {
            curr = s.charAt(i);
            if (curr == prev + 1) len++;
            else len = 1;
            ans = Math.max(ans, len);
            prev = curr;
        }
        return ans;
    }
}
