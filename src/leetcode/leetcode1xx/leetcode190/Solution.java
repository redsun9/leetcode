package leetcode.leetcode1xx.leetcode190;

public class Solution {
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 16; i++) {
            ans |= (n & (1 << i)) << (31 - 2 * i) | (n & (1 << (31 - i))) >>> (31 - 2 * i);
        }
        return ans;
    }
}
