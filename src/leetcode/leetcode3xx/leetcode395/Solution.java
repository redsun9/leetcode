package leetcode.leetcode3xx.leetcode395;

public class Solution {
    private static int longestSubstring(String s, int start, int end, int k) {
        if (end - start < k) return 0;
        int[] count = new int[26];
        for (int i = start; i < end; i++) count[s.charAt(i) - 'a']++;
        boolean ok = true;
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0 && count[i] < k) {
                ok = false;
                break;
            }
        }
        if (ok) return end - start;
        int ans = 0;
        for (int left = start, right = start; right < end; right++) {
            int c = count[s.charAt(right) - 'a'];
            if (c != 0 && c < k) {
                ans = Math.max(ans, longestSubstring(s, left, right, k));
                left = right + 1;
            } else if (right == end - 1) {
                ans = Math.max(ans, longestSubstring(s, left, right + 1, k));
            }
        }
        return ans;
    }

    public int longestSubstring(String s, int k) {
        int n = s.length();
        if (k == 1) return n;
        return longestSubstring(s, 0, n, k);
    }
}
