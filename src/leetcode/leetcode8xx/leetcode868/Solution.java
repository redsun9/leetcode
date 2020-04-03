package leetcode.leetcode8xx.leetcode868;

public class Solution {
    public int binaryGap(int n) {
        if ((n & (n - 1)) == 0) return 0; // n - zero or power of two
        int prevPos = 32;
        int max = 0;
        for (int i = 0; i < 31; i++) {
            if ((n & 1) == 1) {
                if (max < i - prevPos) max = i - prevPos;
                prevPos = i;
            }
            n >>= 1;
        }
        return max;
    }
}
