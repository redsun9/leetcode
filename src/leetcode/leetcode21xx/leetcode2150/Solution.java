package leetcode.leetcode21xx.leetcode2150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> findLonely(int[] nums) {
        int n = nums.length;
        if (n == 0) return Collections.emptyList();
        if (n == 1) return List.of(nums[0]);
        if (n == 2) {
            if (nums[0] > nums[1]) {
                if (nums[0] > nums[1] + 1) return List.of(nums[1], nums[0]);
                else return Collections.emptyList();
            } else {
                if (nums[0] + 1 < nums[1]) return List.of(nums[0], nums[1]);
                else return Collections.emptyList();
            }
        }
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        if (nums[0] + 1 < nums[1]) ans.add(nums[0]);
        for (int i = 1; i < n - 1; i++) {
            if (nums[i - 1] + 1 < nums[i] && nums[i] + 1 < nums[i + 1]) ans.add(nums[i]);
        }
        if (nums[n - 2] + 1 < nums[n - 1]) ans.add(nums[n - 1]);
        return ans;
    }
}
