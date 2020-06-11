package leetcode.leetcode14xx.leetcode1415;

public class Solution {
    public String getHappyString(int n, int k) {
        int[] a = new int[n];
        k--;
        for (int i = n - 1; i > 0; i--) {
            a[i] = k % 2;
            k /= 2;
        }
        if (k > 2) return "";
        a[0] = k;
        char[] c = new char[n];
        c[0] = (char) (a[0] + 'a');
        for (int i = 1; i < n; i++) {
            if (a[i - 1] <= a[i]) a[i]++;
            c[i] = (char) (a[i] + 'a');
        }
        return new String(c);
    }
}
