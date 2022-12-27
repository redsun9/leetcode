package leetcode.leetcode25xx.leetcode2516;

public class Solution {
    public int takeCharacters(String s, int k) {
        if (k == 0) return 0;
        int n = s.length();
        int[] cnt = new int[3];
        int left = 3;
        int l = 0;
        while (l < n && left != 0) if (++cnt[s.charAt(l++) - 'a'] == k) left--;
        if (left != 0) return -1;
        int ans = l, r = n;
        while (l != 0) {
            while (l != 0 && left == 0) {
                if (cnt[s.charAt(--l) - 'a']-- == k) left++;
                else ans = Math.min(ans, l + (n - r));
            }
            while (left != 0) if (++cnt[s.charAt(--r) - 'a'] == k) left--;
            ans = Math.min(ans, l + (n - r));
        }
        return ans;
    }
}
