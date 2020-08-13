package leetcode.leetcode4xx.leetcode448;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
                count++;
            }
        }
        List<Integer> ans = new ArrayList<>(n - count);
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) ans.add(i + 1);
        }
        return ans;
    }
}
