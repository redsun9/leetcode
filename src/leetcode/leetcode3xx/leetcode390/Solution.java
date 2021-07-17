package leetcode.leetcode3xx.leetcode390;

public class Solution {
    public int lastRemaining(int n) {
        boolean left = true;
        int ans = 1, step = 1;
        while (n > 1) {
            if (left || (n & 1) == 1) ans += step;
            n >>= 1;
            step <<= 1;
            left = !left;
        }
        return ans;
    }
}
