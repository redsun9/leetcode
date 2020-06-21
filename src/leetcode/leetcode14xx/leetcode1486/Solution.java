package leetcode.leetcode14xx.leetcode1486;

public class Solution {
    public int xorOperation(int n, int start) {
        return 2 * (xor(start / 2 + n - 1) ^ xor(start / 2 - 1)) | (start & n & 1);
    }

    private static int xor(int n) {
        if (n <= 0) return 0;
        return switch (n % 4) {
            case 0 -> n;
            case 1 -> 1;
            case 2 -> n | 1;
            default -> 0;
        };
    }
}
