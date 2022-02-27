package leetcode.leetcode21xx.leetcode2177;

public class Solution {
    public long[] sumOfThree(long num) {
        if (num % 3 != 0) return new long[0];
        num /= 3;
        return new long[]{num - 1, num, num + 1};
    }
}
