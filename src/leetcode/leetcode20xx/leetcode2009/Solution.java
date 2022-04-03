package leetcode.leetcode20xx.leetcode2009;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int pos = 0;
        for (int num : nums) if (set.add(num)) nums[pos++] = num;
        Arrays.sort(nums, 0, pos);

        int ans = n - 1, left = 0, right = 1;
        while (left < pos) {
            while (right < pos && nums[left] + n - 1 >= nums[right]) right++;
            ans = Math.min(ans, n - (right - left));
            left++;
        }
        return ans;
    }
}
