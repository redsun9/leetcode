package leetcode.leetcode17xx.leetcode1716;

public class Solution {
    public int totalMoney(int n) {
        int a = n / 7, b = n % 7;
        return 28 * a + 7 * a * (a - 1) / 2 + b * a + b * (b + 1) / 2;
    }
}
