package leetcode.leetcode18xx.leetcode1848;

public class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int i1 = start, i2 = start, n = nums.length;
        while (true) {
            if (i1 >= 0 && nums[i1] == target) return start - i1;
            if (i2 < n && nums[i2] == target) return i2 - start;
            i1--;
            i2++;
        }
    }
}
