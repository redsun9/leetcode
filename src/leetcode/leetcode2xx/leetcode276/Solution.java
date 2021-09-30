package leetcode.leetcode2xx.leetcode276;

public class Solution {
    public int numWays(int n, int k) {
        if (n == 1) return k;
        if (n == 2) return k * k;
        int a = k * (k - 1), b = k, c;

        for (int i = 2; i < n; i++) {
            c = (k - 1) * (a + b);
            b = a;
            a = c;
        }
        return a + b;
    }
}
