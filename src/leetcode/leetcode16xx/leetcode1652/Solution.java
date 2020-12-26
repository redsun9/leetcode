package leetcode.leetcode16xx.leetcode1652;

public class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        if (k == 0) return ans;
        int s = 0;
        int sign = Integer.signum(k);
        for (int i = k > 0 ? k : n + k; i != 0; i = (i - sign) % n) {
            s += code[i];
        }
        for (int i = 0, l = k > 0 ? 1 : n + k, r = Math.max(k + 1, 0) % n; i < n; i++, l = (l + 1) % n, r = (r + 1) % n) {
            ans[i] = s;
            s = s + code[r] - code[l];
        }
        return ans;
    }
}
