package leetcode.leetcode7xx.leetcode779;

public class Solution {
    public int kthGrammar(int n, int k) {
        return Integer.bitCount(k - 1) & 1;
    }
}
