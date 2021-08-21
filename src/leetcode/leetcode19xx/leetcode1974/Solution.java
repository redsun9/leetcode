package leetcode.leetcode19xx.leetcode1974;

public class Solution {
    public int minTimeToType(String word) {
        int n = word.length(), ans = n, pos = 0;
        for (int i = 0; i < n; i++) {
            int c = word.charAt(i) - 'a';
            int d = Math.abs(pos - c);
            ans += Math.min(d, 26 - d);
            pos = c;
        }
        return ans;
    }
}
