package leetcode.leetcode2xx.leetcode258;

public class Solution {
    public int addDigits(int num) {
        int a = num % 9;
        return num != 0 ? a == 0 ? 9 : a : 0;
    }
}
