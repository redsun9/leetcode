package leetcode.leetcode10xx.leetcode1031;

public class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < firstLen; i++) sum1 += nums[i];
        for (int i = firstLen, j = 0; j < secondLen; i++, j++) sum2 += nums[i];
        int ans = sum1 + sum2, maxSum1 = sum1;
        for (int i1 = 0, i2 = firstLen, i3 = firstLen + secondLen; i3 < n; i1++, i2++, i3++) {
            sum2 = sum2 - nums[i2] + nums[i3];
            sum1 = sum1 - nums[i1] + nums[i2];
            maxSum1 = Math.max(maxSum1, sum1);
            ans = Math.max(ans, maxSum1 + sum2);
        }
        if (firstLen == secondLen || firstLen + secondLen == n) return ans;
        sum1 = 0;
        sum2 = 0;
        for (int i = 0; i < secondLen; i++) sum1 += nums[i];
        for (int i = secondLen, j = 0; j < firstLen; i++, j++) sum2 += nums[i];
        ans = Math.max(ans, sum1 + sum2);
        maxSum1 = sum1;
        for (int i1 = 0, i2 = secondLen, i3 = firstLen + secondLen; i3 < n; i1++, i2++, i3++) {
            sum2 = sum2 - nums[i2] + nums[i3];
            sum1 = sum1 - nums[i1] + nums[i2];
            maxSum1 = Math.max(maxSum1, sum1);
            ans = Math.max(ans, maxSum1 + sum2);
        }
        return ans;
    }
}
