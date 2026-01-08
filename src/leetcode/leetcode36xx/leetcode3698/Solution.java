package leetcode.leetcode36xx.leetcode3698;

public class Solution {
    public long splitArray(int[] nums) {
        int n = nums.length, maxIncreasing = 0, maxDecreasing = n - 1;
        while (maxIncreasing < n - 1 && nums[maxIncreasing] < nums[maxIncreasing + 1]) maxIncreasing++;
        while (maxDecreasing > 0 && nums[maxDecreasing] < nums[maxDecreasing - 1]) maxDecreasing--;
        if (maxIncreasing + 1 < maxDecreasing) return -1;

        long totalSum = 0;
        for (int num : nums) totalSum += num;

        long prefSum = 0;
        for (int i = 0; i < maxDecreasing; i++) prefSum += nums[i];
        long ans = Math.abs(prefSum - (totalSum - prefSum));
        for (int i = maxDecreasing; i <= maxIncreasing; i++) {
            prefSum += nums[i];
            ans = Math.min(ans, Math.abs(prefSum - (totalSum - prefSum)));
        }
        return ans;
    }
}
