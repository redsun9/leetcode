package leetcode.leetcode25xx.leetcode2595;

import static java.lang.Integer.bitCount;

public class Solution {
    public int[] evenOddBit(int n) {
        return new int[]{bitCount(n & 0x55555555), bitCount(n & 0xAAAAAAAA)};
    }
}
