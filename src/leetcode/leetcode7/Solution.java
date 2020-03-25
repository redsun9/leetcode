package leetcode.leetcode7;

public class Solution {
    public int reverse(int x) {
        long ans = x % 10;
        x /= 10;
        while (x != 0) {
            ans = ans * 10 + (x % 10);
            x /= 10;
        }
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) return 0;
        return (int) ans;
    }
}
