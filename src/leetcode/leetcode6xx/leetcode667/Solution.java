package leetcode.leetcode6xx.leetcode667;

public class Solution {
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        ans[0] = 1 + k / 2;
        for (int i = 1, d = 2 * (k % 2) - 1; i <= k; i++, d = -d) ans[i] = ans[i - 1] + i * d;
        for (int i = k + 1; i < n; i++) {
            ans[i] = i + 1;
        }
        return ans;
    }
}
