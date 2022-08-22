package leetcode.leetcode23xx.leetcode2379;

public class Solution {
    public int minimumRecolors(String blocks, int k) {
        int ans = k, n = blocks.length();
        for (int l = 0, r = 0, s = 0; r < n; ) {
            if (blocks.charAt(r++) == 'W') s++;
            if (r - l == k) {
                ans = Math.min(ans, s);
                if (blocks.charAt(l++) == 'W') s--;
            }
        }
        return ans;
    }
}
