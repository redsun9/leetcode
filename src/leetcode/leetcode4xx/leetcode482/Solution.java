package leetcode.leetcode4xx.leetcode482;

public class Solution {
    public String licenseKeyFormatting(String s, int k) {
        int n = s.length();
        int m = (n / k * (k + 1) + (n % k == 0 ? -1 : n % k)); //max required length
        char[] ans = new char[m + 1];
        int start = m + 1;
        int currentK = k;

        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                if (currentK++ == k) {
                    currentK = 1;
                    ans[--start] = '-';
                }
                ans[--start] = Character.toUpperCase(c);
            }
        }
        if (start == m + 1) return "";
        return new String(ans, start, m - start);
    }
}
