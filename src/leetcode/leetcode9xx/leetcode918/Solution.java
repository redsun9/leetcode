package leetcode.leetcode9xx.leetcode918;

public class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxValue = Integer.MIN_VALUE;
        int sumAll = 0, maxPosSum = 0, maxNegSum = 0, tmpPosSum = 0, tmpNegSum = 0;

        for (int a : nums) {
            sumAll += a;
            maxValue = Math.max(maxValue, a);
            tmpPosSum += a;
            if (tmpPosSum > 0) {
                if (tmpPosSum > maxPosSum) maxPosSum = tmpPosSum;
            } else tmpPosSum = 0;

            tmpNegSum += a;
            if (tmpNegSum < 0) {
                if (tmpNegSum < maxNegSum) maxNegSum = tmpNegSum;
            } else tmpNegSum = 0;
        }
        if (maxValue <= 0) return maxValue;
        return Math.max(maxPosSum, sumAll - maxNegSum);
    }
}
