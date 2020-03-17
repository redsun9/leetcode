package leetcode.leetcode41;

public class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        if (n == 0) return 1;
        int tmpValue, tmpIndex;
        for (int i = 0; i < n; i++) {
            tmpValue = nums[i];
            tmpIndex = i;
            while (tmpValue != tmpIndex + 1 && tmpValue > 0 && tmpValue <= n) {
                tmpIndex = tmpValue - 1;
                tmpValue = nums[tmpIndex];
                nums[tmpIndex] = tmpIndex + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }
}
