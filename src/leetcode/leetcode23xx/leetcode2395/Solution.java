package leetcode.leetcode23xx.leetcode2395;

import java.util.HashSet;

public class Solution {
    public boolean findSubarrays(int[] nums) {
        int n = nums.length;
        if (n <= 2) return false;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1, sum = nums[0]; i < n; i++) {
            sum += nums[i];
            if (set.contains(sum)) return true;
            set.add(sum);
            sum -= nums[i - 1];
        }
        return false;
    }
}
