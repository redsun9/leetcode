package leetcode.leetcode13xx.leetcode1365;

public class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 1; i < 100; i++) {
            count[i] += count[i - 1];
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] != 0 ? count[nums[i] - 1] : 0;
        }
        return nums;
    }
}
