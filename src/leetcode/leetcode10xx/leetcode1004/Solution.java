package leetcode.leetcode10xx.leetcode1004;

public class Solution {
    public int longestOnes(int[] a, int k) {
        int n = a.length;
        if (n == 0 || n <= k) return n;
        int ans = 0;
        int left = 0, cur = 0;
        for (int right = 0; right < n; right++) {
            if (a[right] == 0) {
                cur++;
                if (cur > k) {
                    while (a[left++] != 0) ;
                    cur--;
                }
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
