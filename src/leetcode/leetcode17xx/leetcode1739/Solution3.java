package leetcode.leetcode17xx.leetcode1739;

public class Solution3 {
    // Fixed Lee solution
    public int minimumBoxes(int n) {
        int i = (int) (Math.cbrt(6L * n));
        if (i * (i + 1L) * (i + 2) / 6 > n) i--;
        int floor = (int) (i * (i + 1L) / 2), sum = (int) (i * (i + 1L) * (i + 2) / 6);
        int diff = n - sum;
        int ceil = (int) Math.ceil((-1 + Math.sqrt(1 + 8L * diff)) / 2);
        return floor + ceil;
    }
}
