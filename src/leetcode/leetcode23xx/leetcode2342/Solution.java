package leetcode.leetcode23xx.leetcode2342;

public class Solution {
    private static final int MAX_SUM_DIGIT = 81;

    public int maximumSum(int[] nums) {
        int[] maxVal = new int[MAX_SUM_DIGIT + 1];
        int ans = -1;
        for (int num : nums) {
            int sum = 0;
            int tmp = num;
            while (tmp != 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
            if (maxVal[sum] != 0) ans = Math.max(ans, maxVal[sum] + num);
            maxVal[sum] = Math.max(maxVal[sum], num);
        }
        return ans;
    }
}
