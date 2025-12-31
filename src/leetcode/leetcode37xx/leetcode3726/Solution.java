package leetcode.leetcode37xx.leetcode3726;

public class Solution {
    public long removeZeros(long n) {
        long tmp = 0, pow = 1, digit;
        while (n != 0) {
            digit = n % 10;
            if (digit != 0) {
                tmp += digit * pow;
                pow *= 10;
            }
            n /= 10;
        }
        return tmp;
    }
}
