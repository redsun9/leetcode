package leetcode.leetcode0xx.leetcode69;

public class Solution {
    public int mySqrt(int x) {
        long round = Math.round(Math.sqrt(x));
        if (round * round > x) round--;
        return (int) round;
    }
}
