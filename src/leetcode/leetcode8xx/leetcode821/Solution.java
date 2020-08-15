package leetcode.leetcode8xx.leetcode821;

public class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];
        int pos = -n;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                ans[i] = 0;
                pos = i;
            } else {
                ans[i] = i - pos;
            }
        }
        pos = 2 * n;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) pos = i;
            else ans[i] = Math.min(ans[i], pos - i);
        }
        return ans;
    }
}
