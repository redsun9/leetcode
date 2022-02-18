package leetcode.leetcode21xx.leetcode2167;

public class Solution {
    public int minimumTime(String s) {
        int n = s.length();
        int[] left = new int[n + 1];
        for (int i = 0; i < n; i++) left[i + 1] = Math.min(i + 1, left[i] + (s.charAt(i) == '1' ? 2 : 0));

        int ans = left[n];

        for (int i = n - 1, right = 0, dist = 1; i >= 0; i--, dist++) {
            right = Math.min(dist, right + (s.charAt(i) == '1' ? 2 : 0));
            ans = Math.min(ans, left[i] + right);
        }
        return ans;
    }
}
