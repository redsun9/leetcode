package leetcode.leetcode14xx.leetcode1403;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sunUnselected = 0;
        for (int num : nums) {
            sunUnselected += num;
        }
        LinkedList<Integer> ans = new LinkedList<>();
        int sumSelected = 0;
        int i = nums.length - 1;
        while (sumSelected <= sunUnselected) {
            ans.addLast(nums[i]);
            sumSelected += nums[i];
            sunUnselected -= nums[i];
            i--;
        }
        return ans;
    }
}
