package leetcode.leetcode37xx.leetcode3779;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int minOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (!set.add(nums[i])) return 1 + i / 3;
        }
        return 0;
    }
}
