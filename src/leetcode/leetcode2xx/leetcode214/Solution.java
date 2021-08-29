package leetcode.leetcode2xx.leetcode214;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) return s;
        String tmp = s + "#" + new StringBuilder(s).reverse();
        int[] zf = zFunction(tmp);
        int i = n + 1, j = n;
        while (zf[i] < j) {
            i++;
            j--;
        }
        return tmp.substring(n + 1, i) + s;
    }

    private static int[] zFunction(String s) {
        int n = s.length();
        int[] zf = new int[n];
        int left = 0, right = 0;
        for (int i = 1; i < n; i++) {
            zf[i] = Math.max(0, Math.min(right - i, zf[i - left]));
            while (i + zf[i] < n && s.charAt(zf[i]) == s.charAt(i + zf[i])) zf[i]++;
            if (i + zf[i] > right) {
                left = i;
                right = i + zf[i];
            }
        }
        return zf;
    }
}
