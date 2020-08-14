package leetcode.leetcode7xx.leetcode717;

public class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int i = 0;
        while (i < n - 1) {
            if (bits[i] == 0) i++;
            else i += 2;
        }
        return i == n - 1 || i < n && bits[i] == 0;
    }
}
