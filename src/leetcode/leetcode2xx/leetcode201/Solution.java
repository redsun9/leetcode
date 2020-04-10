package leetcode.leetcode2xx.leetcode201;

public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int ans = 0;
        int hm = Integer.highestOneBit(m);
        int hn = Integer.highestOneBit(n);
        while (hm == hn && hm != 0) {
            ans |= hm;
            m ^= hm;
            n ^= hn;
            hm = Integer.highestOneBit(m);
            hn = Integer.highestOneBit(n);
        }
        return ans;
    }
}
