package leetcode.leetcode38xx.leetcode3804;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int centeredSubarrays(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i, sum = 0; j < n; j++) {
                sum += nums[j];
                set.add(nums[j]);
                if (set.contains(sum)) ans++;
            }
        }
        return ans;
    }
}
