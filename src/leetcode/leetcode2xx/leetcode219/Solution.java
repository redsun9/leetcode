package leetcode.leetcode2xx.leetcode219;

import java.util.HashSet;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!set.add(num)) return true;
            if (i >= k) set.remove(nums[i - k]);
        }
        return false;
    }
}
