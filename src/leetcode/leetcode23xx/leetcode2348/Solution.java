package leetcode.leetcode23xx.leetcode2348;

public class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int cur = 0;
        for (int num : nums) {
            if (num == 0) {
                cur++;
                ans += cur;
            } else cur = 0;
        }
        return ans;
    }
}
