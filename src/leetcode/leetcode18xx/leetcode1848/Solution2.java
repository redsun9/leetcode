package leetcode.leetcode18xx.leetcode1848;

public class Solution2 {
    public int getMinDistance(int[] nums, int target, int start) {
        int ans = nums.length;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) ans = Math.min(ans, Math.abs(i - start));
        }
        return ans;
    }
}
