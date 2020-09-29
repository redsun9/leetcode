package leetcode.leetcode10xx.leetcode1017;

public class Solution {
    public String baseNeg2(int n) {
        char[] ans = new char[32];
        int offset = 32;
        boolean base = true;
        do {
            ans[--offset] = (char) ('0' + (n & 1));
            if (base) n = n >> 1;
            else n = (n >> 1) + (n & 1);
            base = !base;
        } while (n != 0);
        return new String(ans, offset, 32 - offset);
    }
}
