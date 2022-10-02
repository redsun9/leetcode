package leetcode.leetcode24xx.leetcode2429;

public class Solution {
    public int minimizeXor(int num1, int num2) {
        int bc1 = Integer.bitCount(num1), bc2 = Integer.bitCount(num2);
        if (bc1 == bc2) return num1;
        else if (bc1 > bc2) {
            int leftBits = bc1 - bc2;
            for (int i = 0; i < leftBits; i++) num1 &= num1 - 1;
            return num1;
        } else {
            int extraBits = bc2 - bc1;
            for (int i = 0; i <= 30; i++) {
                if ((num1 >> i & 1) == 0) {
                    num1 |= 1 << i;
                    if (--extraBits == 0) break;
                }
            }
            return num1;
        }
    }
}
