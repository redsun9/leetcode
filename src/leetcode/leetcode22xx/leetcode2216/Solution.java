package leetcode.leetcode22xx.leetcode2216;

public class Solution {
    public int minDeletion(int[] nums) {
        int n = nums.length;
        int pairs = 0;
        for (int l = 0, r = 1; r < n; ) {
            if (nums[l] != nums[r]) {
                pairs++;
                l = r + 1;
                r = l + 1;
            } else r++;
        }
        return n - 2 * pairs;
    }
}
