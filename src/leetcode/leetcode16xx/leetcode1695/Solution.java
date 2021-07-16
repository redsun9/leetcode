package leetcode.leetcode16xx.leetcode1695;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length, ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int l = 0, r = 0, sum = 0; r < n; r++) {
            sum += nums[r];
            if (!set.add(nums[r])) {
                while (true) {
                    sum -= nums[l];
                    if (nums[l] == nums[r]) break;
                    set.remove(nums[l++]);
                }
                l++;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
