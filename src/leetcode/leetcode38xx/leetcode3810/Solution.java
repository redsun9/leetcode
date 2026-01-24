package leetcode.leetcode38xx.leetcode3810;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int minOperations(int[] nums, int[] target) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != target[i]) set.add(nums[i]);
        }
        return set.size();
    }
}
