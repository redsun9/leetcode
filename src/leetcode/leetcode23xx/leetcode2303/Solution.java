package leetcode.leetcode23xx.leetcode2303;

public class Solution {
    public double calculateTax(int[][] brackets, int income) {
        int tax = 0;
        for (int i = 0, prevThreshold = 0; i < brackets.length; i++) {
            tax += brackets[i][1] * (Math.min(income, brackets[i][0]) - prevThreshold);
            prevThreshold = brackets[i][0];
            if (income <= brackets[i][0]) break;
        }
        return tax / 100.0;
    }
}
