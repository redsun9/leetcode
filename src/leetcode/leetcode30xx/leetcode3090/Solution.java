package leetcode.leetcode30xx.leetcode3090;

public class Solution {
    public int maximumLengthSubstring(String s) {
        int[] count = new int[26];
        int ans = 0, n = s.length();
        for (int r = 0, l = 0; r < n; r++) {
            int c = s.charAt(r) - 'a';
            count[c]++;
            while (count[c] > 2) count[s.charAt(l++) - 'a']--;
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}
