package leetcode.leetcode3xx.leetcode396;

public class Solution {
    public int maxRotateFunction(int[] a) {
        int n = a.length;
        if (n <= 1) return 0;
        int tmp = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            tmp += a[i] * i;
            sum += a[i];
        }
        int ans = tmp;
        for (int i = n - 1; i >= 0; i--) {
            tmp = tmp + sum - n * a[i];
            ans = Math.max(ans, tmp);
        }
        return ans;
    }
}
