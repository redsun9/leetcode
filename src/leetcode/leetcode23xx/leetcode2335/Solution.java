package leetcode.leetcode23xx.leetcode2335;

public class Solution {
    public int fillCups(int[] amount) {
        int a = amount[0], b = amount[1], c = amount[2];
        if (a >= b + c) return a;
        if (b >= a + c) return b;
        if (c >= a + b) return c;
        return (a + b + c + 1) / 2;
    }
}
