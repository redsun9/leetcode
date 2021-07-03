package leetcode.leetcode4xx.leetcode481;

public class Solution {
    public int magicalString(int n) {
        if (n <= 0) return 0;
        if (n <= 3) return 1;
        int[] a = new int[n + 1];
        a[0] = 1;
        a[1] = 2;
        a[2] = 2;
        int left = 2, right = 3, num = 1, ans = 1, counter = 2;
        while (right < n) {
            a[right++] = num;
            if (num == 1) ans++;
            if (--counter == 0) {
                counter = a[++left];
                num = num ^ 3;
            }
        }
        return ans;
    }
}
