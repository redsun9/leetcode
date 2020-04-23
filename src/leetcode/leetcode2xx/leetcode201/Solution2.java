package leetcode.leetcode2xx.leetcode201;

public class Solution2 {
    public int rangeBitwiseAnd(int m, int n) {
        return m == n ? m : m & -(Integer.highestOneBit(m ^ n) << 1);
    }
}
