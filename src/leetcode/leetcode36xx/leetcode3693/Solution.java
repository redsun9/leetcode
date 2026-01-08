package leetcode.leetcode36xx.leetcode3693;

public class Solution {
    public int climbStairs(int n, int[] costs) {
        int a = 0, b = 0, c = 0, d;
        for (int cost : costs) {
            d = cost + Math.min(a + 9, Math.min(b + 4, c + 1));
            a = b;
            b = c;
            c = d;
        }
        return c;
    }
}
