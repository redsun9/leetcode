package leetcode.leetcode25xx.leetcode2571;

public class Solution {
    public int minOperations(int n) {
        if (n <= 1) return n;
        else if ((n & 1) == 0) return minOperations(n >> 1);
        else return 1 + Math.min(minOperations(n >> 1), minOperations((n + 1) >> 1));
    }
}
