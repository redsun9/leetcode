package leetcode.leetcode9xx.leetcode942;

public class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] ans = new int[n + 1];
        int lo = 0, hi = n;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') ans[i] = lo++;
            else ans[i] = hi--;
        }
        ans[n] = lo;
        return ans;
    }
}
