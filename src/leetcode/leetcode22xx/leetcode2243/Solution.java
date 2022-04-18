package leetcode.leetcode22xx.leetcode2243;

public class Solution {
    public String digitSum(String s, int k) {
        int n = s.length();
        if (n <= k) return s;
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) digits[i] = s.charAt(i) - '0';
        while (n > k) {
            int pos = 0;
            for (int i = 0, sum = 0; i < n; ) {
                sum += digits[i++];
                if (i % k == 0 || i == n) {
                    if (sum >= 1000) digits[pos++] = sum / 1000;
                    if (sum >= 100) digits[pos++] = sum % 1000 / 100;
                    if (sum >= 10) digits[pos++] = sum % 100 / 10;
                    digits[pos++] = sum % 10;
                    sum = 0;
                }
            }
            n = pos;
        }
        for (int i = 0; i < n; i++) digits[i] += '0';
        return new String(digits, 0, n);
    }
}
