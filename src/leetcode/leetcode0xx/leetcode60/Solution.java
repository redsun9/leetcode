package leetcode.leetcode0xx.leetcode60;

public class Solution {
    private static final int[] fact;

    static {
        fact = new int[9];
        fact[0] = 1;
        for (int i = 1; i < 9; i++) {
            fact[i] = fact[i - 1] * i;
        }
    }

    public String getPermutation(int n, int k) {
        boolean[] used = new boolean[n];
        char[] ans = new char[n];

        k--;
        for (int i = 0; i < n; i++) {
            int d = k / fact[n - i - 1];
            for (int j = 0; j <= d; j++) {
                if (used[j]) d++;
            }
            used[d] = true;
            ans[i] = (char) ('1' + d);
            k %= fact[n - i - 1];
        }
        return new String(ans);
    }
}
