package leetcode.leetcode37xx.leetcode3754;

public class Solution {
    public long sumAndMultiply(int n) {
        long tmp = 0, sum = 0, power = 1, digit;
        while (n != 0) {
            digit = n % 10;
            if (digit != 0) {
                sum += digit;
                tmp += power * digit;
                power *= 10;
            }
            n /= 10;
        }
        return tmp * sum;
    }
}
