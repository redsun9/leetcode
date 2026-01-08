package leetcode.leetcode37xx.leetcode3703;

public class Solution {
    public String removeSubstring(String s, int k) {
        int n = s.length();
        char[] ans = new char[n];
        int[] kmp = new int[n + 1];
        int pos = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                ans[pos] = '(';
                if (kmp[pos] <= k) kmp[pos + 1] = Math.min(kmp[pos] + 1, k);
                else kmp[pos + 1] = 1;
            } else {
                ans[pos] = ')';
                if (kmp[pos] >= k) {
                    kmp[pos + 1] = kmp[pos] + 1;
                    if (kmp[pos + 1] == 2 * k) pos -= 2 * k;
                } else kmp[pos + 1] = 0;
            }
            pos++;
        }
        return new String(ans, 0, pos);
    }
}
