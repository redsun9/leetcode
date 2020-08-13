package leetcode.leetcode4xx.leetcode455;

import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0;
        int m = g.length;
        int n = s.length;
        for (int i = 0, j = 0; i < m && j < n; j++) {
            if (g[i] <= s[j]) {
                ans++;
                i++;
            }
        }
        return ans;
    }
}
