package leetcode.leetcode4xx.leetcode440;

public class Solution {
    private static int between(int n, long n1, long n2) {
        int ans = 0;
        while (n1 <= n) {
            ans += Math.min(n + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return ans;
    }

    public int findKthNumber(int n, int k) {
        int ans = 1;
        int k1 = 1;
        while (k1 != k) {
            int dk = between(n, ans, ans + 1);
            if (k1 + dk <= k) {
                // we can easily increase last digit
                ans += 1;
                k1 += dk;
            } else {
                // ans+1 has position more than k
                // so we add zero in the end
                // cause a0 stays exactly after a
                ans *= 10;
                k1++;
            }
        }
        return ans;
    }
}
