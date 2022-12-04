package leetcode.leetcode24xx.leetcode2481;

public class Solution {
    public int numberOfCuts(int n) {
        if (n == 1) return 0;
        if ((n & 1) == 0) return n >> 1;
        else return n;
    }
}
