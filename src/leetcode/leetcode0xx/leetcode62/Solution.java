package leetcode.leetcode0xx.leetcode62;

public class Solution {
    public int uniquePaths(int m, int n) {
        if (m > n) {
            int t = m;
            m = n;
            n = t;
        }
        long ans = 1;
        for (int i = 1, j = m + n - 2; i < m; i++, j--) {
            ans = ans * j / i;
        }
        return (int) ans;
    }
}
