package leetcode.leetcode37xx.leetcode3713;

public class Solution {
    public int longestBalanced(String s) {
        int ans = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            int[] cnt = new int[26];
            for (int j = i, max = 0, uniq = 0; j < n; j++) {
                int c = s.charAt(j) - 'a';
                if (cnt[c]++ == 0) uniq++;
                max = Math.max(max, cnt[c]);
                if (max * uniq == j - i + 1) ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
}
