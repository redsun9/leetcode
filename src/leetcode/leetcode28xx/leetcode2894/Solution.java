package leetcode.leetcode28xx.leetcode2894;

public class Solution {
    public int differenceOfSums(int n, int m) {
        return n * (n + 1) / 2 - m * (n / m) * (n / m + 1);
    }
}
