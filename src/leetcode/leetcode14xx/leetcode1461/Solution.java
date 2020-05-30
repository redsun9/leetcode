package leetcode.leetcode14xx.leetcode1461;

public class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        int total = 1 << k;
        int mask = total - 1;
        if (n - k + 1 < total) return false;
        int tmp = 0;
        for (int i = 0; i < k - 1; i++) tmp = (tmp << 1) | (s.charAt(i) - '0');
        boolean[] a = new boolean[total];
        for (int i = k - 1; i < n; i++) {
            tmp = ((tmp << 1) | (s.charAt(i) - '0')) & mask;
            a[tmp] = true;
        }
        for (boolean b : a) if (!b) return false;
        return true;
    }
}
