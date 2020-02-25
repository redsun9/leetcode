package leetcode.leetcode45;

class Solution {
    public int jump(int[] nums) {
        int res = 0, prev = 0, cur = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            cur = Math.max(i + nums[i], cur);
            if (i == prev) {
                ++res;
                prev = cur;
            }
        }
        return res;
    }
}
