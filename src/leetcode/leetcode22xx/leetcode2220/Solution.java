package leetcode.leetcode22xx.leetcode2220;

public class Solution {
    public int minBitFlips(int start, int goal) {
        return Integer.bitCount(start ^ goal);
    }
}
