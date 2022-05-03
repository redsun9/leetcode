package leetcode.leetcode5xx.leetcode581;

public class Solution2 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;
        if (n == 2) return nums[0] > nums[1] ? 2 : 0;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for (int i = 1; i < n; i++) {
            flag |= nums[i] < nums[i - 1];
            if (flag) min = Math.min(min, nums[i]);
        }
        flag = false;
        for (int i = n - 2; i >= 0; i--) {
            flag |= nums[i] > nums[i + 1];
            if (flag) max = Math.max(max, nums[i]);
        }
        int l = 0, r = n - 1;
        while (l < n && nums[l] <= min) l++;
        while (r >= 0 && nums[r] >= max) r--;
        return r - l < 0 ? 0 : r - l + 1;
    }
}
