package leetcode.leetcode19xx.leetcode1927;

public class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int sum1 = 0, sum2 = 0, n1 = 0, n2 = 0;
        for (int i = 0; i < n / 2; i++) {
            char c = num.charAt(i);
            if (c >= '0' && c <= '9') sum1 += c - '0';
            else n1++;
        }
        for (int i = n / 2; i < n; i++) {
            char c = num.charAt(i);
            if (c >= '0' && c <= '9') sum2 += c - '0';
            else n2++;
        }
        return sum1 * 2 + 9 * n1 != sum2 * 2 + 9 * n2;
    }
}
