package leetcode.leetcode24xx.leetcode2413;

public class Solution {
    public int smallestEvenMultiple(int n) {
        return (n & 1) == 0 ? n : n << 1;
    }
}
