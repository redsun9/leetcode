package leetcode.leetcode19xx.leetcode1960;

public class Solution {
    private static int[] manacherOdd(String str) {
        char[] s = str.toCharArray();
        int n = s.length;
        int[] ans = new int[n];
        for (int i = 0, l = 0, r = -1; i < n; i++) {
            int k = i > r ? 1 : Math.min(ans[l + r - i], r - i + 1);
            int maxK = Math.min(i, n - i - 1);
            int i1 = i - k, i2 = i + k;
            while (k <= maxK && s[i1--] == s[i2++]) k++;
            ans[i] = k--;
            if (i + k > r) {
                l = i - k;
                r = i + k;
            }
        }
        return ans;
    }

    public long maxProduct(String s) {
        int n = s.length();
        int[] d = manacherOdd(s);
        int[] left = new int[n], right = new int[n];
        for (int i = 0; i < n; i++) {
            left[i + d[i] - 1] = Math.max(left[i + d[i] - 1], 2 * d[i] - 1);
            right[i - d[i] + 1] = 2 * d[i] - 1;
        }
        for (int i = n - 2, j = n - 1; i >= 0; i--, j--) left[i] = Math.max(left[i], left[j] - 2);
        for (int i = 1, j = 0; i < n; i++, j++) right[i] = Math.max(right[i], right[j] - 2);

        for (int i = 1, j = 0; i < n; i++, j++) left[i] = Math.max(left[i], left[j]);
        for (int i = n - 2, j = n - 1; i >= 0; i--, j--) right[i] = Math.max(right[i], right[j]);

        long ans = 1;
        for (int i = 1; i < n; i++) ans = Math.max(ans, (long) left[i - 1] * right[i]);
        return ans;
    }

}
