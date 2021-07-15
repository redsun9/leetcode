package leetcode.leetcode3xx.leetcode397;

public class Solution {
    public int integerReplacement(int n) {
        if (n == 1) return 0;
        if ((n & 1) == 0) return 1 + integerReplacement(n >> 1);
        else return 2 + Math.min(integerReplacement(n >> 1), integerReplacement((n >> 1) + 1));
    }
}
