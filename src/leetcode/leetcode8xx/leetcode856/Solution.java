package leetcode.leetcode8xx.leetcode856;

public class Solution {
    public int scoreOfParentheses(String s) {
        int n = s.length();
        int ans = 0, cur = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') cur++;
            else {
                cur--;
                if (s.charAt(i - 1) == '(') ans += 1 << cur;
            }
        }
        return ans;
    }
}
