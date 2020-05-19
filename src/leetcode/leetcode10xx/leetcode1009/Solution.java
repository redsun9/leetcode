package leetcode.leetcode10xx.leetcode1009;

public class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;
        return (Integer.highestOneBit(n) << 1) - n - 1;
    }
}
