package leetcode.leetcode4xx.leetcode476;

public class Solution {
    public int findComplement(int num) {
        if (num == 0) return 1;
        return num ^ (Integer.highestOneBit(num) | (Integer.highestOneBit(num) - 1));
    }
}
