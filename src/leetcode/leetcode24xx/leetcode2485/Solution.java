package leetcode.leetcode24xx.leetcode2485;

public class Solution {
    public int pivotInteger(int n) {
        int sum = n * (n + 1) / 2;
        int val = (int) Math.round(Math.sqrt(sum));
        if (val * val == sum) return val;
        else return -1;
    }
}
