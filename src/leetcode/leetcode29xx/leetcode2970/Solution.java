package leetcode.leetcode29xx.leetcode2970;

public class Solution {
    public int incremovableSubarrayCount(int[] nums) {
        int start = 1, n = nums.length;
        while (start < n && nums[start] > nums[start - 1]) start++;
        if (start == n) return n * (n + 1) / 2;

        int ans = start + 1;
        int end = n - 1;
        while (end == n - 1 || nums[end] < nums[end + 1]) {
            while (start != 0 && nums[end] <= nums[start - 1]) start--;
            ans += (start + 1);
            end--;
        }
        return ans;
    }
}
