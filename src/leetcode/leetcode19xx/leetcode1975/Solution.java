package leetcode.leetcode19xx.leetcode1975;

public class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long minModule = Integer.MAX_VALUE, sum = 0L, numberOfZero = 0, numberOfNegative = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                sum += Math.abs(num);
                minModule = Math.min(minModule, Math.abs(num));
                if (num == 0) numberOfZero++;
                if (num < 0) numberOfNegative++;
            }
        }
        if ((numberOfNegative & 1) == 0 || numberOfZero != 0) return sum;
        else return sum - 2 * minModule;
    }
}
