package leetcode.leetcode37xx.leetcode3750;

public class Solution {
    public int minimumFlips(int n) {
        int highestBit = Integer.highestOneBit(n), lowestBit = 1;
        int ans = 0;
        while (highestBit != 0) {
            if ((n & highestBit) == 0 ^ (n & lowestBit) == 0) ans++;
            highestBit >>>= 1;
            lowestBit <<= 1;
        }
        return ans;
    }
}
