package leetcode.leetcode3xx.leetcode377;

import java.util.Arrays;

public class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] ans = new int[target + 1];
        ans[0] = 1;
        for (int i = 0; i < target; i++) {
            int a = ans[i];
            if (a == 0) continue;
            for (int num : nums) {
                int j = num + i;
                if (j > target) break;
                ans[j] += a;
            }
        }
        return ans[target];
    }
}
