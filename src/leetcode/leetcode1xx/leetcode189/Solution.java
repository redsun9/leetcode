package leetcode.leetcode1xx.leetcode189;

public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length < 2 || k % nums.length == 0) return;
        k %= nums.length;
        mirror(nums, 0, nums.length - k);
        mirror(nums, nums.length - k, nums.length);
        mirror(nums, 0, nums.length);
    }

    private static void mirror(int[] nums, int from, int to) {
        to--;
        int tmp;
        while (from < to) {
            tmp = nums[from];
            nums[from] = nums[to];
            nums[to] = tmp;
            from++;
            to--;
        }
    }
}
