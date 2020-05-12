package leetcode.leetcode5xx.leetcode540;

public class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if ((mid & 1) == 0) {
                if (nums[mid] == nums[mid + 1]) lo = mid + 2;
                else hi = mid;
            } else {
                if (nums[mid] == nums[mid - 1]) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return nums[lo];
    }
}
