package leetcode.leetcode3xx.leetcode319;

public class Solution {
    public int bulbSwitch(int n) {
        long round = Math.round(Math.sqrt(n));
        if (round * round > n) round--;
        return (int) round;
    }
}
