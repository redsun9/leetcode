package leetcode.leetcode4xx.leetcode461;

public class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
