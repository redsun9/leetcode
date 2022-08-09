package leetcode.leetcode23xx.leetcode2366;

public class Solution {
    public long minimumReplacement(int[] nums) {
        long ans = 0;
        for (int i = nums.length - 1, prev = nums[i]; i >= 0; i--) {
            int curr = nums[i];
            int k = (curr + prev - 1) / prev;
            ans += k - 1;
            prev = curr / k;
        }
        return ans;
    }
}
