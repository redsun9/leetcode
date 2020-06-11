package leetcode.leetcode14xx.leetcode1415;

public class Solution {
    public String getHappyString(int n, int k) {
        k--;
        char[] c = new char[n];
        for (int i = n - 1; i > 0; i--) {
            c[i] = (char) ('a' + k % 2);
            k /= 2;
        }
        if (k > 2) return "";
        c[0] = (char) ('a' + k);
        for (int i = 1; i < n; i++) {
            if (c[i - 1] <= c[i]) c[i]++;
        }
        return new String(c);
    }
}
