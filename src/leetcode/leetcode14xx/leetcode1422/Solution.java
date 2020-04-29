package leetcode.leetcode14xx.leetcode1422;

public class Solution {
    public int maxScore(String s) {
        int tmp = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            tmp += s.charAt(i) == '1' ? 1 : 0;
        }
        int ans = s.charAt(0) == '1' ? --tmp : ++tmp;
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == '0') ans = Math.max(ans, ++tmp);
            else tmp--;
        }
        return ans;
    }
}
