package leetcode.leetcode3xx.leetcode367;

public class Solution {
    public boolean isPerfectSquare(int num) {
        if (num < 0) return false;
        long r = num;
        while (r * r > num) r = (r + num / r) / 2;
        return r * r == num;
    }
}
