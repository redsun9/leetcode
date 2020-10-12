package leetcode.leetcode16xx.leetcode1611;

public class Solution {
    public int minimumOneBitOperations(int n) {
        int sign = 1, res = 0;
        while (n > 0) {
            res += n ^ (n - 1) * sign;
            n &= n - 1;
            sign = -sign;
        }
        return Math.abs(res);
    }
}
